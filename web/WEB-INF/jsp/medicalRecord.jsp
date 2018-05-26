<%-- 
    Document   : medicalRecord
    Created on : 2018-5-19, 10:30:04
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>个人病例</title>
        <jsp:include page="resourcesTemplete.jsp"/>
    </head>
    <body>
        <jsp:include page="patientHeaderTemplete.jsp"/>
        <%--<jsp:include page="persionalCenterTemplete.jsp"/>--%>
        <div class="container">
            <div class="row">
                <div class="panel panel-primary">
                
                    <table class="ui blue table">
                        <thead>
                            <tr>
                                <th>病例编号</th>
                                <th>病人姓名</th>
                                <th>入院日期</th>
                                <th>入院诊断</th>
                                <th>诊查科室</th>
                                <th>诊查医生</th>
                                <th>诊查结果</th>
                                <th>是否住院</th>
                                <th>出院日期</th>
                                <th>出院诊断</th>
                                <th>查看详情</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td><a  class="btn btn-primary" href="medicalRecordDetails\1">查看</a></td>
                            </tr>
                        </tbody>
                        <tr>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td><a href="medicalRecordDetails\1">查看</a></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
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
