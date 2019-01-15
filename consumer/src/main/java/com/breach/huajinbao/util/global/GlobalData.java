package com.breach.huajinbao.util.global;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: Financial
 * @description: 全局数据
 * @author: shaokang
 * @create: 2019-01-08 13:01
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalData {
    private Integer code;
    private String message;
    private List user;
    private List news;
    private List borrow;
    private Object object;

    public GlobalData(Integer code) {
        this.code = code;
    }

    public GlobalData(String message) {
        this.message = message;
    }

    public GlobalData(List user) {
        this.user = user;
    }

    public GlobalData(Integer code, String message, List user) {
        this.code = code;
        this.message = message;
        this.user = user;
    }

    public GlobalData(Integer code, Object object) {
        this.code = code;
        this.object = object;
    }

    public GlobalData(Object object) {
        this.object = object;
    }

    public GlobalData setUserData(List userData) {
        this.user = userData;
        return this;
    }
}
