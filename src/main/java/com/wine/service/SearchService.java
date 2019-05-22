package com.wine.service;

import com.wine.entity.Company;
import com.wine.entity.Liquor;

import java.util.List;

/**
 * Created by Administrator on 2019/5/7.
 */
public interface SearchService {
    //热搜
    public List<Liquor> resou();

    //
    public List<Liquor>  mingjiudaili();

    public List<Company> findten();
}
