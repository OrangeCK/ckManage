package com.example.baseframe.myspringboot.mapper;

import com.example.baseframe.myspringboot.domain.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 01378803
 * @date 2018/10/17 15:10
 * Description  :
 */
@Mapper
@Repository
public interface DemoMapper extends BaseMapper<Employee>{

    Employee testConnect(@Param("code") String code);
}
