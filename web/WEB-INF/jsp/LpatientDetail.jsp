<%-- 
    Document   : LpatientDetail
    Created on : 2018-6-12, 21:22:21
    Author     : 刘福港
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="${pageContext.request.contextPath}/">
        <body style="background-image: url(resources/image/bg.png) ">
        <title>病人个人信息</title>
    </head>
    <body>
        <h1>病人详细信息</h1>
        
        <table id="patientDetail" >
            <tr>
                <td>姓名：</td>
                <td>${Lpatient.patientName}</td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>${Lpatient.patientGender}</td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td>${Lpatient.patientAge}</td>
            </tr>
            <tr>
                <td>血型</td>
                <td>${Lpatient.bloodType}</td>
            </tr>
            <tr>
                <td>出生日期：</td>
                <td>${Lpatient.patientBirthday}</td>
            </tr>
            
        </table>
            <a href="goBackToDoctorCenter">返回主页面</a>
    </body>
</html>
