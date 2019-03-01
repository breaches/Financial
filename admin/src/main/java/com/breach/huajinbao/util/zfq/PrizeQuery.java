package com.breach.huajinbao.util.zfq;

import lombok.Data;
import lombok.ToString;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-02-27 21:13
 **/
@Data
@ToString
public class PrizeQuery {
    private  int  page;
    private  int  count;

    private  String  name;
    private String beginDate;
    private  String  endDate;

    public int getPage(){
        return (page-1)*count;
    }
}
