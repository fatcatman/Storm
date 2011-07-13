package storm.impl.webservice;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import storm.utils.IFileProivder;
import storm.webservice.IImageService;

/**
 * 图片取得服务
 * 
 * @author hexiao
 * @version 1.0
 * 
 */
@Path("/ImageService")
@Produces("image/jpeg")
@Component(value="imageServiceImpl")
public class ImageServiceImpl implements IImageService {
	
	@Autowired
	private IFileProivder fileProvider;

	/**
	 * {@inheritDoc}
	 */
	@GET
	@Path("/getImage/{filename}")
	@Override
	public InputStream getImage(@PathParam("filename") String filename) {
		return fileProvider.getFile(filename);
	}
}
