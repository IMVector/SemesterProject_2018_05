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

            <table id="billTable" class="ui orange table">
            

            </table>
            <div>
                <p id="pageText_3"></p>
                <div id="billButtons" class="mini ui basic buttons">

                </div>
                <div>
                    <label for="" class="ui label">跳转到：</label>
                    <!--发送ajax请求-->
                    <select id="pageSelecter_3" class="mini ui button basic dropdown">
                        <option value="">页码</option>
                        <!--<option value="1">1</option>-->
                    </select>
                </div>
            </div>
        </div>

    </body>
    <script>

        $(document).ready(function () {
            $("#bill").click(function () {
                 var url = 'billList/${patient.patientId}/page_key_word';
                fillForm("billButtons", "pageText_3", "pageSelecter_3", currentPage = 1, url, billTableShow, getbillItemNumber);
            });
            $("#pageSelecter_3").on("change", function () {
                 var url = 'checkRecordList/${patient.patientId}/page_key_word';
                goToThPage("billButtons", "pageText_3", "pageSelecter_3", url, billTableShow, getbillItemNumber);
            });
        });


        function billTableShow(data) {

            $("#billTable").empty();
            $("#billTable").append("<thead><tr> <th>账单编号</th><th>病人姓名</th><th>账单金额</th><th>账单日期</th>th>是否支付</th><th>查看详情</th></tr></thead>");
            $.each(data, function (index, bill) {
                var str = "<tr id=" + bill.billId + ">\n\
                  <td>" + bill.billId + "</td>\n\
                   <td>${patient.patientName}</td>\n\
                   <td>" + bill.totalAmount + "</td>\n\
                   <td>" + formatDatebox(bill.billDate) + "</td>\n\
                   <td>" + bill.paymentStatus + "</td>\n\
                   <td> <a  class='ui button small blue' href='billDetails/" + bill.billId + "'>查看</a> </td>\n\</tr>"

                $("#billTable").append(str);
            });


        }

        function getbillItemNumber() {
            var itemNum = 0;
            $.ajax({
                 url: "billListItemNumber/${patient.patientId}",
                type: 'POST',
                async: false,
                data: {},
                success: function (data, textStatus, jqXHR) {
                    //返回List项目总数量
                    itemNum = data
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("请求失败，请重试！错误码:1_1");
                }
            });
            return itemNum;
        }

    </script>
</html>
