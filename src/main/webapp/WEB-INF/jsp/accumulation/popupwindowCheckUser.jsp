<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!-- iframe的弹出部分 -->
<head>
</head>
<body>
	<c:forEach var="i" begin="1" end="10">
		<input type="checkbox" id="${i}"><span>张三——${i}</span><br>
	</c:forEach>
	<script type="text/javascript">
		function test(){
			alert("testwe");
		}
	</script>
</body>
