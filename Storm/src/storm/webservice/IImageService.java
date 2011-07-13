package storm.webservice;

import java.io.InputStream;

/**
 * 图片取得服务接口
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
public interface IImageService {
	
	/**
	 * 图片取得方法
	 * 
	 * @param filename 图片文件名
	 * 
	 * @return 图片文件流
	 */
	public InputStream getImage(String filename);
}
