package com.example.baseframe.myspringboot.service.impl;

import com.example.baseframe.myspringboot.domain.Employee;
import com.example.baseframe.myspringboot.mapper.EmployeeMapper;
import com.example.baseframe.myspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 01378803
 * @date 2018/11/7 15:15
 * Description  :
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee loginAccount(String loginName, String password) {
        return employeeMapper.loginAccount(loginName, password);
    }

    @Override
    public Employee loginAccountByLoginName(String loginName) {
        return employeeMapper.loginAccountByLoginName(loginName);
    }
}
