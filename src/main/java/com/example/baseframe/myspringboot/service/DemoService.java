package com.example.baseframe.myspringboot.service;

import com.example.baseframe.myspringboot.domain.Demo;

/**
 * @author 01378803
 * @date 2018/10/17 15:08
 * Description  :
 */
public interface DemoService extends BaseService<Demo>{

    Demo testConnect(String code);
}
