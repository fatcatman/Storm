package storm.impl.webservice;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import storm.impl.model.domain.AccountInfo;
import storm.impl.validator.IsEmptyStringValidator;
import storm.model.application.manager.IAccountInfoManager;
import storm.webservice.BaseService;
import storm.webservice.ILoginService;

/**
 * 登录服务
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@WebService(endpointInterface = "storm.webservice.ILoginService", serviceName = "LoginService")
@Component(value="loginServiceImpl")
public class LoginServiceImpl extends BaseService implements ILoginService {
	
	@Autowired
	private IAccountInfoManager accountInfoManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean login(String username, String password) {
		
		//登陆用户名输入check
		if(validatorManager.validator(IsEmptyStringValidator.class, new Object[]{username})) {
			return false;
		}
		
		//登陆密码输入check
		if(validatorManager.validator(IsEmptyStringValidator.class, new Object[]{password})) {
			return false;
		}
		
		
		AccountInfo accountInfo = accountInfoManager
				.getAccountInfoByUsernameAndPassword(username, password);

		if (null == accountInfo) {
			return false;
		}
		
		sessionManager.setAttribute("loginUser", username);
		
		return true;
	}
}
