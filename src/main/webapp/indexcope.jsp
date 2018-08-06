<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="jsp/css/bootstrap/bootstrap.min.css" />
		<link rel="stylesheet" href="jsp/css/bootstrap/mystyle.css" />
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
					<c:forEach items="${requestScope.blogs}" var="blog">
					<div class="row">
						<div class="panel panel-orange">
							<div class="panel-heading">
								<div class="text-center">
									<h3 class="color-gray"><a href="#" class="blogTitle">${blog.title}</a></h3>
									<h5>
									<span class="glyphicon glyphicon-user color-orange"></span><span>${blog.author}</span>
									<span class="glyphicon glyphicon-time color-orange"></span><span>${blog.createTime}</span>
									<span class="glyphicon glyphicon-eye-open color-orange"></span><span>${blog.readCount}</span>
								</h5>
								</div>
							</div>
							<div class="panel-body">
								<div class="content col-lg-10 col-lg-offset-1">
									<div class="row">
									<img src="img/pier-407252_1920.jpg" class="img-responsive center-block img-thumbnail" />
									</div>
									<div class="content-text row">
									<p>${blog.content}</p>
									</div>
								</div>
								<div>
									<button class="btn btn-default pull-right love"><span class="glyphicon glyphicon-heart love-icon"></span> 喜欢</button>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
					<div class="row">
						<div class="panel panel-orange">
							<div class="panel-heading">
								<div class="text-center">
									<h3 class="color-gray"><a href="#" class="blogTitle">博客标题1</a></h3>
									<h5>
									<span class="glyphicon glyphicon-user color-orange"></span><span>王大可</span>
									<span class="glyphicon glyphicon-time color-orange"></span><span>2018年7月6日</span>
									<span class="glyphicon glyphicon-eye-open color-orange"></span><span>100</span>
								</h5>
								</div>
							</div>
							<div class="panel-body">
								<div class="content col-lg-10 col-lg-offset-1">
									<div class="row">
									<img src="jsp/img/pier-407252_1920.jpg" class="img-responsive center-block img-thumbnail" />
									</div>
									<div class="content-text row">
									<p>博客最初的名称是Weblog，由web和log两个单词组成，按字面意思就为网络日记，后来喜欢新名词的人把这个词的发音故意改了一下，读成we blog， 由此，blog这个词被创造出来。中文意思即网志或网络日志，不过，在中国大陆有人往往也将Blog本身和blogger（即博客作者）均音译为“博客”。 “博客”有较深的涵义：“博”为“广博”；“客”不单是“blogger”更有“好客”之意。看Blog的人都是“客”。而在台湾，则分别音译成“部落格”（或“部落阁”）及“部落客”， 认为Blog本身有社群群组的意含在内，借由Blog可以将网络上网友集结成一个大博客，成为另一个具有影响力的自由媒体。
									</p>
									</div>
								</div>
								<div>
									<button class="btn btn-default pull-right love"><span class="glyphicon glyphicon-heart love-icon"></span> 喜欢</button>
								</div>
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
								<img src="jsp/img/man.jpg" class="img-circle col-lg-5 col-lg-offset-3"/>
								</div>
	<!-- 调用admin数据库 -->
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
					<div class="row">
						<div class="panel panel-default">
							<div class="panel-body">
									<h3>热门文章</h3>
									<div class="row">
										<table class="table table-hover">
											<tr>
												<td><a href="#" class="blogTitle"><span class="glyphicon glyphicon-menu-right"></span>  博客标题1</a></td>
											</tr>
											<tr>
												<td><a href="#" class="blogTitle"><span class="glyphicon glyphicon-menu-right"></span>  博客标题1</a></td>
											</tr>
											<tr>
												<td><a href="#" class="blogTitle"><span class="glyphicon glyphicon-menu-right"></span>  博客标题1</a></td>
											</tr>
											<tr>
												<td><a href="#" class="blogTitle"><span class="glyphicon glyphicon-menu-right"></span>  博客标题1</a></td>
											</tr>
											<tr>
												<td><a href="#" class="blogTitle"><span class="glyphicon glyphicon-menu-right"></span>  博客标题1</a></td>
											</tr>
										</table>
									</div>
									<a class="pull-right" href="#">>>更多</a>
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