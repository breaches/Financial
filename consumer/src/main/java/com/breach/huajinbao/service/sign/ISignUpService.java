package com.breach.huajinbao.service.sign;

import com.breach.common.entity.ConsumerAccount;
import com.breach.huajinbao.util.sign.RegisterData;
import com.breach.huajinbao.util.sign.ReturnUtil;

public interface ISignUpService {
    ReturnUtil join(ConsumerAccount consumerAccount);

    ReturnUtil sendMessage(RegisterData registerData);

    ReturnUtil verifyCode(RegisterData registerData);

    ReturnUtil register(RegisterData registerData);
}
