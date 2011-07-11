package storm.model.core.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.proxy.HibernateProxy;

/**
 * 带自增ID的基础实体对象<br/>
 * 
 * 所有实体对象都继承自本类，为实体对象提供基本信息并提供自增ID字段
 * 
 * @author hexiao
 * @version 1.0
 */
@MappedSuperclass
public abstract class EntityObjectWithGeneratedId extends EntityObject {

	@Transient
    private volatile Object object;
	
	/**
	 * id取得方法
	 * 
	 * @return id
	 */
	public abstract Long getId();

	/**
	 * {@inheritDoc}
	 */
	@Override
    public boolean equals(Object obj) {
        final boolean returner;
        Class targetClass;
        if(obj instanceof HibernateProxy){
        	targetClass = ((HibernateProxy)obj).getHibernateLazyInitializer().getImplementation().getClass();
        }
        else targetClass = obj.getClass();
        
        if (obj != null && this.getClass() == targetClass) {
            return getObject().equals(((EntityObjectWithGeneratedId)obj).getObject());
        } else {
            returner = false;
        }
        return returner;
    }
   
	/**
	 * {@inheritDoc}
	 */
	@Override
    public int hashCode() {
        return getObject().hashCode();
    }
	
	/**
	 * 自定义对象取得方法
	 */
	private Object getObject() {
        if (object != null || object == null && getId() == null) {
            if (object == null) {
                synchronized(this) {
                    if (object == null)
                        object = new Object();
                }
            }
            return object;
        }
        return getId();
    } 

}
