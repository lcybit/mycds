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
<title>Create Assessment</title>
<link rel="stylesheet" href="plugin/layui/css/layui.css" />
</head>

<body>
  <div class="layui-container" style="margin-top: 30px;">
    <form id="assessmentDto" class="layui-form" action="assessment/create" method="post">
      <div class="layui-form-item">
        <label class="layui-form-label">Theme:</label>
        <div class="layui-input-block">
          <input type="text" name="theme" required lay-verify="required" placeholder="AN UNIQUE word"
            autocomplete="off" class="layui-input" />
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">Title:</label>
        <div class="layui-input-block">
          <input type="text" name="title" required lay-verify="required" placeholder="Assessment Title"
            autocomplete="off" class="layui-input" />
        </div>
      </div>
    </form>
  </div>
<script src="plugin/layui/layui.all.js"></script>
</body>

</html>
