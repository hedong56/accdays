/**
 * Create by hedong
 * Since 2013-7-27下午8:17:56
 */
package com.accdays.jspTagAndFunction;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.accdays.model.User;
import com.accdays.service.hibernateFeature.IHibernateFeatureDemoService;

/**
 * 通过BodyTagSupport注定是标签
 * <b>注意：SimpleTagSupport不支持<body-content>JSP</body-content></b>
 * <b>注意：BodyTagSupport支持<body-content>JSP</body-content></b>
 * @author hedong
 * @date 2013-7-27 下午8:17:56
 * @modifyNote
 * @version 1.0
 */
public class UserTagByTagSupport extends BodyTagSupport {

	private Long userId;
	private String var;
	/**
	 * @author hedong
	 * @date 2013-7-27 下午8:25:25
	 * @modifyNote
	 * @return
	 * @throws JspException
	 */
	@Override
	public int doStartTag() throws JspException {
		// 获取容器的对象
		ServletContext context = (ServletContext) pageContext.getServletContext();
		// 获取容器的上下文获取初始化的Context
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		//通过bean的名称得到bean
		IHibernateFeatureDemoService hibernateService = (IHibernateFeatureDemoService) ctx.getBean("hibernateFeatureService");
		User user=hibernateService.getUser(userId);
		pageContext.setAttribute(var, user); 
		return EVAL_BODY_INCLUDE;//EVAL_BODY_INCLUDE:表示将显示标签间的文字
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
