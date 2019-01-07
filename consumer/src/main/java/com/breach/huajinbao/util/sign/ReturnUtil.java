package com.breach.huajinbao.util.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-05 12:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnUtil {
    /** 状态码 **/
    private Integer code;
    /** 消息 **/
    private String message;
    /** 数据 **/
    private List data;

    public ReturnUtil(Integer code) {
        this.code = code;
    }

    public ReturnUtil(String message) {
        this.message = message;
    }

    public ReturnUtil(List data) {
        this.data = data;
    }
    public ReturnUtil(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
