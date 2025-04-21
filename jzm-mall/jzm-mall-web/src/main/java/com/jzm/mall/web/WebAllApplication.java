package com.jzm.mall.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
/**
 * Web应用启动类
 * 整合了服务发现、Feign调用等功能
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 排除数据源自动配置
@ComponentScan({"com.jzm.mall"})  // 指定组件扫描路径
@EnableDiscoveryClient          // 启用服务发现
@EnableFeignClients(basePackages= {"com.jzm.mall.web.client"})  // 启用Feign客户端
public class WebAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAllApplication.class, args);
    }
}