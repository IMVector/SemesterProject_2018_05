<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>找回密码</title> 
<base href="${pageContext.request.contextPath}/">
<link href="resources/css/login.css" type="text/css" rel="stylesheet"> 
<script src="resources/js/jquery-3.2.1.min.js"></script>

</head> 
<body style="background-image: url(resources/image/bg.png)"> 
    <div class="login"  >
    <div class="message">欢迎来到InstalHMS</div>
    <div id="darkbannerwrap"></div>
    <div>
		<input name="action"  type="hidden">
		<input id="patientId" name="patientId" placeholder="请输入用户名" required="true" type="text">
		<hr class="hr15">
                <input id="searchQuestion" value="查询密保问题" style="width:100%;" type="submit">
                <hr class="hr15">
                <h4 id="msg"></h4>
                <hr class="hr15">
    </div>
    
    <script>
            //js代码
            //编写jQuery一般需要编写到document的ready事件中
            $(document).ready(function(){

                //处理id为submitBtn按钮的点击事件
                $("#searchQuestion").click(function(){
                    
                    //这里当按钮点击后应该执行的代码
                    //调用jQuery的ajax函数，发送异步请求
                    //JSONs
                    //url:指定请求路径
                    //type: 请求提交方式
                    //data:发送给服务器的数据，也就是参数
                    //success: 指定如果ajax请求成功，要执行的操作
                    //error:如果ajax请求失败，要执行的操作
                    $.ajax({
                        url: "patient/searchPassword/searchPasswordQuestion",
                        type: 'POST',
                        data: {"patientId": $("#patientId").val()},
                        success: function(s){ //success对应的函数可有参数，该参数表示服务器返回的数据
                            //将id为msg的h2的内容设置为服务器返回的内容
                            $("#msg").html(s);
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                         alert("输入用户不存在"+errorThrown);
                    }
                    });
                }); 
            });
            
        </script>
        <script>
            $(document).ready(function(){
                //处理id为submitBtn按钮的点击事件
                $("#searchPassword").click(function(){
                    $.ajax({
                        url: "patient/searchPassword/searchPassword",
                        type: 'POST',
                        data: {"answer": $("#answer").val(),"patientId": $("#patientId").val()},
                        success: function(sh){ //success对应的函数可有参数，该参数表示服务器返回的数据
                            //将id为msg的h2的内容设置为服务器返回的内容
                            $("#msg2").html("密码已修改为"+sh+"，请登陆后及时修改");
                        },
                        error: function(){
                            alert("密保问题回答错误");
                        } //最后一个属性不要加逗号
                    });
                }); 
            });
        </script>
        <div>
            <input id="answer" name="answer" placeholder="请输入密保答案" required="true" type="text">
                <input id="patientId" name="patientId" type="hidden" value="${patient.patientId}">
		<hr class="hr15">
		<input id="searchPassword" value="获取密码" style="width:100%;" type="submit">
		<hr class="hr20">
                <h4 id="msg2"></h4>
		<!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
                <a href="patient/signup">返回登陆页面-></a><br><br>
                
	<div>
    

	
</div>
</body>
</html>
