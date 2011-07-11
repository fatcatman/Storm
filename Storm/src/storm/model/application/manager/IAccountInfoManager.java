package storm.model.application.manager;

import java.util.List;

import storm.impl.model.domain.AccountInfo;



/**
 * 帐户信息管理器接口
 * 
 * @author hexiao
 * @version 1.0
 */
public interface IAccountInfoManager {
	
	/**
	 * 通过id取得AccountInfo的实体。<br>
	 * 如果实体不存在则返回NULL。
	 * 
	 * @param id ID
	 * @return AccountInfo的实体
	 */
	public AccountInfo getById(Long id);
	

	/**
	 * 通过id和version删除AccountInfo的实体。
	 * 
	 * @param id ID
	 * @param version 数据版本
	 */
	public void delete(Long id, Long version);
	
	/**
	 * 全对象取得
	 * 
	 * @return 全对象
	 */
	public List<AccountInfo> getAll();
	
	/**
	 * 通过用户名密码获得AccountInfo实体
	 * 
	 * @param username 登陆用户名
	 * @param password 登陆密码
	 * @return AccountInfo的实体
	 */
	public AccountInfo getAccountInfoByUsernameAndPassword(
			String username, String password);

}
