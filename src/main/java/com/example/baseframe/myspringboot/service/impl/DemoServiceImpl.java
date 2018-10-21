package com.example.baseframe.myspringboot.service.impl;

import com.example.baseframe.myspringboot.domain.Employee;
import com.example.baseframe.myspringboot.mapper.DemoMapper;
import com.example.baseframe.myspringboot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 01378803
 * @date 2018/10/17 15:06
 * Description  :
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;
    @Override
    public Employee testConnect(String code) {
        Employee employee = demoMapper.testConnect(code);
        return employee;
    }
}
