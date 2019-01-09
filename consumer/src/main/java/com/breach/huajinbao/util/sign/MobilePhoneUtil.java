package com.breach.huajinbao.util.sign;

/**
 * @program: Financial
 * @description: 手机号码工具
 * @author: shaokang
 * @create: 2019-01-07 22:12
 **/
public class MobilePhoneUtil {

    /**
     * 是否是电话号码
     * 先判断是否是十一位数字
     * 再判断是否是正确的手机号码
     * @param phone
     * @return
     */
    public static boolean isMobilePhone(String phone) {
        if(isNumber(phone)) {
            if(isPhone(phone)) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * 是否是 11 位数字
     * @return
     */
    public static boolean isNumber(String number) {
        return number.matches("[0-9]{11}");
    }

    /**
     * 是否是手机号码
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        StringBuilder re = new StringBuilder();
        re.append("^(1)");
        re.append("(");
        // 移动
        re.append("(3[4-9])");
        re.append("|(4[7-8])");
        re.append("|(5[0-2])");
        re.append("|(5[7-9])");
        re.append("|(6[5])");
        re.append("|(7[2])");
        re.append("|(7[8])");
        re.append("|(8[2-4])");
        re.append("|(8[7-8])");
        re.append("|(9[8])");
        // 联通
        re.append("|(3[0-2])");
        re.append("|(4[5-6])");
        re.append("|(5[5-6])");
        re.append("|(6[6])");
        re.append("|(7[1])");
        re.append("|(7[5-6])");
        re.append("|(8[5-6])");
        // 电信
        re.append("|(3[3])");
        re.append("|(4[9])");
        re.append("|(5[3])");
        re.append("|(7[3-4])");
        re.append("|(7[7])");
        re.append("|(8[0-1])");
        re.append("|(8[9])");
        re.append("|(9[1])");
        re.append("|(9[9])");
        // 虚拟
        re.append("|(7[0])");
        re.append(")");
        re.append("[0-9]{8}");

        return phone.matches(re.toString());
    }
}
