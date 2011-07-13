package storm.impl.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

import storm.utils.IFileProivder;

/**
 * 文件提供器接口（测试用，非正式版本）
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@Component
public class FileProivder implements IFileProivder {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Deprecated
	public InputStream getFile(String filename) {
		try {
			FileInputStream fis = new FileInputStream("C:\\" + filename);
			return fis;
		} catch (IOException e) {
			return null;
		}
	}

}
