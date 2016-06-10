<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<%@include file="/WEB-INF/jsp/commons/common.jsp"%>
</head>
<body>
	<center>
		<img src="img/jing.jpg" onclick="enterList()" style="cursor: pointer;">
	</center>
	<script type="text/javascript">
		function enterList(){
			location.href=basePath+"/accumulation/pointLists";
		}
	</script>
</body>
</html>