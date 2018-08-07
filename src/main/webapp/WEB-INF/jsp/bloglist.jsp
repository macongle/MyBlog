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
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="<%=staticPath%>/css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="<%=staticPath%>/css/bootstrap/mystyle.css" />
<title></title>
</head>
<body>
	<jsp:include page="top.jsp" />
	<div class="container">
		<div class="row">
			<!-- 博客列表 -->
			<div class="col-lg-8">

				<div class="row">
					<div class="panel panel-orange">
						<div class="panel-body">
							<form class="form-horizontal">
								<div class="form-group">
									<label class="control-label sr-only">按条件排序</label>
									<div class="col-lg-3">
										<select class="form-control" id="conditionSearch">
											<option>阅读量</option>
											<option>时间</option>
											<option>作者</option>
											<option>分类</option>
										</select>
									</div>
								</div>
							</form>
							<table class="table table-hover">
								<c:forEach items="${requestScope.blogListByReadcount}"
									var="blog">
									<tr>
										<td><a class="blogTitle" href="#">${blog.title}</a> <span
											class="pull-right"> <span
												class="glyphicon glyphicon-user color-orange"></span><span>${blog.author}</span>
												<span class="glyphicon glyphicon-time color-orange"></span><span>${blog.createtime}</span>
												<span class="glyphicon glyphicon-eye-open color-orange"></span><span>${blog.readcount}</span>
										</span></td>
									</tr>
								</c:forEach>
							</table>							
						    <c:if test="${pageNow > 1}">
								<a href="<%=path %>/main/blogList?pageNow=${pageNow-1}" id="up">上一页</a>
							</c:if>
							<c:forEach begin="1" end="${pageCount}" varStatus="page">
								<a href="<%=path %>/main/blogList?pageNow=${page.index}"
									class="yema">${page.index}</a>
							</c:forEach>
							<c:if test="${pageNow < pageCount}">
								<a href="<%=path %>/main/blogList?pageNow=${pageNow+1}"
									id="down">下一页</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
			<!-- 组件复用 -->
			<div class="col-lg-3" style="margin-left: 30px;">
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3>文章分类</h3>
							<div class="row">
								<table class="table table-hover">
									<tr>
										<td><a href="#" class="blogTitle"><span
												class="glyphicon glyphicon-menu-right"></span> Java(3)</a></td>
									</tr>
									<tr>
										<td><a href="#" class="blogTitle"><span
												class="glyphicon glyphicon-menu-right"></span> Spring(5)</a></td>
									</tr>
									<tr>
										<td><a href="#" class="blogTitle"><span
												class="glyphicon glyphicon-menu-right"></span> MyBatis(4)</a></td>
									</tr>
									<tr>
										<td><a href="#" class="blogTitle"><span
												class="glyphicon glyphicon-menu-right"></span> JDBC(2)</a></td>
									</tr>
									<tr>
										<td><a href="#" class="blogTitle"><span
												class="glyphicon glyphicon-menu-right"></span> Linux(3)</a></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="foot.jsp" />

</body>
<script type="text/javascript"
	src="<%=staticPath%>/js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="<%=staticPath%>/js/bootstrap/bootstrap.min.js"></script>

</html>
