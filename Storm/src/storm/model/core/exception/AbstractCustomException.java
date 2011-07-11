package storm.model.core.exception;

import java.text.MessageFormat;

/**
 * 自定义列外抽象类
 * 
 * @author hexiao
 * @version 1.0
 */
public abstract class AbstractCustomException extends RuntimeException implements
		CustomException {

	private static final long serialVersionUID = -4201513991028417241L;

	/**
	 * 构造方法1
	 * 
	 * @param cause 可抛出对象
	 */
	public AbstractCustomException(Throwable cause) {
		super(cause);
	}

	/**
	 * 构造方法2
	 * 
	 * @param message 异常信息
	 * @param cause 可抛出对象
	 */
	public AbstractCustomException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 构造方法3
	 * 
	 * @param message 异常信息
	 */
	public AbstractCustomException(String message) {
		super(message);
	}

	/**
	 * 默认构造方法
	 */
	public AbstractCustomException() {
		super();
	}

	/**
	 * 例外信息参数集合
	 */
	private Object[] messageArgs;

	/**
	 * 例外信息key
	 */
	private String messageKey;

	/**
	 * 例外信息key取得方法
	 * 
	 * @return 例外信息key
	 */
	public String getMessageKey() {
		if (messageKey == null) {
			return this.getClass().getName();
		} else {
			return messageKey;
		}
	}

	/**
	 * 例外信息key设定方法
	 * 
	 * @param messageKey　例外信息key
	 */
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * 例外信息参数集合取得方法
	 * 
	 * @return　例外信息参数集合
	 */
	public Object[] getMessageArgs() {
		return this.messageArgs;
	}

	/**
	 * 例外信息参数合集设定方法
	 * 
	 * @param messageArgs　例外信息参数合集
	 */
	public void setMessageArgs(Object... messageArgs) {
		this.messageArgs = messageArgs;
	}

	/**
	 * 例外信息取得方法
	 * 
	 * @return 例外信息
	 */
	@Override
	public String getMessage() {

		// 如果父类包含例外信息，则优先使用父类中的例外信息
		String message = super.getMessage();
		if (message == null || message.equals("")) {

			// 如果父类不包含例外信息，则使用子类中的例外信息
			String baseMessage = this.getErrorMessage();
			if ((baseMessage != null) && (baseMessage.length() > 0)) {
				message = MessageFormat.format(baseMessage, this.messageArgs);
			}
		}

		return message;
	}

	/**
	 * 错误信息取得方法
	 * 
	 * @return 错误信息
	 */
	public abstract String getErrorMessage();
}
