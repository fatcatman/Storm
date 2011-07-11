package storm.model.core.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.LockModeType;

import storm.model.core.domain.EntityObject;

/**
 * 
 * Repository基础接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 * @param T　所操作实体类
 * @param PK　所操作实体的主键类型
 */
public interface IBaseRepository<T extends EntityObject, PK extends Serializable>{

	/**
	 * 全对象取得
	 * 
	 * @return 全对象
	 */
	public List<T> getAll();

	/**
	 * 通过ID取得实体。<br>
	 * 如果实体不存在则返回NULL。
	 * 
	 * @param id ID
	 * @return 实体对象
	 */
	public T get(PK id);
	
	/**
	 * 通过ID与version取得实体对象。<br>
	 * 如果实体不存在则返回NULL。
	 * 
	 * @param id ID
	 * @param version 数据版本
	 * @return 实体对象
	 */
	public T get(PK id, Long version);

	/**
	 * 检查指定ID的实体对象是否在数据库中存在。<br>
	 * 如果实体不存在则返回NULL。
	 * 
	 * @param id ID
	 * @return 实体对象
	 */
	public boolean exists(PK id);

	/**
	 * 将指定实体对象合并进数据库。<br>
	 * 
	 * @param object 实体对象
	 * @return 合并后实体对象
	 */
	public T merge(T object);
	
	/**
	 * 将指定实体对象插入数据库。<br>
	 * 
	 * @param object 实体对象
	 */
	public void persist(T object);
	
	/**
	 * 更新事务的最后一定要执行的方法。<BR>
	 * 调用flush方法，强制触发DB访问操作，定为例外发生的场所。
	 */
	public void update();

	/**
	 * 通过ID从数据库中删除实体对象。
	 * 
	 * @param id ID
	 */
	public void remove(PK id);
	
	/**
	 * 通过ID与version从数据库中删除实体对象。
	 * 
	 * @param id ID
	 */
	public void remove(PK id, Long version );
	
	/**
	 * 让参数中指定的实体的version自增。<BR>
	 *
	 * @param object 实体对象
	 */
	public void incrementVersion(T object);
	
	/**
	 * 对参数中指定的实体加行级锁。<BR>
	 * select for update
	 * 
	 * @param object 实体对象
	 */
	public void pessimisticLock(T object);
	
	/**
	 * 通过主键取得实体，然后加只读锁。
	 * @throws EntityNotFoundException
	 * 
	 * @param primaryKey 主键
	 */
	public T lock(PK primaryKey);
	
	/**
	 * 通过主键取得实体，然后用指定的方法加锁。
	 * 
	 * @param primaryKey 主键
	 * @param lockModeType 锁类型
	 */
	public T lock(PK primaryKey, LockModeType lockModeType);
	
	/**
	 * 通过主键取的对实体的参照。
	 * @throws EntityNotFoundException
	 * 
	 * @param primaryKey 主键
	 */
	public T getReference(PK primaryKey);
	
	/**
	 * 把实体缓存中的实体写入数据库，并清除缓存
	 * @throws EntityNotFoundException
	 */
	public void flushAndClear();
	
}