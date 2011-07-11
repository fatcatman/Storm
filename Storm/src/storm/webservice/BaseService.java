package storm.webservice;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import storm.utils.ILogManager;
import storm.utils.ISessionManager;
import storm.utils.IValidatorManager;

/**
 * WebService基础类
 * 
 * 所有WebService类都继承自本类，为其提供基本对象和方法
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public abstract class BaseService {

	protected Logger log;
	
	@Autowired
	protected ILogManager logManager;
	
	@Resource
	protected WebServiceContext context;
	
	@Autowired
	protected ISessionManager sessionManager;
	
	@Autowired
	protected IValidatorManager validatorManager;
	
	/**
	 * 初始化方法
	 * 
	 * 类实例化完成后，该方法被自动调用
	 * 
	 */
	@PostConstruct
	public void init() {
		log = Logger.getLogger(getClass());
		logManager.registerLog(log);
	}
}
