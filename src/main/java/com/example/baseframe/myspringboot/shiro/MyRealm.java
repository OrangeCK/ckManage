package com.example.baseframe.myspringboot.shiro;

import com.example.baseframe.myspringboot.domain.Employee;
import com.example.baseframe.myspringboot.domain.JwtToken;
import com.example.baseframe.myspringboot.domain.Permission;
import com.example.baseframe.myspringboot.domain.Role;
import com.example.baseframe.myspringboot.jwt.JwtUtil;
import com.example.baseframe.myspringboot.service.EmployeeService;
import com.example.baseframe.myspringboot.service.PermissionService;
import com.example.baseframe.myspringboot.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 01378803
 * @date 2018/12/4 17:56
 * Description  :
 */

@Component
public class MyRealm extends AuthorizingRealm {
    private final static Logger logger = LoggerFactory.getLogger(MyRealm.class);
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 权限验证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("权限配置");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Employee employee = (Employee)principalCollection.getPrimaryPrincipal();
        try {
            // 注入角色
            List<Role> roleList = roleService.findDataById(employee.getId());
            for(Role role : roleList){
                authorizationInfo.addRole(role.getRoleCode());
            }
            // 注入权限
            List<Permission> permissionList = permissionService.findDataById(employee.getId());
            for(Permission permission : permissionList){
                authorizationInfo.addStringPermission(permission.getPermissionCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("权限配置出错！");
        }
        logger.info("用户" + employee.getUserName() + "的权限:{}", authorizationInfo.getStringPermissions());
        logger.info("用户" + employee.getUserName() + "的角色:{}", authorizationInfo.getRoles());
        return authorizationInfo;
    }

    /**
     * 登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("用户验证");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token无效");
        }
        // 与数据库数据进行匹配校验
        Employee employee = employeeService.loginAccountByLoginName(username);
        if (null == employee) {
            throw new UnknownAccountException();
        }
        if (!JwtUtil.verify(token, username, employee.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
