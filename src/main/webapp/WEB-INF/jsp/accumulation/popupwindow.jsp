<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>知识点列表</title>
<%@include file="/WEB-INF/jsp/commons/common.jsp"%>
<script type="text/javascript" src="${basePath}/js/accumulation/hdPlugs_1.js"></script>
</head>
<body>
<input type="button" onclick="checkUser()" value="选择用户">
<script type="text/javascript">
var $iframe;
function checkUser(){
	$iframe=$.hdPlugs.popupWin({
		src:basePath+"/accumulation/popupwindowCheckUser",
		dialogConfig:{
			title:"选择用户",
			buttonAlign:"center",
			buttons:{
				确定: sureCloseIframe,
				取消: function() {
					$(this).dialog('close');
				}
		    }
		}
		
	});
}

function sureCloseIframe(){
	alert($dialog.html());
	//可以操作子页面的DOM，但不能调用子页面的方法
	var iframeCon=$("#dialog-message-iframe").contents().find("#3");
	//既可以操作子页面的DOM，又调用子页面的方法
	var iframeWin = document.getElementById("dialog-message-iframe").contentWindow;
	$(iframeWin.document).find("#3")
	//调用子页面的方法
//	iframeDom.test();
	var checkedName=$("#dialog-message-iframe").contents().find("input:checked").next().text();
	var checkedName2=$dialog.find("input:checked").next().text();
	alert(checkedName2);
	
	$(this).dialog('close');
}
</script>
</body>
</html>