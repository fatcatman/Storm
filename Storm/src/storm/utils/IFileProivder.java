package storm.utils;

import java.io.InputStream;

/**
 * 文件提供器接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public interface IFileProivder {
	
	/**
	 * 文件取得方法
	 * 
	 * @param filename 文件名
	 * 
	 * @return 文件流
	 */
	public InputStream getFile(String filename);
}
