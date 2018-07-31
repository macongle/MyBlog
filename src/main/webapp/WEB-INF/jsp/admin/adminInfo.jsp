<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<link href="<%=staticPath%>/css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%=staticPath%>/css/adminStyles.css" />

</head>

<body>	
  <jsp:include page="top.jsp"/>
  <jsp:include page="menuLeft.jsp"/>
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
						<form action="#" role="form" method="post">
								<div class="form-group">
									<label>ID</label>
									<input class="form-control" placeholder="ID"  type="text" readonly="readonly">
								</div>
								<div class="form-group">
									<label>名称</label>
									<input type="text" class="form-control">
								</div>
								<div class="form-group">
									<label>标签</label>
									<input type="text" class="form-control">
								</div>
								<div class="form-group">
									<label>头像</label>
									<input type="file" class="form-control">
								</div>
								<div class="form-group">
									<label>地址</label>
									<input type="text" class="form-control">
								</div>
								<div class="form-group">
									<label>联系方式</label>
									<input type="text" class="form-control">
								</div>
								<button type="submit" class="btn btn-primary">修改信息</button>
								</form>
								</div>
					</div>	
				</div>
			</div>
		</div>
		</div>
			
	</div><!--/.main-->
    <script src="<%=staticPath%>/js/jquery/jquery-3.3.1.min.js" ></script>
    <script src="<%=staticPath%>/js/bootstrap/bootstrap.min.js" ></script>
</body>

</html>
