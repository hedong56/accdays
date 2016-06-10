<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="d" uri="/WEB-INF/selfJSPTagAndFunction.tld" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+":"+"//"+request.getServerName()+":"+request.getServerPort()+path;
if(request.getServerPort()==80){
	basePath = request.getScheme()+":"+"//"+request.getServerName()+path;
}

%>
<c:set var="basePath" value="<%=basePath %>"/>