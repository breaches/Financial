package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-02 22:59
 **/
@SpringBootApplication
@MapperScan({
        "com.breach.common.mapper",
        "com.breach.huajinbao.mapper.*"
})
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
