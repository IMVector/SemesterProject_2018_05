<%-- 
    Document   : medicalRecordDetails
    Created on : 2018-5-25, 14:01:03
    Author     : Vector
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div class="ui header blue segment">${patient.patientName}待检查详情</div>
                <div class="ui segment item"><p class="ui label">检查日期：</p>${checkRecord.checkDate}</div>
                <div class="ui segment item"><p class="ui label">检查项目：</p>${checkRecord.checkItem.checkItemName}</div>
                <div class="ui segment item"><p class="ui label">检查项目花费：</p>${checkRecord.checkItem.checkItemPrice}</div>
                <div class="col-offset-14">
                    <a href="personalCenter" class="ui button blue" >返回</a>
                </div>


            </div>
        </div>
    </body>
</html>
