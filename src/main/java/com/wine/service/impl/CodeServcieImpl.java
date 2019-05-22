package com.wine.service.impl;

import com.wine.common.JsonBean;
import com.wine.service.CodeService;
import com.wine.util.AliyunSmsUtil;
import com.wine.util.JedisUtil;
import com.wine.util.JsonUtil;
import com.wine.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Administrator on 2019/5/5.
 */
@Service
public class CodeServcieImpl implements CodeService {
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    public JsonBean sendMsg(String phone) {
        //先验证之前1分钟内是否发过短信、之前3分钟有没有过验证码
        if(jedisUtil.isExists("register:"+phone)){
            return JsonUtil.createJsonBean(1000,"使用之前的验证码",null);
        }else {
            int code=RandomUtil.createNum(6);
            //存储验证码到Redis  2个key
            //1个key 用于短信失效  三分钟
            jedisUtil.setStr("register:"+phone,code+"",180);
            //1个key  1分钟只能发送一次
            jedisUtil.setStr("sms:"+phone,"",60);
            return JsonUtil.exec(AliyunSmsUtil.sendSms(phone,code),"短信验证码发送成功",null);
        }
    }

    @Override
    public JsonBean sendReMsg(String phone) {
        //先验证之前1分钟内是否发过短信、之前3分钟有没有过验证码
        if(jedisUtil.isExists("sms:"+phone)) {
            if (jedisUtil.isExists("register:" + phone)) {
                //存在就重新把验证码发送一次
                String code=jedisUtil.getStr("register:" + phone);
                jedisUtil.setExpire("register:" + phone,180);
                return JsonUtil.exec(AliyunSmsUtil.sendSms(phone, Integer.parseInt(code)), "短信验证码发送成功", null);
            } else {
                //不存在 生成验证码
                int code = RandomUtil.createNum(6);
                //存储验证码到Redis  2个key
                //1个key 用于短信失效  三分钟
                jedisUtil.setStr("register:" + phone, code + "", 180);
                //1个key  1分钟只能发送一次
                jedisUtil.setStr("sms:" + phone, "", 60);
                return JsonUtil.exec(AliyunSmsUtil.sendSms(phone, code), "短信验证码发送成功", null);
            }
        }else {
            return JsonUtil.createJsonBean(1000,"稍后重试",null);
        }

    }

    @Override
    public JsonBean checkCode(String phone, String code) {
        String servercode=jedisUtil.getStr("register:"+phone);
        if(Objects.equals(code,servercode)){
            //验证通过
            return JsonUtil.createJsonBean(1000,"稍后重试",null);
        }else {
            return JsonUtil.createJsonBean(1001,"验证码错误",null);
        }
    }
}
