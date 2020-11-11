package com.zsh.springcloud.service;

import com.zsh.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2020/11/8 - 11:34
 */
public interface DeptService {
    public  boolean addDept(Dept dept);
    public  Dept queryById(Long id);
    public List<Dept> queryAll();
}
