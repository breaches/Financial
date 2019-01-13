package com.breach.huajinbao.sysconst.api;

/**
 * @program: Financial
 * @description: 接口常量
 * @author: shaokang
 * @create: 2019-01-08 15:44
 **/
public interface IApiConsts {
    /** 【登录】 验证码模板 **/
    String TEMPLATE_LOGIN = "TP1901082";
    /** 【注册】 验证码模板 **/
    String TEMPLATE_REGISTER = "TP1901087";
    /** 【重置密码】 验证码模板 **/
    String TEMPLATE_RESET_PASSWORD = "TP1901089";
    /** 【修改绑定手机号】 验证码模板 **/
    String TEMPLATE_PHONE_BIND = "TP19010810";
    /** 【支付验证码】 验证码模板 **/
    String TEMPLATE_PAY = "TP1901088";

    /** 【正面/头像面】 身份证图片扫描接口 **/
    String IDCARD_FRONT = "front";
    /** 【反面/国徽面】 身份证图片扫描接口 **/
    String IDCARD_BACK = "back";

    /** 【身份证二要素校验】 高磊 **/
    String APPCODE_ID_VERIFY_GAOLEI = "9858fb2548b04cc7b0b4e920a3d141cb";
    /** 【身份证二要素校验】 森林 **/
    String APPCODE_ID_VERIFY_SENLIN = "dc34a85368654bad9e1967dd86020fad";
    /** 【身份证二要素校验】 富强 **/
    String APPCODE_ID_VERIFY_FUQIANG = "2c045b5dc09b404d9422c519ac85e7ac";
    /** 【身份证二要素校验】 韶康 **/
    String APPCODE_ID_VERIFY_SHAOKANG = "7be28c7a8c2e4dc2a4a2706eb412747d";

    /** 【Ali OSS】 endpoint **/
    String ALI_OSS_ENDPOINT = "oss-cn-beijing.aliyuncs.com";
    /** 【Ali OSS】 AK **/
    String ALI_OSS_ACCESS_KEY_ID = "LTAIC9EtDnxGReKf";
    /** 【Ali OSS】 AKS **/
    String ALI_OSS_ACCESS_KEY_SECRET = "Gw4pVHFwzU8JRsdbAkPVwvFstjE9oV";
    /** 【Ali OSS】 bucketName **/
    String ALI_OSS_BUCKET_NAME = "olololo";
}
