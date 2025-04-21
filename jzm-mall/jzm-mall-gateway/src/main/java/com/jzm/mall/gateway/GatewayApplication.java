package com.jzm.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关服务启动类
 */
@SpringBootApplication              // Spring Boot 应用启动注解
@EnableDiscoveryClient             // 启用服务注册发现（Nacos）
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println("✅ jzm-mall-gateway 网关模块启动成功！");
    }
}