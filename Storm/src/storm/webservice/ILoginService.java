package storm.webservice;

import javax.jws.WebService;

/**
 * 登录服务接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@WebService
public interface ILoginService {
	
	/**
	 * 登录方法
	 * 
	 * @param username 登陆用户名
	 * @param password 登陆密码
	 * 
	 * @return true - 登陆成功 <br/>
	 *         false - 登陆失败
	 */
	public Boolean login(String username, String password);
}
