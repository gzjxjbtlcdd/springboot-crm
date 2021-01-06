package com.qy25.sm.controller.base;

import com.github.pagehelper.PageHelper;
import com.qy25.sm.common.http.AxiosResult;
import com.qy25.sm.service.base.BaseService;
import com.qy25.sm.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller一般 不封装 请求写在对应的controller中
 * @param <T>
 * @param <ID>
 */
public class BaseController<T,ID> {

    @Autowired
    private BaseService<T,ID> baseService;

    /**
     *                  分页查询所有 无条件
     * @param PageIndex
     * @param PageSize
     * @return
     */
    @GetMapping
    public AxiosResult<PageVo<T>> findAll(@RequestParam(defaultValue = "1") int PageIndex,@RequestParam(defaultValue = "1") int PageSize){
        PageHelper.startPage(PageIndex,PageSize);
        PageVo<T> all = baseService.findAll();
        return  AxiosResult.success(all);
    }

    /**
     *   根据id查询
     * @param id
     * @return
     */
    @GetMapping({"id"})
    public AxiosResult<T> findById(@PathVariable ID id){
        return AxiosResult.success(baseService.findById(id));
    }

    /**
     * 单个添加
     */
    @PostMapping
    public AxiosResult<Void> addEntity(@RequestBody T t){
        int i = baseService.addEntity(t);
        return getAxiosResult(i);
    }

    /**
     * 单个修改
     * @param t
     * @return
     */
    @PutMapping
    public AxiosResult<Void> updateEntity(@RequestBody T t){
        int i = baseService.updateEntity(t);
        return getAxiosResult(i);
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @DeleteMapping({"id"})
    public AxiosResult<Void> deleteEntity(@PathVariable ID id){
        int i = baseService.deleteEntity(id);
        return getAxiosResult(i);
    }

    /**
     * 封装 增 删 改 返回值的方法
     * @param row
     * @return
     */
    public AxiosResult<Void> getAxiosResult(int row){
        return row>0?AxiosResult.success():AxiosResult.error();
    }
}
