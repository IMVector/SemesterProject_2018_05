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
        <title>账单详情</title>
        <jsp:include page="resourcesTemplete.jsp"/>
    </head>
    <body>
        <jsp:include page="patientHeaderTemplete.jsp"/>
        <div class="ui container body-under-header">

            <div class="ui segment">
                <div class="ui header blue segment">${patient.patientName}账单详情</div>
                <div class="ui segment item"><p class="ui label">账单日期：</p>${bill.billDate}</div>
                <div class="ui segment item"><p class="ui label">账单金额：</p>${bill.totalAmount}</div>
                <div class="ui segment item"><p class="ui label">主要检查：</p>
                    <table class="ui blue table">
                        <c:if  test="${not empty bill.checkRecords}">
                            <thead>
                                <tr>
                                    <th>检查项目</th>
                                    <th>检查花费</th>
                                </tr>
                            </thead>
                        </c:if> 

                        <tbody>
                            <c:forEach items="${bill.checkRecords}" var="checkRecord">
                                <tr>
                                    <td>${checkRecord.checkItem.checkItemName}</td>
                                    <td>${checkRecord.checkItem.checkItemPrice}</td>
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>

                </div>
                <div class="ui segment item"><p class="ui label">是否支付：</p>${bill.paymentStatus}</div>
                <div class="col-offset-14">
                    <a href="personalCenter" class="ui button blue" >返回</a>
                </div>


            </div>
        </div>
    </body>
</html>
