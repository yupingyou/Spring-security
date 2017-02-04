package com.xingguo.springSecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xingguo.entity.AppResource;
import com.xingguo.entity.AppUsers;
import com.xingguo.service.sys.AppResourceService;
import com.xingguo.service.sys.AppUserService;


public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private AppUserService appUserService;
    
    /**
     * 根据用户名获取用户对象
     * 实现了UserDetailsService接口中的loadUserByUsername方法
     */
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
        AppUsers users = appUserService.findByUserLoginName(userName);
        return users;
    }
    
}
