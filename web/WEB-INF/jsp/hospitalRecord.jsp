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
        <%--<jsp:include page="persionalCenterTemplete.jsp"/>--%>
        <div class="container">

            <table id="hospitalRecordTable" class="ui red table">


            </table>
            <div>
                <p id="pageText_hospitalRecord"></p>
                <div id="hospitalRecordPageButtons" class="mini ui basic buttons">

                </div>
                <div>
                    <label for="" class="ui label">跳转到：</label>
                    <!--发送ajax请求-->
                    <select id="pageSelecter_hospitalRecord" class="mini ui button basic dropdown">
                        <option value="">页码</option>


                    </select>
                </div>
            </div>



        </div>

        <script>

            $(document).ready(function () {
                $("#record").click(function () {
                    var url = 'getCheckRecordWithNoCheck/${patient.patientId}/page_key_word';
                    fillForm("hospitalRecordPageButtons", "pageText_hospitalRecord", "pageSelecter_hospitalRecord", currentPage = 1, url, showHospitalRecordTable, getHospitalRecordItemNum);
                });

                $("#pageSelecter_hospitalRecord").on("change", function () {
                    var url = 'getCheckRecordWithNoCheck/${patient.patientId}/page_key_word';
                    goToThPage("hospitalRecordPageButtons", "pageText_hospitalRecord", "pageSelecter_hospitalRecord", url, showHospitalRecordTable, getHospitalRecordItemNum);
                });
            });

            function showHospitalRecordTable(data) {
                $("#hospitalRecordTable").empty();
                $("#hospitalRecordTable").append("<thead><tr> <th>就医编号</th><th>病人姓名</th><th>就医日期</th><th>查看详情</th></tr></thead>");
                $.each(data, function (index, checkRecord) {
                var str = "<tr id=" + checkRecord.checkRecordId + ">\n\
                   <td>"+checkRecord.checkRecordId+"</td>\n\
                    <td>${patient.patientName}</td>\n\
                    <td>" + formatDatebox(checkRecord.checkDate) + "</td>\n\
                    <td> <a  class='ui button small blue' href='checkRecordDetailsWithNoCheck/" + checkRecord.checkRecordId + "'>查看</a> </td>\n\</tr>";
                    $("#hospitalRecordTable").append(str);
                });
            }
            function getHospitalRecordItemNum() {
                var itemNum = 0;
                $.ajax({
                    url: "checkRecordItemNumberWithNoCheck/${patient.patientId}",
                    type: 'POST',
                    async: false,
                    data: {},
                    success: function (data, textStatus, jqXHR) {
                        //返回List项目总数量
                        itemNum = data
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
//                        alert("请求失败，请重试！");
                        toastError("请求失败，请重试！" + errorThrown);
                    }
                });
                return itemNum;
            }
        </script>
    </body>
</html>
