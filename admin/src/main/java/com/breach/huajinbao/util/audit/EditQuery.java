package com.breach.huajinbao.util.audit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by wanghehe on 2019年01月17日
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EditQuery {

    private  int  userId;
    private  String  borrowNumber;

}
