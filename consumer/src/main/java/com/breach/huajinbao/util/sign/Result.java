package com.breach.huajinbao.util.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-02-26 14:41
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private  int code;
    private String msg;
}
