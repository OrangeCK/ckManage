package com.example.baseframe.myspringboot.mapper;

import com.example.baseframe.myspringboot.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 01378803
 * @date 2018/11/7 15:21
 * Description  :
 */
@Mapper
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
}
