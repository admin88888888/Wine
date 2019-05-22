package com.wine.controller;

import com.wine.common.JsonBean;
import com.wine.dao.LiquorMapper;
import com.wine.entity.Liquor;
import com.wine.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "首页相关",tags = "酒水操作")
@RestController
public class LiquorController {
    @Autowired
    private LiquorMapper liquorMapper;
    @CrossOrigin
    @ApiOperation(value = "A区特别推荐",notes = "A区特别推荐")
    @GetMapping("/liquor/selectLiquorRecommend.do")
    public JsonBean selectLiquorRecommend(){
        List<Liquor> list = liquorMapper.selectLiquorRecommend();
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "畅销新品招商",notes = "畅销新品招商")
    @GetMapping("/liquor/selectGoodsNewJion.do")
    public JsonBean selectGoodsNewJion(){

        List<Liquor> list = liquorMapper.selectGoodsNewJion();
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "B区 招商爆款-综合酒水",notes = "B区 招商爆款-综合酒水")
    @GetMapping("/liquor/selectSynthesizeLiquor.do")
    public JsonBean selectSynthesizeLiquor(){

        List<Liquor> list = liquorMapper.selectSynthesizeLiquor();
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "搜索酒",notes = "搜索")
    @GetMapping("/liquor/selectjiu.do")
    public JsonBean selectjiu(String kind,String searchstr){
        List<Liquor> list = liquorMapper.selectjiu(kind,searchstr);
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "招商C区-综合酒水(啤酒)",notes = "招商C区-综合酒水(啤酒)")
    @GetMapping("/liquor/selectPLiquor.do")
    public JsonBean selectPLiquor(){

        List<Liquor> list = liquorMapper.selectPLiquor();
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "招商D区-综合酒水(葡萄酒)",notes = "招商D区-综合酒水(葡萄酒)")
    @GetMapping("/liquor/selectPuTaoLiquor.do")
    public JsonBean selectPuTaoLiquor(){

        List<Liquor> list = liquorMapper.selectPuTaoLiquor();
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "招商E区-综合酒水(洋酒)",notes = "招商E区-综合酒水(洋酒)")
    @GetMapping("/liquor/selectYangLiquor.do")
    public JsonBean selectYangLiquor(){

        List<Liquor> list = liquorMapper.selectYangLiquor();
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "招商F区-综合酒水(白酒)",notes = "招商F区-综合酒水(白酒)")
    @GetMapping("/liquor/selectBaiLiquor.do")
    public JsonBean selectBaiLiquor(){

        List<Liquor> list = liquorMapper.selectBaiLiquor();
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "招商G区-综合酒水(黄酒)",notes = "招商G区-综合酒水(黄酒)")
    @GetMapping("/liquor/selectYellowLiquor.do")
    public JsonBean selectYellowLiquor(){

        List<Liquor> list = liquorMapper.selectYellowLiquor();
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "招商J区-综合酒水",notes = "招商J区-综合酒水")
    @GetMapping("/liquor/selectJLiquor.do")
    public JsonBean selectJLiquor(){

        List<Liquor> list = liquorMapper.selectJLiquor();
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "爆款招商区",notes = "爆款招商区")
    @GetMapping("/liquor/selectHotLiquor.do")
    public JsonBean selectHotLiquor(){

        List<Liquor> list = liquorMapper.selectHotLiquor();
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "特惠招商区",notes = "特惠招商区")
    @GetMapping("/liquor/selectLitterLiquor.do")
    public JsonBean selectLitterLiquor(){
        List<Liquor> list = liquorMapper.selectLitterLiquor();
        return JsonUtil.createJsonBean(1000,"成功",list);
    }
    @CrossOrigin
    @ApiOperation(value = "添加酒",notes = "添加酒")
    @PostMapping("/liquor/addLiquor.do")
    public JsonBean addLitterLiquor(@RequestBody Liquor liquor){
        liquorMapper.insertSelective(liquor);
        return JsonUtil.createJsonBean(1000,"添加成功",null);
    }
}
