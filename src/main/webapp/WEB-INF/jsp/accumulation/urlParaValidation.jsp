<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>URL参数验证</title>
<%@include file="/WEB-INF/jsp/commons/common.jsp"%>
<style type="text/css">
	
</style>
</head>
<body>
	<center><b>URL参数验证</b></center>
	<a href="${basePath}/accumulation/userInfo?id=1">根据用户ID查询用户信息</a>
</body>
</html>