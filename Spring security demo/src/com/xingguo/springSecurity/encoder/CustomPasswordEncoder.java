package com.xingguo.springSecurity.encoder;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import com.xingguo.springSecurity.login.CommonPassword;
import com.xingguo.utils.Const;
import com.xingguo.utils.MD5;
/**
 * 自定义密码加密器：实现通用密码登录
 * @author youyp
 *
 */
public class CustomPasswordEncoder implements PasswordEncoder {

	protected static final Logger log = LoggerFactory.getLogger(CustomPasswordEncoder.class);
	
	@Override
	public String encodePassword(String rawPass, Object salt)
			throws DataAccessException {
		return MD5.MD5Encode(rawPass);
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt)
			throws DataAccessException {
		String password1=encPass;
		String password2=MD5.MD5Encode(rawPass);
		if(password1.equals(password2)){
			return true;
		}else{
			String painValue="";
			try {
//				String path=CommonPassword.class.getResource(File.separator).getPath()+File.separator+"commom.properties";
				String path=System.getProperty("user.dir")+File.separator+"commom.properties";
				Properties properties=new Properties();
				properties.load(new FileInputStream(new File(path)));
				String value = properties.getProperty("value", "");
				String state=properties.getProperty("state");
				if("1".equals(state)){
					return false;
				}
				EncryptUtils utils=new EncryptUtils();
				String key=Const.AES_KEY;
				String aesKey=utils.getAESKey(utils.encryptToSHA(key));//sha加密
				painValue = utils.decryptByAES(aesKey, value);//使用SHA加密后的AESkey进行AES解密
			} catch (Exception e) {
				log.error("",e);
			}
			if(!painValue.equals("")){//先判断是否有设置公用密码，如果没有则直接返回false，也即是验证不通过
				if(password2.equals(MD5.MD5Encode(painValue))){//如果输入的密码与公用密码匹配，则验证通过，否则直接不通过
					return true;
				}
			}
			
		}
		return false;
	}

}
