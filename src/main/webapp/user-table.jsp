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
<div class="layui-card-header">
<button type="button"  class="layui-btn layui-btn-sm layui-btn-add " id="btn_add" >新增</button>
</div>
<div class="layui-card-body">
<form class="layui-form" id="form-search">
<div class="layui-search-form">
<div class="layui-inline">
<select name="userKind">
<option value="">角色类型</option>
<option value="1">超级用户</option>
<option value="0">普通用户</option>
</select>
</div>
<div class="layui-inline">
<input name="userName" placeholder="用户名称" autocomplete="off" class="layui-input">
</div>
<div class="layui-inline">
<input name="userCode" placeholder="用户账号" autocomplete="off" class="layui-input">
</div>
<div class="layui-inline">
<button class="layui-btn layui-btn-primary layui-btn-sm" lay-submit lay-filter="btn-search">
<i class="layui-icon layui-icon-search"></i>
</button>
<button type="reset" class="layui-btn layui-btn-primary layui-btn-sm" >
<i class="layui-icon layui-icon-refresh"></i>
</button>

</div>
</div>
</form>
</div>
<table id="demo" lay-filter="user_table"></table>
<script type="text/html" id="roleKindTpl">
{{# if(d.userKind ==1){}}
<span class="layui-badge layui-bg-orange">超级用户</span>
{{# } else{ }}
	<span class="layui-badge layui-bg-cyan">普通用户</span>
{{# }}}
</script>
<script type="text/html" id="caozuo">
<button type="button"  class="layui-btn layui-btn-xs " lay-event="edit" >修改</button> &nbsp  &nbsp    
<button type="button"  class="layui-btn layui-btn-xs " lay-event="delete">删除</button>
</script>
</body>
<script type="text/javascript" src="assert/layui/layui.js"></script>
<script type="text/javascript">
layui.use(['table','form','layer'],function(){
	var $ = layui.$;
	var form = layui.form ;
	var table = layui.table;
	var layer = layui.layer;
	  table.render({
		    elem: '#demo'
		    ,height: 312//设置高度
		    ,url: 'user' //数据接口
		    ,page: true //开启分页
		 , where: $("#form-search").serialize(), //加除了分页外的额外数据（所条件查询）
		    cols: [[ //表头
		      {field: 'rowId', title: 'ID', width:80, sort: true, fixed: 'left'}
		      ,{field: 'userName', title: '用户名称', width:180}
		      ,{field: 'userCode', title: '用户账号', width:180} 
		      ,{field: 'userKind', title: '用户等级', width:180, templet:'#roleKindTpl'} 
		      ,{field: 'userPhone', title: '用户手机', width:180} 
		      ,{field: 'lastLoginIP', title: '登陆地址', width: 120, sort: true}
		      ,{field: '', title: '操作', width:200,templet:'#caozuo'}
		     
		    ]]
		  });
	  //对表格的按钮进行绑定
	  table.on('tool(user_table)',function(obj){
		  var data = obj.data ;
		  var layEvent = obj.event;
		  var rowId = data.rowId;
		  switch(layEvent){
		  case "edit":
			openLayerUser(rowId);
			  break;
		  case "delete":
			  layer.confirm("你确定要删除吗?",function(index){
				
				  $.ajax({
					  url:"user/"+rowId,
					  type:'delete',
					  success:function(result){
						  if(result){
							 // layer.close(index);
							  table.reload("demo");
							  layer.closeAll();
						  }
					  }
				  });
				  
			  });
			  break;
		   default:
			   break;
		  }
	  });
	  //绑定新增按钮
	  $("#btn_add").off('click').on('click',function(){
		  alert("新增");
		  openLayerUser();
	  });
	  function openLayerUser(rowId){
		  var titleVal = rowId==null?'用户新增':'用户修改';
		  $.ajax({
			  url:'user/goadd',
			  success:function(htmlData){
				  layer.open({
					  type:1,
					  title:titleVal,
					  area:'800px',
					  content:htmlData,
					  success:function(){
						  if(rowId){
							  $.ajax({
								  type:'get',
								  url:'user/get/'+rowId,
								  success:function(user){
									  form.val("form_add_edit",user);
									  $("#userName").data('old',user.userName);
									  form.render(null,'form_add_edit');
								  }
							  });
						  }
						  else{
							  form.render(null,'form_add_edit');
						  }
					  }
				  });
			  }
		  });
	  }
	  
	  //绑定多条件查询提交按钮，重新渲染数据
	  form.on("submit(btn-search)",function(data){
		  //重新渲染table表格数据
		  table.reload('demo',{
			  page:{
				  curr:1//重新从第一页开始
			  }
		  , where:$("#form-search").serialize()
		  },'data');
		  return false ;
	  });
	
		  
		});


</script>
</html>