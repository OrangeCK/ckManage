package com.example.baseframe.myspringboot.controller;

import com.example.baseframe.myspringboot.domain.Employee;
import com.example.baseframe.myspringboot.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    private DemoService demoService;
    @Value("${com.sysName}")
    private String sysName;
    @RequestMapping(value = "/connection")
    public Employee testConnectDemo(){
        Employee result = demoService.testConnect("成都市");
        System.out.println("系统名称是：" + sysName + "还有：" +sysName);
        logger.info("正在打印中info");
        logger.warn("正在打印中warn");
        logger.error("正在打印中error");
        return result;
    }

}