package com.zhourx.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class,args);
    }
}
