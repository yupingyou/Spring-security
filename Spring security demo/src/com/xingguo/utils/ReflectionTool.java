package com.xingguo.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.Column;

/**
 * 反射工具类
 * @author yyp
 *
 */
public class ReflectionTool {
	/**
	 * 获取当前实现的泛型类型
	 * @param classes 当前类型 this.getClass()
	 * @return
	 */
	public static Class<?> getSuperGenericType(Class<?> classes){
		Class<?> result=null;
		Type type = classes.getGenericSuperclass();
        if (type  instanceof  ParameterizedType) {
                ParameterizedType  paramType  =  (ParameterizedType) type;
                Type[] args = paramType.getActualTypeArguments();
                if (args != null && args.length>0) {
                          Type arg = args[0]; 
                          if (arg instanceof Class) {
                        	  result= (Class<?>) arg;
                          }
                }
        }
        return result;
	}
	/**
	 * 根据实体类的属性名反射出该属性对应的表的列名
	 * @param c
	 * @param property
	 * @return
	 * @throws IntrospectionException
	 */
	public static String getTableColumnByPropertyName(Class<?> c,String property) throws IntrospectionException{
		PropertyDescriptor pd=new PropertyDescriptor(property, c);
		Method readMethod = pd.getReadMethod();
		Column annotation = readMethod.getAnnotation(Column.class);
		String columnName = annotation.name();
		return columnName;
	}
}
