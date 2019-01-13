package com.breach.api.idno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-12 22:33
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdCard {
    /**姓名**/
    private String name;
    /**身份证号码**/
    private String idNo;
    /**返回信息**/
    private String respMessage;
    /**返回代码**/
    private String respCode;
    /**省份**/
    private String province;
    /**城市**/
    private String city;
    /**地区**/
    private String county;
    /**生日**/
    private String birthday;
    /**性别 M：男**/
    private String sex;
    /**年龄**/
    private String age;
}
