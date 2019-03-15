package com.mzyan.springboot.controller;

import com.mzyan.springboot.dao.DepartmentDao;
import com.mzyan.springboot.dao.EmployeeDao;
import com.mzyan.springboot.entities.Department;
import com.mzyan.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放到q请求域中
        model.addAttribute("emps", employees);
        //thymeleaf 会默认拼接路径
        // classpath:/templates/xxxx.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        //来到添加页面
        return "emp/add";
    }
}
