package com.wine.service.impl;

import com.wine.dao.PostMessageMapper;
import com.wine.entity.PostMessage;
import com.wine.service.PostMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/5/4 0004.
 */
@Service
public class PostMessageServiceImpl implements PostMessageService {
    @Autowired
    private PostMessageMapper postMessageMapper;
    @Override
    public int addMessage(PostMessage postMessage) {

        return postMessageMapper.addMessage(postMessage);
    }

    @Override
    public List<PostMessage> findByType(Integer type) {
        return postMessageMapper.findByType(type);
    }

    @Override
    public List<PostMessage> findMessage() {
        return postMessageMapper.findMessage();
    }

    @Override
    public int countByType(Integer type) {
        return postMessageMapper.countByType(type);
    }
    @Override
    public List<PostMessage> findByAll() {
        List<PostMessage> list = postMessageMapper.findAll();
        return list;
    }
}
