package com.breach.huajinbao.util.product;

import com.breach.huajinbao.util.sign.ReturnUtil;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-21 18:47
 **/
public class ProductUtil {

    public static Map<String, Object> getData(Map data) {

        // 产品名 + 产品单子编号
        StringBuilder spliceProduct = new StringBuilder();
        spliceProduct.append(data.get("product_name"));
        spliceProduct.append("-");
        spliceProduct.append(data.get("borrow_number"));
        data.put("productID", spliceProduct.toString());

        // 更新年利率格式
        data.put("lending_rate", ProductUtil.annualRatePlus(data.get("lending_rate")));

        // 插入描述信息
        data.put("description", ProductUtil.getDescription(
                data.get("name"),
                data.get("sex"),
                data.get("borrow_money")
        ));
        return data;
    }

    /**
     * 补充年利率格式：12.00，精确到小数后两位
     *
     * @param rate
     * @return
     */
    public static String annualRatePlus(Object rate) {
        StringBuilder annualRate = new StringBuilder();
        annualRate.append(rate);
        int length = (((BigDecimal) rate).toString()).length();
        switch (length) {
            case 2:
                annualRate.append(".00");
                break;
            case 4:
                annualRate.append("0");
                break;
        }
        return annualRate.toString();
    }

    /**
     * 获取散标描述信息
     *
     * @param name
     * @param sex
     * @param amount
     * @return
     */
    public static String getDescription(Object name, Object sex, Object amount) {
        StringBuilder description = new StringBuilder();
        description.append("本项借款属于个人借款，借款总金额");
        description.append(amount);
        description.append("元。");
        description.append("借款人");
        description.append(getGenderName((String) name, (Boolean) sex));
        description.append("人资质已通过审核，申请信息已核实，结合资料审查和风险项综合评估，其还款能力符合要求。");
        description.append("根据借款人当前情况评估，其还款来源能够覆盖借款本息且还款意愿良好。");
        description.append("但不排除未来因宏观经济、市场产品价格波动、经营不善等因素导致借款人经营情况、财务状况恶化，从而发生逾期的可能。");
        return description.toString();
    }

    /**
     * 获取姓别称 袁先生/袁女士
     *
     * @param name
     * @param sex
     * @return
     */
    public static String getGenderName(String name, boolean sex) {
        return getFirstName(name) + getGender(sex);
    }

    /**
     * 获取性的别称 true：1：男士/false：2：女士
     *
     * @param sex
     * @return
     */
    public static String getGender(boolean sex) {
        return sex ? "先生" : "女士";
    }

    /**
     * 获取姓名的姓
     *
     * @param name
     * @return
     */
    public static String getFirstName(String name) {
        return name.substring(0, 1);
    }

}
