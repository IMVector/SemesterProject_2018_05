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
        <title>处方详情</title>
        <jsp:include page="resourcesTemplete.jsp"/>
    </head>
    <body>
        <jsp:include page="patientHeaderTemplete.jsp"/>
        <div class="ui container body-under-header">

            <div class="ui segment">
                <div class="ui header blue segment">${patient.patientName}处方详情</div>
                <div class="ui segment item"><p class="ui label">处方编号：</p>${prescription.prescriptionId}</div>
                <div class="ui segment item"><p class="ui label">处方日期：</p>${prescription.prescriptionDate}</div>
                <div class="ui segment item"><p class="ui label">处方内容：</p>${prescription.prescriptionContent}</div>
                <div class="ui segment item"><p class="ui label">处方使用症状：</p>${prescription.medicalRecord.inDiagnosis}</div>
                <div class="ui segment item"><p class="ui label">处方注意事项：</p>${prescription.prescriptionPrecautions}</div>
                <div class="ui segment item"><p class="ui label">处方开出医生姓名：</p>${prescription.medicalRecord.doctorName}</div>
                <div class="col-offset-14">
                    <a href="personalCenter" class="ui button blue" >返回</a>
                </div>


            </div>
        </div>
    </body>
</html>
