package storm.impl.validator;

import storm.validator.IValidator;

/**
 * 字符串长度验证类
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public class StringLengthValidator implements IValidator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean validator(Object... args) {
		if (null == args || args.length != 2 || !(args[0] instanceof String)
				|| !(args[1] instanceof Integer)) {
			return false;
		}
		
		String value=(String)args[0];
		int length = (Integer)args[1];
		
		
		if("".equals(value) && 0 != length) {
			return false;
		}
		
		if (length != value.length()) {
			return false;
		}
		
		return true;
	}
}
