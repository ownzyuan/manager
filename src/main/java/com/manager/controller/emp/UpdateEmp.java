package com.manager.controller.emp;

import com.manager.pojo.Employee;
import com.manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/updateEmp")
/**
 * 员工信息修改控制
 */
public class UpdateEmp {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 在员工页面，携带全部信息跳转到修改页面 emp/EmployeeUpdate.html
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}")
    public String EmployeeToUpdate(@PathVariable("id") Integer id, Model model){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("id",id);
        Employee employee = employeeService.selectByAnyway(map);
        model.addAttribute("employee",employee);
        return "emp/EmployeeUpdate";
    }

    /**
     * 修改员工信息，通过form表单传递的值
     *  成功后返回员工页面 emp/EmployeeList.html
     * @param employee
     * @param model
     * @return
     */
    @PostMapping("/update")
    public String updateEmployee(Employee employee, Model model){
        //通过id更新数据
        int i = employeeService.updateById(employee);
        if (i != 0){
            model.addAttribute("employees",employee);
        }
        return "emp/EmployeeList";
    }

}
