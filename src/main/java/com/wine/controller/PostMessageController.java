package com.wine.controller;

import com.wine.common.JsonBean;
import com.wine.entity.PostMessage;
import com.wine.service.PostMessageService;
import com.wine.service.UserService;

import com.wine.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/5/4 0004.
 */
@RestController
@Api(value = "发布信息", tags = "发布信息")
public class PostMessageController {
    @Autowired
    private PostMessageService postMessageService;
    @CrossOrigin
    @ApiOperation(value = "发布信息上传图片",notes = "发布信息上传图片")
    @RequestMapping(value = "image.do", method = RequestMethod.POST)
    public JsonBean uploadHead(@RequestParam("file") MultipartFile file, HttpSession session) {
        try {
            if (file != null ) {
                //获取文件名
                String fileName = file.getOriginalFilename();
                //截取扩展名
                String extName = fileName.substring(fileName.lastIndexOf("."));
                List list = new ArrayList();
                list.add(".jpg");
                list.add(".png");
                list.add(".jpeg");
                list.add(".gif");
                if(list.contains(extName.toLowerCase())){
                    String realPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img";
                    String photoFileName = new Date().getTime()+extName;
                    String descPath = "/img/"+photoFileName;
                    file.transferTo(new File(realPath,photoFileName));
                    return JsonUtil.createJsonBean(1000,"上传成功",descPath);
                }else {
                    return JsonUtil.createJsonBean(0,"上传失败",null);//文件类型不正确
                }
            }else {
                return JsonUtil.createJsonBean(0,"上传失败",null);//上传文件为空
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtil.createJsonBean(0,"上传失败",null);//上传异常
        }


    }

    @CrossOrigin
    @ApiOperation(value = "新增发布信息",notes = "新增发布信息")
    @PostMapping("addMessage.do")
    public JsonBean addMessage(@RequestBody @ApiParam(name = "postMessage",value = "用户相关的键值对")PostMessage postMessage){
        int i = postMessageService.addMessage(postMessage);
        if (i != 0){
            return JsonUtil.createJsonBean(1000,"新增信息成功",null);
        }else {
            return JsonUtil.createJsonBean(0,"新增信息失败",null);
        }
    }
    @CrossOrigin
    @ApiOperation(value = "招商/代理/供应信息展示",notes = "招商/代理/供应信息展示")
    @GetMapping("findMessage.do")
    public JsonBean findMessage(){
        List<PostMessage> list = postMessageService.findMessage();
        return JsonUtil.createJsonBean(1000,"查找成功",list);

    }
    @CrossOrigin
    @ApiOperation(value = "根据类型展示",notes = "根据类型展示")
    @GetMapping("findByType.do")
    public JsonBean findByType(Integer type){
        List<PostMessage> list = postMessageService.findByType(type);
        return JsonUtil.createJsonBean(1000,"查找成功",list);

    }


    @ApiOperation(value = "已发布条数",notes = "已发布条数")
    @GetMapping("countByType.do")
    public JsonBean countByType(Integer type){
        int num = postMessageService.countByType(type);
        return JsonUtil.createJsonBean(1000,"查找成功",num);

    }
    @ApiOperation(value = "招商/代理/供应信息展示",notes = "招商/代理/供应信息展示")
    @PostMapping("/message/list.do")

    public JsonBean Message(){
        List<PostMessage> list = postMessageService.findByAll();
        return JsonUtil.createJsonBean(1000, null, list);
    }


}
