package com.wine.controller;

import com.wine.common.JsonBean;
import com.wine.entity.FeedBack;
import com.wine.service.ExhibitionService;
import com.wine.service.FeedBackService;
import com.wine.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/5/7 0007.
 */
@RestController
@Api(value = "调查意见箱", tags = "调查意见箱")
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;
    @CrossOrigin
    @ApiOperation(value = "添加调查意见",notes = "添加调查意见")
    @GetMapping("addFeedBack.do")
    public JsonBean addFeedBack(@RequestBody @ApiParam(name = "feedBack",value = "用户相关的键值对")FeedBack feedBack){
        feedBackService.addFeedBack(feedBack);
        return JsonUtil.createJsonBean(1000,"添加成功",null);

    }
}
