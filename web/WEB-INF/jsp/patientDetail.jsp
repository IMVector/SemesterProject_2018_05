<%-- 
    Document   : patientDetail
    Created on : 2018-6-10, 13:24:30
    Author     : 刘福港
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <base href="${pageContext.request.contextPath}/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>个人信息</title>
        <link href="resources/css/login.css" type="text/css" rel="stylesheet"> 
    </head>
    <body style="background-image: url(resources/image/bg.png);overflow-y: visible"> 
        <form action="patient/updateDetail" method="post">
            <table>
                <tr>
                    <td style="text-align: center"><label for="qqq" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">用户ID:</label></td>
                <input type="hidden" value="${patientDetail.patientId}" name="patientId">
                <td><input id="qqq" type="text" value="${patientDetail.patientId}" name="" disabled="true"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="www" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">姓名:</label></td>
                    <td><input id="www" type="text" value="${patientDetail.patientName}" name="patientName"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="eee" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">出生日期:</label></td>
                    <td><input id="eee" type="date" value="${patientDetail.patientBirthday}" name="patientBirthday"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="rrr" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">性别:</label></td>
                    <td>
                        <select name="patientGender" id="rrr"  value="${patientDetail.patientGender}">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td style="text-align: center"><label for="ttt" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">血型:</label></td>
                    <td>
                        <select name="bloodType" id="ttt" value="${patientDetail.bloodType}">
                            <option value="A">A</option>
                            <option value="B">B</option>
                            <option value="O">O</option>
                            <option value="AB">AB</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="yyy" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">联系方式:</label></td>
                    <td><input id="yyy" type="text" value="${patientDetail.patientPhone}" name="patientPhone"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="uuu" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">家庭住址:</label></td>
                    <td><input id="uuu" type="text" value="${patientDetail.patientAddress}" name="patientAddress"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="iii" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">婚姻状况:</label></td>
                    <td>
                        <select name="patientMstatus" id="iii" value="${patientDetail.patientMstatus}">
                            <option value="是">已婚</option>
                            <option value="否">未婚</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="ooo" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">电子邮箱:</label></td>
                    <td><input id="ooo" type="text" value="${patientDetail.patientEmail}" name="patientEmail"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="ppp" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">密保问题:</label></td>
                    <td><input id="ppp" type="text" value="${patientDetail.patientQuestion}" name="patientQuestion"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="aaa" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">密保答案:</label></td>
                    <td><input id="aaa" type="text" value="${patientDetail.patientAnswer}" name="patientAnswer"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="sss" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">登陆密码:</label></td>
                    <td><input id="sss" type="text" value="${patientDetail.patientPassword}" name="patientPassword"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="提交"></td>
                </tr>
            </table>
                <h4 style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">${isSuccess}</h4>
        </form>
    </body>
</html>
