package storm.impl.validator;

import storm.validator.IValidator;

/**
 * 空字符串验证类
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public class IsEmptyStringValidator implements IValidator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean validator(Object... args) {
		if (null == args || args.length != 1 || !(args[0] instanceof String)) {
			return true;
		}
		
		if("".equals(args[0])) {
			return true;
		}
		
		return false;
	}

}
