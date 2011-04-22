package com.mkyong.common.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter{
 	
	//before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request, 
		HttpServletResponse response, Object handler)
	    throws Exception {
 
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
 
		return true;
	}
 
	//after the handler is executed
	public void postHandle(
					
		HttpServletRequest request, HttpServletResponse response, 
		Object handler, ModelAndView modelAndView)
		throws Exception {
 
		long startTime = (Long)request.getAttribute("startTime");
 
		long endTime = System.currentTimeMillis();
 
		long executeTime = endTime - startTime;
 
		//modified the exisitng modelAndView
		modelAndView.addObject("executeTime",executeTime);
   	   System.out.println("[" + handler + "] executeTime : " + executeTime + "ms");
		
	}
}