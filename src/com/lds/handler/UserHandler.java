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
			//设置下载的编码
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			name = new String(name.getBytes("ISO-8859-1"),"utf-8");
//			设置要下载的文件信息
			response.setHeader("Content-Disposition", "attachment;filename="+name);
			//得到下载的文件的对象
			String path = request.getRealPath("/savefile/")+"/"+bm;
			FileInputStream fis = new FileInputStream(path);
			//得到输入出流
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
			System.out.println("上传人:"+ui.getUname());
//			得到文件保存的路径
			@SuppressWarnings("deprecation")
			String path=request.getRealPath("/savefile/");
			String fname=fs.getOriginalFilename();
			System.out.println("图片名称:"+fs.getOriginalFilename());
//			得到新的文件名
			String newname=this.getNewFilenae()+"."+fname.replace('.', ',').split(",")[1];
			System.out.println("文件存储路径:"+path);
			System.out.println("原始文件名:"+fname);
			System.out.println("新文件名:"+newname);
			
//			将新的文件信息保存到数据库
			ui.setImbm(newname);
			ui.setImname(fname);
			ui.setImpath(path+"\\"+newname);
			
//			将用户信息保存到数据库
			dao.saveadd(ui);
			
//			根据当前文件信息创建一个文件对象
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