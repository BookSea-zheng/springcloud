package com.zsh.springcloud.controller;

import com.zsh.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @date 2020/11/8 - 13:31
 */
@RestController
public class DeptConsumerController {
//    消费者不应该有service层
    //使用RestTemplate来调用远程的服务
    @Autowired
    private RestTemplate restTemplate;


//    private  static  final  String REST_URL_PREFIX ="http://localhost:8001";
    private  static  final  String REST_URL_PREFIX ="http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return      restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return      restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return      restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }
}
