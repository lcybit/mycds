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
<title>Create</title>
<script src="plugin/layui/layui.all.js"></script>
<link rel="stylesheet" href="plugin/layui/css/layui.css" />
</head>

<body>
  <div class="layui-container" style="margin-top: 30px;">
    <form id="questionDto" class="layui-form" action="question/create" method="post">
      <div class="layui-form-item">
        <label class="layui-form-label">Assessment ID:</label>
        <div class="layui-input-block">
          <input type="text" name="parent.componentId" value="${parentId}" class="layui-input" />
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">Title:</label>
        <div class="layui-input-block">
          <input type="text" name="title" required lay-verify="required" placeholder="Question Title"
            autocomplete="off" class="layui-input" />
        </div>
      </div>
    </form>
  </div>
</body>

</html>
