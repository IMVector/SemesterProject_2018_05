<%-- 
    Document   : medicalRecord
    Created on : 2018-5-19, 10:30:04
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>个人病例</title>
        <jsp:include page="resourcesTemplete.jsp"/>
    </head>
    <body>
        <jsp:include page="patientHeaderTemplete.jsp"/>
        <div class="container container-outer">
        <div class="container-inner">
            <table id="prescriptionTable" class="ui olive table">


            </table>
        </div>

            <div>
                <p id="pageText_2"></p>
                <div id="prescriptionPageButtons" class="mini ui basic buttons">

                </div>
                <div>
                    <label for="" class="ui label">跳转到：</label>
                    <!--发送ajax请求-->
                    <select id="pageSelecter_2" class="mini ui button basic dropdown">
                        <option value="">页码</option>
                        <!--<option value="1">1</option>-->
                    </select>
                </div>
            </div>
        </div>

    </body>
    <script>
        $(document).ready(function () {
            $("#prescription").click(function () {
                var url = 'prescriptionList/${patient.patientId}/page_key_word';
                fillForm("prescriptionPageButtons", "pageText_2", "pageSelecter_2", currentPage = 1, url, showPrescriptionTable, getPrescriptionListItemNum);


            });
            $("#pageSelecter_2").on("change", function () {
                var url = 'prescriptionList/${patient.patientId}/page_key_word';
                goToThPage("prescriptionPageButtons", "pageText_2", "pageSelecter_2", url, showPrescriptionTable, getPrescriptionListItemNum);

            });
        });

        function showPrescriptionTable(data) {
            $("#prescriptionTable").empty();
            $("#prescriptionTable").append("<thead><tr> <th>处方编号</th><th>病人姓名</th><th>处方日期</th><th>处方内容</th><th>注意事项</th><th>查看详情</th></tr></thead>");
            $.each(data, function (index, prescription) {
                var str = "<tr id=" + prescription.prescriptionId + ">\n\
                    <td>" + prescription.prescriptionId + "</td><td>${patient.patientName}</td>\n\
                    <td><label class=\"mylabel\" data-content=\"" +  formatDatebox(prescription.prescriptionDate) + "\" data-position=\"right center\">" + formatDatebox(prescription.prescriptionDate) + "</label></td>\n\
                    <td><label class=\"mylabel\" data-content=\"" +  prescription.prescriptionContent + "\" data-position=\"right center\">" + prescription.prescriptionContent + "</label></td>\n\
                    <td><label class=\"mylabel\" data-content=\"" +  prescription.prescriptionPrecautions + "\" data-position=\"right center\">" + prescription.prescriptionPrecautions + "</label></td>\n\
                    <td> <a  class='ui button small blue' href='prescriptionDetails/" + prescription.prescriptionId + "'>查看</a> </td>\n\</tr>"

                $("#prescriptionTable").append(str);
            });
        }
        $(document).on("mouseover", ".mylabel", function () {
            $(this).popup("show");
        });
        function getPrescriptionListItemNum() {
            var itemNum = 0;
            $.ajax({
                url: "prescriptionListItemNumber/${patient.patientId}",
                type: 'POST',
                async: false,
                data: {},
                success: function (data, textStatus, jqXHR) {
                    //返回List项目总数量
                    itemNum = data
                },
                error: function (jqXHR, textStatus, errorThrown) {
//                    alert("请求失败，请重试！");
                    toastError("请求失败,请重试！" + errorThrown);
                }
            });
            return itemNum;
        }
    </script>
</html>
