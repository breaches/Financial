package com.breach.huajinbao.util.audit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by wanghehe on
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PassQuery {

    private  String text;
    private  String borrowNumber;
}
