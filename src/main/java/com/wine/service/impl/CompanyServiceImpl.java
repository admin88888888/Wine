package com.wine.service.impl;

import com.wine.dao.CompanyMapper;
import com.wine.entity.Company;
import com.wine.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> findByAll() {
        List<Company> list = companyMapper.findAll();
        return list;
    }
}
