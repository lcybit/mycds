<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>" />
<title>MyCDS</title>
<link rel="stylesheet" href="plugin/layui/css/layui.css">
</head>

<body>
  <div class="layui-container" style="margin-top: 30px;">
    <div class="layui-input-inline">
      <button class="layui-btn">Home</button>
      <button class="layui-btn" onclick="goList()">CRC Assessment</button>
    </div>
  </div>
  <script src="plugin/jquery/jquery-1.7.2.js"></script>
  <script src="plugin/layui/layui.all.js"></script>
  <script>
    function goList() {
      window.location.href = "html/assessment/questionnaire/list.html";
    }
  </script>
</body>
</html>
