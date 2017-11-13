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
		<base href="<%=basePath%>">
		<title>Display Result</title>
		<link rel="stylesheet" href="plugin/layui/css/layui.css">
	</head>
	<body>
		<button id="convert" class="layui-btn layui-bg-green" onclick="convert()">Convert</button>
		<div id="riskChart" style="width: 100%;height:100%;"></div>
	</body>
	<script src="plugin/layui/layui.all.js"></script>
	<script src="plugin/echarts/echarts.js"></script>
	<script type="text/javascript">
		var riskChart = echarts.init(document.getElementById('riskChart'));
		var status = "person";
	    function displayByPerson() {
			var option = {
				tooltip: {
					trigger: 'axis',
					axisPointer: {            // 坐标轴指示器，坐标轴触发有效
						type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				legend: {
					data: [
						<c:forEach items="${riskData}" var="risk">
							'${risk.getKey()}',
						</c:forEach>
					]
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				xAxis:  {
					type: 'category',
					data: ['You']
				},
				yAxis: {
					type: 'value'
				},
				series: [
					<c:forEach items="${riskData}" var="risk">
					{
						name: '${risk.getKey()}',
						type: 'bar',
						stack: 'TotalValue',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [${risk.getValue()}]
					},
					</c:forEach>
				]
			};
			riskChart.setOption(option, true);
	    }
	    
	    function displayByRisk() {
			var option = {
				tooltip: {
					trigger: 'axis',
					axisPointer: {            // 坐标轴指示器，坐标轴触发有效
						type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				legend: {
					data: ['You']
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				xAxis:  {
					type: 'category',
					data: [
						<c:forEach items="${riskData}" var="risk">
							'${risk.getKey()}',
						</c:forEach>
					]
				},
				yAxis: {
					type: 'value'
				},
				series: [
					{
						name: 'You',
						type: 'bar',
						stack: 'TotalValue',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [
							<c:forEach items="${riskData}" var="risk">
								${risk.getValue()},
							</c:forEach>
						]
					},
				]
			};
			riskChart.setOption(option, true);
	    }
		
	    function convert() {
			if(status == "person") {
				displayByRisk();
				status = "risk";
			} else if(status == "risk") {
				displayByPerson();
				status = "person";
			}
		}
	    
	    window.onload = function(){
	    	displayByPerson();
	    }
	</script>
</html>
