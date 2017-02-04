package com.xingguo.listener;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.xingguo.springSecurity.login.CommonPassword;

public class CommonPasswordInitListener implements ServletContextListener {
	private static final Logger log=Logger.getLogger(CommonPasswordInitListener.class);
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		String userDir = System.getProperty("user.dir");
		String path=userDir+File.separator+"commom.properties";
		File oldFile=new File(path);
		if(!oldFile.exists()){
			try {
				oldFile.createNewFile();
				String origin=CommonPassword.class.getResource(File.separator).getPath()+File.separator+"commom.properties";
				File originFile=new File(origin);
				FileUtils.copyFile(originFile, oldFile);
				log.info("初始化公用密码配置成功！");
			} catch (IOException e) {
				log.error("",e);
			}
		}else{
			log.info("二次部署，继续沿用用户配置的公用密码");
		}
	}

}
