<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<jsp:include page="/base.jsp"></jsp:include>
<form class="layui-form" lay-filter="form_add_edit">
  <div class="layui-form-item">
    <label class="layui-form-label">用户名称</label>
    <div class="layui-input-block">
      <input  name="userName" value="${user.userName}" required  lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">用户账号</label>
    <div class="layui-input-block">
      <input  name="userCode" required  value="${user.userCode}" lay-verify="required|checkUserCode" placeholder="请输入账号" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">用户手机</label>
    <div class="layui-input-block">
      <input  name="userPhone" value="${user.userPhone}" required  lay-verify="required|phone" placeholder="请输入手机号" autocomplete="off" class="layui-input">
    </div>
  </div>
 <c:if test="${empty user}">
 <div class="layui-form-item">
    <label class="layui-form-label">用户密码</label>
    <div class="layui-input-inline">
      <input type="password" name="userPass" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux"></div>
  </div>
 </c:if>
  <input type="hidden" id="rowId" value="${user.rowId}" name="rowId">
  <div class="layui-form-item">
    <label class="layui-form-label">用户等级</label>
    <div class="layui-input-block">
      <select name="userKind" lay-verify="required">
        <option value=""></option>
        <option value="1"${user.userKind==1?'selected':''}>超级用户</option>
        <option value="0"${user.userKind==0?'selected':''}>普通用户</option>
        
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="btn-user-submit">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
<script>
layui.use(['form','layer'],function(){
	var form = layui.form;
	var layer=layui.layer ;
	var $ = layui.$;
	//表单唯一性校验
	 form.verify({
		 checkUserCode:function(value,item){
			 var msg ;
			 $.ajax({
				 type:"get",
				 async:false,//为了做唯一性校验，需要将ajax的异步请求关闭
				 url:'user/checkUserCode',
				 data:{"userCode":value},
				 success:function(result){
					 if(result==1){
						 msg="此编号已经被使用";
					 }
				 }
			 });
			 //如果赋值了，则不能使用，如果为空则校验成功
			 return msg ;
		 }
	 });
	
	  form.on('submit(btn-user-submit)',function(data){
		  var rowId = $("#rowId").val();
		  var formData = $(data.form).serialize();
		  if(rowId){
			  $.ajax({
				  type:'put',
				  url:"user",
				  data:formData,
				  success:function(result){
					  if(result){
						  layer.msg("角色修改成功");
					  }
				  }
				  
			  });
			  
		  }
		  else{ 
			  $.ajax({
			  type:"post",
			  url:"user/addUser",
			  data:formData,
			  success:function(result){
				  if(result){
					  layer.msg("角色新增成功");
				  }
			  }
		  });
		  }
		  layer.close(layer.index);
		  table.reload("demo");
		  return false ;
	  });
	  
	 
		 
	
});
</script>
