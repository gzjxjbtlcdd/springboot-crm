package com.qy25.sm.service.base.impl;


import com.github.pagehelper.PageInfo;
import com.qy25.sm.mapper.base.BaseMapper;
import com.qy25.sm.service.base.BaseService;
import com.qy25.sm.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BaseServiceImpl<T,ID> implements BaseService<T,ID> {

    @Autowired
    private BaseMapper<T,ID> baseMapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public PageVo<T> findAll() {
        List<T> list = baseMapper.selectByExample(null);
        PageVo<T> pageVo = getPageVo(list);
        return pageVo;
    }

    /**
     * 分页 有条件的查询  r
     */
    @Override
    public PageVo<T> findTermAll(Object example){
        List<T> ts = baseMapper.selectByExample(example);
        PageVo<T> pageVo = getPageVo(ts);
        return pageVo;
    }


    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public T findById(ID id) {
        T t = baseMapper.selectByPrimaryKey(id);
        return t;
    }
    /**
     * 添加
     */
    @Override
    public int addEntity(T t) {
        int insert = baseMapper.insert(t);
        return insert;
    }
    /**
     * 修改
     */
    @Override
    public int updateEntity(T t) {
        int i = baseMapper.updateByPrimaryKey(t);
        return i;
    }
    /**
     * 删除
     */
    @Override
    public int deleteEntity(ID id) {
        int i = baseMapper.deleteByPrimaryKey(id);
        return i;
    }
    /**
     * 批量添加
     */
    @Override
    @Transactional
    public int addList(List<T> list) {
        list.forEach(item-> baseMapper.insert(item));
        return 1;
    }
    /**
     * 批量修改
     */
    @Override
    @Transactional
    public int UpdateList(List<T> list) {
        list.forEach(item->{
            baseMapper.updateByPrimaryKey(item);
        });
        return 1;
    }
    /**
     * 批量删除
     */
    @Override
    @Transactional
    public int deleteList(List<ID> list) {
        list.forEach(item->{
            baseMapper.deleteByPrimaryKey(item);
        });
        return 1;
    }


    @Override
    public PageVo<T> getPageVo(List<T> list) {
        PageInfo<T> brandPageInfo = new PageInfo<>(list);
        long total = brandPageInfo.getTotal();
        PageVo<T> PageVo = new PageVo<>();
        PageVo.setList(list);
        PageVo.setTotal(total);
        return PageVo;
    }
}
