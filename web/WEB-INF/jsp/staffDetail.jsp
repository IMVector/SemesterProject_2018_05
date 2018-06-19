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

        <link href="resources/css/signup.css" type="text/css" rel="stylesheet"> 

        <script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="resources/js/myScript.js"></script>
        <script type="text/javascript" src="resources/js/toast.js"></script>
    </head>
    <body style="background-image: url(resources/image/bg.png) "> 
        <form action="staff/updateDetail" method="post">
            <table >
                <tr>
                    <td style="font-size: 20px">员工编号：</td>
                    <td><input  type="text" value="${staffDetail.staffId}" readonly="true">
                        <input name="staffId" type="hidden" value="${staffDetail.staffId}">
                    </td>
                </tr>
                <tr>
                    <td style="font-size: 20px">职位：</td>
                <input type="hidden" value="${staffDetail.titleId}" name="titleId">
                <td><input type="text" value="${staffDetail.title.titleName}" readonly="true"></td>
                <td><input type="hidden" name="titleName" value="${staffDetail.title.titleName}" ></td>
                </tr>
                <tr>
                    <td style="font-size: 20px">姓名：</td>
                    <td><input type="text" value="${staffDetail.staffName}" name="staffName"></td>
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
                <input id="imageValue" name="staffImagePath" type="hidden" >
                </tr>
                <tr>
                    <td style="font-size: 20px">部门编号：</td>
                    <td><input type="text" value="${staffDetail.departmentId}" readonly="true" >
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
