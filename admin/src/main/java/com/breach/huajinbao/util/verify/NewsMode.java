package com.breach.huajinbao.util.verify;

/**
 * Created by wanghehe on 2019年01月15日
 */
public interface NewsMode {

    /**
     * 成功标题
     * @param
     * @return
     *
     */
    String SUCCESS_TITLE="激活成功";
    String SUCCESS_CONTENT="用户您好，欢迎使用华金宝，现已激活成功，请放心使用";
    String DEFEAT_TITLE="激活失败";
    String DEFEAT_CONTENT="用户您好，欢迎使用华金宝，激活失败，请检查信息，再次提交";
    String SUCCESS_TITLE_AUDIT="招标审核通过";
    String SUCCESS_CONTENT_AUDIT="用户您好，欢迎使用华金宝，现已招标审核通过，请耐心等待招标结果";
    String DEDEAT_TITLE_AUDIT="招标审核未通过";
    String DEFEAT_CONTENT_AUDIT="用户您好，欢迎使用华金宝，现已招标审核未通过，请重新尝试";


}
