package tools;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.json.JSONArray;

import model.Student;

public class ServletUtil {
	public static void uploadPhotos(OutputStream outputStream,String path) throws IOException {
		ZipOutputStream zos = new ZipOutputStream(outputStream);
		File folder = new File(path);
		File[] files = folder.listFiles();
		//将用户个人照片目录下的所有照片用压缩包的形式
		for(File file:files) {
            zos.putNextEntry(new ZipEntry(file.getName()));  
            FileInputStream fis = new FileInputStream(file);  
            try  
            {  
                byte b[] = new byte[1024];  
                int n = 0;  
                while((n = fis.read(b)) != -1){  
                    zos.write(b, 0, n);  
                }  
            }finally  
            {  
                zos.flush();  
                fis.close();  
            } 
		}
		zos.close();
	}
	public static void uploadPhotos(OutputStream outputStream,List<String> paths) throws IOException {
		ZipOutputStream zos = new ZipOutputStream(outputStream);
		//将用户个人照片目录下的所有照片用压缩包的形式
		for(String path:paths) {
			File file = new File(path);
            zos.putNextEntry(new ZipEntry(file.getName()));  
            FileInputStream fis = new FileInputStream(file);  
            try  
            {  
                byte b[] = new byte[1024];  
                int n = 0;  
                while((n = fis.read(b)) != -1){  
                    zos.write(b, 0, n);  
                }  
            }finally  
            {  
                zos.flush();  
                fis.close();  
            } 
		}
		zos.close();
		
	}
	public static void uploadList(Writer writer,List<?> list) throws IOException {
		JSONArray jsonArray = JsonTool.toJsonArray(list);
		writer.write(jsonArray.toString());
		writer.flush();
	}

}
