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
//			获取session对象
			HttpSession session=request.getSession();
//			从session中获取登陆的用户对象
			UserInfo ui=(UserInfo) session.getAttribute("ui");
			if (ui==null) {
//				对用户请求进行判断
				String uri=request.getRequestURI();
				
//				如果请求的是登陆方法，则对请求放行
				if (uri.indexOf("tologin.sw")>0) {
					return super.preHandle(request, response, handler);
				} else {
					//否则跳转到登录页面
					//跳转到登录页面
					response.sendRedirect("login.jsp");
				}				
			} else {//已经登录
				//允许请求继续向后执行
				return super.preHandle(request, response, handler);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;		
	}
}