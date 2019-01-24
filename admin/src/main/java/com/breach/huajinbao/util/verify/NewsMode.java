package com.breach.huajinbao.util.verify;

/**
 * Created by wanghehe on 2019年01月15日
 */
public interface NewsMode {


    String SUCCESS_TITLE="激活成功";
    String SUCCESS_CONTENT="用户您好，欢迎使用华金宝，现已激活成功，请放心使用";
    String DEFEAT_TITLE="激活失败";
    String DEFEAT_CONTENT="用户您好，欢迎使用华金宝，激活失败，请检查信息，再次提交";

    String SUCCESS_TITLE_AUDIT="招标审核通过";
    String SUCCESS_CONTENT_AUDIT="用户您好，欢迎使用华金宝，现已招标审核通过，请耐心等待招标结果";
    String DEDEAT_TITLE_AUDIT="招标审核未通过";
    String DEFEAT_CONTENT_AUDIT="用户您好，欢迎使用华金宝，现已招标审核未通过，请重新尝试";

    String SUCCESS_TITLE_AUDIT_FULL_SCALE="满标初审通过";
    String SUCCESS_CONTENT_AUDIT_FULL_SCALE="用户您好，欢迎使用华金宝，现已招满标初审通过，请耐心等待招标结果";
    String DEDEAT_TITLE_AUDIT_FULL_SCALE="满标初审未通过";
    String DEFEAT_CONTENT_AUDIT_FULL_SCALE="用户您好，欢迎使用华金宝，现已满标初审未通过，请重新尝试";

    String SUCCESS_TITLE_AUDIT_RE_FULL_SCALE="满标复审通过";
    String SUCCESS_CONTENT_AUDIT_RE_FULL_SCALE="用户您好，欢迎使用华金宝，现已招标满标复审通过，请查收招标金额";
    String DEDEAT_TITLE_AUDIT_RE_FULL_SCALE="满标复审未通过";
    String DEFEAT_CONTENT_AUDIT_RE_FULL_SCALE="用户您好，欢迎使用华金宝，现已满标复审未通过，请重新尝试";

    //failure
    String FAILURE_TITLE="流标";
    String FAILURE_CONTENT="用户你好，欢迎使用华金宝，招标失败，现已流标";

}
