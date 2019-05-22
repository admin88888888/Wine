package com.wine.controller;

import com.wine.common.JsonBean;
import com.wine.service.CodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/29 10:17
 */
@Api(value = "短信验证码",tags = "sms短信操作")
@RestController
public class SmsController {
    @Autowired
    private CodeService codeService;
    //发送验证码  一份钟发送1次  验证码3分钟失效
    @CrossOrigin
    @ApiOperation(value = "发送短信验证码",notes = "发送短信验证码")
    @PostMapping("sms/sendmsg.do")
    public JsonBean sendMsg(String phone){
        return codeService.sendMsg(phone);
    }
    @CrossOrigin
    @ApiOperation(value = "校验短信验证码",notes = "校验短信验证码")
    @GetMapping("sms/checkcode.do")
    public JsonBean checkCode(String phone,String code){
        return codeService.checkCode(phone,code);
    }
}
