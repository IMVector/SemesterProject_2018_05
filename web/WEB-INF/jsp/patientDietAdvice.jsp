<%-- 
    Document   : patientDietAdvice
    Created on : 2018-6-9, 20:06:15
    Author     : 刘福港
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="resources/js/jquery-3.2.1.min.js"></script>
        <title>饮食建议</title>
    </head>
    <body>
        <!--        <form action="patient/insertDietAdvice" method="post" id="form1">-->
        <div>
            <table>
                <!--
                -->            
                <tr>
                    <td>病人姓名：</td>
                    <td><input id="LpatientName" type="text" value="${Lpatient.patientName}" disabled="true"></td>
                </tr>
                <tr>
                    <td>病人ID：</td>
                    <td><input id="LpatientId" type="text"  value="${Lpatient.patientId}" id="YpatientId" readonly="true"></td>
                </tr>
                <tr>
                    <td>相关医生：</td>
                    <td><input type="text" value="${staffDetail.staffName}" disabled="true"></td>
                </tr>

                <tr>
                    <td>医生ID：</td>
                    <td><input type="text" name="staffId" value="${staffDetail.staffId}" id="staffId" readonly="true"></td>
                </tr>
                <tr>
                    <td>内容：</td>
                    <td><input type="text"  name="dietAdviceContent" id="dietAdviceContent"></td>
                </tr>
                <tr>
                    <td>时间：</td>
                    <td><input type="date"  name="dietAdviceTime" id="Gtime"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="提交" id="submit1"></td>
                </tr>
            </table>
            <h3 id="result"></h3>
        </div>
        <script>
            $(document).ready(function () {
//                console.log("+++++++++++++++++++++++++++++++++++++++++++");
//                $("#prescription").on("click", function () {
//                    console.log("-----------------------------------------");
////                    document.location.reload();
//                });
                //处理id为submitBtn按钮的点击事件
                $("#submit1").click(function () {
                    $.ajax({
                        url: "patient/insertDietAdvice",
                        type: 'POST',
//                        contentType:"application/x-www-form-urlencoded",
                        data: {"patientId": $("#YpatientId").val(), "staffId": $("#staffId").val(), "dietAdviceContent": $("#dietAdviceContent").val(), "time": $("#Gtime").val()},

                        success: function (result) { //success对应的函数可有参数，该参数表示服务器返回的数据
                            //将id为msg的h2的内容设置为服务器返回的内容
                            $("#result").html("插入成功");
                        },
                        error: function () {
                            alert("异常！");
                        } //最后一个属性不要加逗号
                    });
                });
            });
        </script>
    </body>
</html>
