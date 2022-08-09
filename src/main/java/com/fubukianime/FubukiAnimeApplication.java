package com.fubukianime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

import java.util.TimeZone;

@SpringBootApplication
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})//去掉数据源
@ServletComponentScan
@EnableCaching // 开启Spring Cache注解方式缓存功能
public class FubukiAnimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FubukiAnimeApplication.class, args);

    }

}
