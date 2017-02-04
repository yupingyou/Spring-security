package com.xingguo.springSecurity.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import com.xingguo.entity.AppRoles;
import com.xingguo.entity.AppUsers;
/**
 * Spring security context holder 获取当前用户信息
 * @author you
 *
 */
public class SpringSecurityUtils {
	public static AppUsers getCurrUser(){
		return (AppUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public static String getCurrUserName(){
		AppUsers user = (AppUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user!=null){
			return user.getLoginName();
		}
		return null;
	}
	
	public static List<AppRoles> getCurrUserRole(){
		AppUsers user = (AppUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user!=null){
			List<AppRoles> list=new ArrayList<AppRoles>(user.getRoles());
			return list;
		}
		return null;
	}
	
	
	
	
	
}
