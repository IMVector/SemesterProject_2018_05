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
                        url: "doctor/searchPassword/searchQuestion",
                        type: 'POST',
                        data: {"staffId": $("#staffId").val()},
                        success: function(s){ //success对应的函数可有参数，该参数表示服务器返回的数据
                            
                         //将id为msg的h2的内容设置为服务器返回的内容
                            $("#msg").html(s);
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            toastError("输入用户不存在！"+errorThrown);
//                         alert("输入用户不存在"+errorThrown);
                    }
                    });
                }); 
            });
            
        </script>
        <div>
		<input name="action" value="login" type="hidden">
                <input id="staffId" name="username" placeholder="请输入用户名" required="true" type="text">
		<hr class="hr15">
                <input id="searchQuestion" value="查询密保问题" style="width:100%;" type="submit">
                <hr class="hr15">
                <h3 id="msg"></h3>
    </div>
        <script>
            $(document).ready(function(){

                //处理id为submitBtn按钮的点击事件
                $("#getPassword").click(function(){
                    
                    
                    $.ajax({
                        url: "doctor/searchPassword/searchPassword",
                        type: 'POST',
                        data: {"answer": $("#username").val(),"staffId": $("#staffId").val()},
                        success: function(sh){ //success对应的函数可有参数，该参数表示服务器返回的数据
                            //将id为msg的h2的内容设置为服务器返回的内容
                            $("#msg2").html("密码已修改为"+sh+"，请登陆后及时修改");
                        },
                        error: function(){
                            toastError("密保问题回答错误");
//                            alert("密保问题回答错误");
                        } //最后一个属性不要加逗号
                    });
                }); 
            });
        </script>
        <div>
        <input id="username" name="username" placeholder="请输入密保答案" required="true" type="text">
                <input id="staffId" type="hidden" value="${s.staffId}">
		<hr class="hr15">
                <input id="getPassword" value="获取密码" style="width:100%;" type="submit">
		<hr class="hr20">
                <h3 id="msg2"></h3>
		<!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
                <a href="doctor/signup">返回登陆页面-></a><br><br>
                
	</div>

	
</div>
</body>
</html>
