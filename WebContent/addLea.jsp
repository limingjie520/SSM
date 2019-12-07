<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加请假页面</title>
<style type="text/css">

#div{
border: 5px solid purple; 

width: 700px;
margin: auto;
padding: 40px;
}
h1{
text-align: center;
}


</style>
</head>
<body>
<div id="div">
    <form action="LeaveServlet?oper=add" method="post">
    <h1>添加请假记录</h1>
    <table>
    <tr>
    <td>姓名：</td>
    <td><input type="text" name="name" id="nameid"></td>
    </tr>
    <tr>
    <td>请假时间:</td>
    <td><input type="text" name="time" id="timeid">格式要求：yyyy-mm-dd</td>
    </tr>
    <tr>
    <td>请假原因:</td>
    <td><textarea rows="5" cols="50" name="qjyy" id="qiyyid"></textarea> </td>
    </tr>
    
    </table>
    <p>
    <br/>
    <input type="submit" value="提交" style="margin-left: 78px" id="sub"> <input type="reset" value="清空" style="margin-left: 50px">
    </p>
    </form>
    </div>
</body>
<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#sub").click(function(){
		var reg=new RegExp("^[1-2]\\d{3}-(0?[1-9]||1[0-2])-(0?[1-9]||[1-2][1-9]||3[0-1])$");
		var name=$("#nameid").val();
		var time=$("#timeid").val();
		var  qjyy=$("#qiyyid").val();
		if(name==""||name==null ||
		  time==""||time==null ||
		  qjyy==""||qjyy==null ){
			alert("信息未填写完整，请完善！");
			return false ;
		}else if(!reg.test(time)){
			alert("日期格式有误，请重新输入！");
			return false;
		}
		return true;
		
		
		
		
	})
	
})
</script>
</html>