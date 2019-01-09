package com.breach.huajinbao.util.global;

import com.breach.api.message.HttpUtils;
import com.breach.huajinbao.sysconst.ISystemConsts;
import org.apache.http.HttpResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-08 15:40
 **/
public class MessageUtil {

    public static String generatorRandomCode() {
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        StringBuilder randomCode = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            randomCode.append(numbers[r.nextInt(9)]);
        }

        return randomCode.toString();
    }

    public static String sendMessage(String phone, String template){
        System.out.println("【系统消息】验证码开始发送");
        String randomCode = generatorRandomCode(); // 随机验证码
        setRandomCode(randomCode); // 存起来
        String host = "http://dingxin.market.alicloudapi.com";
        String path = "/dx/sendSms";
        String method = "POST";
        String appcode = "dc34a85368654bad9e1967dd86020fad";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);
        querys.put("param", "code:" + getRandomCode());
        querys.put("tpl_id", template);
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
            System.out.println("【系统消息】验证码发送成功：" + randomCode);
        } catch (Exception e) {
            System.out.println("【系统消息】验证码发送异常，准备再次发送...");
            e.printStackTrace();
            sendMessage(phone, template);
        } finally {
            return randomCode;
        }
    }

    /***********存储***********/
    private static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    /**
     * 获取 servlet 请求
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    /**
     * 获取 session 中的验证码
     * @param
     * @return
     */
    public static String getRandomCode() {
        return (String) getSession().getAttribute(ISystemConsts.MESSAGE_RANDOM_CODE);
    }

    /***
     * 存储随机验证到 session 中
     * @param randomCode
     */
    public static void setRandomCode(String randomCode) {
        getSession().setAttribute(ISystemConsts.MESSAGE_RANDOM_CODE, randomCode);
    }

    /**
     * 清除 session
     */
    public static void removeRandomCode() {
        HttpSession session = getSession();
        session.invalidate();
    }

}