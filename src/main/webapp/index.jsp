<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Insert title here</title>
<!-- 引入layui样式 -->
 <link rel="stylesheet" href="assert/layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="role_form">
  <div class="layui-form-item">
    <label class="layui-form-label">角色名称</label>
    <div class="layui-input-block">
      <input type="text" name="roleName" required  lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
    </div>
    
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">角色编号</label>
    <div class="layui-input-block">
      <input type="text" name="roleCode" required  lay-verify="required|checkRoleCode" placeholder="请输入编号" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <!-- <div class="layui-form-item">
    <label class="layui-form-label">复选框</label>
    <div class="layui-input-block">
      <input type="checkbox" name="like[write]" title="写作">
      <input type="checkbox" name="like[read]" title="阅读" checked>
      <input type="checkbox" name="like[dai]" title="发呆">
    </div>
  </div> -->
<!--   <div class="layui-form-item">
    <label class="layui-form-label">开关</label>
    <div class="layui-input-block">
      <input type="checkbox" name="switch" lay-skin="switch">
    </div>
  </div> -->
  <div class="layui-form-item">
    <label class="layui-form-label">角色等级</label>
    <div class="layui-input-block">
      <select name="roleKind" lay-verify="required">
        <option value="1">一级</option>
        <option value="2">二级</option>
        <option value="3">三级</option>
        <option value="4">四级</option>
        <option value="5">特级</option>
      </select>
    </div>
 <!--  <div class="layui-form-item">
    <label class="layui-form-label">单选框</label>
    <div class="layui-input-block">
      <input type="radio" name="sex" value="男" title="男">
      <input type="radio" name="sex" value="女" title="女" checked>
    </div>
  </div> -->
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">角色简介</label>
    <div class="layui-input-block">
      <textarea name="roleInfo" placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>

</body>
<script type="text/javascript" src="assert/layui/layui.js"></script>
<script type="text/javascript">
layui.use(['layer','form'],function(){
	var layer = layui.layer;
	var form = layui.form;
	var $ = layui.$;
/* 	laydate.rendar({
		elem:"#birthday"(指定渲染的元素)
	});
	 */
	 //表单的自定义校检
           
	 form.verify({
		 checkRoleCode:function(value,item){
			 var msg ;
			 $.ajax({
				 type:"get",
				 async:false,//为了做唯一性校验，需要将ajax的异步请求关闭
				 url:'role/checkRoleCode',
				 data:{"roleCode":value},
				 success:function(result){
					 if(result==0){
						 msg="此编号已经被使用";
					 }
				 }
			 });
			 //如果赋值了，则不能使用，如果为空则校验成功
			 return msg ;
		 }
	 });
	 
	 
	 form.on("submit(formDemo)",function(data){
		 //使用表单序列化
		 var formData = $(data.form).serialize();
		 $.ajax({
			 type:"post",
			 url:"role",
			 data:formData,
			 success:function(result){
				 if(result){
					 layer.msg("角色新增成功");
				 }
				 
			 }
		 });
		 //将按钮自带的提交动作屏蔽掉
		 return false ;
	 });
	 
});
</script>
</html>
	

