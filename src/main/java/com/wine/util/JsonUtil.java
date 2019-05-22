package com.wine.util;


import com.wine.common.JsonBean;

public class JsonUtil {
	public static JsonBean createJsonBean(int code, String msg, Object data) {
		JsonBean jsonBean = new JsonBean();
		jsonBean.setCode(code);
		jsonBean.setMsg(msg);
		jsonBean.setData(data);
		return jsonBean;
	}

	public static JsonBean exec(boolean istrue,String msg,Object obj){
		JsonBean jsonBean=new JsonBean(istrue?1000:1001,msg,obj);
		return jsonBean;
	}
}
