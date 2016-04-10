package com.accdays.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * 排除springSecurity对webservices的拦截
 * @author hedong
 * @date 2013年11月24日 下午11:43:48
 * @modifyNote
 * @version 1.0
 */
public class ExtendSpringSecurityFilter extends DelegatingFilterProxy {
	
	@Override  
    public void doFilter(ServletRequest req, ServletResponse res,  
            FilterChain chain) throws IOException, ServletException {  
  
        try {  
            HttpServletRequest request = (HttpServletRequest) req;  
            // 判断是否是向WebService发出的请求  
            if (request.getRequestURI().contains("/services")) {  
                // 如果是来自向CXFService发出的请求  
                chain.doFilter(req, res);  
            } else {  
                // 默认action请求  
                super.doFilter(req, res, chain);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    } 

}
