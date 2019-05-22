package com.wine.dao;

import com.wine.entity.LiquorType;

public interface LiquorTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LiquorType record);

    int insertSelective(LiquorType record);

    LiquorType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LiquorType record);

    int updateByPrimaryKey(LiquorType record);
}