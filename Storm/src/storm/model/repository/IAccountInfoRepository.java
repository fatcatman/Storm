package storm.model.repository;

import java.util.List;

import storm.impl.model.domain.AccountInfo;
import storm.model.core.repository.IBaseRepository;

/**
 * 帐户信息仓库接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public interface IAccountInfoRepository extends IBaseRepository<AccountInfo, Long>{

	/**
	 * 通过ID取得AccountInfo的实体。<br>
	 * 如果实体不存在则返回NULL。
	 * 
	 * @param id ID
	 * @return AccountInfo的实体
	 */
	public AccountInfo getById(Long id);
	
	/**
	 * 全对象取得
	 * 
	 * @return 全对象
	 */
	public List<AccountInfo> getAll();
	
	/**
	 * 通过用户名密码获得AccountInfo实体
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return 帐户信息实体
	 */
	public AccountInfo getAccountInfoByUsernameAndPassword(
			String username, String password);

}
