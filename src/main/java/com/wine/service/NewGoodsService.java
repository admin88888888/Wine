package com.wine.service;

import com.wine.entity.NewGoods;

import java.util.List;

public interface NewGoodsService {

    public List<NewGoods> findByAll();

    public List<NewGoods> findByOne(String title);

    public List<NewGoods> findAllNews(int page);

}
