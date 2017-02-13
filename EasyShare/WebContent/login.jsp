<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
		String path = request.getContextPath();
	 	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="images/icon.png" sizes="512x512">
<title>es|易享健康科技</title>
<meta charset="UTF-8">
<script type="text/javascript">
    function changeCode(){
        document.getElementById("coderImg").src='<%=basePath%>code.html?id='+new Date().getMilliseconds();
    }
    function  getObjsByClass (param) {
        var tags = tags || document.getElementsByTagName("*");
        var list = [];
        for( var k in tags)
        {
            var tag = tags[k];
            if(tag.className == param) {
                list.push(tag);
            }
        }
        return list;
    }
    $(document).ready(function(){
        var coderFlag = 0;
        $("#coder").hide();
        $("#chkFormInfo").hide();
        function showChkFormInfo(){
            $("#chkFormInfo").fadeIn("fast");
        }
        function hideChkFormInfo(){
            $("#chkFormInfo").fadeOut("fast");
        }
        function hideChkFormInfoTimer(){
            var t=setTimeout("hideChkFormInfo()",3000);
        }
        function getChkFormInfo(str){
            document.getElementById("chkFormInfo").innerHTML = str;
            showChkFormInfo();
            hideChkFormInfoTimer();
        }
        $("#ident").click(function(){
                $(function () {$('#ident').popover('destroy');});
                var info = '';
                $("#ident").popover({title: '验证码',
                                      content: info,
                });
                $(function () {$('#ident').popover('show');});
                changeCode();
                var objer = getObjsByClass("popover-content");
                objer[0].innerHTML = document.getElementById("coder").innerHTML;
        });

        $("#ident").blur(function(){
            $(function () {$('#ident').popover('destroy');});
        });
        $("#login-button").click(function(){
            var username = document.getElementById("username").value;
            var userpass = document.getElementById("userpass").value;
            var ident = document.getElementById("ident").value;
            var temp = document.getElementsByName("options");
            var root = -1;
            for(var i=0;i<temp.length;i++){
               if(temp[i].checked) root = temp[i].value;
            }
            if(username == ""){
                getChkFormInfo("请输入您的邮箱或手机号");
            }else if(userpass == ""){
                getChkFormInfo("请输入您的密码");
            }else if(ident == ""){
                getChkFormInfo("请输入验证码");
            }else if((root != "1") && (root != "2") && (root != "0")){
                getChkFormInfo("请选择您的账户类型")
            }else{
                document.getElementById("login-button").type = "submit";
                document.getElementById("former").action = "<%=basePath%>login.html?type=login";
                document.getElementById("login-button").click();
            }
        });
    });
</script>
</head>
<body>

<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<h1>Welcome to Easy Share</h1>
            <!--action="/EasyShare/index.html"-->
			<form class="form" method="post" id="former">
				<label>${error_message}</label>
				<input type="text" name="condition" placeholder="邮箱/手机号" id="username">
				<input type="password" name="password" placeholder="密码" id="userpass">
                <input type="text" id="ident" name="code" class="" rel="popover" placeholder="验证码">
                <div class="btn-group" data-toggle="buttons" >
                    <label class="btn btn-primary selectRootBtn" style="width: 150px;">
                        <input type="radio" name="options" id="" checked value="2">学生
                    </label>
                    <label class="btn btn-primary selectRootBtn" style="width: 150px;">
                        <input type="radio" name="options" id="" value="1">教师
                    </label>
                  
                </div>
                <p></p>
                <div>
				    <button type="button" id="login-button">登录</button>
                </div>
            </form>
            <p id="chkFormInfo" style="font-size: 20px;"></p>
            <div id="coder"><img id="coderImg" src="<%=basePath%>code.html" style="margin:0px 0px 7px 0px;"></div>
		</div>
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</div>

</body>
</html>
