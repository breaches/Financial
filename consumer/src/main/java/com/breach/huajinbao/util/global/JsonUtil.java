package com.breach.huajinbao.util.global;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-08 13:13
 **/
@Data
public class JsonUtil {
    private List data = new ArrayList();
    private Map map = new HashMap();

    public void put(String key, Object value) {
        map.put(key, value);
        data.add(map);
    }

    public List getJson() {
        return data;
    }
}
