package com.lds.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lds.vo.UserInfo;

public class InvInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		try {
//			��ȡsession����
			HttpSession session=request.getSession();
//			��session�л�ȡ��½���û�����
			UserInfo ui=(UserInfo) session.getAttribute("ui");
			if (ui==null) {
//				���û���������ж�
				String uri=request.getRequestURI();
				
//				���������ǵ�½����������������
				if (uri.indexOf("tologin.sw")>0) {
					return super.preHandle(request, response, handler);
				} else {
					//������ת����¼ҳ��
					//��ת����¼ҳ��
					response.sendRedirect("login.jsp");
				}				
			} else {//�Ѿ���¼
				//��������������ִ��
				return super.preHandle(request, response, handler);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;		
	}
}