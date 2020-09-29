package com.cebbank.liuxiaoming.springmvc.crud.servlet;

import com.cebbank.liuxiaoming.springmvc.crud.dao.DepartmentDao;
import com.cebbank.liuxiaoming.springmvc.crud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class EmployeeHandler {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(value = "emp",method = RequestMethod.GET)
    public String input(Map<String,Object> map) {
        map.put("deparments",departmentDao.getDepartments());
        return "input";
    }

    @RequestMapping("/emps")
    public String list(Map<String,Object> map){
        map.put("employees",employeeDao.getAll());
        return "list";
    }
}
