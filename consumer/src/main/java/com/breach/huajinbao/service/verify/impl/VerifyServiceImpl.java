package com.breach.huajinbao.service.verify.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breach.common.entity.*;
import com.breach.common.mapper.*;
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
    IRegionProvinceMapper regionProvinceMapper;
    @Autowired
    IRegionCityMapper regionCityMapper;
    @Autowired
    IRegionAreaMapper regionAreaMapper;
    @Autowired
    IConsumerEducationMapper consumerEducationMapper;
    @Autowired
    private IConsumerIncomeRangeMapper consumerIncomeRangeMapper;


    @Override
    public ReturnUtil listAllProvince() {

        List<RegionProvince> regionProvinces = regionProvinceMapper.selectList(null);

        System.out.println("---------------------------------");
        System.out.println("全国省份数据");
        System.out.println(regionProvinces);
        System.out.println("---------------------------------");


        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, regionProvinces);
    }

    @Override
    public ReturnUtil listAllRegions() {

        return null;
    }

    @Override
    public ReturnUtil getListAllCity(RegionProvince regionProvince) {
        System.out.println(regionProvince);
        String codeProvince = regionProvince.getCodeProvince();
        RegionCity regionCity = new RegionCity();
        regionCity.setCodeProvince(codeProvince);

        List<RegionCity> regionCities = regionCityMapper.selectList(new QueryWrapper<>(regionCity));
        System.out.println("******************************************************");
        System.out.println("查出的所有城市");
        System.out.println(regionCities);
        System.out.println("******************************************************");

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, regionCities);
    }

    @Override
    public ReturnUtil getListAllArea(RegionCity regionCity) {
        System.out.println("-=-=-=-=-=-=");
        System.out.println(regionCity);
        String codeCity = regionCity.getCodeCity();
        RegionArea regionArea = new RegionArea();
        regionArea.setCodeCity(codeCity);
        List<RegionArea> regionAreas = regionAreaMapper.selectList(new QueryWrapper<>(regionArea));
        System.out.println("******************************************************");
        System.out.println("查出的所有地区");
        System.out.println(regionAreas);
        System.out.println("******************************************************");

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, regionAreas);
    }

    @Override
    public ReturnUtil listAllEducation() {
        List<ConsumerEducation> consumerEducations = consumerEducationMapper.selectList(null);
        System.out.println("******************************************************");
        System.out.println("查出的所有学历");
        System.out.println(consumerEducations);
        System.out.println("******************************************************");

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, consumerEducations);
    }

    @Override
    public ReturnUtil listAllIncome() {
        List<ConsumerIncomeRange> data = verifyMapper.listAllIncome();

        System.out.println("******************************************************");
        System.out.println("查出的所有收入范围");
        System.out.println(data);
        System.out.println("******************************************************");

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, data);
    }
}
