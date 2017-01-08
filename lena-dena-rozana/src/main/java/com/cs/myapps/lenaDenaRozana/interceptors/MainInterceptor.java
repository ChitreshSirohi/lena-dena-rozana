package com.cs.myapps.lenaDenaRozana.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cs.myapps.lenaDenaRozana.util.Constants;



@Component
public class MainInterceptor implements HandlerInterceptor
{
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception
	{
		//request.getSession().getAttribute(Constants.getOwnerId());
		System.out.println("CH** intercept1:"+request.getRequestURI());
		System.out.println("OwnerId:"+request.getSession().getAttribute(Constants.getOwnerId()));
		if(request.getSession().getAttribute(Constants.getOwnerId()) != null)
		{
			return true;
		}
		//com.cs.myapps.lenaDenaRozana.logging.LenaDenaLogger.getLogger().warn("CH** interceptor called");
		
		if(request.getRequestURI().equals(Constants.getHomePage())
				|| request.getRequestURI().equals(Constants.getLoginPage())
				|| request.getRequestURI().equals(Constants.getRegisterPage())
				|| request.getRequestURI().equals(Constants.getVerifyOwner())
				|| request.getRequestURI().equals(Constants.getSaveOwner()))
		{
			System.out.println("CH** intercept2:"+request.getRequestURI());
			return true;
		}
		response.sendRedirect("login?notloggedin=true");
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
