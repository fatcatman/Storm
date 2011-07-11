package storm.model.core.exception;

/**
 * 自定义警告级别列外接口
 * 
 * @author hexiao
 * @version 1.0
 */
public class CustomWarningException extends AbstractCustomException {

	private static final long serialVersionUID = -3926875108350300271L;

	private String errorMessage;
	
	private boolean warningLevel = true;
	
	/**
	 * 默认构造方法
	 */
	public CustomWarningException() {
		super();
		this.warningLevel = true;
	}

	/**
	 * 构造方法1
	 * 
	 * @param cause 可抛出对象
	 */
	public CustomWarningException(Throwable cause) {
		super(cause);
		this.warningLevel = true;
	}

	/**
	 * 构造方法2
	 * 
	 * @param cause 可抛出对象
	 * @param messageArgs 异常信息集合
	 */
	public CustomWarningException(Throwable cause, Object... messageArgs) {
		super(cause);
		this.warningLevel = true;
		this.setMessageArgs(messageArgs);
	}
	
	/**
	 * 构造方法3
	 * 
	 * @param messageArgs 异常信息集合
	 */
	public CustomWarningException(Object... messageArgs) {
		super();
		this.warningLevel = true;
		this.setMessageArgs(messageArgs);
	}

	/**
	 * 错误信息取得方法
	 * 
	 * @return 错误信息
	 */
	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * 错误信息设定方法
	 * 
	 * @param errorMessage 错误信息
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * 警告级别设定方法
	 * 
	 * @param level 警告级别
	 */
	public void setWarningLevel(boolean level) {
		warningLevel = level;
	}

	/**
	 * 当前警告级别取得方法
	 * 
	 * @return 当前警告级别
	 */
	public boolean isWarningLevel() {
		return warningLevel;
	}
}
