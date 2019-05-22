package com.wine.dao;

import com.wine.entity.Exhibition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExhibitionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Exhibition record);

    int insertSelective(Exhibition record);

    Exhibition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Exhibition record);

    int updateByPrimaryKey(Exhibition record);
    @Select("select count(*) from exhibition")
    int countExhibition();
    @Insert("insert into exhibition (name,phone,time,introduce,size,flage) values (#{name},#{phone},#{time},#{introduce},11,1)")
    void addExhibition(Exhibition exhibition);
    @Select("select * from exhibition")
    List<Exhibition> listExhibition();
}