package com.cebbank.liuxiaoming.springmvc.crud.servlet;

import com.cebbank.liuxiaoming.springmvc.crud.dao.DepartmentDao;
import com.cebbank.liuxiaoming.springmvc.crud.dao.EmployeeDao;
import com.cebbank.liuxiaoming.springmvc.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeHandler {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;


    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id",required = false) Integer id,Map<String,Object> map){
        if (id!=null){
            Employee employee= employeeDao.get(id);
            map.put("employee",employee);
        }
    }

    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.POST )
    public String save(@Valid Employee employee, BindingResult result,Map<String,Object> map){
        System.out.println("save:"+employee.toString());
        if (result.getErrorCount()>0){
            System.out.println("save 出错了");
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField()+" ： "+fieldError.getDefaultMessage());
            }

            map.put("departments",departmentDao.getDepartments());
            return "input";
        }
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String input(@PathVariable(value = "id") Integer id,Map<String,Object> map){
        map.put("employee",employeeDao.get(id));
        map.put("departments",departmentDao.getDepartments());
        return "input";
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String input(Map<String,Object> map) {
        map.put("departments",departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "input";
    }

    @RequestMapping("/emps")
    public String list(Map<String,Object> map){
        map.put("employees",employeeDao.getAll());
        return "list";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
       // binder.setDisallowedFields("lastName");
    }
}
