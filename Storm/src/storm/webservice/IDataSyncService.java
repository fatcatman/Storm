package storm.webservice;

import java.util.List;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;

import storm.impl.model.domain.AccountInfo;
import storm.impl.model.domain.TestTable;

/**
 * 数据同步服务接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@XmlSeeAlso({AccountInfo.class, TestTable.class})
@WebService
public interface IDataSyncService {
	
	/**
	 * 数据同步方法
	 * 
	 * @param objectString 需要同步的实体对象集合
	 * @param whereString 同步用where条件集合
	 */
	@SuppressWarnings("unchecked")
	public List sync(String objectString, String whereString);
}
