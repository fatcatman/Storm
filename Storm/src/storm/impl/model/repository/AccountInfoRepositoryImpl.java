package storm.impl.model.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import storm.impl.model.domain.AccountInfo;
import storm.model.core.repository.jpa.BaseRepositoryImpl;
import storm.model.repository.IAccountInfoRepository;

/**
 * 帐户信息仓库
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@Repository
public class AccountInfoRepositoryImpl extends
		BaseRepositoryImpl<AccountInfo, Long> implements
		IAccountInfoRepository {

	public AccountInfoRepositoryImpl() {
		super(AccountInfo.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public AccountInfo getAccountInfoByUsernameAndPassword(String username,
			String password) {
		String queryString = "FROM "
			+AccountInfo.class.getName()
			+ " ai WHERE ai.username = :username"
			+ " and ai.password = :password";
		
		Query query = createJPQLQuery(queryString);
		
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<AccountInfo> resultList = query.getResultList();
		return returnSingleResult(resultList);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public AccountInfo getById(Long id) {
		String queryString = "FROM "
			+AccountInfo.class.getName()
			+ " ai WHERE ai.id = :id";
		
		Query query = createJPQLQuery(queryString);
		
		query.setParameter("id", id);
		List<AccountInfo> resultList = query.getResultList();
		return returnSingleResult(resultList);
	}

}
