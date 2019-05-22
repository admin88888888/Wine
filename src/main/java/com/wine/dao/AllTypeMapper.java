package com.wine.dao;

import com.wine.entity.AllType;

public interface AllTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AllType record);

    int insertSelective(AllType record);

    AllType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AllType record);

    int updateByPrimaryKey(AllType record);
}