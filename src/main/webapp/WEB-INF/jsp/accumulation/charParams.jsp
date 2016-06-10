<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>字符串拼接方式传递参数</title>
<%@include file="/WEB-INF/jsp/commons/common.jsp"%>
<script type="text/javascript" src="${basePath}/js/accumulation/charParams.js"></script>
<style type="text/css">
	.roundCorderC{
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
		left: 765px;
	}
</style>
</head>
<body>
	<form>
		<ul id="icons" class="ui-widget ui-helper-clearfix">
	       <li class="ui-state-default ui-corner-all hd_position" title="添加" onclick="addPersonInfo()"><span class="ui-icon ui-icon-circle-plus"></span></li>
	    </ul>
	  <fieldset class="roundCorderC">
	    <legend>用户信息</legend>
		    <ul id="icons" class="ui-widget ui-helper-clearfix">
		       <li class="ui-state-default ui-corner-all" title="删除" style="position: relative;	left: 156px;" onclick="delePersonInfo(this)"><span class="ui-icon ui-icon-trash"></span></li>
		    </ul>
	                姓名：<input type="text" name="userName"/>
	                性别：<input type="radio" name="sex" id="man"><label for="man">男</label>&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" id="woman"><label for="woman">女</label><br>
		    身高：<input type="text" name="height"/>
		    体重：<input type="text" name="weight"/>
	  </fieldset>
	</form>
</body>
</html>