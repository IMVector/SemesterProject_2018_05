<%-- 
    Document   : patientMedicalHisory
    Created on : 2018-6-9, 20:06:49
    Author     : 刘福港
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>药物历史</title>
    </head>
    <body>
        <form action="action">
            <table>
                <input type="hidden" value="${patient}" name="patient">
                <tr>
                    <td>病人姓名：</td>
                    <td><input type="text" value="${patient.patientName}" disabled="true"></td>
                </tr>
                
                <tr>
                    <td>药物名称：</td>
                    <c:forEach items="${mh.medication}" var="med" >
                        <td>${med.medicationName}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>不良反应：</td>
                    <td><input type="text" value="${mh.adverseReactions}" disabled="${isTrue}"></td>
                </tr>
                <tr>
                    <td>持续时间：</td>
                    <td><input type="text" value="${mh.duration}" disabled="${isTrue}"></td>
                </tr>
                <tr>
                    <td>最近一次：</td>
                    <td><input type="text" value="${mh.lastTime}" disabled="${isTrue}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="text" value="提交"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
