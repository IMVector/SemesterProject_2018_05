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
                <div class="ui header blue segment">${patient.patientName}病例详情</div>
                <div class="ui segment item"><p class="ui label">病例日期：</p>${medicalRecord.inDate}</div>
                <div class="ui segment item"><p class="ui label">检查项目：</p><c:forEach items="${medicalRecord.checkResults}" var="result">
                        ${result.checkItem.checkItemName}、
                    </c:forEach></div>
                <div class="ui segment item"><p class="ui label">检查结果：</p><c:forEach items="${medicalRecord.checkResults}" var="result">
                        ${result.checkResultDescription}、
                    </c:forEach></div>
                <div class="ui segment item"><p class="ui label">诊断结果：</p>${medicalRecord.inDiagnosis}</div>
                <div class="ui segment item"><p class="ui label">诊断医师：</p>${medicalRecord.staff.staffName}</div>
                <div class="ui segment item"><p class="ui label">是否住院：</p>${medicalRecord.isHospitalization}</div>
                <div class="ui segment item"><p class="ui label">出院日期：</p>${medicalRecord.outDate}</div>
                <div class="ui segment item"><p class="ui label">出院诊断：</p>${medicalRecord.outDiagnosis}</div>
                <div class="ui segment item"><p class="ui label">处方信息：</p><c:forEach items="${medicalRecord.prescriptions}" var="prescriptions">
                        ${prescriptions.prescriptionContent}、
                    </c:forEach></div>
                <div class="col-offset-14">
                    <a href="personalCenter" class="ui button blue" >返回</a>
                </div>


            </div>
    </body>
</html>
