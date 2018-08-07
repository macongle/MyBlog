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
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="<%=staticPath%>css/bootstrap/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=staticPath%>css/bootstrap/mystyle.css" />
		<title></title>
	</head>
	<body>
		<div class="container-fluid footer-content  text-center" style="background-color: #555555;">
			<div class="row">
						<ul class="list-group list-inline footer-ul">
							<li ><a href="#">我的GitHub</a></li>
						</ul>
			</div>
			<hr class="bg-danger" />
			<div class="row">
				<div class="col-lg-5">
						<p>
							<address>
  									${sessionScope.admin.adress}<br>
									联系方式: ${sessionScope.admin.phone}
							</address>
						</p>
				</div>
				<div class="col-lg-2">
					<div class="line-cz"></div>
				</div>
				<div class="col-lg-5">
						<p>
							<address>
  							<strong>${sessionScope.admin.name}</strong><br>
  							<a href="mailto:#">${sessionScope.admin.email}</a>
							</address>
						</p>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="<%=staticPath%>js/jquery/jquery-3.3.1.min.js" ></script>
	<script type="text/javascript" src="<%=staticPath%>js/bootstrap/bootstrap.min.js" ></script>
</html>
