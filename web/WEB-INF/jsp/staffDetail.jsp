<%-- 
    Document   : staffDetail
    Created on : 2018-6-10, 14:01:17
    Author     : 刘福港
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>个人信息</title>
        <link href="resources/css/login.css" type="text/css" rel="stylesheet"> 
    </head>
    <body style="background-image: url(resources/image/bg.png) "> 
        <form action="staff/updateDetail" method="post">
            <table >
                <tr>
                    <td style="font-size: 20px">员工编号：</td>
                    <td><input  type="text" value="${staffDetail.staffId}" disabled="true">
                        <input name="staffId" type="hidden" value="${staffDetail.staffId}">
                    </td>
                </tr>
                <tr>
                    <td style="font-size: 20px">职位：</td>
                <input type="hidden" value="${staffDetail.titleId}" name="titleId">
                    <td><input type="text" value="${staffDetail.title.titleName}" disabled="true"></td>
                    <td><input type="hidden" name="titleName" value="${staffDetail.title.titleName}" ></td>
                </tr>
                <tr>
                    <td style="font-size: 20px">姓名：</td>
                    <td><input type="text" value="${staffDetail.staffName}" name="staffName"></td>
                </tr>
                <tr>
                    <td style="font-size: 20px">部门编号：</td>
                    <td><input type="text" value="${staffDetail.departmentId}" disabled="true" name="departmentId">
                        <input type="hidden" value="${staffDetail.departmentId}" name="departmentId">
                    </td>
                </tr>
                <tr>
                    <td style="font-size: 20px">密保问题：</td>
                    <td><input type="text" value="${staffDetail.staffQuestion}" name="staffQuestion"></td>
                </tr>
                <tr>
                    <td style="font-size: 20px">密保答案：</td>
                    <td><input type="text" value="${staffDetail.staffAnswer}" name="staffAnswer"></td>
                </tr>
                <tr>
                    <td style="font-size: 20px">密码：</td>
                    <td><input type="text" value="${staffDetail.staffPassword}" name="staffPassword"></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><input type="submit" value="提交"></td>
                </tr>
            </table>
                    <h3>${isSuccess}</h3>
        </form>
    </body>
</html>
