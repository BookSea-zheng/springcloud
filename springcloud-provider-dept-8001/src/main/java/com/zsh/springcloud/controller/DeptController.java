package com.zsh.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.zsh.springcloud.pojo.Dept;
import com.zsh.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @date 2020/11/8 - 12:08
 */
//提供Restful服务
    @RestController
public class DeptController {
        @Autowired
        private  DeptService deptService;
        //获取一些配置的信息，得到具体的微服务！
        @Autowired
        private DiscoveryClient client;
@PostMapping("/dept/add")
@HystrixCommand()
        public  boolean addDept(Dept dept){
return  deptService.addDept(dept);
        }

    @GetMapping("/dept/get/{id}")
    @HystrixCommand()
    public  Dept get(@PathVariable("id") Long id){
Dept dept =deptService.queryById(id);
if (dept==null){
throw new RuntimeException("Fail");
}
    return  dept;
    }

    @GetMapping("/dept/list")
    @HystrixCommand()
    public List<Dept> queryAll(){
        return  deptService.queryAll();
    }

    @GetMapping("/dept/discovery")
    @HystrixCommand()
    public Object discovery(){
    List <String> services =client.getServices();
        System.out.println("discovery=>services:"+services);
        List<ServiceInstance> instances=client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance :  instances){
            System.out.println(
                    instance.getHost()+"\t"+
                            instance.getPort()+"\t"+
                            instance.getUri()+"\t"+
                            instance.getServiceId()

            );
        }
        return  this.client;
     }
}
