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

            <table id="dietAdviceTable" class="ui purple table">

            </table>
            <div>
                <p id="pageText_dietAdvice"></p>
                <div id="dietAdvicePageButtons" class="mini ui basic buttons">

                </div>
                <div>
                    <label for="" class="ui label">跳转到：</label>
                    <!--发送ajax请求-->
                    <select id="pageSelecter_dietAdvice" class="mini ui button basic dropdown">
                        <option value="">页码</option>


                    </select>
                </div>
            </div>
        </div>


        <script>

            $(document).ready(function () {
                $("#dietAdvice").click(function () {
                    var url = 'dietAdviceList/${patient.patientId}/page_key_word';
                    fillForm("dietAdvicePageButtons", "pageText_dietAdvice", "pageSelecter_dietAdvice", currentPage = 1, url, showdietAdviceTable, getdietAdviceItemNum);
                });

                $("#pageSelecter_dietAdvice").on("change", function () {
                    var url = 'dietAdviceList/${patient.patientId}/page_key_word';
                    goToThPage("dietAdvicePageButtons", "pageText_dietAdvice", "pageSelecter_dietAdvice", url, showdietAdviceTable, getdietAdviceItemNum);
                });
            });

            function showdietAdviceTable(data) {
                $("#dietAdviceTable").empty();
                $("#dietAdviceTable").append("<thead><tr> <th>建议编号</th><th>病人姓名</th><th>建议日期</th><th>建议内容</th><th>查看详情</th></tr></thead>");
                $.each(data, function (index, dietAdvice) {
                    var str = "<tr id=" + dietAdvice.dietAdviceId + ">\n\
                    <td>" + dietAdvice.dietAdviceId + "</td><td>${patient.patientName}</td>\n\
                    <td>" + formatDatebox(dietAdvice.dietAdviceTime) + "</td>\n\
                    <td>" + dietAdvice.dietAdviceContent + "</td>\n\
                    <td> <a  class='ui button small blue' href='dietAdviceDetails/" + dietAdvice.dietAdviceId + "'>查看</a> </td>\n\</tr>"

                    $("#dietAdviceTable").append(str);
                });
            }
            function getdietAdviceItemNum() {
                var itemNum = 0;
                $.ajax({
                    url: "dietAdviceListItemNumber/${patient.patientId}",
                    type: 'POST',
                    async: false,
                    data: {},
                    success: function (data, textStatus, jqXHR) {
                        //返回List项目总数量
                        itemNum = data
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        toastError("请求失败，请重试！"+errorThrown);
                        //alert("请求失败，请重试！");
                    }
                });
                return itemNum;
            }
        </script>

    </body>
</html>
