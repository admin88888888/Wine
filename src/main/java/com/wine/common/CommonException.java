package com.wine.common;


import com.wine.util.JsonUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


// 统一处理异常
// 控制器没有处理的异常，会被该类接收进行处理
@ControllerAdvice
@ResponseBody
public class CommonException {

	@ExceptionHandler(Exception.class)
	public JsonBean commonException(Exception e){
		return JsonUtil.createJsonBean(0, e.getMessage(),null);
	}
}
