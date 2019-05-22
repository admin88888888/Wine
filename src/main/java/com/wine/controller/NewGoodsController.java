package com.wine.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wine.common.JsonBean;
import com.wine.entity.NewGoods;
import com.wine.service.NewGoodsService;
import com.wine.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "新品酒水新闻信息", tags = "新品酒水新闻信息")
public class NewGoodsController {

    @Autowired
    private NewGoodsService newGoodsService;
    @CrossOrigin
    @PostMapping("/newgoods/list.do")
    @ApiOperation(value = "新品酒水新闻展示", notes = "新品酒水新闻展示")
    public JsonBean newgoods(){
        List<NewGoods> list = newGoodsService.findByAll();
        return JsonUtil.createJsonBean(1000, null, list);
    }
    @CrossOrigin
    @PostMapping("/newgoods/onenews.do")
    @ApiOperation(value = "新品酒水单条新闻内容展示", notes = "新品酒水单条新闻内容展示")
    public JsonBean OneNews(String title) {
        List<NewGoods> list = newGoodsService.findByOne(title);
        return JsonUtil.createJsonBean(1000, null, list);
    }
    @CrossOrigin
    @GetMapping("/newgoods/pagelist.do")
    @ApiOperation(value = "新闻展示的分页展示", notes = "传入页码")
    public Map<String, Object> courseList(int page) {
        PageHelper.startPage(page, 2);
        Map<String, Object> map = new HashMap<>();
        try {
            List<NewGoods> list = newGoodsService.findAllNews(page);
            long total = ((Page) list).getTotal();
            map.put("code", 0); // 0 表示成功
            map.put("msg", "");
            map.put("count", total);
            map.put("data", list);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        }
    }
    @CrossOrigin
    @PostMapping("/newgoods/addnewgoods.do")
    @ApiOperation(value = "新闻添加", notes = "添加新闻")
    public JsonBean addNewgoods(@RequestBody NewGoods newGoods){
        int i = newGoodsService.insertSelective(newGoods);
        if (i == 1){
            return JsonUtil.createJsonBean(1000,"添加成功",null);
        }else {
            return JsonUtil.createJsonBean(1000,"添加失败",null);
        }
    }



}
