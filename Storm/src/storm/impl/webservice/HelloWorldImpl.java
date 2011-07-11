package storm.impl.webservice;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import storm.webservice.BaseService;
import storm.webservice.IHelloWorld;

/**
 * 测试用服务
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@WebService
@Component(value="helloWorldImpl")
public class HelloWorldImpl extends BaseService implements IHelloWorld {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String sayHello(String name) {
		System.out.println("test=[" + sessionManager.getAttribute("test") + "]");
		sessionManager.setAttribute("test", name);
		System.out.println("sayHello is called by " + name);
		return "Hello " + name;
	}

}
