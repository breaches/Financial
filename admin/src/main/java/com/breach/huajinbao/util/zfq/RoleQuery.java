package com.breach.huajinbao.util.zfq;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class RoleQuery {
	
	private  int  page;
	private  int  count;
	
	private  String  name;
	private  String  description;

	public int getPage(){
		return (page-1)*count;
	}

}
