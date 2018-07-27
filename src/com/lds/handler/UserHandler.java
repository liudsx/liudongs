package com.lds.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lds.dao.UserDao;
import com.lds.vo.UserInfo;

@Controller
public class UserHandler {
	@Autowired
	private UserDao dao;
	
	@RequestMapping("/uploadfile")
	public String uploadfile(String name,String bm,HttpServletRequest request,HttpServletResponse response) {
		try {
			//�������صı���
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			name = new String(name.getBytes("ISO-8859-1"),"utf-8");
//			����Ҫ���ص��ļ���Ϣ
			response.setHeader("Content-Disposition", "attachment;filename="+name);
			//�õ����ص��ļ��Ķ���
			String path = request.getRealPath("/savefile/")+"/"+bm;
			FileInputStream fis = new FileInputStream(path);
			//�õ��������
			OutputStream out = response.getOutputStream();
			int m=-1;
			while((m=fis.read())!=-1){
				out.write(m);
			}
			
			out.close();
			fis.close();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@RequestMapping("/tolist")
	public String tolist(Map map) {
		System.out.println(11111);
		List<UserInfo> list = dao.tolist();
		map.put("list",list);
		return "list";		
	}
	                  
	@RequestMapping("/fileupload")
	public String fileUpload(UserInfo ui,@RequestParam("fs") MultipartFile fs,HttpServletRequest request) {
		try {
			System.out.println("�ϴ���:"+ui.getUname());
//			�õ��ļ������·��
			@SuppressWarnings("deprecation")
			String path=request.getRealPath("/savefile/");
			String fname=fs.getOriginalFilename();
			System.out.println("ͼƬ����:"+fs.getOriginalFilename());
//			�õ��µ��ļ���
			String newname=this.getNewFilenae()+"."+fname.replace('.', ',').split(",")[1];
			System.out.println("�ļ��洢·��:"+path);
			System.out.println("ԭʼ�ļ���:"+fname);
			System.out.println("���ļ���:"+newname);
			
//			���µ��ļ���Ϣ���浽���ݿ�
			ui.setImbm(newname);
			ui.setImname(fname);
			ui.setImpath(path+"\\"+newname);
			
//			���û���Ϣ���浽���ݿ�
			dao.saveadd(ui);
			
//			���ݵ�ǰ�ļ���Ϣ����һ���ļ�����
			File f = new File(path,newname);
			fs.transferTo(f);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "index";		
	}

	private String getNewFilenae() {
		String newname = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHmsS");
			Date d = new Date();
			newname = sdf.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newname;
	}

}