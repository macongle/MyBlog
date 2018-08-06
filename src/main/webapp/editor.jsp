<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
String path=request.getContextPath();
%>
</head>
<body>

<div id="editor"></div>

<hr>

<textarea id="text" style="width:100%; height:200px; display:none" ></textarea>

<br>
<button id="btn1">获取html</button>
<button id="btn2">获取text</button>

<script type="text/javascript" src="<%=path%>/static/js/jquery/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="<%=path%>/static/js/wangEditor.min.js"></script>
    <script type="text/javascript">
        var E = window.wangEditor;
        var editor = new E('#editor');
        var $text = $('#text');
        editor.customConfig.onchange = function (html) {
            // 监控变化，同步更新到 textarea
            $text.val(html);
        }
        editor.create();
        // 初始化 textarea 的值
        $text.val(editor.txt.html());
        
        document.getElementById('btn1').addEventListener('click', function () {
            // 读取 html
            alert(editor.txt.html());
        }, false)

        document.getElementById('btn2').addEventListener('click', function () {
            // 读取 text
            alert(editor.txt.text());
        }, false)
    </script>
</body>
</html>