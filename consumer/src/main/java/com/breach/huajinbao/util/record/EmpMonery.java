package com.breach.huajinbao.util.record;

import com.alibaba.druid.sql.visitor.functions.Substring;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class EmpMonery  {
    private Integer id;
    private boolean borrow_number;
    private String trading_amount;
    private Date create_time;
    private String beginDate;
    private String endDate;
    private Integer page;
    private Integer count;
    private String name;

    public Integer getPage(){
        return (page-1)*count;
    }
    public void setPage(){
        this.page = page;

    }
    public Integer getCount(){
        return count;

    }
    public void setCount(Integer count){
        this.count = count;
    }
}
