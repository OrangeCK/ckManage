package com.example.baseframe.myspringboot.service.impl;

import com.example.baseframe.myspringboot.domain.BaseForm;
import com.example.baseframe.myspringboot.domain.PageList;
import com.example.baseframe.myspringboot.mapper.BaseMapper;
import com.example.baseframe.myspringboot.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/10/28 0028
 * Description :
 */
public class BaseServiceImpl<T extends BaseForm> implements BaseService<T>{
    @Autowired
    private BaseMapper<T> baseMapper;
    @Override
    public PageList<T> getPageList(T query) {
        int total = baseMapper.findPageTotal(query);
        List<T> list = baseMapper.findPageData(query);
        return new PageList(total, list);
    }

    @Override
    public List<T> findData(T query) {
        return null;
    }

    @Override
    public T findDetailById(Long id) {
        return null;
    }

    @Override
    public Integer saveForm(T form) {
        return null;
    }

    @Override
    public Integer updateForm(T form) {
        return null;
    }

    @Override
    public Integer deleteForm(T form) {
        return null;
    }

    @Override
    public Integer updateToDisable(T form) {
        return null;
    }

    @Override
    public Integer updateToEnable(T form) {
        return null;
    }
}
