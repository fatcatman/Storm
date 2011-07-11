package storm.impl.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import storm.impl.model.domain.AccountInfo;
import storm.impl.model.domain.TestTable;
import storm.model.application.manager.IDataSyncManager;
import storm.model.core.domain.EntityObject;
import storm.webservice.BaseService;
import storm.webservice.IDataSyncService;

/**
 * 数据同步服务
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@XmlSeeAlso({AccountInfo.class, TestTable.class}) 
@WebService(endpointInterface = "storm.webservice.IDataSyncService", serviceName = "DataSyncService")
@Component(value="dataSyncServiceImpl")
public class DataSyncServiceImpl extends BaseService implements IDataSyncService {
	
	@Autowired
	private IDataSyncManager dataSyncManager;
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List sync(String objectString, String whereString) {

//		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<EntityObject> resultList = new ArrayList<EntityObject>();
		
		if(null==objectString || objectString.isEmpty()) {
			return null;
		}
		
		try {
			int i =0;
			
			String[] objectArray = objectString.split(";");
			String[] whereArray = null;
			if(null != whereString && !whereString.isEmpty()) {
				whereArray = whereString.split(";");
			} else {
				whereArray = new String[objectArray.length];
			}
			
			for(String object:objectArray) {
				object = "storm.impl.model.domain." + object; 
				
				List<EntityObject> list = dataSyncManager.getSyncDataByWhereString(
						object, whereArray[i].replace("@", "="));
				
				i=i+1;
				
				resultList.addAll(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return resultList;
		
	}
}
