<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="assert/layui/css/layui.css">
</head>
<body>
 
学生头像<button type="button" class="layui-btn" id="test1">
  <i class="layui-icon">&#xe67c;</i>上传图片
</button>
<input type="hidden" name="stuImg" id="stuImg">
</body>
<script type="text/javascript" src="assert/layui/layui.js"></script>
<script type="text/javascript">
layui.use(['upload'],function(){
	var upload = layui.upload;
	var $ = layui.$ ;
	upload.render({
		elem:"#test1"
		,
		url:"upload/"
		,
		field:"uploadFile"
		,
		done:function(res){
			$("#stuImg").val(res.data);
		},
		error:function(){
			
		}
	
	});
});



</script>
</html>