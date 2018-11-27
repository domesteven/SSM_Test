<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		table{
		margin:0 auto;
		width:900px;
		}
		tr{
		text-align:center;
		}
		td img{
		width: 100px;
		heigth: 100px
		}

		#searchBtn{
		position:relative;
		left:40%;
		}
		#bottom{
		display:inline-block;
		position:relative;
		left:40%;
		}
		#search{
		width: 900px;
		height: 50px;
		background-color: skyblue;
		position:relative;
		left:15.6%;
		}
	</style>
	
	
	

	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">	
		var allpage;//定义一个全局的两个变量
	var currNum; 
	var count;
  $(function (){
  	getData("");//页面加载完成，加载员工数据
  	queryJob();//查询所有job,并加载到下拉框
  	queryDeptName();//查询所有部门名称,并加载到下拉框
  	queryLoc();//查询工作地点，并加载到下拉框
  });
  
  
function getData(){//通过异步获取数据
  	$.ajax({
	  url:'<%=path %>/index/queryViewByMap',
      type:'post',	  
	  data:{"currentPage":"1","pageSize":"5","dName":"","job":"","loc":""},
	  dataType:'json',
	  success:function(data){
	   console.log(data);
		loadData(data.list);
		loadPageMsg(data.bean);
	  }
  	});
  	}
  	
  	function queryLoc(){//通过异步获取数据
  	$.ajax({
	  url:'<%=path %>/index/queryLoc',
      type:'post',	  
	  data:{},
	  dataType:'json',
	  success:function(data){
	   console.log(data);
		loadLocData(data);
	  }
  	});
  	}
  
 function queryJob(){//通过异步获取数据
  	$.ajax({
	  url:'<%=path %>/index/queryJob',
      type:'post',	  
	  data:{},
	  dataType:'json',
	  success:function(data){
	   console.log(data);
		loadJobData(data);
	  }
  	});
  	}
  	//
  	function queryDeptName(){//通过异步获取数据
  	$.ajax({
	  url:'<%=path %>/index/queryDeptName',
      type:'post',	  
	  data:{},
	  dataType:'json',
	  success:function(data){
	   console.log(data);
		loadDeptNameData(data);
	  }
  	});
  	}
  	
  function loadLocData(data){
  var loc=data;
 	$("#loc").empty();
 	var $option1=$("<option selected ='selected'></option>");
 	$("#loc").append($option1);
 	for(var i=0;i<loc.length;i++){
 		var $option=$("<option>"+loc[i]+"</option>");
 		$("#loc").append($option);
 	}
  
  }
  function loadDeptNameData(data){//加载部门名称至条件选择下拉框
 	var deptName=data;
 	$("#deptName").empty();
 	var $option1=$("<option selected ='selected'></option>");
 	$("#deptName").append($option1);
 	for(var i=0;i<deptName.length;i++){
 		var $option=$("<option>"+deptName[i]+"</option>");
 		$("#deptName").append($option);
 	}
 	
 	
 	}
 function loadJobData(data){//加载job至条件选择下拉框
 	var job=data;
 	$("#job").empty();
 	var $option1=$("<option selected ='selected'></option>");
 	$("#job").append($option1);
 	for(var i=0;i<job.length;i++){
 		var $option=$("<option>"+job[i]+"</option>");
 		$("#job").append($option);
 	}
 	
 }
  	
 function loadData(data){//把数据加载页面++
 	var emp=data;//
 	$("tbody").empty();
  		for(var i=0;i<emp.length;i++){
  			var $tr=$("<tr></tr>");
  			var $empNo=$("<td>"+emp[i].empNo+"</td>");
  			var $eName=$("<td>"+emp[i].eName+"</td>");
  			var $job=$("<td>"+emp[i].job+"</td>");
  			var $mgr=$("<td>"+emp[i].mgr+"</td>");
  			var $hireDate=$("<td>"+new Date(emp[i].hireDate).toLocaleDateString()+"</td>");
  			var $sal=$("<td>"+emp[i].sal+"</td>");
  			var $comm=$("<td>"+emp[i].comm+"</td>");
  			var $deptNo=$("<td>"+emp[i].deptNo+"</td>");
  			var $dName=$("<td>"+emp[i].dName+"</td>");
  			var $loc=$("<td>"+emp[i].loc+"</td>");
  			var $do=$("<td><a href='javascript:'><input type='button' value='删除'></a><a href='#'><input type='button' value='修改'></a><a href='/ProManage/user/GrantManage'><input type='button' value='角色管理'></a></td>");
 			$tr.append($empNo).append($eName).append($job).append($mgr).append($hireDate).append($sal).append($comm).append($deptNo).append($dName).append($loc).append($do);
 			$("tbody").append($tr);
 		}
  	}
  	
  	function search(){
  		var dName=$("#deptName").find("option:selected").text();
		var job=$("#job").find("option:selected").text();
		var loc=$("#loc").find("option:selected").text();
		var currentPage=currNum;
		var pageSize=$("#pageSize").val();
  		$.ajax({
	 	 url:'<%=path %>/index/queryViewByMap',
     	 type:'post',	  
	 	 data:{"currentPage":currentPage,"pageSize":pageSize,"dName":dName,"job":job,"loc":loc},
	  	dataType:'json',
	 	 success:function(data){
	   	console.log(data);
		loadData(data.list);
		loadPageMsg(data.bean);
	  }
  	});
  	}
	function loadPageMsg(data){
		count=data.count;
		allpage=Math.ceil(data.count/data.pageSize);
		$("#currentPage").html(data.currNum);
		$("#pageAll").html(allpage);
		currNum=data.currNum;
	}
	function nextPage(){
	var dName=$("#deptName").find("option:selected").text();
	var job=$("#job").find("option:selected").text();
	var loc=$("#loc").find("option:selected").text();
	if(currNum==allpage||allpage==0){
		return;
	}
	var currentPage=currNum+1;
	var pageSize=$("#pageSize").val();
	$.ajax({
	  url:'<%=path %>/index/queryViewByMap',
      type:'post',	  
	  data:{"currentPage":currentPage,"pageSize":pageSize,"dName":dName,"job":job,"loc":loc},
	  dataType:'json',
	  success:function(data){
	   console.log(data);
		loadData(data.list);
		loadPageMsg(data.bean);
	  }
  	});
	}
	
	function upPage(){
	if(currNum==1){
		return;
	}
	var dName=$("#deptName").find("option:selected").text();
	var job=$("#job").find("option:selected").text();
	var loc=$("#loc").find("option:selected").text();
	var currentPage=currNum-1;
	var pageSize=$("#pageSize").val();
	$.ajax({
	  url:'<%=path %>/index/queryViewByMap',
      type:'post',	  
	  data:{"currentPage":currentPage,"pageSize":pageSize,"dName":dName,"job":job,"loc":loc},
	  dataType:'json',
	  success:function(data){
	   console.log(data);
		loadData(data.list);
		loadPageMsg(data.bean);
	  }
  	});

	}
	
	function getPageSizeData(pageSize){
	var dName=$("#deptName").find("option:selected").text();
	var job=$("#job").find("option:selected").text();
	var loc=$("#loc").find("option:selected").text();
	var flag=false;
	//if(count>currNum*pageSize){
	//if((count-currNum*pageSize)<pageSize){//总数据-（当前页*页面显示数据）小于需要显示的数据，就将当前页做减法
	//currNum--;
	//}
	//}
	//else{
	currNum=1;
	//}
	var currentPage=currNum;
	$.ajax({
	  url:'<%=path %>/index/queryViewByMap',
      type:'post',	  
	  data:{"currentPage":currentPage,"pageSize":pageSize,"dName":dName,"job":job,"loc":loc},
	  dataType:'json',
	  success:function(data){
	   console.log(data);
		loadData(data.list);
		loadPageMsg(data.bean);
	  }
  	});
	}
	
	function firstPage(){
	if(currNum==1){
		return;
	}
	var dName=$("#deptName").find("option:selected").text();
	var job=$("#job").find("option:selected").text();
	var loc=$("#loc").find("option:selected").text();
	var currentPage=1;
	var pageSize=$("#pageSize").val();
	$.ajax({
	  url:'<%=path %>/index/queryViewByMap',
      type:'post',	  
	  data:{"currentPage":currentPage,"pageSize":pageSize,"dName":dName,"job":job,"loc":loc},
	  dataType:'json',
	  success:function(data){
	   console.log(data);
		loadData(data.list);
		loadPageMsg(data.bean);
	  }
  	});
	}
	
	function lastPage(){
	if(currNum==allpage){
		return;
	}
	var dName=$("#deptName").find("option:selected").text();
	var job=$("#job").find("option:selected").text();
	var loc=$("#loc").find("option:selected").text();
	var currentPage=allpage;
	var pageSize=$("#pageSize").val();
	$.ajax({
	  url:'<%=path %>/index/queryViewByMap',
      type:'post',	  
	  data:{"currentPage":currentPage,"pageSize":pageSize,"dName":dName,"job":job,"loc":loc},
	  dataType:'json',
	  success:function(data){
	   console.log(data);
		loadData(data.list);
		loadPageMsg(data.bean);
	  }
  	});
	}
	</script>
  </head>
  
 <body>
 <div id="search" align="center">
 	部门:<select id="deptName">
 	<option></option>
 	<option></option>
 	</select>
 	职位:<select id="job">
 	<option></option>
 	</select>
 	就职地点:<select id="loc">
 	<option></option>
 	<option></option>
 	</select>
  	<button onclick="search()" ><img src="<%=path %>\image\search.png" />查询</button>
  	</div>
   <form action="" method="post" onsubmit="return false" id="myForm">
    <table border="1px blue solid" cellpadding="0" cellspacing="0" width="500px" >
    	<thead>
    	<tr>
    		<td>员工id</td>
    		<td>员工姓名</td>
    		<td>工作</td>
    		<td>上级id</td>
    		<td>入职日期</td>
    		<td>佣金</td>
    		<td>福利</td>
    		<td>部门编号</td>
    		<td>部门名称</td>
    		<td>工作地点</td>
    		<td>操作</td>
    	</tr>
    	</thead>
    	<tbody>
    	
    	</tbody>
    </table>
    <div id="bottom">
    <button onclick="firstPage()"><img src="<%=path %>\image\pencil.png" />首页</button>
    <button onclick="upPage()"><img src="<%=path %>\image\search.png" />上一页</button>
    <span id="currentPage"></span>/<span id="pageAll"></span>
    <button onclick="nextPage()"><img src="<%=path %>\image\search.png" />下一页</button>
    <button onclick="lastPage()"><img src="<%=path %>\image\search.png" />尾页</button>
    <select id="pageSize" onchange="getPageSizeData(this.value)">
    	<option>5</option>
    	<option>10</option>
    	<option>15</option>
    </select>
    </div>
  </form>
  </body>
</html>
