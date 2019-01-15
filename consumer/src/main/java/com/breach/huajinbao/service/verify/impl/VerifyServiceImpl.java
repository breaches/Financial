package com.breach.huajinbao.service.verify.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breach.api.idno.IdCard;
import com.breach.common.entity.*;
import com.breach.common.mapper.*;
import com.breach.huajinbao.mapper.verify.IVerifyMapper;
import com.breach.huajinbao.service.verify.IVerifyService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.sysconst.api.IApiConsts;
import com.breach.huajinbao.util.global.*;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-10 19:28
 **/
@SuppressWarnings(value = "all") // 消除代码重复黄线警告
@Service
public class VerifyServiceImpl implements IVerifyService {

    @Autowired
    IVerifyMapper verifyMapper;
    @Autowired
    IRegionProvinceMapper regionProvinceMapper;
    @Autowired
    IRegionCityMapper regionCityMapper;
    @Autowired
    IRegionAreaMapper regionAreaMapper;
    @Autowired
    IConsumerEducationMapper consumerEducationMapper;
    @Autowired
    IConsumerActivateVerifyRecordMapper consumerActivateVerifyRecordMapper;
    @Autowired
    IConsumerInfoMapper consumerInfoMapper;
    @Autowired
    IConsumerCardMapper consumerCardMapper;


