<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String staticPath = path+"/static";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Tables</title>
		<link href="<%=staticPath%>/css/bootstrap/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=staticPath%>/css/adminStyles.css" />
		<style>
			#editor {
				overflow: scroll;
				max-height: 500px;
			}
		</style>

	</head>

	<body>
		<jsp:include page="top.jsp"/>
		<jsp:include page="menuLeft.jsp"/>
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
			<div class="row">
				<ol class="breadcrumb">
					<li>
						<a href="#"><span class="glyphicon glyphicon-home"></span></a>
					</li>
					<li class="active">编辑博文</li>
				</ol>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">编辑博文</h1>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">编辑博文</div>
						<div class="panel-body">
						<form action="<%=path%>/blog/editBlog" method="post" role="form">
						<input type="hidden" class="form-control"
										name="bId" value="${requestScope.blog.bId}">
							<div class="form-group">
									<label>标题</label> <input type="text" class="form-control"
										name="title" value="${requestScope.blog.title}">
							</div>
							<div class="form-group">
									<label>作者</label> <input type="text" class="form-control"
										name="author" value="${requestScope.blog.author}">
							</div>
							<div id="editor"></div>
							<div class="form-group">
									<textarea id="text1" class="form-control" name="content" style="display: none"></textarea>
							</div>
							<button type="submit" class="btn btn-primary">提交修改</button>
						</form>
						</div>
						
					</div>
				</div>
			</div>
		</div>

		
		<!--/.main-->
		<script src="<%=staticPath%>/js/jquery/jquery-3.3.1.min.js"></script>
		<script src="<%=staticPath%>/js/bootstrap/bootstrap.min.js"></script>
		<script src="<%=staticPath%>/js/wangEditor.min.js"></script>
		<script>
		var E = window.wangEditor;
		var editor = new E('#editor');
		var $text1 = $('#text1');
		editor.customConfig.uploadImgServer = '<%=path%>/blog/imgUpload';
		editor.customConfig.uploadFileName = 'img';
		editor.customConfig.onchange = function (html) {
            $text1.val(html);
        };
		editor.create();
		$text1.val(editor.txt.html());
		
		window.onload = function(){
			var str = '${requestScope.blog.content}';
			editor.txt.html(str);
		}
		</script>
	</body>

</html>