package com.breach.huajinbao.service.verify.impl;


import com.breach.common.entity.ConsumerActivateVerifyRecord;
import com.breach.common.entity.ConsumerAddress;
import com.breach.common.entity.EmployeeInfo;
import com.breach.huajinbao.mapper.verify.IVerifyMapper;
import com.breach.huajinbao.service.verify.IVerifyService;
import com.breach.huajinbao.util.base.EmployeeSessionUtil;
import com.breach.huajinbao.util.verify.NewsMode;
import com.breach.huajinbao.util.verify.Result;
import com.breach.huajinbao.util.verify.VerifyQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 认证信息业务实现类
 */
@Service
public class VerifyServiceImpl implements IVerifyService {
    @Autowired
    private IVerifyMapper verifyMapper;


    /**
     * 分页和查询（认证详情表）
     * 1.搜索所有的待审核的实名认证表
     * 2.获取总个数
     * 3.返回拿到的数据
     * @param
     * @return
     *
     */
    @Override
    public Map<String, Object> getUserInfo(VerifyQuery info) {
        //获取待审核的实名认证表
        List<Map<String, Object>> verifyList = verifyMapper.getAuthentication(info);
        //获取页码
        Integer total = verifyMapper.getTotal(info);
        Map<String, Object> map = new HashMap<>();
        map.put("data", verifyList);
        map.put("total", total);
        return map;

    }

    /**
     * 获取选中的信息展示
     *  1.由认证订单的编号，获取信息
     *  2.由拿到的个人信息，来查子集信息，
     *  3.封装成map，返回数据
     * @param
     * @return
     */
    @Override
    public Map<String, Object> getDetailed(String record) {
        //由认证订单的编号，获取信息
        ConsumerActivateVerifyRecord info = verifyMapper.getDetailed(record);

        Map<String, Object> map = new HashMap<>();
        map.put("data", info);
        //学历信息
        map.put("sonInfo1", verifyMapper.getEducation(info.getEducationId()));
        //收入信息
        map.put("sonInfo2", verifyMapper.getIncomeRange(info.getIncomeRangeId()));
        //地址：
        map.put("sonInfo3", verifyMapper.getCodeProvince(info.getCodeProvince()));
        map.put("sonInfo4", verifyMapper.getCodeCity(info.getCodeCity()));
        map.put("sonInfo5", verifyMapper.getCodeArea(info.getCodeArea()));
        return map;

    }

    /**
     * 1.通过时提交信息到个人表中，完善用户的信息情况
     * {
     * 1.身份证信息（关联表）插入，返回插入id
     * 2.现住址地址表（关联表）插入，返回插入id
     * 3.最后修改个人的基本信息
     * }
     * 2.发送成功的信息到用户的消息管理表中
     * 3.绑定的银行卡插入；
     * 4.激活用户的账号额度：（50000）;
     *     1.找到个人的信息表返回   （非自增的 ）账户id（关联）
     *     2.再修改子集信息额度，
     *
     * 5.修改审核表中的
     * 审核状态（1：未审核 2：通过 3：不通过），审核时间，审核员工id
     * 6.返回成功提交信息
     *
     * @param
     * @return
     */
    @Override
    public Result submitReInfo(String recordNumber) {
        ConsumerActivateVerifyRecord per = verifyMapper.getDetailed(recordNumber);
        //身份证信息（关联表）插入，
        // 返回插入id(就是per.getId()  注意！！！！！)
        verifyMapper.insertConsumerCard(per);

        ConsumerAddress address = new ConsumerAddress();
        address.setProvince(verifyMapper.getCodeProvince(per.getCodeProvince()));
        address.setCity(verifyMapper.getCodeCity(per.getCodeCity()));
        address.setArea(verifyMapper.getCodeArea(per.getCodeArea()));
        address.setAddress(per.getAddress());
        //2.现住址地址表（关联表）插入，
        // 返回插入id(就是address.getId() 注意！！！)
        verifyMapper.insertAddress(address);

        //3.最后修改个人的基本信息
        verifyMapper.updateInfo(per, per.getId(), address.getId());
        //回复用户消息
        verifyMapper.insertNews(NewsMode.SUCCESS_TITLE, NewsMode.SUCCESS_CONTENT, per.getConsumerId(), new Date());
        //绑定银行卡的信息插入表中；
        verifyMapper.insertBank(per.getBankCode(),per.getConsumerId());

        //激活账户的信息额度

        Integer accountId =verifyMapper.getAccountId(per.getConsumerId());
        verifyMapper.setCreditLine(accountId);
        //修改审核记录的信息（人，时间，审核状态）
        EmployeeInfo emp = EmployeeSessionUtil.getEmp();
        verifyMapper.setStateForConsumer(emp.getId(), new Date(), recordNumber);

        return new Result(200, "通过，提交成功");
    }

    /**
     * 不通过，执行以下条件
     * 1 发激活失败的消息给用户
     * 2 修改审核状态（1：未审核 2：通过 3：不通过），审核时间，审核员工id
     *
     * @param
     * @return
     */
    @Override
    public Result submitNoInfo(String recordNumber) {
        ConsumerActivateVerifyRecord per = verifyMapper.getDetailed(recordNumber);
        //回复用户消息
        verifyMapper.insertNews(NewsMode.DEFEAT_TITLE, NewsMode.DEFEAT_CONTENT, per.getConsumerId(), new Date());

        //修改审核记录的信息（人，时间，审核状态）
        EmployeeInfo emp = EmployeeSessionUtil.getEmp();
        verifyMapper.setStateForConsumerAgain(emp.getEmployeeAccountId(), new Date(), recordNumber);
        return new Result(200, "不通过，提交成功");
    }


}
