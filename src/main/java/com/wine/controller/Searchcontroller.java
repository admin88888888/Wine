package com.wine.controller;

import com.wine.common.JsonBean;
import com.wine.entity.Company;
import com.wine.entity.Liquor;
import com.wine.service.SearchService;
import com.wine.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/5/7.
 */
@Api(value = "热搜，名酒代理，名酒代理的logo展示", tags = "热搜，名酒代理，名酒代理的logo展示")
@RestController
public class Searchcontroller {
    @Autowired
    private SearchService searchService;
    //热搜
    @CrossOrigin
    @GetMapping("reselect.do")
    @ApiOperation(value = "热搜",notes = "热搜")
    public JsonBean reselect(){
        List<Liquor> list = searchService.resou();
        return JsonUtil.createJsonBean(1000,"查询成功",list);
    }
    //名酒代理
    @CrossOrigin
    @GetMapping("mingjiu.do")
    @ApiOperation(value = "名酒代理",notes = "名酒代理")
    public JsonBean showMingJiu(){
        List<Liquor> list = searchService.mingjiudaili();
        return JsonUtil.createJsonBean(1000,"查询成功",list);
    }
    //名酒代理的logo展示
    @CrossOrigin
    @GetMapping("showLogo.do")
    @ApiOperation(value = "名酒代理",notes = "名酒代理")
    public JsonBean showLogo(){
        List<Company> list = searchService.findten();
        return  JsonUtil.createJsonBean(1000,"查询成功",list);
    }



}
