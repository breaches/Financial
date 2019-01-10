package com.breach.huajinbao.service.verify.impl;

import com.breach.common.entity.AddressProvince;
import com.breach.common.mapper.IAddressAreaMapper;
import com.breach.common.mapper.IAddressCityMapper;
import com.breach.common.mapper.IAddressProvinceMapper;
import com.breach.huajinbao.mapper.verify.IVerifyMapper;
import com.breach.huajinbao.service.verify.IVerifyService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-10 19:28
 **/
@Service
public class VerifyServiceImpl implements IVerifyService {

    @Autowired
    IVerifyMapper verifyMapper;

    @Autowired
    IAddressProvinceMapper addressProvinceMapper;

    @Autowired
    IAddressCityMapper addressCityMapper;

    @Autowired
    IAddressAreaMapper addressAreaMapper;

    @Override
    public ReturnUtil listAllProvince() {

        List<AddressProvince> addressProvinces = addressProvinceMapper.selectList(null);
        System.out.println("---------------------------------");
        System.out.println("全国省份数据");
        System.out.println(addressProvinces);
        System.out.println("---------------------------------");


        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, addressProvinces);
    }

    @Override
    public ReturnUtil listAllRegions() {
        List<AddressProvince> addressProvinces = addressProvinceMapper.selectList(null);
        return null;
    }
}
