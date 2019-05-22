package com.wine.service.impl;

import com.wine.dao.ExhibitionMapper;
import com.wine.entity.Exhibition;
import com.wine.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Administrator on 2019/5/4 0004.
 */
@Service
public class ExhibitionServiceImpl implements ExhibitionService {
    @Autowired
    private ExhibitionMapper exhibitionMapper;

    @Override
    public int countExhibition() {
        return exhibitionMapper.countExhibition();
    }

    @Override
    public void addExhibition(Exhibition exhibition) {
        exhibitionMapper.addExhibition(exhibition);
    }

    @Override
    public List<Exhibition> listExhibition() {
        return exhibitionMapper.listExhibition();
    }
}
