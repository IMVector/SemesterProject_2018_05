<%-- 
    Document   : LCheckRecord
    Created on : 2018-6-11, 16:46:14
    Author     : NIIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>编辑诊断记录</title>
    </head>
    <body>
        <form action="patient/insertMedicalRecord" method="post">
            <table >
                <input type="hidden" value="${staffDetail}" name="staff">
                <input type="hidden" value="${staffDetail.departmentId}" name="department">
                <tr>
                    <td>医生姓名：</td>
                    <td><input type="text" disabled="true" value="${staffDetail.staffName}" name="doctorName"></td>
                </tr>
                
                <tr>
                    <td>病人姓名：</td>
                    <td><input type="text" disabled="true" value="${patient.patientName}"></td>
                </tr>
                <tr>
                    <td>入院时间：</td>
                    <td><input type="date" name="inDate"></td>
                </tr>
                <tr>
                    <td>入院诊断：</td>
                    <td><input type="text" name="inDiagnosis"></td>
                </tr>
                <tr>
                    <td>出院时间：</td>
                    <td><input type="date" name="outDate"></td>
                </tr>
                <tr>
                    <td>出院诊断：</td>
                    <td><input type="text" name="outDiagnosis"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
