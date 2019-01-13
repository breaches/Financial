package com.breach.huajinbao.util.audit;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class AuditQuery {
	
	private  int  page;
	private  int  count;
	
	private  String  name;
	private  String  beginDate;
	private  String  endDate;
	
	public int getPage(){
		return (page-1)*count;
	}

}
