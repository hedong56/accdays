<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>知识点列表</title>
<%@include file="/WEB-INF/jsp/commons/common.jsp"%>
</head>
<body>
	<ol>
		<li><a href="${basePath}/accumulation/charParams">通过拼接字符串方式传递参数</a></li>
		<li><a href="${basePath}/accumulation/mapParams">传递Map对象参数</a></li>
		<li><a href="${basePath}/accumulation/dynamicLading">滚动鼠标动态加载内容</a></li>
		<li><a href="${basePath}/jspTagAndFunction/jspTagFunction?id=1">自定义JSP标签和函数</a></li>
		<li><a href="${basePath}/jspTagAndFunction/filterHtml">过滤掉html标签</a></li>
		<li><a href="${basePath}/accumulation/vedioPlayer">文件预览（jwplayer播放器，图片，文档）</a></li>
		<li><a href="${basePath}/accumulation/popupwindow">弹出窗口</a></li>
		<li><a href="${basePath}/accumulation/iframeAndFrame">Iframe与Frame</a></li>
		<li><a href="${basePath}/accumulation/selfStyleValidation">页面自定义样式验证</a></li>
		<li><a href="${basePath}/accumulation/struts2Validation">Struts2验证</a></li>
		<li><a href="${basePath}/accumulation/urlParaValidation">url参数验证</a></li>
		<li><a href="${basePath}/accumulation/rmiAccess">跨服务RMI访问</a></li>
		<li><a href="${basePath}/accumulation/webservice?name=张三">跨服务webservice访问</a></li>
	</ol>
</body>
</html>