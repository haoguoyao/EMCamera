package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.HibernateSessionFactory;
import service.FaceUtil;
import tools.FilePath;
import tools.Tool;

public class RollCallPhotoServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		//学生照片目录
		String filepath = "images/rollcall";
		//servlet上传缓存文件
		File temppath = new File("images/temp");
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setSizeThreshold(1024*1024*10);
		diskFileItemFactory.setRepository(temppath);
		String rollCallID = null;
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		try {
			List<FileItem> fileItems = servletFileUpload.parseRequest(req);
			Iterator<FileItem> iter = fileItems.iterator();
			while (iter.hasNext()){
		        FileItem item = (FileItem) iter.next();
		        if (item.isFormField()){
		        		//如果是id的话
		            rollCallID = item.getString();
		            System.out.println(item.getName()+"\n"+item.getFieldName()+"\n"+item.getString());
		            filepath = filepath+"/"+FilePath.idToPath(rollCallID);
		            File parentPath = new File(filepath);
		            //创建callover照片文件夹
		            if(!parentPath.exists())
		            		parentPath.mkdirs();
		        }
		        else{
		        		//如果是图片
		            String filename = item.getName();
		            File uploadFile = new File(filepath+"/"+filename);
		            item.write(uploadFile);
		            FaceUtil.doDetect(uploadFile);
		        }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
