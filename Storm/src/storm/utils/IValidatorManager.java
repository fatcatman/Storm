package storm.utils;

/**
 * 验证管理器接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public interface IValidatorManager {
	
	/**
	 * 验证方法
	 * 
	 * @param validatorClass 验证类
	 * @param args 验证所需参数
	 * @return 验证结果<br/>
	 *         true - 验证成功<br/>
	 *         false - 验证失败<br/>
	 */
	@SuppressWarnings("unchecked")
	public Boolean validator(Class validatorClass, Object... args);
}
