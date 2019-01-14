package com.breach.huajinbao.sysconst;

/**
 * @program: Financial
 * @description: 系统常量
 * @author: shaokang
 * @create: 2019-01-05 14:57
 **/
public interface ISystemConsts {

    /** 用户 session 键名 **/
    String CONSUMER_SESSION = "CONSUMER";
    /** 随机验证码 **/
    String MESSAGE_RANDOM_CODE = "MESSAGE_RANDOM_CODE";

    /* AJAX 异步请求结果 */
    /** AJAX 请求成功 **/
    Integer AJAX_SUCCESS = 200;
    /** AJAX 未登录 **/
    Integer AJAX_IS_NOT_LOGIN = 401;
    /** AJAX 请求失败 **/
    Integer AJAX_ERROR = 400;

    /** 额度申请订单的状态 **/
    /** 未审核 - 审核中 **/
    Integer CONSUMER_ACTIVATE_VERIFY_RECORD_STATE_UNAUDITED = 1;
    /** 通过 **/
    Integer CONSUMER_ACTIVATE_VERIFY_RECORD_STATE_PASS = 2;
    /** 未通过 **/
    Integer CONSUMER_ACTIVATE_VERIFY_RECORD_STATE_NO_PASS = 3;

    /** 用户申请额度的状态 **/
    /** 【未申请】 1 **/
    Integer CONSUMER_INFO_VERIFY_STATE_NEVER = 1;
    /** 【已审额】 2 **/
    Integer CONSUMER_INFO_VERIFY_STATE_WAIT = 2;
    /** 【未通过】 3 **/
    Integer CONSUMER_INFO_VERIFY_STATE_NO_PASS = 3;
    /** 【已通过】 4 **/
    Integer CONSUMER_INFO_VERIFY_STATE_PASS = 4;

    /** 验证 认证 **/
    /** 身份信息可以使用，目前没有被占用 **/
    Integer VERIFY_ID_INFO_ENABLE = 1001;
    /** 身份信息不可用，已被占用 **/
    Integer VERIFY_ID_INFO_DISABLE = 1002;

}
