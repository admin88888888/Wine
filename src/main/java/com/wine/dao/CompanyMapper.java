package com.wine.dao;

import com.wine.entity.Company;

import java.util.List;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
    /**
     * 展示公司信息
     * @return
     */
    public List<Company> findAll();

    public List<Company> findten();
}