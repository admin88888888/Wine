package com.wine.dao;

import com.wine.entity.PostMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostMessage record);

    int insertSelective(PostMessage record);

    PostMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostMessage record);

    int updateByPrimaryKey(PostMessage record);

    public int addMessage(PostMessage postMessage);
    @Select("select * from post_message where type = #{type}")
    public List<PostMessage> findByType(Integer type);
    @Select("select * from post_message ")
    public List<PostMessage> findMessage();
    @Select("select COUNT(*) from post_message\n" +
            "where type = #{type}\n" +
            "GROUP BY type ")
    public int countByType(Integer type);

    public List<PostMessage> findAll();
}