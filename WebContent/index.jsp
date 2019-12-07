<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请假记录列表</title>
<style type="text/css">
#div1{
width: 600px;
margin:auto;
}
h1{
text-align: center;
}

table {
	text-align: center;
	margin: auto;
}
p{
	margin: auto;
	text-align: center;
}


</style>
</head>
<body>

<c:if test="${empty page }">
<c:redirect url="LeaveServlet?oper=sel"></c:redirect>
</c:if>

		<div id="div1">
		<h1>请假记录列表</h1>
		<a href="addLea.jsp" style="text-decoration: none; margin-left: 120px" >添加请假记录</a>
		<table border="1">
		<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>请假时间</th>
		<th>请假原因</th>
		<th>操作</th>
		</tr>
		<c:forEach var="list"  items="${list}"  varStatus="va">
		<tr>
	       <td>${va.count}</td>
	       <td>${list.name }</td>
	        <td>${list.leaveTime }</td>
	        <td>${list.reason }</td>
	        <td><a href=""  onclick="del(${list.id})" style="text-decoration: none;">删除</a></td>
		</tr>
		</c:forEach>
		
		</table>
		<p>
		<a href="LeaveServlet?oper=sel&pageno=1">首页</a>
		<a href="LeaveServlet?oper=sel&pageno=${page.currPageNo-1<1? page.currPageNo:page.currPageNo-1 }">上一页</a>
	    <a href="LeaveServlet?oper=sel&pageno=${page.currPageNo+1>page.totalPageCount?page.currPageNo:page.currPageNo+1 }">下一页</a>
		<a href="LeaveServlet?oper=sel&pageno=${page.totalPageCount<page.currPageNo ?page.currPageNo:page.totalPageCount }">末页</a>
		<span>第${page.currPageNo }页/共${page.totalPageCount}页</span>
		</p>
		</div>
</body>
<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
<script type="text/javascript">
  $(function(){
	  $("tr:even").css("background-color","red");
	
	  
  })
    function del(id) {
	  if(confirm("确认要删除吗？")){
		  $.ajax({
				url:"LeaveServlet?oper=del",
				type:"get",
				data:"id="+id,
				dataType:"text",
				success:backAll,
				error:function(){
					alert("兄弟出异常了！");
				}
			});


			function backAll(data){
				alert(data);
			}
	  }
		
	}
</script>
</html>