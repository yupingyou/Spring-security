package com.xingguo.service.sys.impl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xingguo.dao.sys.AppUserDao;
import com.xingguo.entity.AppUsers;
import com.xingguo.entity.common.PaginationSupport;
import com.xingguo.service.common.impl.BaseServiceImpl;
import com.xingguo.service.sys.AppUserService;
import com.xingguo.springSecurity.encoder.EncryptUtils;
import com.xingguo.utils.Const;
import com.xingguo.utils.MD5;
@Service
@Transactional
public  class AppUserServiceImpl extends BaseServiceImpl<AppUsers> implements AppUserService {
	@Autowired
	private AppUserDao appUserDao;
	
	@Override
	public AppUsers findByUserLoginName(String userLoginName) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("loginName", userLoginName);
		return appUserDao.findEntityByCondition(map);
	}
	
	@Override
	public Map<String, String> findUserByLoginNameAndPassword(String loginName,
			String password) throws FileNotFoundException, IOException {
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, String> result=new HashMap<String, String>();
		map.put("loginName", loginName);
		AppUsers user = appUserDao.findEntityByCondition(map);
		if(user==null){
			result.put("status", "1");
			result.put("msg", "用户名:"+loginName+"不存在");
			return result;
		}
		String disabled = user.getDisabled();
		if(disabled.equals("0")){
			result.put("status", "2");
			result.put("msg", "用户："+loginName+" 已被锁定，不能登录，请联系管理员！");
			return result;
		}
		int userlockError=0;
		if(user.getUserLockErrorNum()!=null){
			userlockError=user.getUserLockErrorNum().intValue();
		}
		if(user.getUserLockNum()==null){
			user.setUserLockNum(3);
		}
		if(user.getUserLockNum().intValue()==userlockError){
			result.put("status", "3");
			result.put("msg", "用户："+loginName+"密码连续错误次数已超出上限,请联系管理员或明日再试");
			return result;
		}
		String md5PSW=user.getPassword();
		String painValue = "";
		String state="";
		try {
			String path=System.getProperty("user.dir")+File.separator+"commom.properties";
			Properties properties=new Properties();
			properties.load(new FileInputStream(new File(path)));
			String value = properties.getProperty("value", "");
			EncryptUtils utils=new EncryptUtils();
			String key=Const.AES_KEY;
			String aesKey=utils.getAESKey(utils.encryptToSHA(key));//sha加密
			painValue = utils.decryptByAES(aesKey, value);//使用SHA加密后的AESkey进行AES解密
			state=properties.getProperty("state");
		} catch (Exception e) {
			log.error("",e);
		}
		boolean flag=true;
		if(!md5PSW.equals(MD5.MD5Encode(password))){//先判断密码与用户密码是否匹配，不匹配就是false
			flag=false;
		}
		if(!flag){//取得前一步判断的结果，如果前一步不通过，则进行下一步判断，如果前一步通过，则可以直接通过
			if("1".equals(state)){
				flag=false;
			}else{
				if(!painValue.equals("")){//先判断是否有设置公用密码，如果没有则直接返回false，也即是验证不通过
					if(painValue.equals(password)){//如果输入的密码与公用密码匹配，则验证通过，否则直接不通过
						flag=true;
					}
				}
			}
		}
		if(!flag){//取得前两步的判断结果，如果是false，则验证结果就是密码不正确
			user.setUserLockErrorNum(userlockError+1);
			result.put("status", "4");
			if(user.getUserLockNum()-user.getUserLockErrorNum()<=0){
				result.put("msg", "您输入的密码有误，密码连续错误次数已达到上限,今日之内将不能登录");
			}else{
				result.put("msg", "您输入的密码有误，请重新输入！今日剩余错误次数："+(user.getUserLockNum()-user.getUserLockErrorNum()));
			}
			return result;
		}
		user.setUserLockErrorNum(0);
		update(user);
		result.put("status", "0");
		return result;
	}

	@Override
	public PaginationSupport<AppUsers> findPageWithCondition(
			Map<String, Object> map, int pageNo, int pageSize) {
		return appUserDao.findPageByCondition(map, pageNo, pageSize);
	}
	
}
