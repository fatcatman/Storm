package storm.model.core.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 基础对象<br/>
 * 
 * 基础实体对象继承自本类，为基础实体对象提供 toString、equals、hashCode等方法
 * 
 * @author hexiao
 * @version 1.0
 */
public abstract class BaseObject{
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * 默认构造方法
	 */
	public BaseObject() {
		if (log.isDebugEnabled()) {
			log.debug("the instance of thedomain model [ " + getClass().getName() + " ] is created.");
		}
	}

	/**
	 * 自定义toString方法
	 */
	@Override
	public String toString() {
		
		if (log.isDebugEnabled()) {
			return ToStringBuilder.reflectionToString(this,
					ToStringStyle.MULTI_LINE_STYLE);
		}else{
			return super.toString();
		}
		
	}
	
	/**
	 * 自定义equals方法
	 * 
	 * @param o 比较对象
	 */
	@Override
	public abstract boolean equals(Object o);

	/**
	 * 自定义hashCode方法
	 */
	@Override
	public abstract int hashCode();
}
