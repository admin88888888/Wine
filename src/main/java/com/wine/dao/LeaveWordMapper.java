package com.wine.dao;

import com.wine.entity.LeaveWord;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LeaveWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LeaveWord record);

    int insertSelective(LeaveWord record);

    LeaveWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeaveWord record);

    int updateByPrimaryKey(LeaveWord record);

    @Select("select * from leaveword")
    List<LeaveWord> selectAll();
}