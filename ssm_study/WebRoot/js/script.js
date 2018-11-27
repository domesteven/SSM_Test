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
	  url:'<%=path %>/index/getView',
      type:'post',	  
	  data:{},
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
  			var $hireDate=$("<td>"+emp[i].hireDate+"</td>");
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
  		$.ajax({
	 	 url:'<%=path %>/index/search',
     	 type:'post',	  
	 	 data:{"dName":dName,"job":job,"loc":loc},
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