<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="<c:url value='/static/css/tutorial.css'/>" type="text/css" />
      <title>Home Page</title>
      <%@include file="/WEB-INF/jsp/commons/common.jsp"%>
  </head>
	<body>
	<div id="content">
		<h1>Home Page</h1>
		<p>Anyone can view this page.</p>
		<p>
			While anyone can also view the <a href="${basePath}/list/listAccounts">list accounts</a> page, you
			must be authorized to post to an Account from the list accounts page.
		</p>
		<p>
			Your principal object is....:
			<%=request.getUserPrincipal()%>
		</p>
		<sec:authorize url='${basePath}/secure/index.jsp'>
			<p>You can currently access "/secure" URLs.</p>
		</sec:authorize>
		<sec:authorize url='${basePath}/secure/extreme/index.jsp'>
			<p>You can currently access "/secure/extreme" URLs.</p>
		</sec:authorize>

		<p>
			<a href="secure/index.jsp">Secure page</a>
		</p>
		<p>
			<a href="secure/extreme/index.jsp">Extremely secure page</a>
		</p>
	</div>
</body>
</html>
