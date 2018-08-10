<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String staticPath = path + "/static";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="<%=staticPath%>/css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="<%=staticPath%>/css/bootstrap/mystyle.css" />
<title>zanzhu</title>
</head>

<body>
	<jsp:include page="top.jsp" />
    
		<img alt="" src="<%=staticPath%>/img/zz.jsp"> <img alt=""
			src="<%=staticPath%>/img/zfb.jsp">
	<jsp:include page="foot.jsp" />
</body>
<script type="text/javascript"
	src="<%=staticPath%>js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="<%=staticPath%>js/bootstrap/bootstrap.min.js"></script>

</html>