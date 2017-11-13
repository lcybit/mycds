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
<title>Question List</title>
<script src="plugin/jquery/jquery-1.7.2.js"></script>
<link rel="stylesheet" href="plugin/layui/css/layui.css"/>
</head>
<body>
  <div class="layui-container">
    <div class="layui-form-item">
      <label class="layui-form-label">Assessment ID:</label>
      <div class="layui-input-block">
        <input type="text" name="parentId" value="${parentId}" class="layui-input" />
      </div>
    </div>
    <table class="layui-table">
      <thead>
        <tr>
          <th>Question ID</th>
          <th>Title</th>
          <th>Status</th>
          <th>Operation</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="question" items="${questionList}">
          <tr>
            <td>${question.questionId}</td>
            <td>${question.title}</td>
            <td>${question.status}</td>
            <td>
              <button class="layui-btn" onclick="goEdit('${question.questionId}')">Edit</button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div class="layui-input-inline">
        <button class="layui-btn" onclick="goBack()">Back</button>
        <button class="layui-btn" onclick="goAdd('${parentId}')">Add</button>
      </div>
  </div>
</body>

<script src="plugin/layui/layui.all.js"></script>
<script>

	$(document).ready(function(){
	})

	function goAdd(id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.open({
				type: 2,
				id: 'create',
				title: 'New Question',
				content: 'question/goCreate?parentId=' + id,
				area: ['700px', '500px'],
				shade: 0.5,
				btn: ['OK','Cancel'],
				btnAlign: 'c',
				closeBtn: false,
				yes: function(index, layero){
					var body = layer.getChildFrame('body', index);
					body.find("#questionDto").submit();
					layer.close(index);
					location.reload();
				}
			})
		}); 
	}
  
	function goBack() {
		window.location.href = "assessment/goList";
	}
  
	function goEdit(id) {
		window.location.href = "option/goList?parentId=" + id;
	}

</script>
</html>
