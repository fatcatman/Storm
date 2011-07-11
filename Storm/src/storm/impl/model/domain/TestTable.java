package storm.impl.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.cxf.aegis.type.java5.XmlType;
import org.springframework.beans.factory.annotation.Configurable;

import storm.model.core.domain.EntityObjectWithGeneratedId;

/**
 * 测试用实体
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@Entity
@Configurable
@Table(name="test_table", schema = "storm")
@XmlType(name = "TestTable", namespace = "domain.model.storm")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestTable extends EntityObjectWithGeneratedId {

	private static final long serialVersionUID = 1390713557232262988L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * 备注
	 */
	@Column(name="memo", nullable=false, length=255)
	private String memo;
	
	/**
	 * 备注取得方法
	 * 
	 * @return 备注
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * 备注设定方法
	 * 
	 * @param memo 备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * ID设定方法
	 * 
	 * @param id ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * ID取得方法
	 * 
	 * @return ID
	 */
	@Override
	public Long getId() {
		return this.id;
	}
}
