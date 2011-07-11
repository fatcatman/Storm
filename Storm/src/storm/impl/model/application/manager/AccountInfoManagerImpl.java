package storm.impl.model.application.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import storm.impl.model.domain.AccountInfo;
import storm.model.application.manager.IAccountInfoManager;
import storm.model.repository.IAccountInfoRepository;



/**
 * 帐户信息管理器
 * 
 * @author hexiao
 * @version 1.0
 */
@Service
public class AccountInfoManagerImpl implements IAccountInfoManager {

	@Autowired
	private IAccountInfoRepository accountInfoRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public AccountInfo getAccountInfoByUsernameAndPassword(String username,
			String password) {
		return accountInfoRepository.getAccountInfoByUsernameAndPassword(username, password);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AccountInfo> getAll() {
		return accountInfoRepository.getAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public AccountInfo getById(Long id) {
		return accountInfoRepository.getById(id);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public void delete(Long id, Long version) {
		accountInfoRepository.remove(id, version);
	}

}
