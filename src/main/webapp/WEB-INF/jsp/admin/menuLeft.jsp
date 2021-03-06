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
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
			<form role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
			</form>
			<ul class="nav menu">
				<li>
					<a href="<%=path%>/admin/adminLogin"><span class="glyphicon glyphicon-dashboard"></span>个人信息</a>
				</li>
				<li class="parent ">
					<a href="#">
						<span class="glyphicon glyphicon-list"></span> 博客信息 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
					</a>
					<ul class="children collapse" id="sub-item-1">
						<li>
							<a class="" href="<%=path%>/blog?pageNow=1">
								<span class="glyphicon glyphicon-share-alt"></span> 博客管理
							</a>
						</li>
						<li>
							<a class="" href="<%=path%>/blog/addBlog">
								<span class="glyphicon glyphicon-share-alt"></span> 添加博客
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#"><span class="glyphicon glyphicon-list-alt"></span>留言信息</a>
				</li>
				<li>
					<a href="#"><span class="glyphicon glyphicon-list-alt"></span>阅读量统计</a>
				</li>
				<li>
					<a href="#"><span class="glyphicon glyphicon-list-alt"></span>访问统计</a>
				</li>
			</ul>
		</div>
    <script src="<%=staticPath%>/js/jquery/jquery-3.3.1.min.js" ></script>
    <script src="<%=staticPath%>/js/bootstrap/bootstrap.min.js" ></script>
    <script>
		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show');
		});
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide');
		});
	</script>	
</body>

</html>
