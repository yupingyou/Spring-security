package com.xingguo.utils;

import java.util.Map;

import net.sf.json.JSONObject;

public class JSONFormatUtils {
	/**
	 * 将json字符串转换为普通java bean
	 * @param c javabean的class
	 * @param jsonStr json字符串
	 * @param classMap json字符串中存在的对象的类型集合，map形式，key为json字符串里的对象对应的key值
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static Object getObject(Class<?> c,String jsonStr,Map<String, Class<?>> classMap) throws InstantiationException, IllegalAccessException{
		if(jsonStr!=null&&!jsonStr.equals("")){
			JSONObject json=JSONObject.fromObject(jsonStr);
			if(classMap!=null){
				return JSONObject.toBean(json, c, classMap);
			}
			return JSONObject.toBean(json, c);
		}
		return null;
	}
	
}
