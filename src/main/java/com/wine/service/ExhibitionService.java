package com.wine.service;

import com.wine.entity.Exhibition;

import java.util.List;

/**
 * Created by Administrator on 2019/5/4 0004.
 */
public interface ExhibitionService {
    int countExhibition();

    void addExhibition(Exhibition exhibition);

    List<Exhibition> listExhibition();
}
