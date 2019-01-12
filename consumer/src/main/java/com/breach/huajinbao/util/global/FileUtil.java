package com.breach.huajinbao.util.global;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-12 12:42
 **/
public class FileUtil {

    /**
     * MultipartFile 类型 转向 File 类型工具
     * @param multipartFile
     * @return
     * @throws Exception
     */
    public static File MultipartFileToFile(MultipartFile multipartFile) throws Exception {
        InputStream inputStream = multipartFile.getInputStream();
        String originalFilename = multipartFile.getOriginalFilename();
        String prefix = originalFilename.substring(originalFilename.lastIndexOf("."));
        final File excelFile = File.createTempFile("aaa", prefix);
        multipartFile.transferTo(excelFile);
        deleteFile(excelFile);
        return excelFile;
    }

    private static void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                ///file.delete();
            }
        }
    }

    public static File TestMultipartFileToFile(MultipartFile multipartFile) throws Exception {
        System.out.println("=========================================");
        System.out.println("开始 -> ");
        System.out.println("multipartFile -> " + multipartFile);
        InputStream inputStream = multipartFile.getInputStream();
        System.out.println("multipartFile.getInputStream -> " + inputStream);
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println("originalFilename -> " + originalFilename);
        String prefix = originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println("prefix -> " + prefix);
        final File excelFile = File.createTempFile("asdasdas", prefix);
        System.out.println("excelFile -> " + excelFile);
        multipartFile.transferTo(excelFile);
        System.out.println("转换...");
        if (excelFile.exists()) {
            System.out.println("存在 删掉");
            excelFile.delete();
        }
        System.out.println("=========================================");
        return null;
    }

}
