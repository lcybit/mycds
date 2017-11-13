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
<title>Assessment List</title>
<script src="plugin/jquery/jquery-1.7.2.js"></script>
<link rel="stylesheet" href="plugin/layui/css/layui.css"/>
</head>
<body>
  <div class="layui-container">
    <table class="layui-table">
      <thead>
        <tr>
          <th>Assessment ID</th>
          <th>Theme</th>
          <th>Title</th>
          <th>Style</th>
          <th>Status</th>
          <th>Operation</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="assessment" items="${assessmentList}">
          <tr>
            <td>${assessment.assessmentId}</td>
            <td>${assessment.theme}</td>
            <td>${assessment.title}</td>
            <td>${assessment.style}</td>
            <td>${assessment.status}</td>
            <td>
              <button class="layui-btn" onclick="goFill('${assessment.assessmentId}')">Fill</button>
              <button class="layui-btn" onclick="goEdit('${assessment.assessmentId}')">Edit</button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div class="layui-input-inline">
        <button class="layui-btn" onclick="goBack()">Back</button>
        <button class="layui-btn" onclick="goAdd()">Add</button>
      </div>
  </div>
</body>

<script src="plugin/layui/layui.all.js"></script>
<script>

	$(document).ready(function(){
	})

	function goAdd() {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.open({
				type: 2,
				id: 'create',
				title: 'New Assessment',
				content: 'assessment/goCreate',
				area: ['700px', '500px'],
				shade: 0.5,
				btn: ['OK','Cancel'],
				btnAlign: 'c',
				closeBtn: false,
				yes: function(index, layero){
					var body = layer.getChildFrame('body', index);
					body.find('form#assessmentDto').submit();
					layer.close(index);
					alert(JSON.stringify(assessmentDto));
				}
			})
		}); 
	}
  
	function goBack() {
		window.location.href = "assessment/goBack";
	}
  
	function goEdit(id) {
		window.location.href = "question/goList?parentId=" + id;
	}

	function goFill(id) {
		window.location.href = "assessment/goFill?assessmentId=" + id;
	}
  
</script>
</html>
