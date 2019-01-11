package com.breach.huajinbao.util.global;

import com.breach.api.message.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class IdentityVerify {
    public static void main(String[] args) {
        String host = "https://idenauthen.market.alicloudapi.com";
        String path = "/idenAuthentication";
        String method = "POST";
        String appcode = "7be28c7a8c2e4dc2a4a2706eb412747d";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("idNo", "412723199902040039");
        bodys.put("name", "袁韶康");
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
            System.out.println("************************************************");
            System.out.println("response ->");
            System.out.println(response);
            System.out.println("response.toString ->");
            System.out.println(response.toString());
            //获取response的body
            System.out.println("response body ->");
            System.out.println(EntityUtils.toString(response.getEntity()));
            System.out.println("************************************************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}