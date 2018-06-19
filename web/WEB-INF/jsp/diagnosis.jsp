<%-- 
    Document   : diagnosis
    Created on : 2018-6-9, 19:08:47
    Author     : 刘福港
<td><a href=\"diagnosis/getDietAdvice?patientId="+patient.patientId+"\">编辑饮食建议</a>&nbsp;&nbsp;&nbsp;<a href=\"diagnosis/getMedicalHistory?patientId="+patient.patientId+"\">查看药物历史</a>&nbsp;&nbsp;&nbsp;<a href=\"diagnosis/getPrescription?patientId="+patient.patientId+"\">编辑处方信息</a></td>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="${pageContext.request.contextPath}/">
        <script src="resources/js/jquery-3.2.1.min.js"></script>
        <title>诊断页面</title>
    </head>
    <body>
        <div>
            <h4>输入病人ID查看信息：</h4>
            <input id="patientId" type="text" name="patientId">
            <input id="submit" type="submit" value="查看病人相关信息">
        </div>
        <table id="patientDetail" >
            
<!--            <tr>
                <td>姓名：</td>
                <td></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td></td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td></td>
            </tr>
            <tr>
                <td>血型</td>
                <td></td>
            </tr>
            <tr>
                <td>出生日期：</td>
                <td></td>
            </tr>-->
            
        </table>
        <script>
            $(document).ready(function () {
                $("#submit").click(function () {
                    $.ajax({
                        url: 'diagnosis/getPatient',
                        type: 'POST',
                        data: {"patientId":$("#patientId").val()},
                        success: function(patient){ //返回的数据是一个学生对象
                            $("#patientDetail").empty(); //清空表格内容
                            $("#patientDetail").append("<tr><th>姓名</th><th>性别</th><th>年龄</th><th>血型</th></tr>");
                            var str="<tr id="+patient.patientId+"><td>"+patient.patientName+"</td><td>"
                                    +patient.patientGender+"</td><td>"+patient.patientAge+"</td><td>"+patient.bloodType+"</td></tr>";
                                $("#patientDetail").append(str);// 将当前学生的数据追加到表格中
                       
                                $("#LpatientName").val(patient.patientName);
                                $("#LpatientId").val(patient.patientId);
                                $("#LFGpatientName").val(patient.patientName);
                                $("#LFGpatientId").val(patient.patientId)
    },
                        error: function (jqXHR, textStatus, errorThrown) {
                        alert(errorThrown);
                    }
                    });
                });
            });
        </script>
<!--        <a href="patient/getMedicalRecord?patientId="></a>-->
    </body>
</html>
