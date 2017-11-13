<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>" />
<title>Assessment</title>
<script src="plugin/layui/layui.all.js"></script>
<link rel="stylesheet" href="plugin/layui/css/layui.css" />
</head>

<body>
  <div class="layui-container" style="margin-top: 30px;">
    <form id="assessmentDto" class="layui-form" action="assessment/diplay1" method="post">
      <div class="layui-form-item">
        <div class="layui-form-row">
          <h1>${assessment.title}</h1>
        </div>
      </div>
      <c:forEach var="question" items="${assessment.childList}">
        <div class="layui-form-item">
          <div class="layui-form-row">${question.title}</div>
          <div class="layui-input-block">
            <c:forEach var="option" items="${question.childList}">
              <input class="layui-input" type="${option.type}" name="question1" value="${option.value}"
                title="${option.title}" />
            </c:forEach>
          </div>
        </div>
      </c:forEach>
      <div class="layui-input-inline">
        <button id="submit" class="layui-btn" lay-submit>Submit</button>
        <button type="reset" class="layui-btn">Reset</button>
      </div>
    </form>
  </div>
</body>

<script src="plugin/jquery/jquery-1.7.2.js"></script>
<script>
	layui.use('form', function(){
	  var form = layui.form;
	  form.render();
	});
</script>

</html>
