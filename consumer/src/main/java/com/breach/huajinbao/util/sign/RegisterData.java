package com.breach.huajinbao.util.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-08 18:51
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterData {
    /** 用户名 **/
    private String username;
    /** 密码 **/
    private String password;
    /** 确认密码 **/
    private String repassword;
    /** 手机号码 **/
    private String phone;
    /** 手机验证码 **/
    private String code;
}
