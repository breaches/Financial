package com.breach.huajinbao.util.record;

public class BaseQuery {
    private Integer page;
    private Integer count;

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
