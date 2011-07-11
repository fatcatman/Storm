package storm.validator;

/**
 * 验证接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public interface IValidator {
	
	/**
	 * 验证方法
	 * 
	 * @param args 验证所需参数
	 * @return 验证结果<br/>
	 *         true - 验证成功<br/>
	 *         false - 验证失败<br/>
	 */
	public Boolean validator(Object... args);
}
