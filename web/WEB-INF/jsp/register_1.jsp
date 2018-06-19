<%-- 
    Document   : register
    Created on : 2018-6-3, 10:01:01
    Author     : 刘福港
--%>

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
    <div class="message">捐献者身份录入</div>
    <div id="darkbannerwrap"></div>
    <form method="post" action="donor/insert">
		<input name="action" value="login" type="hidden">
		<input name="donorName" placeholder="捐献者姓名" required="true" type="text">
		<hr class="hr15">
		
                <select name="donorGender" id="donorGender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
		<hr class="hr15">
                
<!--                <label for="gender" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">性别:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="gender" name="patientGender" placeholder="性别" required="true" type="radio" value="男">男&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="gender" name="patientGender" placeholder="性别" required="true" type="radio" value="女">女
		<hr class="hr15">
                <label for="marrying" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">婚姻状况:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="marrying" name="patientMstatus" placeholder="性别" required="true" type="radio" value="是">已婚&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="marrying" name="patientMstatus" placeholder="性别" required="true" type="radio" value="否">未婚
		<hr class="hr15">
                <label for="birthday" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">出生日期:</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="birthday" name="patientBirthday" type="date" value="2014-01-13"/>
		<hr class="hr15">-->
<!--                <input name="donorBloodType" placeholder="捐献血型" required="true" type="text">
		<hr class="hr15">-->
                <select name="donorBloodType" id="donorBloodType" >
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="AB">AB</option>
                    <option value="O">O</option>
                    
                </select>
                <hr class="hr15">
                <input name="donorAddress" placeholder="家庭住址" required="true" type="text">
		<hr class="hr15">
                <input name="donorPhone" placeholder="手机号码" required="true" type="text">
		<hr class="hr15">
<!--                <input name="patientAnswer" placeholder="密保答案" required="true" type="text">
		<hr class="hr15">
                <input name="patientPhone" placeholder="手机号码" required="true" type="text">
		<hr class="hr15">
-->		<input value="提交" style="width:100%;" type="submit">
		<hr class="hr20">
                
		<!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
<!--                <a href="patient/signup">已有账号？前去登陆！</a>-->
	</form>
    <h4>${insert}</h4>

	
</div>
</body>
</html>
