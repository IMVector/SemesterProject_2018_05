<%-- 
    Document   : LPatientMedicalRecord
    Created on : 2018-6-10, 21:29:04
    Author     : 刘福港
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>诊断病例</title>
    </head>
    <body>
        <table>
            <tr>
                <td>相关医生姓名：</td>
                <td>${record.doctorName}</td>
            </tr>
            <tr>
                <td>部门：</td>
                <td>${record.department.departmentName}</td>
            </tr>
            <tr>
                <td>入院时间：</td>
                <td>${record.inDate}</td>
            </tr>
            <tr>
                <td>入院诊断：</td>
                <td>${record.inDiagnosis}</td>
            </tr>
            <tr>
                <td>出院时间：</td>
                <td>${record.outDate}</td>
            </tr>
            <tr>
                <td>出院诊断：</td>
                <td>${record.outDiagnosis}</td>
            </tr>
            <tr>
                <td>是否住院：</td>
                <td>${record.isHospitalization}</td>
            </tr>
            <tr>
                <td rowspan="2">处方信息：</td>
                
            </tr>
            <c:forEach items="${record.prescription}" var="p">
                <tr>
                    <td>${p.prescriptionContent}</td>
                    <td>${p.prescriptionDate}</td>
                    <td>${p.prescriptionPrecautions}</td>
                    
                </tr>
            </c:forEach>
            <c:forEach items="${record.checkResults}" var="c">
                <tr>
                    <td>${c.checkItem.checkItemName}</td>
                    <td>${c.checkResultDescription}</td>
                </tr>
                
            </c:forEach>
        </table>
    </body>
</html>
