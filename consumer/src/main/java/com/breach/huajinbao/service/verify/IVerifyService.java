package com.breach.huajinbao.service.verify;

import com.breach.common.entity.ConsumerActivateVerifyRecord;
import com.breach.common.entity.RegionCity;
import com.breach.common.entity.RegionProvince;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: Financial
 * @description: 认证
 * @author: shaokang
 * @create: 2019-01-10 19:27
 **/
public interface IVerifyService {
    ReturnUtil listAllProvince();

    ReturnUtil listAllRegions();

    ReturnUtil getListAllCity(RegionProvince regionProvince);

    ReturnUtil getListAllArea(RegionCity regionCity);

    ReturnUtil listAllEducation();

    ReturnUtil listAllIncome();

    ReturnUtil uploadFront(MultipartFile file, String type);

    ReturnUtil uploadBack(MultipartFile file, String type);

    ReturnUtil finalSubmit(ConsumerActivateVerifyRecord consumerActivateVerifyRecord);

    ReturnUtil idCard(ConsumerActivateVerifyRecord consumerActivateVerifyRecord);
}
