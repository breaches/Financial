package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@SpringBootApplication
@MapperScan({
        "com.breach.common.mapper",
        "com.breach.huajinbao.mapper.sign",
        "com.breach.huajinbao.mapper.*",
        "com.breach.huajinbao.mapper.quest"
})
@EnableTransactionManagement
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}