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
layui.use('table',function(){
	var table = layui.table;
	  table.render({
		    elem: '#demo'
		    ,height: 312//设置高度
		    ,url: 'user/find' //数据接口
		    ,page: true //开启分页
		    ,cols: [[ //表头
		      {field: 'rowId', title: 'ID', width:80, sort: true, fixed: 'left'}
		      ,{field: 'userName', title: '用户名称', width:180}
		      ,{field: 'userCode', title: '用户账号', width:180} 
		      ,{field: 'userKind', title: '用户等级', width:180, templet:'#roleKindTpl'} 
		      ,{field: 'userPhone', title: '用户手机', width:180} 
		      ,{field: 'lastLoginIP', title: '登陆地址', width: 120, sort: true}
		      ,{field: '', title: '操作', width:200,templet:'#caozuo'}
		     
		    ]]
		  });
	  table.on('tool(user_table)',function(obj){
		  var data = obj.data ;
		  console.log(data);
		  var layEvent = obj.event;
		  switch(layEvent){
		  case "edit":
			  console.log("执行修改");
			  break;
		  case "delete":
			  if(layer.confirm("你确定要删除吗?")){
				  
				  
			  }
			  break;
		   default:
			   break;
			  
			  
		  }
	  });
		  
		});


</script>
</html>