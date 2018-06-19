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
        <link href="resources/css/signup.css" type="text/css" rel="stylesheet"> 

        <script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="resources/js/myScript.js"></script>
        <script type="text/javascript" src="resources/js/toast.js"></script>
    </head>
    <body style="background-image: url(resources/image/bg.png);overflow-y: visible"> 
        <form action="patient/updateDetail" method="post">
            <table>
                <tr>
                    <td style="text-align: center"><label for="qqq" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">用户ID:</label></td>
                <input type="hidden" value="${patient.patientId}" name="patientId">
                <td><input id="qqq" type="text" value="${patient.patientId}" name="" disabled="true"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="www" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">姓名:</label></td>
                    <td><input id="www" type="text" value="${patient.patientName}" name="patientName"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input id="mySelect" type="button" value="选择头像">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input id="mysubmit" type="button" value="上传头像">

                    </td>
                <br>
                <br>
                <input id="imageValue" name="patientImagePath" type="hidden" >
                </tr>
                <tr>
                    <td style="text-align: center"><label for="eee" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">出生日期:</label></td>
                    <td><input id="eee" type="date" value="${patient.patientBirthday}" name="patientBirthday"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="rrr" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">性别:</label></td>
                    <td>
                        <select name="patientGender" id="rrr"  value="${patient.patientGender}">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td style="text-align: center"><label for="ttt" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">血型:</label></td>
                    <td>
                        <select name="bloodType" id="ttt" value="${patient.bloodType}">
                            <option value="A">A</option>
                            <option value="B">B</option>
                            <option value="O">O</option>
                            <option value="AB">AB</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="yyy" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">联系方式:</label></td>
                    <td><input id="yyy" type="text" value="${patient.patientPhone}" name="patientPhone"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="uuu" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">家庭住址:</label></td>
                    <td><input id="uuu" type="text" value="${patient.patientAddress}" name="patientAddress"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="iii" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">婚姻状况:</label></td>
                    <td>
                        <select name="patientMstatus" id="iii" value="${patient.patientMstatus}">
                            <option value="是">已婚</option>
                            <option value="否">未婚</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="ooo" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">电子邮箱:</label></td>
                    <td><input id="ooo" type="text" value="${patient.patientEmail}" name="patientEmail"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="ppp" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">密保问题:</label></td>
                    <td><input id="ppp" type="text" value="${patient.patientQuestion}" name="patientQuestion"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="aaa" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">密保答案:</label></td>
                    <td><input id="aaa" type="text" value="${patient.patientAnswer}" name="patientAnswer"></td>
                </tr>
                <tr>
                    <td style="text-align: center"><label for="sss" style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">登陆密码:</label></td>
                    <td><input id="sss" type="text" value="${patient.patientPassword}" name="patientPassword"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="提交"></td>
                </tr>
            </table>
            <h4 style="color:#27A9E3;text-decoration:none;cursor:pointer;font-size: 20px">${isSuccess}</h4>
        </form>


        <form style="display: none"  id="imageForm" enctype="multipart/form-data">
            <div> 
                <input id="select_file"  type="file" id="input-image" name="input-image"> 
            </div> 
        </form>
    </body>

    <script>
        $(document).on("click", "#mySelect", function () {
            $("#select_file").click();
        });

        $(document).on("click", "#mysubmit", function () {
            $.ajax({
                url: "upload/uploadImage/uploadPatientImage",
                type: 'POST',
                cache: false,
                data: new FormData($("#imageForm")[0]),
                processData: false,
                contentType: false,
                success: function (data) {
                    if (data == "Error") {
                        toastError("上传失败");
                    } else {
                        toastSuccess("上传成功");
                        $("#imageValue").val(data);
                    }

                },
                error: function (jqXHR, textStatus, errorThrown) {
                    toastError("请求失败，请重试！" + errorThrown);
                }
            });
        });

    </script>
</html>
