<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
		String path = request.getContextPath();
	 	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>es|易享健康科技-message</title>
</head>

<body>
<form>
	<h1>注册成功，等待管理官审核，24小时后即可登录...</h1>
	<h1 id="time"></h1>
</form>
</body>

<script type="text/javascript">
var t = 5;
function showTime(){  
    t -= 1;
    document.getElementById('time').innerHTML= "剩余"+t+"s执行页面跳转";  
    if(t==0){  
        location.href='<%=basePath%>/index.jsp';  
    }
    setTimeout("showTime()",1000);  
}
showTime();  
</script>
</html>