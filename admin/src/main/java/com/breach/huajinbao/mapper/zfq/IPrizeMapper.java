package com.breach.huajinbao.mapper.zfq;

import com.breach.huajinbao.util.zfq.PrizeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IPrizeMapper {
    List<Map> getPrize(PrizeQuery p);

    Integer getPrizeTotal(PrizeQuery p);

    List<Map> recheck(PrizeQuery p);

    Integer recheckTotal(PrizeQuery p);

    List<Map> failure(PrizeQuery p);

    Integer failureTotal(PrizeQuery p);

    List<Map> Invitation(PrizeQuery p);

    Integer InvitationTotal(PrizeQuery p);
}
