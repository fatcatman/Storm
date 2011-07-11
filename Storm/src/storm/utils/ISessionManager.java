package storm.utils;

import javax.servlet.http.HttpSession;

/**
 * Session管理器接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public interface ISessionManager {
	
	/**
	 * 从session取得对象
	 * 
	 * @param attribute 对象取得用key
	 * @return 取得的对象
	 */
	public Object getAttribute(String attribute);
	
	/**
	 * 向session中存入对象
	 * 
	 * @param attribute 对象存入用key
	 * @param value 对象
	 */
	public void setAttribute(String attribute, Object value);
	
	/**
	 * 从session删除指定对象
	 * 
	 * @param attribute 对象删除用key
	 */
	public void removeAttribute(String attribute);
	
	/**
	 * 设置session对象
	 * 
	 * @param session session对象
	 */
	public void setSession(HttpSession session);
}
