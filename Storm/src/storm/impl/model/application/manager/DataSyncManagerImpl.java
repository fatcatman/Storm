package storm.impl.model.application.manager;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import storm.model.application.manager.IDataSyncManager;
import storm.model.core.domain.EntityObject;
import storm.model.repository.IDataSyncRepository;



/**
 * 数据同步管理器
 * 
 * @author hexiao
 * @version 1.0
 */
@Service
public class DataSyncManagerImpl implements IDataSyncManager {

	@Autowired
	IDataSyncRepository dataSyncRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<EntityObject> getSyncDataByLastUpdateDate(String object, Date lastUpdateDate) {
		return dataSyncRepository.getSyncDataByLastUpdateDate(object, lastUpdateDate);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EntityObject> getSyncDataByWhereString(String object,
			String whereString) {
		return dataSyncRepository.getSyncDataByWhereString(object, whereString);
	}

}
