package com.mzyan.springboot.service;

import com.mzyan.springboot.bean.Department;
import com.mzyan.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(value = "dept")
    public Department getDeptById(Integer id){
        System.out.println("查询部门："+id);
        Department dept = departmentMapper.getDeptById(id);
        return dept;
    }
}
