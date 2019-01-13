package com.breach.huajinbao.util.verify;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class VerifyQuery {
	
	private  int  page;
	private  int  count;
	
	private  String  name;
	private  String  beginDate;
	private  String  endDate;
	
	public int getPage(){
		return (page-1)*count;
	}

}
