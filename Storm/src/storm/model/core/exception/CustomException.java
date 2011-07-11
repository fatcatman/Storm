package storm.model.core.exception;

/**
 * 自定义列外接口
 * 
 * @author hexiao
 * @version 1.0
 */
public interface CustomException {

	/**
	 * 例外信息参数集合取得方法
	 * 
	 * @return　例外信息参数集合
	 */
	public Object[] getMessageArgs();

	/**
	 * 例外信息参数合集设定方法
	 * 
	 * @param messageArgs　例外信息参数合集
	 */
	public void setMessageArgs(Object... messageArgs);
	
	/**
	 * 例外信息取得方法
	 * 
	 * @return 例外信息
	 */
	public String getMessage();
}
