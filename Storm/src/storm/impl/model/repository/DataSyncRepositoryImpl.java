package storm.impl.model.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import storm.model.core.domain.EntityObject;
import storm.model.core.repository.jpa.BaseRepositoryImpl;
import storm.model.repository.IDataSyncRepository;

/**
 * 数据同步仓库
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@Repository
public class DataSyncRepositoryImpl extends
BaseRepositoryImpl<EntityObject, Long>implements IDataSyncRepository {
	
	public DataSyncRepositoryImpl() {
		super(EntityObject.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EntityObject> getSyncDataByLastUpdateDate(String object ,Date lastUpdateDate) {
		String queryString = "FROM "
			+ object
			+ " t WHERE t.updateDate > :lastUpdateDate";
		
		Query query = createJPQLQuery(queryString);
		query.setParameter("lastUpdateDate", lastUpdateDate);
		List<EntityObject> resultList = query.getResultList();
		
		return resultList;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EntityObject> getSyncDataByWhereString(String object,
			String whereString) {
		String queryString = "FROM "
			+ object
			+ " t " + whereString;
		
		Query query = createJPQLQuery(queryString);
		List<EntityObject> resultList = query.getResultList();
		
		return resultList;
	}
}
