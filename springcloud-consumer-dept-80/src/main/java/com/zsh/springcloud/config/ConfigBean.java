package com.zsh.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @date 2020/11/8 - 13:34
 */
@Configuration
public class ConfigBean {
    //配置负载均衡RestTemplate,这样发起请求的时候就可以实现负载均衡
    @Bean
    @LoadBalanced  //Rabbon
    public RestTemplate getTemplate(){
        return  new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return  new RandomRule();
    }


}
