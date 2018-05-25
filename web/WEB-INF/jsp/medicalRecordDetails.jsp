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
        <jsp:include page="patientHeaderTemplete"/>
        <div class="container body-under-header">
            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">XXX病例详情</div>
                    <div class="panel-body">
                        <ul class="list-group">
                            <li class="list-group-item">病例日期：</li>
                            <li class="list-group-item">检查项目：</li>
                            <li class="list-group-item">检查结果：</li>
                            <li class="list-group-item">诊断结果：</li>
                            <li class="list-group-item">诊断医师：</li>
                            <li class="list-group-item">是否住院：</li>
                            <li class="list-group-item">出院日期：</li>
                            <li class="list-group-item">出院诊断：</li>

                        </ul>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
