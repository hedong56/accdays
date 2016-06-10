<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跨服务RMI访问</title>
<%@include file="/WEB-INF/jsp/commons/common.jsp"%>
</head>
<body>
	${userInfo.name}
	<br>
	<c:forEach items="${users}" var="user">
		${user.name}<br/>
	</c:forEach>
</body>
</html>