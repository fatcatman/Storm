package storm.impl.utils;

import org.springframework.stereotype.Component;

import storm.utils.IValidatorManager;
import storm.validator.IValidator;

/**
 * 验证管理器
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@Component
public class ValidatorManager implements IValidatorManager {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Boolean validator(Class validatorClass, Object... args) {
		IValidator validator;
		
		try {
			validator = (IValidator)validatorClass.newInstance();
		} catch (InstantiationException e) {
			return false;
		} catch (IllegalAccessException e) {
			return false;
		}

		return validator.validator(args);
	}

}
