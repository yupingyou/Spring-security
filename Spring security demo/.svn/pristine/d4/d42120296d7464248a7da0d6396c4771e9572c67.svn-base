package com.xingguo.springSecurity.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.xingguo.action.common.BaseAction;
import com.xingguo.entity.AppUsers;
import com.xingguo.service.sys.AppUserService;
/**
 * 自定义登录系统
 * @author yyp
 *
 */
public class UserLoginAction extends BaseAction<AppUsers> {

	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
	private AppUserService appUserService;
	
	public String login() throws Exception{
		jsonData=new HashMap<String, Object>();
		try {
				Map<String, String> map = appUserService.findUserByLoginNameAndPassword(entity.getLoginName(), entity.getPassword());
				if(map.get("status").equals("0")){
					UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(entity.getLoginName(), entity.getPassword());
					Authentication authentication = authenticationManager.authenticate(authRequest); //调用loadUserByUsername
			        SecurityContextHolder.getContext().setAuthentication(authentication);
			        HttpSession session = ServletActionContext.getRequest().getSession();
			        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
			        jsonData.put("status", 0);
				}else{
					jsonData.putAll(map);
				}
		}catch(Exception e){
			log.error("Exception:", e);
			jsonData.put("status", 1);
			jsonData.put("msg", e.getMessage());
		} 
		return JSON_RESULT;
	}

	@Override
	public AppUsers getModel() {
		if(entity==null){
			entity=new AppUsers();
		}
		return entity;
	}
	

}
