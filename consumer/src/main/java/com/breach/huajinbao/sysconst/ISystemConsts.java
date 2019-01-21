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
    int CONSUMER_INFO_VERIFY_STATE_NEVER = 1;
    /** 【已审额】 2 **/
    int CONSUMER_INFO_VERIFY_STATE_WAIT = 2;
    /** 【未通过】 3 **/
    int CONSUMER_INFO_VERIFY_STATE_NO_PASS = 3;
    /** 【已通过】 4 **/
    int CONSUMER_INFO_VERIFY_STATE_PASS = 4;

    /** 验证 认证 **/
    /** 身份信息可以使用，目前没有被占用 **/
    Integer VERIFY_ID_INFO_ENABLE = 1001;
    /** 身份信息不可用，已被占用 **/
    Integer VERIFY_ID_INFO_DISABLE = 1002;



    /**提交招标预审**/
    /**招标预审提交成功**/
    Integer BORROW_BID_APPLY_RECORD_SUCCESS = 2000;
    /**招标预审提交失败，信用额度不足**/
    Integer BORROW_BID_APPLY_RECORD_LACK_OF_CREDIT = 2001;
    /**招标预审提交失败，提交失败**/
    Integer BORROW_BID_APPLY_RECORD_ERROR = 2002;
    /**招标预审提交失败，申请额度失败**/
    Integer BORROW_BID_APPLY_RECORD_CREDIT_FAILURE = 2003;
    /**招标预审提交失败，申请额处理中**/
    Integer BORROW_BID_APPLY_RECORD_CREDIT_PROCESS = 2004;
    /**招标预审提交失败，为申请额度**/
    Integer BORROW_BID_APPLY_RECORD_CREDIT_NEVER = 2005;


    /**投标返回代码**/
    /**散标列表请求成功**/
    Integer PRODUCT_LOAN_PERSON_BID_LIST_SUCCESS = 3000;
    /**散标列表请求失败**/
    Integer PRODUCT_LOAN_PERSON_BID_LIST_ERROR = 3001;
    /**散标详情页请求成功**/
    Integer PRODUCT_LOAN_PERSON_BID_DETAIL_SUCCESS = 3002;
    /**散标详情页请求失败**/
    Integer PRODUCT_LOAN_PERSON_BID_DETAIL_ERROR = 3003;
    /**该标不存在**/
    Integer PRODUCT_LOAN_PERSON_BIT_DETAIL_IS_NOT_EXIST = 3004;


}
