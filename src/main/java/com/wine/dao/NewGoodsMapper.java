package com.wine.dao;

import com.wine.entity.NewGoods;

import java.util.List;

public interface NewGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewGoods record);

    int insertSelective(NewGoods record);

    NewGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewGoods record);

    int updateByPrimaryKey(NewGoods record);

    /**
     * 展示新品酒水新闻 限制8条
     * @return
     */
    public List<NewGoods> findAll();
    /**
     * 通过新闻标题查询新闻的全部内容
     *
     * @param title
     * @return
     */
    public List<NewGoods> findOne(String title);

    /**
     * 所有新品酒水新闻分页
     *
     * @return
     */
    public List<NewGoods> selectAll();
}