package com.lds.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lds.dao.UserDao;
import com.lds.vo.UserInfo;

@Controller
public class Handler {
	@Autowired
	private UserDao dao;
	
	@RequestMapping("/tologin")
	public String userLogin(UserInfo ui,HttpServletRequest request)throws Exception {
		System.out.println(11111111);
		try {
//			�ֶ�����һ���쳣��Ϣ
			ui=null;
			System.out.println(ui.getUname());
			ui=dao.checkUserLogin(ui);
			if (ui==null) {
				System.out.println("~~��¼ʧ��~~");
				return "redirect:login.jsp";
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("ui", ui);
				return "redirect:tolist.sw";

			}
		} catch (Exception e) {
			throw new Exception("�����ֶ������쳣");
		}				
	}
}