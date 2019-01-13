package com.breach.huajinbao.mapper.verify;

import com.breach.huajinbao.util.verify.VerifyQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 认证信息dao接口
 */
@Repository
public interface IVerifyMapper {


    List<Map<String, Object>> getAuthentication(VerifyQuery info);

    Integer geTotal(VerifyQuery info);
}
