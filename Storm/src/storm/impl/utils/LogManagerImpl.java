package storm.impl.utils;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import storm.utils.ILogManager;

/**
 * 日志管理器
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@Component
@Scope("prototype")
public class LogManagerImpl implements ILogManager {

	protected Logger log;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeInfoLog(String message) {
		log.info(message);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeInfoLog(String message, Throwable cause) {
		log.info(message, cause);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeDebugLog(String message) {
		log.debug(message);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeDebugLog(String message, Throwable cause) {
		log.debug(message, cause);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeWarningLog(String message) {
		log.warn(message);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeWarningLog(String message, Throwable cause) {
		log.warn(message, cause);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeErrorLog(String message) {
		log.error(message);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeErrorLog(String message, Throwable cause) {
		log.error(message, cause);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeFatalLog(String message) {
		log.fatal(message);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeFatalLog(String message, Throwable cause) {
		log.fatal(message, cause);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registerLog(Logger log) {
		this.log = log;
	}
}
