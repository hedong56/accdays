/**
 * Create by hedong
 * Since 2013-7-27下午4:38:35
 */
package com.accdays.jspTagAndFunction;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.accdays.model.User;
import com.accdays.service.hibernateFeature.IHibernateFeatureDemoService;

/**
 * 自定义用户标签<br>
 * <b>通过<u>userId</u>得到<u>User</u>对象</b>
 * <b>注意：SimpleTagSupport不支持<body-content>JSP</body-content></b>
 * @author hedong
 * @date 2013-7-27 下午4:38:35
 * @modifyNote
 * @version 1.0
 */
public class UserTag extends SimpleTagSupport {
	
	private Long userId;
	private String var;
	/**
	 * @author hedong
	 * @date 2013-7-27 下午5:38:03
	 * @modifyNote
	 * @throws JspException
	 * @throws IOException
	 */
	@Override
	public void doTag() throws JspException, IOException {
		// 获取容器的对象
		ServletContext servletContext = ServletActionContext.getServletContext();
		// 获取容器的上下文获取初始化的Context
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		//通过bean的名称得到bean
		IHibernateFeatureDemoService hibernateService = (IHibernateFeatureDemoService) ctx.getBean("hibernateFeatureService");
		User user=hibernateService.getUser(userId);
		getJspContext().setAttribute(var, user); 
		getJspBody().invoke(null);
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the var
	 */
	public String getVar() {
		return var;
	}
	/**
	 * @param var the var to set
	 */
	public void setVar(String var) {
		this.var = var;
	}
}
