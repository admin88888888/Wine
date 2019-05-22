package com.wine.service.impl;


import com.wine.dao.FeedBackMapper;

import com.wine.entity.FeedBack;
import com.wine.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/5/7 0007.
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedBackMapper feedBackMapper;
    @Override
    public void addFeedBack(FeedBack feedBack) {
        feedBackMapper.addFeedBack(feedBack);
    }
}
