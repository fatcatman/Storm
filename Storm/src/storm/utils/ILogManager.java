package storm.utils;

import org.apache.log4j.Logger;

/**
 * 日志管理器接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public interface ILogManager {
	
	/**
	 * 输出INFO级别日志
	 * 
	 * @param message 日志信息
	 */
	public void writeInfoLog(String message);
	
	/**
	 * 输出INFO级别日志
	 * 
	 * @param message 日志信息
	 * @param cause 可抛出对象
	 */
	public void writeInfoLog(String message, Throwable cause);
	
	/**
	 * 输出DEBUG级别日志
	 * 
	 * @param message 日志信息
	 */
	public void writeDebugLog(String message);
	
	/**
	 * 输出DEBUG级别日志
	 * 
	 * @param message 日志信息
	 * @param cause 可抛出对象
	 */
	public void writeDebugLog(String message, Throwable cause);
	
	/**
	 * 输出WARN级别日志
	 * 
	 * @param message 日志信息
	 */
	public void writeWarningLog(String message);
	
	/**
	 * 输出WARN级别日志
	 * 
	 * @param message 日志信息
	 * @param cause 可抛出对象
	 */
	public void writeWarningLog(String message, Throwable cause);
	
	/**
	 * 输出ERROR级别日志
	 * 
	 * @param message 日志信息
	 */
	public void writeErrorLog(String message);
	
	/**
	 * 输出ERROR级别日志
	 * 
	 * @param message 日志信息
	 * @param cause 可抛出对象
	 */
	public void writeErrorLog(String message, Throwable cause);
	
	/**
	 * 输出FATAL级别日志
	 * 
	 * @param message 日志信息
	 */
	public void writeFatalLog(String message);
	
	/**
	 * 输出FATAL级别日志
	 * 
	 * @param message 日志信息
	 * @param cause 可抛出对象
	 */
	public void writeFatalLog(String message, Throwable cause);
	
	/**
	 * 注册日志对象
	 * 
	 * @param log 日志对象
	 */
	public void registerLog(Logger log);
}
