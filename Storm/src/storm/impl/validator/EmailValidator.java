package storm.impl.validator;

import storm.validator.IValidator;

/**
 * email格式验证类
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public class EmailValidator implements IValidator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean validator(Object... args) {
		if (null == args || args.length != 1 || !(args[0] instanceof String)) {
			return false;
		}
		
		if (!org.apache.commons.validator.EmailValidator.getInstance().isValid(
				(String) args[0])) {   
	            return false;  
	     }
		 
		 return true;
	}

}
