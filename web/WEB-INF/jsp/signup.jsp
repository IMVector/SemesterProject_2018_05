<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>登录</title> 
<base href="${pageContext.request.contextPath}/">
<link href="resources/css/login.css" type="text/css" rel="stylesheet"> 

</head> 
<body style="background-image: url(resources/image/bg.png)"> 

<div class="login"  >
    <div class="message">欢迎来到InstalHMS</div>
    <div id="darkbannerwrap"></div>
    <form method="post" action="patient/signup/validate">
		<input name="action" value="login" type="hidden">
		<input name="username" placeholder="用户名" required="" type="text">
		<hr class="hr15">
		<input name="password" placeholder="密码" required="" type="password">
		<hr class="hr15">
		<input value="登录" style="width:100%;" type="submit">
		<hr class="hr20">
		<!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
                <a href="patient/register">还没有账号？前去注册！-></a><br><br>
                <a href="patient/searchPassword">忘记密码？前去找回！-></a>
	</form>

	
</div>



</body>
</html>
