package com.wine.controller;

import com.wine.common.JsonBean;
import com.wine.dao.LeaveWordMapper;
import com.wine.entity.LeaveWord;
import com.wine.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/5/17.
 */
@Api(value = "留言", tags = "留言信息")
@RestController
public class LeaveWordController {
    @Autowired
    private LeaveWordMapper leaveWordDao;
    @CrossOrigin
    @ApiOperation(value = "添加留言",notes = "传名字、电话、微信、留言内容、是否同意协议1代表同意或者0")
    @PostMapping("addCommon")
    public JsonBean addCommon(@RequestBody LeaveWord leaveWord){
        leaveWordDao.insertSelective(leaveWord);
        return JsonUtil.createJsonBean(1000,"添加成功",null);
    }
    @CrossOrigin
    @ApiOperation(value = "查询留言",notes = "查询所有的留言")
    @GetMapping("selectAllLeave.do")
    public JsonBean selectAll(){
        List<LeaveWord> leaveWords = leaveWordDao.selectAll();
        return JsonUtil.createJsonBean(1000,"查询成功",leaveWords);
    }
}
