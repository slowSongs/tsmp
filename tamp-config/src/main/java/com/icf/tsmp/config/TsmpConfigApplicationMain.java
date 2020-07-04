package com.icf.tsmp.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @auhther Arvin
 * @date 2020/7/2 17:20
 * @description:
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.icf.tsmp.config.repository"})
@EnableDubbo
public class TsmpConfigApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(TsmpConfigApplicationMain.class, args);
    }
}
