<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap/mystyle.css" />
		<title>Hello World</title>
	</head>

	<body>
		<!-- 组件复用 -->
		<div class="container-fluid">
			<div class="row topimg">
			</div>
			<div class="row">
				<nav class="navbar navbar-default">
					<div class="container">

						<div class="navbar-header">
							<a class="navbar-brand" href="#">个人博客</a>
						</div>

						<div class="collapse navbar-collapse">
							<!-- 导航栏 -->
							<ul class="nav navbar-nav">
								<li>
									<a href="#" class="aa">博客首页</a>
								</li>
								<li>
									<a href="#" class="aa">博客列表</a>
								</li>
								<li>
									<a href="#" class="aa">给我留言</a>
								</li>
								<li>
									<a href="#" class="aa">赞助作者</a>
								</li>
							</ul>
							<!-- 搜索框 -->
							<form class="navbar-form navbar-right">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Search">
								</div>
								<button type="submit" class="btn btn-warning">搜索</button>
							</form>

						</div>
					</div>
				</nav>
			</div>
		</div>
		<!-- 组件复用 -->
		<div class="container">
			<div class="row">
				<!-- 博客列表 -->
				<div class="col-lg-8">
					
					<div class="row">
						<div class="panel panel-orange">
							<div class="panel-body">
								
								<form class="form-horizontal" action="#" method="post">
									<div class="form-group col-lg-5">
										<label class="control-label">姓名：</label><br />
										<input type="input" class="form-control" placeholder="您的姓名" required="required" />
									</div>
									<div class="form-group col-lg-12">
										<label class="control-label">留言：</label><br />
										<textarea class="form-control" rows="4" required="required"></textarea>
									</div>
									<div class="form-group col-lg-5">
										<label class="control-label">若方便，请留下您的联系方式：</label>
										<input type="email" class="form-control" placeholder="您的邮箱" />
										<br />
										<input type="input" class="form-control" placeholder="您的联系方式" />
										
									</div>
									<div class="form-group col-lg-12">
										<button type="submit" class="btn btn-warning">提交</button>
									</div>
									
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- 组件复用 -->
				<div class="col-lg-3" style="margin-left: 30px;">
					<div class="row">
						<div class="panel panel-default">
							<div class="panel-body">
									<h3>博主</h3>
									<div class="title-line">
										<h4></h4>
									</div>
									<div class="row">
								<img src="img/man.jpg" class="img-circle col-lg-5 col-lg-offset-3"/>
								</div>
								<div class="row text-center">
								<b>王大可</b><br />
								<span class="label label-primary">Java</span>
								<span class="label label-success">Python</span>
								<span class="label label-info">大数据</span>
								<span class="label label-warning">闲置码农</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 组件复用 -->
			</div>
		</div>
		
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
  									河南省郑州市中牟县<br>
  									郑州工商学院<br>
									联系方式: (123) 456-7890
							</address>
						</p>
				</div>
				<div class="col-lg-2">
					<div class="line-cz"></div>
				</div>
				<div class="col-lg-5">
						<p>
							<address>
  							<strong>王大可</strong><br>
  							<a href="mailto:#">dake_wang@example.com</a>
							</address>
						</p>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery/jquery-3.3.1.min.js" ></script>
	<script type="text/javascript" src="js/bootstrap/bootstrap.min.js" ></script>
	<script>
		$(function(){
			$(".love").click(function(){
				$(this).children(".love-icon").toggleClass("color-red");
			});
		});
	</script>
</html>