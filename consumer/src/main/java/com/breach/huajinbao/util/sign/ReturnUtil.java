package com.breach.huajinbao.util.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-05 12:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 状态码 **/
    private Integer code;
    /** 消息 **/
    private String message;
    /** 数据 **/
    private List data;
    /**map**/
    private Map map;
    /** 对象 **/
    private Object object;


    public ReturnUtil(Integer code) {
        this.code = code;
    }

    public ReturnUtil(String message) {
        this.message = message;
    }

    public ReturnUtil(List data) {
        this.data = data;
    }
    public ReturnUtil(Integer code, List data) {
        this.code = code;
        this.data = data;
    }
    public ReturnUtil(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public ReturnUtil(Integer code, Object object) {
        this.code = code;
        this.object = object;
    }
    public ReturnUtil(Integer code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }
    public ReturnUtil(Integer code, List data, Object object) {
        this.code = code;
        this.data = data;
        this.object = object;
    }

}
