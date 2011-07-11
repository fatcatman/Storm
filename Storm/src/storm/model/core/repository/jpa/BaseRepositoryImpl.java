package storm.model.core.repository.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.AssertionFailure;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import storm.model.core.domain.EntityObject;
import storm.model.core.exception.CustomLockException;
import storm.model.core.exception.CustomSystemException;
import storm.model.core.exception.CustomWarningException;
import storm.model.core.repository.IBaseRepository;
import storm.utils.ISessionManager;



/**
 * Repository基础类<br/>
 * 
 * 所有Repository类都继承自本类，为其提供基本对象和方法
 * 
 * @author hexiao
 * @version 1.0
 * 
 * @param T 所操作实体类
 * @param PK 所操作实体的主键类型
 */
public class BaseRepositoryImpl<T extends EntityObject, PK extends Serializable>
		implements IBaseRepository<T, PK> {

	@Autowired
	protected ISessionManager sessionManager;
	
	protected final Log log = LogFactory.getLog(getClass());

	protected EntityManager entityManager;

	private Class<T> persistentClass;

	/**
	 * 构造方法
	 * 
	 * @param persistentClass 所操作实体类
	 */
	public BaseRepositoryImpl(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		if (log.isDebugEnabled()) {
			log.debug("The instance of Repository " + getClass().getName()
					+ " is created.");
		}
	}

	/**
	 * 实体管理器的设定方法
	 * 
	 * @param entityManager 实体管理器
	 */
	@PersistenceContext(unitName = "FRAMEWORK_JPA")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return this.entityManager.createQuery(
				"SELECT obj FROM " + this.persistentClass.getName() + " obj "
						+ "ORDER BY obj.id ASC").getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public T get(PK id) {
		T entity = (T) this.entityManager.find(this.persistentClass, id);

		if (entity == null) {
			String msg = this.persistentClass + " is not be found. id=" + id;
			log.warn(msg);

			throw new EntityNotFoundException(msg);
		}

		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	public T get(PK id, Long version) {
		T entity = this.get(id);
		if (entity.getVersion().compareTo(version) != 0) {
			
			CustomWarningException vwe = new CustomLockException();
			vwe.setMessageKey("error.id.1003");
			throw vwe;
		}
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean exists(PK id) {
		T entity = (T) this.entityManager.find(this.persistentClass, id);

		if (entity == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public T merge(T object) {
		T entity = this.entityManager.merge(object);
		this.entityManager.flush();
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	public void persist(T object) {
		this.entityManager.persist(object);
		this.entityManager.flush();
	}

	/**
	 * {@inheritDoc}
	 */
	public void update() {
		this.entityManager.flush();
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(PK id) {
		this.entityManager.remove(this.get(id));
		this.entityManager.flush();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void remove(PK id, Long version) {
		this.entityManager.remove(this.get(id, version));
		this.entityManager.flush();
	}

	/**
	 * {@inheritDoc}
	 */
	public void incrementVersion(T object) {
		this.entityManager.lock(object, LockModeType.WRITE);
	}

	/**
	 * {@inheritDoc}
	 */
	public void pessimisticLock(T object) {
		this.entityManager.lock(object, LockModeType.READ);
	}

	/**
	 * {@inheritDoc}
	 */
	public T lock(PK primaryKey) {
		return this.lock(primaryKey, LockModeType.READ);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T lock(PK primaryKey, LockModeType lockModeType) {
		Session session = (Session) this.entityManager.getDelegate();
		org.hibernate.Query query = session.createQuery(
				"FROM " + this.persistentClass.getName() + " as entity "
						+ "WHERE entity.id = :id ").setParameter("id",
				primaryKey);
		query.setLockMode("entity", getLockMode(lockModeType));
		return returnSingleResult(query.list());
	}

	/**
	 * {@inheritDoc}
	 */
	public T getReference(PK primaryKey) {
		return this.entityManager
				.getReference(this.persistentClass, primaryKey);
	}

	/**
	 * 检查对象结果集中是否只存在一条数据<br/>
	 * 如果多于一条则抛出异常
	 * 
	 * @param results 对象结果集
	 */
	protected T returnSingleResult(Collection<T> results) {
		if (results.size() == 0)
			return null;
		else if (results.size() > 1)
			throw new CustomSystemException(this.getClass().getName()
					+ "所操作的数据可能不整合。存在多个满足检索条件的"
					+ this.persistentClass.getName() + "实体。");
		return results.iterator().next();
	}
	
	
	/**
	 * 检查对象结果集中是否只存在一条不会null的数据<br/>
	 * 如果多于一条或者为null则抛出异常
	 * 
	 * @param results 对象结果集
	 */
	protected T returnSingleResultNotNull(Collection<T> results) {
		
		T t = returnSingleResult(results);
		
		if(t==null){
			String msg = this.getClass().getName()
			+ "所操作的数据可能不整合。存在多个满足检索条件"
			+ this.persistentClass.getName() + "实体。";
			log.warn(msg);
		
			throw new EntityNotFoundException(msg);
		}
		
		return t;
	}

	/**
	 * 为了使用Criteria或则执行HQL，返回org.hibernate.Session
	 * 
	 * @return org.hibernate.Session
	 */
	protected Session getSession() {
		return (Session) entityManager.getDelegate();
	}

	/**
	 * 从JPA的LockMode到Hibernate的LockMode的转换。
	 * 
	 * @param lockMode 锁模式类型
	 * @return 锁模式
	 */
	protected LockMode getLockMode(LockModeType lockMode) {
		switch (lockMode) {
		case READ:
			return LockMode.UPGRADE;
		case WRITE:
			return LockMode.FORCE;
		default:
			throw new AssertionFailure("Unknown LockModeType: " + lockMode);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void flushAndClear() {
		this.entityManager.flush();
		this.entityManager.clear();
	}
	
	/**
	 * 使用log4j，按特定格式向日志中输出所执行的SQL文
	 * 
	 * @param strSQL SQL文
	 */
	protected void writeSQLLog(String strSQL) {
		log.info("SQL Execute From IP[" + sessionManager.getAttribute("clinetIP")
				+ "]:\nSQLText=[" + strSQL + "]");
	}
	
	/**
	 * 执行SQL文，并使用log4j，按特定格式向日志中输出所执行的SQL文
	 * 
	 * @param strSQL SQL文
	 */
	protected Query createJPQLQuery(String strSQL) {
		writeSQLLog(strSQL);
		return this.entityManager.createQuery(strSQL);
	}
}
