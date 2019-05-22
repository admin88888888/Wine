package com.wine.service;

import com.wine.entity.PostMessage;

import java.util.List;

/**
 * Created by Administrator on 2019/5/4 0004.
 */
public interface PostMessageService {

    public int addMessage(PostMessage postMessage);

    public List<PostMessage> findByType(Integer type);

    public List<PostMessage> findMessage();

    public int countByType(Integer type);

    public List<PostMessage> findByAll();
}
