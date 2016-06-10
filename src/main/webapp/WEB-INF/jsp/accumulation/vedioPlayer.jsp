<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>flash视频播放</title>
<%@include file="/WEB-INF/jsp/commons/common.jsp"%>
<script src="${basePath}/js/jwplayer/jwplayer.js" type="text/javascript"></script>
</head>
<body>
	<div id="playerDiv" src="${basePath}/vedioFile/儿童学英语.mp4"></div>
<script type="text/javascript">
	$(function(){
		//初始化一个视频 播放器(start)
		var data = {};
		data.url =$("#playerDiv").attr("src");
		flash_video_player($("#playerDiv"),data,null);
		//初始化一个视频 播放器(end)
	});

	/**
	 * 实例化一个视频播放器对象
	 * @param $target
	 * @param data
	 * @param options
	 */
	function flash_video_player($target,data,options){
		var opts = $.extend({},options);
		thePlayer = jwplayer($target.attr("id")).setup({  
	      flashplayer: basePath+'/js/jwplayer/jwplayer.flash.swf',  
	      file: data.url,  
	      width: opts.width||500,  
	      height: opts.height||400,
	      dock: false,
	      frontcolor:"#FFFF33",
	      backcolor:"#FFFF33",
	      lightcolor:"#FFFF33"
	  });
	}
</script>
</body>
</html>