package com.lds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
		System.out.println("在DispatcherServlet完全处理完请求后被调用,可用于清理资源等   *   * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() ");
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
		System.out.println("在业务处理器处理请求执行完成后,生成视图之前执行的动作  ");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("在业务处理器处理请求之前被调用 ");
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("这个是什么时候调用?");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
