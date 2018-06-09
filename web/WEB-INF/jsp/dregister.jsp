<%-- 
    Document   : register
    Created on : 2018-6-3, 10:01:01
    Author     : 刘福港
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>注册</title> 
<base href="${pageContext.request.contextPath}/">
<link href="resources/css/signup.css" type="text/css" rel="stylesheet"> 

</head> 
<body style="background-image: url(resources/image/bg.png)"> 
    <div class="login"  >
    <div class="message">欢迎来到InstalHMS</div>
    <div id="darkbannerwrap"></div>
    <form method="get" action="doctor/register/register">
		<input name="action" value="login" type="hidden">
		<input name="staffId" placeholder="用户名" required="true" type="text">
		<hr class="hr15">
                <input name="staffName" placeholder="姓名" required="true" type="text">
		<hr class="hr15">
		<input name="staffPassword" placeholder="密码" required="true" type="password">
		<hr class="hr15">
                
<!--                <label for="gender" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">性别:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="gender" name="gender" placeholder="性别" required="true" type="radio" >男&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="gender" placeholder="性别" required="true" type="radio">女
		<hr class="hr15">-->
<!--                <label for="birthday" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">出生日期:</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="birthday" type="date" value="2014-01-13"/>
		<hr class="hr15">-->
                <select name="departmentId" id="">
                    <c:forEach items="${department}" var="d" varStatus="id">
                        <option value="${d.departmentId}">${d.departmentName}</option>
                    </c:forEach>
                </select>
                <hr class="hr15">

                <select name="titleId" id="">
                    <c:forEach items="${title}" var="t" >
                        <option value="${t.titleId}">${t.titleName}</option>
                    </c:forEach>
                </select>
                <hr class="hr15">
<!--                <input name="address" placeholder="职务" required="true" type="">
		<hr class="hr15">
                <input name="email" placeholder="电子邮箱" required="true" type="text">
		<hr class="hr15">-->
                <input name="staffQuestion" placeholder="密保问题" required="true" type="text">
		<hr class="hr15">
                <input name="staffAnswer" placeholder="密保答案" required="true" type="text">
		<hr class="hr15">
<!--                <input name="phoneNumber" placeholder="手机号码" required="true" type="text">
		<hr class="hr15">-->
		<input value="注册" style="width:100%;" type="submit">
		<hr class="hr20">
		<!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
                <a href="doctor/signup">已有账号？前去登陆！</a>
	</form>

	
</div>
</body>
</html>
