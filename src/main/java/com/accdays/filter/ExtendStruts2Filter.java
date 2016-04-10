package com.accdays.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义扩展Struts2过滤器，用于解决struts会拦截cxf webservice请求的问题
 * @author hedong
 * @date 2013年11月24日 上午12:37:35
 * @modifyNote
 * @version 1.0
 */
public class ExtendStruts2Filter extends StrutsPrepareAndExecuteFilter {

	private static Logger log = LoggerFactory  
            .getLogger(ExtendStruts2Filter.class);  
  
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
            log.error(e.getMessage());  
            e.printStackTrace();  
        }  
    }  

	/**
	 * 得到CXF的url-pattern
	 * @Description
	 * @author hedong
	 * @date 2013年11月24日 上午12:50:01
	 * @modifyNote 
	 * @return
	 */
	private String getCXFUrlPattern() {
//		String filePath = "zxt_index.xml";  
//        String indexPath="";  
//         SAXBuilder builder = new SAXBuilder(false);  
//         try {  
//             Document doc = (Document) builder.build(Thread.currentThread().getContextClassLoader().getResource(filePath));  
//             Element books = doc.getRootElement();  
//              Element rootElement= books.getChild("list");  
//             Element index=rootElement.getChild("index");  
//              indexPath=index.getText();  
//              System.out.println(indexPath);  
//         } catch (JDOMException e) {  
//             e.printStackTrace();  
//         } catch (IOException e) {  
//             e.printStackTrace();  
//         }   
		return null;
	}
	
}
