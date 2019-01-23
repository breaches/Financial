package com.breach.huajinbao.util.product;

import java.math.BigDecimal;
import java.util.*;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-21 18:47
 **/
public class ProductUtil {

    /**
     * 获取整理好的借款人信息
     *
     * @param data
     * @return
     */
    public static Map<String, Object> getBorrowerInfo(Map data) {
        // 男女
        if (data.get("sex") != null) {
            data.put("sex", getSex(data.get("sex")));
        }
        // 加密姓名
        if (data.get("name") != null) {
            data.put("name", getFirstName(data.get("name")) + "**");
        }
        // 加密身份证号码
        if (data.get("code") != null) {
            data.put("code", getCodePlus(data.get("code")));
        }
        // 加密居住地
        if (data.get("address") != null) {
            data.put("address", getAddressPlus(data));
        }
        // 婚姻状况
        if (data.get("is_marry") != null) {
            data.put("is_marry", getMarry(data.get("is_marry")));
        }
        // 格式化利率
        if (data.get("lending_rate") != null) {
            data.put("lending_rate", annualRatePlus(data.get("lending_rate")));
        }
        // 修改借款金额格式
        if (data.get("borrow_money") != null) {
            data.put("borrow_money", getBorrowerMoney(data.get("borrow_money")));
        }
        // 有无房产
        if (data.get("is_house") != null) {
            data.put("is_house", getHouse(data.get("is_house")));
        }
        // 有无车辆
        if (data.get("is_car") != null) {
            data.put("is_car", getCar(data.get("is_car")));
        }
        // 是否补充行业信息
        if (data.get("industry") == null) {
            data.put("industry", "待补充");
        }
        // 是否补充岗位
        if (data.get("position") == null) {
            data.put("position", "待补充");
        }
        // 工作地点
        if (data.get("wordAddress") == null) {
            data.put("workAddress", "待补充");
        } else {
            data.put(
                    "workAddress",
                    ((String) data.get("wordAddress")).substring(0, 3)
            );
        }
        // 月收入
        if (data.get("income") == null) {
            data.put("income", "待补充");
        }

        return data;
    }

    /**
     * 有无房产
     *
     * @param house
     * @return
     */
    public static String getHouse(Object house) {
        return ((Boolean) house) ? "有" : "无";
    }

    /**
     * 有无车辆
     *
     * @param car
     * @return
     */
    public static String getCar(Object car) {
        return ((Boolean) car) ? "有" : "无";
    }


    public static Map getDataAfterLogin(Map account) {
        if(account.get("balance") != null) {
            account.put("balance", getBorrowerMoney(account.get("balance")));
        }
        return account;
    }

    /**
     * 返回整理好的标的详细信息，这是登陆后的
     * @param data
     * @param account
     * @return
     */
    public static Map getData(Map<String, Object> data, Map account) {
        Map<String, Object> data1 = getData(data);
        if(account.get("balance") != null) {
            account.put("balance", getBorrowerMoney(account.get("balance")));
        }
        return null;
    }

    /**
     * 返回整理好的标的详细信息，这是没有登录的
     *
     * @param data
     * @return
     */
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

        // 剩余金额
        if (data.get("surplus_amount") != null) {
            data.put("surplus_amount", getBorrowerMoney(data.get("surplus_amount")));
        }
        // 借款金额
        if (data.get("borrow_money") != null) {
            data.put("borrow_money", getBorrowerMoney(data.get("borrow_money")));
        }

        // 个人可用余额
        if(data.get("balance") != null) {
            data.put("balance", getBorrowerMoney(data.get("balance")));
        }


        return data;
    }

    public static String getBorrowerMoney(Object money) {
        BigDecimal bigDecimal = ((BigDecimal) money).setScale(2, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.toString();
    }

    /**
     * 补充年利率格式：12.00，精确到小数后两位
     *
     * @param rate
     * @return
     */
    public static String annualRatePlus(Object rate) {
        // 先判断是否有小数点，没有小数点的增加小数点，有小数点的另外计算


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

    public static String getFirstName(Object name) {
        return ((String) name).substring(0, 1);
    }

    /**
     * 获取男女性别
     *
     * @param sex
     * @return
     */
    public static String getSex(Object sex) {
        return (Boolean) sex ? "男" : "女";
    }

    /**
     * 加密身份证号码 显示前三位以及末尾三位
     *
     * @param code
     * @return
     */
    public static String getCodePlus(Object code) {
        String c = (String) code;
        return c.substring(0, 3) + "************" + c.substring(c.length() - 3);
    }


    /**
     * 加密居住地址/详细地址
     *
     * @param data
     * @return
     */
    private static String getAddressPlus(Map data) {
        StringBuilder address = new StringBuilder();
        address.append(data.get("province"));
        address.append(data.get("city"));
        address.append(data.get("area"));
        address.append(((String) data.get("address")).substring(0, 3) + "******");
        return address.toString();
    }

    /**
     * 获取婚姻状况 true：已婚，false：未婚
     *
     * @param marry
     * @return
     */
    private static String getMarry(Object marry) {
        return (Boolean) marry ? "已婚" : "未婚";
    }

    /**
     * 加密手机号码
     * @param phone
     * @return
     */
    private static String getPhone(Object phone) {
        String p = (String) phone;
        return p.substring(0, 3) + "****" + p.substring(p.length() - 4, p.length() - 1);
    }

    /**
     * 加工获取到的数据结果，投标记录数据
     *
     * @param record
     * @return
     */
    public static List<Map<String, Object>> getTradingRecord(List<Map<String, Object>> record) {
        for (Map<String, Object> item : record) {
            // 加密手机号码
            if(item.get("phone") != null) {
                item.put("phone", getPhone(item.get("phone")));
            }
            // 处理货币
            if(item.get("amount") != null) {
                item.put("amount", getBorrowerMoney(item.get("amount")));
            }
        }
        return record;
    }

    /**
     * 加工分页数据与总数等
     * @param record
     * @param totalTradingRecord
     * @return
     */
    public static Map getTradingRecordInfo(List<Map<String, Object>> record, Integer totalTradingRecord) {
        Map data = new HashMap();
        Set who = new HashSet();

        List<Map<String, Object>> tradingRecord = getTradingRecord(record);
        for (Map<String, Object> item: tradingRecord) {
            who.add(item.get("phone"));
        }
        data.put("info", record);
        data.put("headcount", who.size());
        data.put("totalData", totalTradingRecord);

        return data;
    }


}
