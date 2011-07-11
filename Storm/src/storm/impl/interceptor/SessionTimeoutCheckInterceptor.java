package storm.impl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
 * Session超时访问拦截器 <br/>
 * 
 * 客户端访问服务器的WebService时，本拦截器被触发，
 * 并检查Session是否已超时
 * 
 * @author hexiao
 * @version 1.0
 */
@Component
public class SessionTimeoutCheckInterceptor extends AbstractPhaseInterceptor<Message>
		implements IBaseInterceptor {

	@Autowired
	protected ISessionManager sessionManager;
	
	private Logger log = Logger.getLogger(getClass());
	
	private static final String CONS_LOGIN_SERVICE_NAME = "LoginService";
	
	/**
	 * 默认构造方法
	 */
	public SessionTimeoutCheckInterceptor() {
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
    	HttpSession session = request.getSession();
    	
    	String strLoginUser = (String)session.getAttribute("loginUser");
    	
    	String[] requestURIArrays = ((String)message.get(Message.REQUEST_URI)).split("/");
    	
    	String strWebServiceName = requestURIArrays[requestURIArrays.length-2];
    	if(CONS_LOGIN_SERVICE_NAME.equals(strWebServiceName)) {
    		return;
    	}
    	
    	if(null == strLoginUser || "".equals(strLoginUser)) {
    		log.error("Access From IP["+ strIPAddress + "]:Session is timeouted. Please relogin.");
			throw new Fault(new IllegalAccessException("Access From IP["
					+ strIPAddress + "]:Session is timeouted. Please relogin."));
    	}
    }
}
