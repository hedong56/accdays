<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Iframe与Frame</title>
<%@include file="/WEB-INF/jsp/commons/common.jsp"%>
</head>
<body>
	<iframe src="${basePath}/accumulation/pointLists" id="points"></iframe>
	<script type="text/javascript">
		var iframeWin=$("#points").get(0).contentWindow;
		iframeWin.onload=function(){
			var inhtml=iframeWin.document.body.innerHTML;
			alert(inhtml);
		};
	</script>
</body>
</html>