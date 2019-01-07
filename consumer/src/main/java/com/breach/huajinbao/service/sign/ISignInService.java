package com.breach.huajinbao.service.sign;

import com.breach.common.entity.ConsumerAuths;
import com.breach.huajinbao.util.sign.ReturnUtil;

public interface ISignInService {

    ReturnUtil login(ConsumerAuths consumerAuths);

}
