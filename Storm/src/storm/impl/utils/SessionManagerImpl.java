package storm.impl.utils;

import javax.servlet.http.HttpSession;

import storm.utils.ISessionManager;

/**
 * Session管理器
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public class SessionManagerImpl implements ISessionManager {

//	private String str="";
	
	private HttpSession session = null;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getAttribute(String attribute) {
//		System.out.println("str=" + str);
//		str="123";
		return this.session.getAttribute(attribute);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAttribute(String attribute, Object value) {
		this.session.setAttribute(attribute, value);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeAttribute(String attribute) {
		this.session.removeAttribute(attribute);
	}
	
//	private HttpSession getSession(WebServiceContext context) {
//		 MessageContext ctx = context.getMessageContext();
//	        HttpServletRequest request = (HttpServletRequest) ctx
//	                .get(AbstractHTTPDestination.HTTP_REQUEST);
//	        HttpSession session = request.getSession();
//	        
//	        return session;
//	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSession(HttpSession session) {
		if(null == this.session) {
			this.session = session;
		}
	}
}
