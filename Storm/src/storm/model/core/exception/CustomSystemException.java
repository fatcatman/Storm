package storm.model.core.exception;

/**
 * 自定义系统级别列外接口
 * 
 * @author hexiao
 * @version 1.0
 */
public class CustomSystemException extends AbstractCustomException {

	private static final long serialVersionUID = 6072266449111166193L;

	private static final String DEFAULT_MESSAGE = "system error";

	private String defaultMessage = DEFAULT_MESSAGE;
	
	/**
	 * 默认构造方法
	 */
	public CustomSystemException() {
		super();
	}

	/**
	 * 构造方法1
	 * 
	 * @param cause 可抛出对象
	 */
	public CustomSystemException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * 构造方法2
	 * 
	 * @param message 异常信息
	 * @param cause 可抛出对象
	 */
	public CustomSystemException(String message, Throwable cause) {
		super(message, cause);
		defaultMessage = message;
	}
	
	/**
	 * 构造方法2
	 * 
	 * @param message 例外信息
	 */
	public CustomSystemException(String message) {
		super(message);
		defaultMessage = message;
	}

	/**
	 * 错误信息取得方法
	 * 
	 * @return 错误信息
	 */
	@Override
	public String getErrorMessage() {
		return defaultMessage;
	}
}
