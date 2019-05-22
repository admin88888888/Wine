package com.wine.service.impl;

import com.wine.dao.CompanyMapper;
import com.wine.dao.LiquorMapper;
import com.wine.entity.Company;
import com.wine.entity.Liquor;
import com.wine.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/5/7.
 */
@Service
public class SearchServiceimpl implements SearchService {
    @Autowired
    private LiquorMapper liquorDao;
    @Autowired
    private CompanyMapper companyDao;
    @Override
    public List<Liquor> resou() {
        List<Liquor> list = liquorDao.reselect();
        return list;
    }

    @Override
    public List<Liquor> mingjiudaili() {
        List<Liquor> list = liquorDao.mingjiudaili();
        return list;
    }

    @Override
    public List<Company> findten() {
        List<Company> list = companyDao.findten();
        return list;
    }
}
