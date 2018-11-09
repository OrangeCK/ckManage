package com.example.baseframe.myspringboot.service.impl;

import com.example.baseframe.myspringboot.domain.Demo;
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
public class DemoServiceImpl extends BaseServiceImpl<Demo> implements DemoService {

    @Autowired
    private DemoMapper demoMapper;
    @Override
    public Demo testConnect(String code) {
        Demo demo = demoMapper.testConnect(code);
        return demo;
    }
}
