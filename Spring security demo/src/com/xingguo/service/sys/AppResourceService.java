package com.xingguo.service.sys;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;

import com.xingguo.entity.AppResource;

public interface AppResourceService {
	public List<AppResource> findAllResource();

	public Map<String, Collection<ConfigAttribute>> loadUrlAuthorities();
}
