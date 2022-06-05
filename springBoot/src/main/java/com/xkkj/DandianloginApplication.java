package com.xkkj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xkkj.dao")
public class DandianloginApplication {

    public static void main(String[] args) {
        SpringApplication.run(DandianloginApplication.class, args);
    }

}
