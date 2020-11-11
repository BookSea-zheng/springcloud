package com.zsh.springcloud.dao;

import com.zsh.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2020/11/8 - 11:26
 */
@Mapper
@Repository
public interface DeptDao {
    public  boolean addDept(Dept dept);
    public  Dept queryById(Long id);
    public List<Dept> queryAll();
}
