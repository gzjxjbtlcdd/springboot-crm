package com.qy25.sm.service.base;

import com.qy25.sm.vo.PageVo;

import java.util.List;

public interface BaseService<T,ID> {
    /**
     * 分页 查询所有
     * @return
     */
    PageVo<T> findAll();

    /**
     *  分页 有条件的查询
     */
    PageVo<T> findTermAll(Object example);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    T findById(ID id);
    /**
     * 添加
     */
    int addEntity(T t);

    /**
     * 修改
     */
    int updateEntity(T t);

    /**
     * 删除
     */
    int deleteEntity(ID id);

    /**
     * 批量添加
     */
    int addList(List<T> list);

    /**
     * 批量修改
     */

    int UpdateList(List<T> list);

    /**
     * 批量删除
     */

    int deleteList(List<ID> list);

    /**
     * 封装 分页
     * @param list
     * @return
     */
    PageVo<T> getPageVo(List<T> list);
}
