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
<title>Option List</title>
<script src="plugin/jquery/jquery-1.7.2.js"></script>
<link rel="stylesheet" href="plugin/layui/css/layui.css"/>
</head>
<body>
  <div class="layui-container">
    <div class="layui-form-item">
      <label class="layui-form-label">Question ID:</label>
      <div class="layui-input-block">
        <input type="text" name="parentId" value="${parentId}" class="layui-input" />
      </div>
    </div>
    <table class="layui-table">
      <thead>
        <tr>
          <th>Option ID</th>
          <th>Type</th>
          <th>Title</th>
          <th>Value</th>
          <th>Status</th>
          <th>Operation</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="option" items="${optionList}">
          <tr>
            <td>${option.optionId}</td>
            <td>${option.type}</td>
            <td>${option.title}</td>
            <td>${option.value}</td>
            <td>${option.status}</td>
            <td>
              <button class="layui-btn" onclick="goEdit('${option.optionId}')">Edit</button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div class="layui-input-inline">
        <button class="layui-btn" onclick="goBack('${parentId}')">Back</button>
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
				title: 'New Option',
				content: 'option/goCreate?parentId=' + id,
				area: ['700px', '500px'],
				shade: 0.5,
				btn: ['OK','Cancel'],
				btnAlign: 'c',
				closeBtn: false,
				yes: function(index, layero){
					var body = layer.getChildFrame('body', index);
					body.find("#optionDto").submit();
					layer.close(index);
					location.reload();
				}
			})
		}); 
	}
  
	function goBack(id) {
		window.location.href = "question/goList?parentId=" + id;
	}
  
	function goEdit(id) {
		window.location.href = "option/goList?parentId=" + id;
	}

</script>
</html>
