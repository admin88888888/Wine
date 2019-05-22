package com.wine.service;

import com.wine.common.JsonBean;

/**
 * Created by Administrator on 2019/5/5.
 */
public interface CodeService {
    //发送
    JsonBean sendMsg(String phone);
    //重复发送  验证码不变
    JsonBean sendReMsg(String phone);
    //校验
    JsonBean checkCode(String phone,String code);
}
