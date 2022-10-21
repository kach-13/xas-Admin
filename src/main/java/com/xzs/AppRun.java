package com.xzs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.xzs.mapper")
public class AppRun {
    public static void main(String[] args) {
        SpringApplication.run(AppRun.class ,args);
    }
}
