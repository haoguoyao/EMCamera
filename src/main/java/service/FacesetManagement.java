package service;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import tools.ImageUtil;

public class FacesetManagement {
	public static void createFaceSet(int clazzID) {
		CloseableHttpClient httpclient = HttpClients.createDefault();  
		HttpPost httppost = new HttpPost("https://api-cn.faceplusplus.com/facepp/v3/faceset/create");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("api_key", "XJAr1InMRuCe7RNzVE_LUCp5vHZxQeJM");
        builder.addTextBody("api_secret", "Pge81stJT7ut65mjboA9YmPLkC1fM1ZR");
        builder.addTextBody("outer_id", String.valueOf(clazzID));
        try { 
            httppost.setEntity(builder.build());  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost); 
            try {  
                HttpEntity entity = response.getEntity(); 
                JSONObject result = new JSONObject(EntityUtils.toString(entity, "UTF-8"));
                System.out.println(result.toString());
            } finally {  
                response.close();  
           
            }}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void addFaceToSet(int facesetID,String token) {
		CloseableHttpClient httpclient = HttpClients.createDefault();  
		HttpPost httppost = new HttpPost("https://api-cn.faceplusplus.com/facepp/v3/faceset/addface");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("api_key", "XJAr1InMRuCe7RNzVE_LUCp5vHZxQeJM");
        builder.addTextBody("api_secret", "Pge81stJT7ut65mjboA9YmPLkC1fM1ZR");
        builder.addTextBody("outer_id", String.valueOf(facesetID));
        builder.addTextBody("face_tokens", token);
        try { 
            httppost.setEntity(builder.build());  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost); 
            try {  
                HttpEntity entity = response.getEntity(); 
                JSONObject result = new JSONObject(EntityUtils.toString(entity, "UTF-8"));
                System.out.println(result.toString());
            } finally {  
                response.close();  
           
            }}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String doDetectReturnToken(File photo) {
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
            HttpEntity entity = response.getEntity(); 
            JSONObject result = new JSONObject(EntityUtils.toString(entity, "UTF-8"));
            JSONArray faces= result.getJSONArray("faces");
            	if(faces.length()>1)
            		return null;
            	else {
                	String faceToken = (String) faces.getJSONObject(0).get("face_token");
            		return faceToken;

            }}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
