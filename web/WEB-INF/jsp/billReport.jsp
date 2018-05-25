<%-- 
    Document   : billReport
    Created on : 2018-5-19, 10:49:16
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>查看个人帐单</title>
        <jsp:include page="resourcesTemplete.jsp"/>
    </head>
    <body>
        <jsp:include page="patientHeaderTemplete.jsp"/>
        <jsp:include page="persionalCenterTemplete.jsp"/>

        <div class="container">
            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">XXX的个人帐单记录</div>
                    <table class="table">
                        <tr>
                            <th>账单编号</th>
                            <th>病人姓名</th>
                            <th>检查记录</th>
                            <th>总金额</th>
            
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                        </tr>

                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
