<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义JSP标签</title>
<%@include file="/WEB-INF/jsp/commons/common.jsp"%>
</head>
<body>
	==========自定义JSP标签===================<br>
	标签的所有属性都要生成get,set方法<br>
	----------------------------<br>
	1:继承SimpleTagSupport(不支持JSP脚本代码)<br>
<%-- 	<d:userBean userId="${id}" var="user">${user.name}<%="这是JSP脚本输出" %></d:userBean><br> --%>
	<d:userBean userId="${id}" var="user">${user.name}</d:userBean><br>
	2:继承BodyTagSupport(支持JSP脚本代码)<br>
	<d:userBeanStrong userId="${id}" var="user">${user.name}&nbsp;&nbsp;&nbsp;<%="这是JSP脚本输出" %>&nbsp;&nbsp;<%=request.getRequestURI() %>&nbsp;&nbsp;&nbsp;<%=request.getRequestURL() %></d:userBeanStrong>
	
	<br><br><br>
	==========自定义JSP函数=================== <br>
	<%="${d:intToChnNum(1)}" %>= "${d:intToChnNum(id)}"<br>
</body>
</html>