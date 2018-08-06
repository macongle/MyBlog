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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tables</title>

<link href="<%=staticPath%>/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="<%=staticPath%>/css/adminStyles.css" />

</head>

<body>
	<jsp:include page="top.jsp" />
	<jsp:include page="menuLeft.jsp" />
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">个人信息</li>
			</ol>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">个人信息</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">修改信息</div>
					<div class="panel-body">
						<div class="col-md-6 col-md-offset-2">
							<form action="<%=path%>/admin/updateAdmin" role="form"
								method="post" enctype="multipart/form-data">

								<!-- 显示头像 -->
								<div class="row">
									<img alt="" src="<%=path%>${sessionScope.admin.img}"
										class="img-circle col-md-3 col-md-offset-5">
								</div>
								<div class="form-group">
									<label>ID</label> <input class="form-control" name="amId"
										placeholder="ID" value="${sessionScope.admin.amId}"
										type="text" readonly="readonly">
								</div>
								<div class="form-group">
									<label>名称</label> <input type="text" name="name"
										value="${sessionScope.admin.name}" class="form-control">
								</div>


								<div class="form-group">
									<label>标签</label>
									<c:forTokens items="${sessionScope.admin.tag}" delims=","
										var="t">
										<label class="checkbox-inline"> <input type="checkbox"
											name="tag" value="${t}" checked="checked"> ${t}
										</label>
									</c:forTokens>
								</div>

								<div class="form-group">
									<label>头像</label> <input type="file"
										value="${sessionScope.img}" name="imgFile"
										class="form-control">
								</div>

								<div class="form-group">
									<label>地址</label> <input type="text" name="adress"
										value="${sessionScope.admin.adress}" class="form-control">
								</div>
								<div class="form-group">
									<label>邮箱</label> <input type="text" name="email"
										class="form-control" value="${sessionScope.admin.email}">
								</div>
								<div class="form-group">
									<label>密码</label> <input type="password" name="pass"
										class="form-control" value="${sessionScope.admin.pass}">
								</div>
								<div class="form-group">
									<label>联系方式</label> <input type="text" name="phone"
										value="${sessionScope.admin.phone}" class="form-control">
								</div>
								<button type="submit" class="btn btn-primary">修改信息</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	</div>
	<!--/.main-->
	<script src="<%=staticPath%>/js/jquery/jquery-3.3.1.min.js"></script>
	<script src="<%=staticPath%>/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript">
		window.onload = function() {
			var msg = '${msg}';
			if (msg != null && msg != "" && msg != undefined) {
				alert(msg);
			}
		}
	</script>
</body>

</html>
