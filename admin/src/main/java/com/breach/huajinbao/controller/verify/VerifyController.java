package com.breach.huajinbao.controller.verify;

import com.breach.huajinbao.service.verify.IVerifyService;
import com.breach.huajinbao.util.verify.Result;
import com.breach.huajinbao.util.verify.VerifyQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wanghehe
 * 认证信息控制层
 */
@RequestMapping("/verify")
@RestController
public class VerifyController {

    @Autowired
    private IVerifyService verifyService;


    /**
     * @Description: 获取实名认证信息
     * @Param: * @param
     * @return: 待处理实名认证表
     * @Author: wanghe
     * @Date:
     */
    @RequestMapping("/getUserInfo")
    public Map<String, Object> getUserInfo(@RequestBody VerifyQuery info) {

        return verifyService.getUserInfo(info);

    }

    /**
     * @Description: 获取实名认证信息的个人详情进行比对，（通过或不通过）
     * @Param:  * @param info
     * @return: java.util.Map<java.lang.String , java.lang.Object>
     * @Author: wanghe
     * @Date:
     */

    @RequestMapping("/getDetailed")
    public Map<String, Object> getDetailed(String record) {
        return verifyService.getDetailed(record);

    }

    /**
     * @Description: 通过时，提交信息（分步处理）
     * @Param: * @param null
     * @return: 通过成功提示
     * @Author: wanghe
     * @Date: 2019/1/15 13:36
     */
    @RequestMapping("/submitReInfo")
    public Result submitReInfo(String recordNumber) {

        return verifyService.submitReInfo(recordNumber);
    }
    /**
     * @Description: 不通过时，处理
     * @Param:  * @param null
     * @return:
     * @Author: wanghe
     * @Date: 2019/1/16 19:55
     */
    @RequestMapping("/submitNoInfo")
    public Result submitNoInfo(String recordNumber) {
        return verifyService.submitNoInfo(recordNumber);
    }

}
