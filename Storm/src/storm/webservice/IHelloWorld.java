package storm.webservice;

import javax.jws.WebService;

/**
 * 测试用服务接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@WebService
public interface IHelloWorld {
	
	/**
	 * 测试用方法
	 * 
	 * @param name 测试用参数
	 * 
	 * @return 测试用结果
	 */
	public String sayHello(String name);
}
