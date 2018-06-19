<%-- 
    Document   : donorDetail
    Created on : 2018-6-9, 18:55:20
    Author     : 刘福港
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>捐献者个人信息</title>
    </head>
    <body>
        <table>
            <tr>
                <td>捐献者姓名：</td>
                <td>${donor.donorName}</td>
            </tr>
            <tr>
                <td>捐献者血型：</td>
                <td>${donor.donorBloodType}</td>
            </tr>
            <tr>
                <td>捐献者性别：</td>
                <td>${donor.donorGender}</td>
            </tr>
            <tr>
                <td>捐献者联系电话：</td>
                <td>${donor.donorPhone}</td>
            </tr>
            <tr>
                <td>捐献者家庭住址：</td>
                <td>${donor.donorAddress}</td>
            </tr>
            <tr>
                <td>血液是否在库：</td>
                <td>${donor.isInBank}</td>
            </tr>
        </table>
    </body>
</html>
