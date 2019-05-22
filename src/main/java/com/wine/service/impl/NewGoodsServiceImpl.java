package com.wine.service.impl;

import com.wine.dao.NewGoodsMapper;
import com.wine.entity.NewGoods;
import com.wine.service.NewGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewGoodsServiceImpl implements NewGoodsService {

    @Autowired
    private NewGoodsMapper newGoodsMapper;

    @Override
    public List<NewGoods> findByAll() {
        List<NewGoods> list = newGoodsMapper.findAll();
        return list;
    }


    @Override
    public List<NewGoods> findByOne(String title) {
        List<NewGoods> list = newGoodsMapper.findOne(title);
        return list;
    }

    @Override
    public List<NewGoods> findAllNews(int page) {
        List<NewGoods> list = newGoodsMapper.selectAll();
        return list;
    }
}
