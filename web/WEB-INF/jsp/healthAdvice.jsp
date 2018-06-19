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
        <div class="container container-outer">
        <div class="container-inner">
            <table id="healthAdviceTable" class="ui green table">

            </table>
        </div>
            <div>
                <p id="pageText_healthAdvice"></p>
                <div id="healthAdvicePageButtons" class="mini ui basic buttons">

                </div>
                <div>
                    <label for="" class="ui label">跳转到：</label>
                    <!--发送ajax请求-->
                    <select id="pageSelecter_healthAdvice" class="mini ui button basic dropdown">
                        <option value="">页码</option>


                        <!--<option value="1">1</option>-->
                    </select>
                </div>
            </div>
        </div>

        <script>


            $(document).ready(function () {
                $("#healthAdvice").click(function () {
                    var url = 'healthAdviceList/${patient.patientId}/page_key_word';
                    fillForm("healthAdvicePageButtons", "pageText_healthAdvice", "pageSelecter_healthAdvice", currentPage = 1, url, showHealthAdviceTable, getHealthAdviceItemNum);
                });

                $("#pageSelecter_healthAdvice").on("change", function () {
                    var url = 'healthAdviceList/${patient.patientId}/page_key_word';
                    goToThPage("healthAdvicePageButtons", "pageText_healthAdvice", "pageSelecter_healthAdvice", url, showHealthAdviceTable, getHealthAdviceItemNum);
                });
            });
            function showHealthAdviceTable(data) {
                $("#healthAdviceTable").empty();
                $("#healthAdviceTable").append("<thead><tr> <th>建议编号</th><th>病人姓名</th><th>建议日期</th><th>建议内容</th><th>查看详情</th></tr></thead>");
                $.each(data, function (index, healthAdvice) {
                    var str = "<tr id=" + healthAdvice.precautionAdviceId + ">\n\
                    <td>" + healthAdvice.precautionAdviceId + "</td><td>${patient.patientName}</td>\n\
                    <td><label class=\"mylabel\" data-content=\"" +  formatDatebox(healthAdvice.dietAdviceTime)  + "\" data-position=\"right center\">" + formatDatebox(healthAdvice.dietAdviceTime) + "</label></td>\n\
                    <td><label class=\"mylabel\" data-content=\"" +  healthAdvice.precautionAdviceContent + "\" data-position=\"right center\">" + healthAdvice.precautionAdviceContent + "</label></td>\n\
                    <td> <a  class='ui button small blue' href='healthAdviceDetails/" + healthAdvice.precautionAdviceId + "'>查看</a> </td>\n\</tr>";

                    $("#healthAdviceTable").append(str);
                });
            }
            
            $(document).on("mouseover", ".mylabel", function () {
                $(this).popup("show");
            });
            function getHealthAdviceItemNum() {
                var itemNum = 0;
                $.ajax({
                    url: "healAdviceListItemNumber/${patient.patientId}",
                    type: 'POST',
                    async: false,
                    data: {},
                    success: function (data, textStatus, jqXHR) {
                        //返回List项目总数量
                        itemNum = data
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        toastError("请求失败，请重试！" + errorThrown);
//                        alert("请求失败，请重试！");
                    }
                });
                return itemNum;
            }
        </script>

    </body>
</html>
