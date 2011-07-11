package storm.model.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.cxf.aegis.type.java5.XmlType;

/**
 * 基础实体对象<br/>
 * 
 * 所有实体对象都继承自本类，为实体对象提供基本信息。
 * 
 * @author hexiao
 * @version 1.0
 */
@MappedSuperclass
@XmlType(name = "EntityObject", namespace = "domain.core.model.storm")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class EntityObject extends BaseObject implements Serializable{

	/**
	 * 数据版本
	 */
	@Version
	@Column(nullable = false)
	protected Long version;
	
	/**
	 * 创建日期
	 */
	@Column(name = "create_date")
	protected Date createDate;

	/**
	 * 更新日期
	 */
	@Column(name = "update_date")
	protected Date updateDate;
	
	/**
	 * 创建者
	 */
	@Column(name = "created_by", length=100)
	protected String createdBy;

	/**
	 * 更新者
	 */
	@Column(name = "updated_by", length=100)
	protected String updatedBy;

	/**
	 * 数据版本取得方法
	 * 
	 * @return 数据版本
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * 创建日期取得方法
	 * 
	 * @return 创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 创建日期设定方法
	 * 
	 * @param createDate 创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 创建者取得方法
	 * 
	 * @return 创建者
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * 创建者设定方法
	 * 
	 * @param createdBy 创建者
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * 更新日期取得方法
	 * 
	 * @return 更新日期
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 更新日期设定方法
	 * 
	 * @param updateDate 更新日期
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 更新者取得方法
	 * 
	 * @return 更新者
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * 更新者设定方法
	 * 
	 * @param updatedBy 更新者
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
