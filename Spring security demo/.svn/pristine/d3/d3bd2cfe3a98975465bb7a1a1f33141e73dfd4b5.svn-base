package com.xingguo.service.sys.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xingguo.dao.sys.AppResourceDao;
import com.xingguo.entity.AppResource;
import com.xingguo.service.sys.AppResourceService;
@Service
@Transactional
public class AppResourceServiceImpl implements AppResourceService {
	@Autowired
	private AppResourceDao appResourceDao;
	
	@Override
	public List<AppResource> findAllResource() {
		return appResourceDao.findAllResource();
	}
	
	/**
     * 获取所有资源
     */
	@Override
    public Map<String, Collection<ConfigAttribute>> loadUrlAuthorities() {
    	Map<String, Collection<ConfigAttribute>> urlAuthorities = new LinkedHashMap<String, Collection<ConfigAttribute>>();
        List<AppResource> urlResources =findAllResource();
        for(AppResource resource : urlResources) {
        	List<ConfigAttribute> collection=new ArrayList<ConfigAttribute>();
        	collection.add(new SecurityConfig(resource.getResouceCode()));
            urlAuthorities.put(resource.getUrl(),collection);
        }
        return urlAuthorities;
    }
	
}
