<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>动态加载内容</title>
<%@include file="/WEB-INF/jsp/commons/common.jsp"%>
<script type="text/javascript" src="${basePath}/js/accumulation/dynamicLading.js"></script>
<style type="text/css">
	#roundCorderC{
		font-family: Arial;
		-moz-border-radius: 5px;
		-webkit-border-radius: 5px;
		padding: 1px 1px;
		height: inherit;
		border-color:green;
		width: 202px;
		margin:auto;
	}
	body{
		font: 62.5% "Trebuchet MS", sans-serif;
		margin: 50px;
	}
	
	#dialog-link span.ui-icon {
		margin: 0 5px 0 0;
		position: absolute;
		left: .2em;
		top: 50%;
		margin-top: -8px;
	}
	#icons {
		margin: 0;
		padding: 0;
	}
	#icons li {
		margin: 2px;
		position: relative;
		padding: 4px 0;
		cursor: pointer;
		float: left;
		list-style: none;
	}
	#icons span.ui-icon {
		float: left;
		margin: 0 4px;
	}
	.hd_position{
		position: relative;
		left: 156px;
	}
	#back {
	position: fixed;
	left: 1115px;
	top: 360px;
	}
</style>
</head>
<body>
	<form>
	  <fieldset id="roundCorderC">
	    <legend>用户信息</legend>
		    <ul id="icons" class="ui-widget ui-helper-clearfix">
		     <li class="ui-state-default ui-corner-all hd_position" title="添加" onclick="addInfo()"><span class="ui-icon ui-icon-circle-plus"></span></li>
		    </ul>
	                姓名：<input type="text" class="name"/>
		    身高：<input type="text" />
		    体重：<input type="text" value="1" class="weight"/>
	  </fieldset>
	</form>
	<input type="button" value="back" id="back" onclick="backTop()">
</body>
</html>