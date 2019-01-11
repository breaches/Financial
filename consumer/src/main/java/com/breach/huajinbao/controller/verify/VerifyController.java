package com.breach.huajinbao.controller.verify;

import com.breach.common.entity.RegionCity;
import com.breach.common.entity.RegionProvince;
import com.breach.huajinbao.service.verify.IVerifyService;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Financial
 * @description: 认证
 * @author: shaokang
 * @create: 2019-01-10 19:26
 **/
@RestController
@RequestMapping("/verify")
public class VerifyController {

    @Autowired
    IVerifyService verifyService;

    @RequestMapping("/listAllProvince")
    public ReturnUtil listAllProvince() {
        return verifyService.listAllProvince();
    }

    @RequestMapping("/listAllRegions")
    public ReturnUtil listAllRegions() {
        return verifyService.listAllRegions();
    }

    @RequestMapping("/getListAllCity")
    public ReturnUtil getListAllCity(@RequestBody RegionProvince regionProvince) {
        return verifyService.getListAllCity(regionProvince);
    }

    @RequestMapping("/getListAllArea")
    public ReturnUtil getListAllArea(@RequestBody RegionCity regionCity) {
        return verifyService.getListAllArea(regionCity);
    }

    @RequestMapping("/listAllEducation")
    public ReturnUtil listAllEducation() {
        return verifyService.listAllEducation();
    }

    @RequestMapping("/listAllIncome")
    public ReturnUtil listAllIncome() {
        return verifyService.listAllIncome();
    }

    /**
     * 上传
     **/


























    @RequestMapping("/uploadFront")
    public ReturnUtil uploadFront(@RequestBody MultipartFile[] file, String type) {

        System.out.println("----------------------------------");
        System.out.println("type ->");
        System.out.println(type);
        System.out.println("----------------------------------");
        System.out.println("==================================");
        System.out.println("file ->");
        System.out.println(file);
        System.out.println("==================================");

        //获取项目编译之后的文件路径，一般是“项目路径/target/classes”
        String Path = (
                String.valueOf(
                        Thread.currentThread()
                                .getContextClassLoader()
                                .getResource("") + "static/swagger/")
        ).replaceAll("file:/", "")
                .replaceAll("%20", " ")
                .trim();
        if (Path.indexOf(":") != 1) {
            Path = File.separator + Path;
        }
        System.out.println("path -> " + Path);
        //遍历文件
        if (file != null && file.length > 0) {
            System.out.println("文件正常");
            for (MultipartFile item : file) {
                System.out.println("item -> " + item);
                String fileName = item.getOriginalFilename();//获取文件名
                System.out.println("item fileName -> " + fileName);
                String filePath = Path + "uploadFiles/uploadFiles";//自定义上传路径
                System.out.println("item filePath -> " + filePath);
                File file1 = new File(filePath, fileName);
                if (!file1.exists()) {//判断文件夹是否存在，如果不存在则创建
                    if (!file1.getParentFile().exists()) {
                        System.out.println("文件夹不存在，开始创建文件夹... -> " + file1);
                        file1.getParentFile().mkdirs();
                    }
                    try {
                        file1.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.println("开始上传文件...");
                    item.transferTo(file1);//上传文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}
