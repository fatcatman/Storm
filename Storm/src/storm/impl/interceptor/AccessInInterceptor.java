package storm.impl.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import storm.interceptor.IBaseInterceptor;
import storm.utils.ISessionManager;
 
/**
 * 自定义Service访问拦截器 <br/>
 * 
 * 客户端访问服务器的WebService时，本拦截器被触发，
 * 并使用log4j把reqeust信息输出访问日志
 * 
 * @author hexiao
 * @version 1.0
 */
@Component
public class AccessInInterceptor extends AbstractPhaseInterceptor<Message>
		implements IBaseInterceptor {

	@Autowired
	protected ISessionManager sessionManager;
	
	private Logger log = Logger.getLogger(getClass());
	
	/**
	 * 默认构造方法
	 */
	public AccessInInterceptor() {
        super(Phase.RECEIVE);
    }
 
	/**
	 * 消息处理方法
	 * 
	 * @param message CXF消息
	 */
    public void handleMessage(Message message) throws Fault {
    	HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
    	String strIPAddress = request.getRemoteAddr();
    	
    	sessionManager.setSession(request.getSession());
    	sessionManager.setAttribute("clinetIP", strIPAddress);
    	
    	String[] requestURIArrays = ((String)message.get(Message.REQUEST_URI)).split("/");
    	
        log.warn("Access From IP["+ strIPAddress + "]:");
        log.info("\tRequest URL: [" + message.get(Message.REQUEST_URL) + "]");
        log.warn("\tReqeust WebService Name: [" + requestURIArrays[requestURIArrays.length-2] + "]");
        log.warn("\tReqeust Method Name: [" + requestURIArrays[requestURIArrays.length-1] + "]");
        log.info("\tRequest Parameters: [" + message.get(Message.QUERY_STRING) + "]");
    }
}
