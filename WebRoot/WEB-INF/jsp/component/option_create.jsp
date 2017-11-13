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
<link rel="stylesheet" href="plugin/layui/css/layui.css">
</head>

<body>
  <div class="layui-container" style="margin-top: 30px;">
    <form id="optionDto" class="layui-form" action="option/create" method="post">
      <div class="layui-form-item">
        <label class="layui-form-label">Question ID:</label>
        <div class="layui-input-block">
          <input type="text" name="parent.componentId" value="${parentId}" class="layui-input" />
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">Type:</label>
        <div class="layui-input-block">
          <input type="radio" name="type" value="radio" title="radio" />
          <input type="radio" name="type" value="checkbox" title="checkbox" />
          <input type="radio" name="type" value="textarea" title="textarea" />
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">Title:</label>
        <div class="layui-input-block">
          <input type="text" name="title" required lay-verify="required" placeholder="Option Title" autocomplete="off"
            class="layui-input" />
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">Value:</label>
        <div class="layui-input-block">
          <input type="text" name="value" required lay-verify="required" placeholder="Option Value" autocomplete="off"
            class="layui-input" />
        </div>
      </div>
    </form>
  </div>
</body>

<script src="plugin/layui/layui.all.js"></script>

</html>
