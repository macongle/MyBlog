<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>right</title>
</head>
<body>
	<div class="col-lg-3" style="margin-left: 30px;">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-body">
					<h3>博主</h3>
					<div class="title-line">
						<h4></h4>
					</div>
					<div class="row">
						<img src="<%=staticPath%>/img/man.jpg" class="img-circle col-lg-5 col-lg-offset-3" />
					</div>
					<div class="row text-center">
					<!-- 直接使用${sessionScope.admin.name}查不到结果 -->
						<b>王大可</b><br/> 
						<span class="label label-primary">Java</span>
						<span class="label label-success">Python</span>
						<span class="label label-info">大数据</span>
						<span class="label label-warning">闲置码农</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=staticPath%>/js/jquery/jquery-3.3.1.min.js" ></script>
	<script type="text/javascript" src="<%=staticPath%>/js/bootstrap/bootstrap.min.js" ></script>
</html>