<%@page session="false" %>
<%@include file="/WEB-INF/jsp/commons/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="<c:url value='/static/css/tutorial.css'/>" type="text/css" />
      <title>Logged Out</title>
  </head>
	<body>
		<div id="content">
			<h2>Logged Out</h2>
				<p>
					You have been logged out. <a href="<c:url value='/'/>">Start again</a>.
				</p>
		</div>
	</body>
</html>
