package com.hgy.handler;

import java.io.File;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.StudentService;

@Controller
public class OpenidBindHandler {
	
	@Autowired
	private BaseDAO baseDAO;
	@Autowired
	private StudentService studentDAO;
	
	/**
	 * 打开小程序的时候拿着openid向服务器发请求，这时有两种情况
	 * 1.openid不存在（进行学号绑定，作为student的一个变量存入数据库）
	 * 2.openid已经存在（取出学生id，进行返回）
	 * 
	 * 
	 * */
	@RequestMapping(value = "/wechat/OpenidLoginHandler")
	@ResponseBody
	public int openidLogin(String openid) throws Exception {
		if(!isOpenidExist(openid))
			return 0;
		else {
			Student student = studentDAO.findByOpenid(openid);
			return student.getId();
		}
		
	}
	/**
	 * 绑定的过程分两步
	 * 1、看是否有已绑定的学号进行解绑
	 * 2、绑定新学号
	 * 
	 * */
	@RequestMapping(value = "/student/OpenidBindHandler")
	@ResponseBody
	public String openidBind(String openid,Integer id) throws Exception {
		if(!isOpenidExist(openid))
			return "0";
		else {
			//解绑
			Student student = studentDAO.findByOpenid(openid);
			if(student!=null) {
				student.setOpenid(null);
				baseDAO.save(student);
			}
			//绑定
			Student student2 = (Student) baseDAO.find(Student.class, id);
			student2.setOpenid(openid);
			baseDAO.save(student2);
			return "1";
		}
		
	}
	public boolean isOpenidExist(String openid) {
		 return studentDAO.openidBinded(openid);
	}
	
}
