package com.jzm.mall;

import org.springframework.boot.SpringApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.jzm.mall.product.mapper")
@MapperScan(basePackages = "com.jzm.mall.common.config")
public class ProductServiceApplicaion {
    public static void main(String[] args){
        SpringApplication.run(ProductServiceApplicaion.class,args);
    }
}