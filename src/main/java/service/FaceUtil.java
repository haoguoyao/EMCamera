package service;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import model.PhotoResult;
import model.Student;
import repository.InfoDAO;
import repository.RollCallDAO;
import tools.FilePath;
import tools.ImageUtil;
import tools.JsonTool;

public class FaceUtil {
	public static int doFace(String photo1,String photo2,int id) {
		int confidence = 0;
		CloseableHttpClient httpclient = HttpClients.createDefault();  
		HttpPost httppost = new HttpPost("https://api-cn.faceplusplus.com/facepp/v3/compare");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        File file1 = new File(photo1);
        File file2 = new File(photo2);
        builder.addTextBody("api_key", "XJAr1InMRuCe7RNzVE_LUCp5vHZxQeJM");
        builder.addTextBody("api_secret", "Pge81stJT7ut65mjboA9YmPLkC1fM1ZR");
        builder.addBinaryBody("image_file1", file1);
        builder.addBinaryBody("image_file2", file2);
        try { 
            httppost.setEntity(builder.build());  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity(); 
                JSONObject result = new JSONObject(EntityUtils.toString(entity, "UTF-8"));
                confidence = result.getInt("confidence"); 
                System.out.println(confidence);
            } finally {  
                response.close();  
           
            }}catch (Exception e) {
			e.printStackTrace();
		}
        if(confidence>60) {
        		PhotoResult photoResult = new PhotoResult(id,photo2);
        		RollCallDAO.createPhotoResult(photoResult);
        		return id;
        }
        else 
        		return -1;
    
	}
	public static void doClass (String classPhotoPath,int clazzId) {
		List<Student> students = InfoDAO.retrieveStudentByClazz(clazzId);
		for(Student student:students){
			int studentId = student.getId();
			String studentPhotoPath = FilePath.studentIDToPath(studentId);
			doFace(classPhotoPath, studentPhotoPath, studentId);
		}
	}
	public static void faceSearch(File photo,int classID) {
		CloseableHttpClient httpclient = HttpClients.createDefault();  
		HttpPost httppost = new HttpPost("https://api-cn.faceplusplus.com/facepp/v3/search");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("api_key", "XJAr1InMRuCe7RNzVE_LUCp5vHZxQeJM");
        builder.addTextBody("api_secret", "Pge81stJT7ut65mjboA9YmPLkC1fM1ZR");
        builder.addTextBody("outer_id", String.valueOf(classID));
        builder.addBinaryBody("image_file", photo); 
        try { 
            httppost.setEntity(builder.build());  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost); 
            try {  
                HttpEntity entity = response.getEntity(); 
                JSONObject result = new JSONObject(EntityUtils.toString(entity, "UTF-8"));
                JSONArray faceResut = result.getJSONArray("results");
                System.out.println(result.toString());
            } finally {  
                response.close();  
           
            }}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void doDetect(File photo) {
		ImageUtil imageUtil = new ImageUtil(photo);
		CloseableHttpClient httpclient = HttpClients.createDefault();  
		HttpPost httppost = new HttpPost("https://api-cn.faceplusplus.com/facepp/v3/detect");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("api_key", "XJAr1InMRuCe7RNzVE_LUCp5vHZxQeJM");
        builder.addTextBody("api_secret", "Pge81stJT7ut65mjboA9YmPLkC1fM1ZR");
        builder.addBinaryBody("image_file", photo); 
        try { 
            httppost.setEntity(builder.build());  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost); 
            try {  
                HttpEntity entity = response.getEntity(); 
                JSONObject result = new JSONObject(EntityUtils.toString(entity, "UTF-8"));
                JSONArray faces= result.getJSONArray("faces");
                for(int i= 0;i<faces.length();i++) {
                		JSONObject position = (JSONObject) faces.getJSONObject(i).get("face_rectangle");
                		imageUtil.cutImage(position,i);
                		System.out.println(position.toString());
                }
            } finally {  
                response.close();  
           
            }}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}	
