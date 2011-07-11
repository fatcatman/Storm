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
 * 帐户信息实体
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@Entity
@Configurable
@Table(name="account_info", schema = "storm")
@XmlType(name = "AccountInfo", namespace = "domain.model.storm")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountInfo extends EntityObjectWithGeneratedId {

	private static final long serialVersionUID = 7144853433573266371L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * 登陆用户名
	 */
	@Column(name="username", nullable=false, length=20)
	private String username;

	/**
	 * 登陆密码
	 */
	@Column(name="password", nullable=false, length=20)
	private String password;
	
	/**
	 * 住址
	 */
	@Column(name="address",nullable=true,length=100)
	private String address;

	/**
	 * 电子邮箱地址
	 */
	@Column(name="email",nullable=true,length=50)
	private String email;

	/**
	 * 默认构造函数
	 */
	public AccountInfo(){
		super();
	}

	/**
	 * ID取得方法
	 * 
	 * @return ID
	 */
	@Override
	public Long getId() {
		return id;
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
	 * 登陆用户名取得方法
	 * 
	 * @return 登陆用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 登陆用户名设定方法
	 * 
	 * @param username 登陆用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 登陆密码取得方法
	 * 
	 * @return 登陆密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 登陆密码设定方法
	 * 
	 * @param password 登陆密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 住址取得方法
	 * 
	 * @return 住址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 住址设定方法
	 * 
	 * @param address 住址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 电子邮箱地址取得方法
	 * 
	 * @return 电子邮箱地址
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 电子邮箱地址设定方法
	 * 
	 * @param email 电子邮箱地址
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
