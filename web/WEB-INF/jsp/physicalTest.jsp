<%-- 
    Document   : physicalTest
    Created on : 2018-6-10, 15:39:30
    Author     : 刘福港
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>安排相关检查</title>
        <script src="resources/js/jquery-3.2.1.min.js"></script>
    </head>
    <body>
        <form action="patient/physicalTest" method="post">

            <table>
                
                <tr>
                    <td>用户ID：</td>
                    <td><input name="patientId" type="text" value="${Lpatient.patientId}" id="LpatientId" readonly="true"></td>
                </tr>
                
                
                
<!--                <input name="LpaymentStatus" type="text" value="否" id="LpaymentStatus" readonly="true">-->
                <tr>
                    <td>选择检查项目：</td>
                    <td><select name="LcheckItem" id="LcheckItem">
                            <option value="1">脑电图</option>
                            <option value="3">心电图</option>
                            <option value="4">查血</option>
                            <option value="5">尿检</option>
                        </select></td>
                </tr>
                
                <tr>
                    <td>检查时间：</td>
                    <td><input name="LcheckDate" type="date" id="LcheckDate"></td>
                </tr>
                <tr>
                    <td>检查结果：</td>
                    <td><input name="LcheckResult" type="text" value="尚未检查" id="LcheckResult" readonly="true"></td>
                </tr>
                <tr>
                    <td>是否检查：</td>
                    <td><input name="LisChecked" type="text" value="0" id="LisChecked" readonly="true"></td>
                </tr>
                <tr>
                    <td>支付状态：</td>
                    <td><input name="LpaymentStatus" type="text" value="否" id="LpaymentStatus" readonly="true"></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><input id="Lsubmit" type="submit" value="提交"></td>
                </tr>
            </table>
            <h4 id="eee"></h4>
        </form>

<!--        <script>
            $(document).ready(function () {
                $("#Lsubmit").click(function () {
                    $.ajax({
                        url: "patient/physicalTest",
                        type: 'POST',
                        data: {"LcheckResult": $("#LcheckResult").val(), "LpatientId": $("#LpatientId"), "LisChecked": $("#LisChecked"), "LpaymentStatus": $("#LpaymentStatus"), "LcheckItem": $("#LcheckItem"), "LcheckDate": $("#LcheckDate")},
                        success: function (s) { //success对应的函数可有参数，该参数表示服务器返回的数据
                            //将id为msg的h2的内容设置为服务器返回的内容
                            $("#eee").html(s);
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            alert("失败");
                        }
                    });
                });
            });
        </script>-->

    </body>
</html>
