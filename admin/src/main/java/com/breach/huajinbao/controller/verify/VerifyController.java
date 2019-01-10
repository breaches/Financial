package com.breach.huajinbao.controller.verify;

import com.breach.huajinbao.service.verify.IVerifyService;
import com.breach.huajinbao.util.verify.VerifyQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 认证信息控制层
 */
@RequestMapping("/verify")
@RestController
public class VerifyController {

    @Autowired
    private IVerifyService verifyService;

    
    /**
     * @Description: 获取实名认证信息
     * @Param:  * @param
     * @return:  待处理实名认证表
     * @Author: wanghe
     * @Date: 2019/1/6 20:23
     */ 
    @RequestMapping("/getUserInfo")
    public Map<String,Object> getUserInfo(@RequestBody VerifyQuery info){

      return  verifyService.getUserInfo(info);

      /**
       * @Description:  获取实名认证信息的个人详情进行比对，（通过或不通过）
       * @Param:  * @param info
       * @return: java.util.Map<java.lang.String,java.lang.Object>
       * @Author: wanghe
       * @Date: 2019/1/6 22:27
       */
    }
    @RequestMapping("/getDetailed")
    public   Map<String,Object> getDetailed(int id){

        return null;
    }

}
