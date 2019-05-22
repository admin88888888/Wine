package com.wine.dao;

import com.wine.entity.FeedBack;
import org.apache.ibatis.annotations.Insert;

public interface FeedBackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    FeedBack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKey(FeedBack record);
    /*@Insert("insert into feedback (title,name,cname,email,phone,content) values (#{title},#{name},#{cname},#{email},#{phone},#{content})")*/
    void addFeedBack(FeedBack feedBack);
}