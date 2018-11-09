package com.example.baseframe.myspringboot.service.impl;

import com.example.baseframe.myspringboot.domain.Permission;
import com.example.baseframe.myspringboot.mapper.PermissionMapper;
import com.example.baseframe.myspringboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 01378803
 * @date 2018/11/7 15:15
 * Description  :
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
}
