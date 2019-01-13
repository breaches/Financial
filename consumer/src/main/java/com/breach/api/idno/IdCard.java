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
    private String name;
    private String idNo;
    private String respMessage;
    private Integer respCode;
    private String province;
    private String city;
    private String county;
    private String birthday;
    private String sex;
    private String age;
}
