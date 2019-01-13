package com.breach.huajinbao.util.global;

import com.breach.api.message.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ScanIDcardUtil {

    /**
     *
     * @param url 图片的网络地址路径
     * @param scanType 图片的扫描方式 IDCARD_FRONT 为正面
     * @return
     */
    public static String scanIDCard(String url, String scanType) {
        HttpResponse response = null;
        String host = "https://ocridcard.market.alicloudapi.com";
        String path = "/idimages";
        String method = "POST";
        String appcode = "dc34a85368654bad9e1967dd86020fad";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        // "https://i.loli.net/2019/01/08/5c344f9549953.png"
        bodys.put("image", url);
        bodys.put("idCardSide", scanType);//默认正面，背面请传back
        //或者base64
        //bodys.put("image", "data:image/jpeg;base64,........");   //jpg图片
        //bodys.put("image", "data:image/png;base64,........");   //png图片

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
            response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            //System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                return EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                return null;
        }
    }


    }
}