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

}
