package com.example.baseframe.myspringboot.controller;

import com.example.baseframe.myspringboot.domain.Demo;
import com.example.baseframe.myspringboot.domain.Employee;
import com.example.baseframe.myspringboot.domain.PageList;
import com.example.baseframe.myspringboot.redis.RedisUtil;
import com.example.baseframe.myspringboot.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    private DemoService demoService;
    @Autowired
    private RedisUtil redisUtil;
    @Value("${com.sysName}")
    private String sysName;
    @RequestMapping(value = "/connection", method = RequestMethod.POST)
    public PageList<Demo> testConnectDemo(){
        Demo emp = new Demo();
        emp.setUserName("陈康");
        redisUtil.set("test-util",emp.getUserName());
        redisUtil.set("test-time", emp.getUserName(), 120);
        System.out.println("redis中储存的数据1是：" + redisUtil.get("test-word"));
        System.out.println("redis中储存的数据2是：" + redisUtil.get("test-name"));
//        Demo result = demoService.testConnect("陈康");
//
//        System.out.println("系统名称是：" + sysName + "还有：" +sysName);
//        logger.info("正在打印中info");
//        logger.warn("正在打印中warn");
//        logger.error("正在打印中error");
        return demoService.getPageList(emp);
    }

}
