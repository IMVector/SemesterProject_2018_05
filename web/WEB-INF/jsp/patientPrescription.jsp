<%-- 
    Document   : patientPrescription
    Created on : 2018-6-9, 20:05:51
    Author     : 刘福港
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="${pageContext.request.contextPath}/">
        <title>处方信息</title>
    </head>
    <body>
        <div>
            <table>
<!--                <input name="patient" type="hidden" value="$">-->
                
                <tr>
                    <td>病人姓名：</td>
                
                    <td><input type="text" id="LFGpatientName" value="${Lpatient.patientName}" readonly="true"></td>
                </tr>
                <tr>
                    <td>病人ID：</td>
                    <td><input type="text" id="LFGpatientId" value="${Lpatient.patientId}" name="patientId" readonly="true" id="patientId"></td>
                </tr>
<!--                <tr>
                    <td>就诊记录：</td>
                    <td><input type="text" value="" ></td>
                </tr>-->
                <tr>
                    <td>处方信息：</td>
                    <td><input name="prescriptionContent" type="text" value="" id="prescriptionContent"></td>
                </tr>
                <tr>
                    <td>日期：</td>
                    <td><input name="prescriptionDate" type="date" value="" id="btime"></td>
                </tr>
                <tr>
                    <td>预防要点：</td>
                    <td><input name="prescriptionPrecautions" type="text" value="" id="prescriptionPrecautions"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="提交" id="submitPrescription"></td>
                </tr>
            </table>
                <h4 id="msg2"></h4>
        </div>
                <script>
            $(document).ready(function(){
                //处理id为submitBtn按钮的点击事件
                $("#submitPrescription").click(function(){
                    
                    $.ajax({
                        url: "patient/prescription/insert",
                        type: 'GET',
                        data: {"prescriptionPrecautions": $("#prescriptionPrecautions").val(),"prescriptionDate": $("#btime").val(),"prescriptionContent": $("#prescriptionContent").val(),"patientId": $("#patientId").val()},
                        success: function(sh){ //success对应的函数可有参数，该参数表示服务器返回的数据
                            //将id为msg的h2的内容设置为服务器返回的内容
                            $("#msg2").html("插入成功");
                        },
                        error: function(){
                            alert("失败");
                        } //最后一个属性不要加逗号
                    });
                }); 
            });
        </script>
    </body>
</html>
