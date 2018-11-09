package com.example.baseframe.myspringboot.service.impl;

import com.example.baseframe.myspringboot.domain.Role;
import com.example.baseframe.myspringboot.mapper.RoleMapper;
import com.example.baseframe.myspringboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 01378803
 * @date 2018/11/7 15:16
 * Description  :
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
}
