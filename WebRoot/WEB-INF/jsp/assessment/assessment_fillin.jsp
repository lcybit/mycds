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
<title>Assessment</title>
<script src="plugin/jquery/jquery-1.7.2.js"></script>
<link rel="stylesheet" href="plugin/layui/css/layui.css" />
</head>

<body>
  <div class="layui-container" style="margin-top: 30px;">
    <form id="form" class="layui-form" action="assessment/display1" method="post">
      <div class="layui-form-item">
        <div class="layui-form-row">1. How many of your first-degree relatives have colorectal cancer?</div>
        <div class="layui-input-inline">
          <input type="text" name="familyHistory" class="layui-input"/>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-form-row">2. Did you have inflammatory bowel disease?</div>
        <div class="layui-input-inline">
          <input type="radio" name="inflammatoryBowelDisease" value="1" title="Yes" />
          <input type="radio" name="inflammatoryBowelDisease" value="0" title="No" />
          <input type="radio" name="inflammatoryBowelDisease" value="0" title="I don't know" />
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-form-row">3. Do you have diabetes?</div>
        <div class="layui-input-inline">
          <input type="radio" name="diabetes" value="1" title="Yes" />
          <input type="radio" name="diabetes" value="0" title="No" />
          <input type="radio" name="diabetes" value="0" title="I don't know" />
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-form-row">4. What is your alcohol consumption on daily average?</div>
        <div class="layui-input-inline">
          <input type="radio" name="alcoholConsumption" value="0" title="&#60;2 drinks" />
          <input type="radio" name="alcoholConsumption" value="1" title="2-3 drinks" />
          <input type="radio" name="alcoholConsumption" value="2" title="&#62;3 drinks" />
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-form-row">5. Do you have obesity?</div>
        <div class="layui-input-inline">
          <input type="radio" name="obesity" value="1" title="Yes" />
          <input type="radio" name="obesity" value="0" title="No" />
          <input type="radio" name="obesity" value="0" title="I don't know" />
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-form-row">6. What is your red meat consumption per day?</div>
        <div class="layui-input-inline">
          <input type="radio" name="redMeatConsumption" value="0" title="&#60;100g" />
          <input type="radio" name="redMeatConsumption" value="1" title="&ge;100g" />
          <input type="radio" name="redMeatConsumption" value="0" title="I don't know" />
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-form-row">7. What is your processed meat consumption per day?</div>
        <div class="layui-input-inline">
          <input type="radio" name="processedMeatConsumption" value="0" title="&#60;50g" />
          <input type="radio" name="processedMeatConsumption" value="1" title="&ge;50g" />
          <input type="radio" name="processedMeatConsumption" value="0" title="I don't know" />
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-form-row">8. Do you smoke?</div>
        <div class="layui-input-inline">
          <input type="radio" name="smoking" value="1" title="Yes" />
          <input type="radio" name="smoking" value="0" title="No" />
          <input type="radio" name="smoking" value="0" title="I don't know" />
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-form-row">9. Do you do physical activities about colon?</div>
        <div class="layui-input-inline">
          <input type="radio" name="physicalActivity" value="1" title="Yes" />
          <input type="radio" name="physicalActivity" value="0" title="No" />
          <input type="radio" name="physicalActivity" value="0" title="I don't know" />
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-form-row">10. What is your dairy consumption per day?</div>
        <div class="layui-input-inline">
          <input type="radio" name="dairyConsumption" value="1" title="&#60;400g" />
          <input type="radio" name="dairyConsumption" value="0" title="&ge;400g" />
          <input type="radio" name="dairyConsumption" value="0" title="I don't know" />
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-form-row">11. What is your milk consumption per day?</div>
        <div class="layui-input-inline">
          <input type="radio" name="milkConsumption" value="1" title="&#60;200g" />
          <input type="radio" name="milkConsumption" value="0" title="&ge;200g" />
          <input type="radio" name="milkConsumption" value="0" title="I don't know" />
        </div>
      </div>
      <div class="layui-input-inline">
        <button id="submit" class="layui-btn layui-bg-blue" lay-submit>Submit</button>
        <button type="reset" class="layui-btn layui-btn-primary">Reset</button>
      </div>
    </form>
  </div>
  <div>
    <p id="conclusion"></p>
  </div>
</body>

<script src="plugin/layui/layui.all.js"></script>

<script>
/* layui.use('form', function() {
	var form = layui.form;
	form.on('submit(assessmentSubmit)', function(data) {
		$("#form").hide();
		$("#conclusion").append("${conclusion}");
	});
}); */
/* $(document).ready(function(){
	$("#submit").click(function(){
		$("#form").hide();
		$("#conclusion").append("${conclusion}");
		return false;
	});
}); */
</script>

</html>
