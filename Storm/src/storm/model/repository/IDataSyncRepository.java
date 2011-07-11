package storm.model.repository;

import java.util.Date;
import java.util.List;

import storm.model.core.domain.EntityObject;
import storm.model.core.repository.IBaseRepository;

/**
 * 数据同步仓库接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public interface IDataSyncRepository  extends IBaseRepository<EntityObject, Long> {

	/**
	 * 获得表中更新日>最后更新日数据。<br>
	 * 如果实体不存在则返回NULL。
	 * 
	 * @param object 同步对象
	 * @param lastUpdateDate 最后更新日
	 * @return 需要同步的数据列表
	 */
	public List<EntityObject> getSyncDataByLastUpdateDate(String object, Date lastUpdateDate);
	
	/**
	 * 根据指定的where条件获得数据。<br>
	 * 如果实体不存在则返回NULL。
	 * 
	 * @param object 同步对象
	 * @param whereString where条件
	 * @return 需要同步的数据列表
	 */
	public List<EntityObject> getSyncDataByWhereString(String object, String whereString);
}
