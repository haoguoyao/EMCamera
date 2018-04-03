package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.HibernateSessionFactory;
import tools.FilePath;

public class StudentPhotoUploadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6569737396992917930L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		//学生照片目录
		String filepath = null;
		//servlet上传缓存文件
		File temppath = new File("images/temp");
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setSizeThreshold(1024*1024*10);
		diskFileItemFactory.setRepository(temppath);
		String studentID = null;
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		try {
			List<FileItem> fileItems = servletFileUpload.parseRequest(req);
			Iterator<FileItem> iter = fileItems.iterator();
			while (iter.hasNext()){
		        FileItem item = (FileItem) iter.next();
		        if (item.isFormField()){
		        	//如果是id的话
		            studentID = item.getString();
		            System.out.println(item.getName()+"\n"+item.getFieldName()+"\n"+item.getString());
		            filepath = FilePath.studentIDToPath(studentID);
		            File parentPath = new File(filepath);
		            //创建学生id
		            if(!parentPath.exists())
		            		parentPath.mkdir();
		        }
		        else{
		        	//如果是图片
		            String filename = item.getFieldName();
		            File uploadFile = new File(filepath+"/"+filename);
		            item.write(uploadFile);
		        }
		        //对点名照片进行处理
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
