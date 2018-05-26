<%-- 
    Document   : medicalRecordDetails
    Created on : 2018-5-25, 14:01:03
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>病例详情</title>
        <jsp:include page="resourcesTemplete.jsp"/>
    </head>
    <body>
        <jsp:include page="patientHeaderTemplete.jsp"/>
        <div class="ui container body-under-header">

            <div class="ui segment">
                <div class="ui header blue segment">XXX病例详情</div>
                <div class="ui segment item">病例日期：</div>
                <div class="ui segment item">检查项目：</div>
                <div class="ui segment item">检查结果：</div>
                <div class="ui segment item">诊断结果：</div>
                <div class="ui segment item">诊断医师：</div>
                <div class="ui segment item">是否住院：</div>
                <div class="ui segment item">出院日期：</div>
                <div class="ui segment item">出院诊断：</div>
                <div class="col-offset-14">
                    <div class="ui button blue" >返回</div>
                </div>


            </div>
    </body>
</html>
