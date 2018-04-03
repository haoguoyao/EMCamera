package tools;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.json.JSONObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
public class ImageUtil {
	private File photoFile;
	public ImageUtil(File file) {
		this.photoFile = file;
	}
	//2个非静态方法
	public void cutImage(JSONObject position,int num) throws IOException {
		cutImage(position.getInt("top"),position.getInt("left"),position.getInt("width"),position.getInt("height"),num);
	}
	public void cutImage(int x, int y, int w, int h,int num) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(photoFile);
		System.out.println(x+"  "+y+"  "+w+"  "+h);
		BufferedImage newImage = bufferedImage.getSubimage(y,x , w, h);
		File f = new File(photoFile.getParent()+"/"+num);  
		ImageIO.write(newImage, "png", f);
	}
	public void cutImageAndCompare(int x, int y, int w, int h,int num) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(photoFile);
		System.out.println(x+"  "+y+"  "+w+"  "+h);
		BufferedImage newImage = bufferedImage.getSubimage(y,x , w, h);
		File f = new File(photoFile.getParent()+"/"+num);  
		ImageIO.write(newImage, "png", f);
	}
    /**
     * 
     * 使用imageIO高级方法
     * */
    public static void cutImage2(File sourceFile, String src, String dest, int x, int y, int w, int h) throws IOException {  
        Iterator iterator = ImageIO.getImageReadersByFormatName(getImageFormatName(sourceFile));  
        ImageReader reader = (ImageReader) iterator.next();  
        InputStream in = new FileInputStream(src);  
        ImageInputStream iis = ImageIO.createImageInputStream(in);  
        reader.setInput(iis, true);  
        ImageReadParam param = reader.getDefaultReadParam(); 
        Rectangle rect = new Rectangle(x, y, w, h);  
        param.setSourceRegion(rect);  
        BufferedImage bi = reader.read(0, param);  
        ImageIO.write(bi, getImageFormatName(sourceFile), new File(dest));  
  
    } 
    public static String getImageFormatName(File file) throws IOException {
        String formatName = null;
        ImageInputStream iis = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> imageReader = ImageIO.getImageReaders(iis);
        if (imageReader.hasNext()) {
            ImageReader reader = imageReader.next();
            formatName = reader.getFormatName();
        }

        return formatName;
    } 


}
