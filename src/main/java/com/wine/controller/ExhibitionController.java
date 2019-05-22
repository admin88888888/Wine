package com.wine.controller;

import com.wine.common.JsonBean;
import com.wine.entity.Exhibition;
import com.wine.service.ExhibitionService;

import com.wine.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/5/4 0004.
 */
@RestController
@Api(value = "展会信息", tags = "展会信息")
public class ExhibitionController {
    @Autowired
    private ExhibitionService exhibitionService;
    @CrossOrigin
    @ApiOperation(value = "展会信息发布条数",notes = "展会信息发布条数")
    @GetMapping("countExhibition.do")
    public JsonBean countExhibition(){
        int num = exhibitionService.countExhibition();
        return JsonUtil.createJsonBean(1000,"查找成功",num);
    }
    @CrossOrigin
    @ApiOperation(value = "添加展会信息",notes = "添加展会信息")
    @PostMapping("addExhibition.do")
    public JsonBean addExhibition(@RequestBody @ApiParam(name = "exhibition",value = "用户相关的键值对")Exhibition exhibition){
        exhibition.setTime(new Date());

        exhibitionService.addExhibition(exhibition);

        return JsonUtil.createJsonBean(1000,"添加成功",null);

    }
    @CrossOrigin
    @ApiOperation(value = "展会信息展示",notes = "展会信息展示")
    @GetMapping("listExhibition.do")
    public JsonBean listExhibition(){
        List<Exhibition> list = exhibitionService.listExhibition();
        return JsonUtil.createJsonBean(1000,"成功",list);

    }

}