    @Override
    public ReturnUtil listAllProvince() {

        List<RegionProvince> regionProvinces = regionProvinceMapper.selectList(null);

        System.out.println("---------------------------------");
        System.out.println("全国省份数据");
        System.out.println(regionProvinces);
        System.out.println("---------------------------------");


        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, regionProvinces);
    }

    @Override
    public ReturnUtil listAllRegions() {

        return null;
    }

    @Override
    public ReturnUtil getListAllCity(RegionProvince regionProvince) {
        System.out.println(regionProvince);
        String codeProvince = regionProvince.getCodeProvince();
        RegionCity regionCity = new RegionCity();
        regionCity.setCodeProvince(codeProvince);

        List<RegionCity> regionCities = regionCityMapper.selectList(new QueryWrapper<>(regionCity));
        System.out.println("******************************************************");
        System.out.println("查出的所有城市");
        System.out.println(regionCities);
        System.out.println("******************************************************");

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, regionCities);
    }

    @Override
    public ReturnUtil getListAllArea(RegionCity regionCity) {
        System.out.println("-=-=-=-=-=-=");
        System.out.println(regionCity);
        String codeCity = regionCity.getCodeCity();
        RegionArea regionArea = new RegionArea();
        regionArea.setCodeCity(codeCity);
        List<RegionArea> regionAreas = regionAreaMapper.selectList(new QueryWrapper<>(regionArea));
        System.out.println("******************************************************");
        System.out.println("查出的所有地区");
        System.out.println(regionAreas);
        System.out.println("******************************************************");

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, regionAreas);
    }

    @Override
    public ReturnUtil listAllEducation() {
        List<ConsumerEducation> consumerEducations = consumerEducationMapper.selectList(null);
        System.out.println("******************************************************");
        System.out.println("查出的所有学历");
        System.out.println(consumerEducations);
        System.out.println("******************************************************");

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, consumerEducations);
    }

    @Override
    public ReturnUtil listAllIncome() {
        List<ConsumerIncomeRange> data = verifyMapper.listAllIncome();

        System.out.println("******************************************************");
        System.out.println("查出的所有收入范围");
        System.out.println(data);
        System.out.println("******************************************************");

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, data);
    }

    /**
     * 上传正面身份证
     *
     * @param file
     * @param type
     * @return
     */
    @Override
    public ReturnUtil uploadFront(MultipartFile file, String type) {
        if (GlobalConsumerUtil.isLogin()) {
            if (file != null) {
                String url = null;
                try {
                    url = AliOSSUtil.upload(file, ConsumerSessionUtil.getConsumer().getUsername());
                    System.out.println("URL -> " + url);
                    return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "seccess", url);
                } catch (Exception e) {
                    e.printStackTrace();
                    // 上传的过程中抛出了异常
                    return new ReturnUtil(ISystemConsts.AJAX_ERROR, "upload error");
                }
            }
            // 文件是空的

        }
        // 未登录
        return new ReturnUtil(ISystemConsts.AJAX_ERROR, "not login");
    }

    /**
     * 上传背面身份证
     *
     * @param file
     * @param type
     * @return
     */
    @Override
    public ReturnUtil uploadBack(MultipartFile file, String type) {
        if (GlobalConsumerUtil.isLogin()) {
            if (file != null) {
                String url = null;
                try {
                    url = AliOSSUtil.upload(file, ConsumerSessionUtil.getConsumer().getUsername());
                    // 上传成功
                    System.out.println("URL -> " + url);
                    return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "seccess", url);
                } catch (Exception e) {
                    e.printStackTrace();
                    // 上传的过程中抛出了异常
                    return new ReturnUtil(ISystemConsts.AJAX_ERROR, "upload error");
                }
            }
            // 文件是空的

        }
        // 未登录
        return new ReturnUtil(ISystemConsts.AJAX_ERROR, "not login");
    }

    /**
     * 提交资料
     *
     * @param consumerActivateVerifyRecord
     * @return
     */
    @Override
    public ReturnUtil finalSubmit(ConsumerActivateVerifyRecord consumerActivateVerifyRecord) {
        if (GlobalConsumerUtil.isLogin()) {
            // 已登录
            // 把数据插入数据库
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("consumer 提交过来的资料");
            System.out.println(consumerActivateVerifyRecord);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            // 设置用户审额单号 设置用户id 设置时间
            consumerActivateVerifyRecord.setRecordNumber(SerialUtil.getRecordNumber());
            consumerActivateVerifyRecord.setConsumerId(ConsumerSessionUtil.getConsumer().getConsumerId());
            consumerActivateVerifyRecord.setCreateTime(TimeUtil.getSqlTimeStamp());
            consumerActivateVerifyRecord.setState(ISystemConsts.CONSUMER_ACTIVATE_VERIFY_RECORD_STATE_UNAUDITED);
            int insert = consumerActivateVerifyRecordMapper.insert(consumerActivateVerifyRecord);
            return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, insert);
        }
        return new ReturnUtil(ISystemConsts.AJAX_IS_NOT_LOGIN, "error");

    }

    /**
     * 身份证验证
     *
     * @param consumerActivateVerifyRecord
     * @return
     */
    @Override
    public ReturnUtil idCard(ConsumerActivateVerifyRecord consumerActivateVerifyRecord) {
        if (GlobalConsumerUtil.isLogin()) {
            // 登录
            String verify = IdVerifyUtil.verify(
                    IApiConsts.APPCODE_ID_VERIFY_SHAOKANG, // 选择 appcode
                    consumerActivateVerifyRecord.getName(), // 获取姓名
                    consumerActivateVerifyRecord.getCode() // 获取身份证号码
            );

            IdCard idCard = IdVerifyUtil.jsonStringToObject(verify);
            System.out.println(idCard);

            if (idCard.getRespCode().equals(IApiConsts.ID_CARD_VERIFY_SUCCESS) /** 如果包含 0000 **/
                    || idCard.getRespCode() == IApiConsts.ID_CARD_VERIFY_SUCCESS
            ) {
                // 验证成功
                return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, idCard);
            } else {
                // 验证出了问题
                return new ReturnUtil(ISystemConsts.AJAX_ERROR, idCard);
            }
        }
        // 未登录
        return new ReturnUtil(ISystemConsts.AJAX_IS_NOT_LOGIN, "error");
    }

    /**
     * 用户审额状态
     * 1 2 3 4
     * 未审额
     * 已审额
     * 未通过
     * 已通过
     *
     * @return
     */
    @Override
    public ReturnUtil verifyState() {
        if (GlobalConsumerUtil.isLogin()) {
            ConsumerInfo queryConsumerInfo = new ConsumerInfo();
            queryConsumerInfo.setId(ConsumerSessionUtil.getConsumer().getConsumerId());
            ConsumerInfo consumerInfo = consumerInfoMapper.selectOne(new QueryWrapper<>(queryConsumerInfo));
            System.out.println(consumerInfo);
            if (consumerInfo.getVerifyState() == ISystemConsts.CONSUMER_INFO_VERIFY_STATE_PASS) {
                // 如果申请已通过，我需要查询一下他的身份证编号与姓名
                Integer cardId = consumerInfo.getCardId(); // 找到身份证信息表的id
                ConsumerCard querConsumerCard = new ConsumerCard();
                querConsumerCard.setId(cardId);
                ConsumerCard consumerCard = consumerCardMapper.selectOne(new QueryWrapper<>(querConsumerCard));
                return new ReturnUtil(consumerInfo.getVerifyState(), consumerCard);
            }
            return new ReturnUtil(consumerInfo.getVerifyState(), consumerInfo);
        }
        return new ReturnUtil(ISystemConsts.AJAX_IS_NOT_LOGIN, "error");
    }

    /**
     * 验证身份证号码是否被实名过
     * 找提交单
     * 未审核的所有身份信息可以重复提交，但后台只给处理第一个提交过来的信息，其余全部拒绝
     * 需要验证 idCard 表中查找此身份证是否存在，因为 idCard 表中存放的全部都是通过认证的身份信息
     *
     * @param consumerActivateVerifyRecord
     * @return
     */
    @Override
    public ReturnUtil verifyIdCardExist(ConsumerActivateVerifyRecord consumerActivateVerifyRecord) {

        ConsumerCard queryConsumerCard = new ConsumerCard();
        queryConsumerCard.setCode(consumerActivateVerifyRecord.getCode());
        ConsumerCard consumerCard = consumerCardMapper.selectOne(new QueryWrapper<>(queryConsumerCard));
        System.out.println(consumerCard);
        if (consumerCard != null) {
            // 如果查到这个身份信息
            // 返回此身份信息已被占用
            return new ReturnUtil(ISystemConsts.VERIFY_ID_INFO_DISABLE, "disable");
        } else {
            // 没有查到 可以使用
            return new ReturnUtil(ISystemConsts.VERIFY_ID_INFO_ENABLE, "enable");
        }
    }
}
