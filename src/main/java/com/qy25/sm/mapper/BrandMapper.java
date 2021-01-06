package com.qy25.sm.mapper;

import com.qy25.sm.entity.Brand;
import com.qy25.sm.entity.BrandExample;
import com.qy25.sm.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper extends BaseMapper<Brand,Long> {
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
}