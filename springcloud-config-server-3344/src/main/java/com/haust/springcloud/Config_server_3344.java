package com.haust.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Auther: csp1999
 * @Date: 2020/05/21/9:52
 * @Description:
 */
@SpringBootApplication
@EnableConfigServer //开启spring cloud config server服务
public class Config_server_3344 {
    public static void main(String[] args) {
        SpringApplication.run(Config_server_3344.class,args);
    }
}
