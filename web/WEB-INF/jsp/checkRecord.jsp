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
        <div class="container container-outer">
            <div class="container-inner">
            <table id="checkRecordTable" class="ui teal table">
                <!--                        <thead>
                                    <tr>
                                        <th>病例编号</th>
                                        <th>病人姓名</th>
                                        <th>入院日期</th>
                                        <th>入院诊断</th>
                                        <th>诊查科室</th>
                                        <th>诊查医生</th>
                                        <th>诊查结果</th>
                                        <th>是否住院</th>
                                        <th>出院日期</th>
                                        <th>出院诊断</th>
                                        <th>查看详情</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><a  class="ui button small" href="medicalRecordDetails\1">查看</a></td>
                                    </tr>
                                </tbody>-->

            </table>
                </div>
            <div>
                <p id="pageText_1"></p>
                <div id="checkRecordButtons" class="mini ui basic buttons">

                </div>
                <div>
                    <label for="" class="ui label">跳转到：</label>
                    <!--发送ajax请求-->
                    <select id="pageSelecter_1" class="mini ui button basic dropdown">
                        <option value="">页码</option>
                        <!--<option value="1">1</option>-->
                    </select>
                </div>
            </div>
            <!--<div id="pageNumber_1" class="nonevisiual"></div>-->
        </div>
    </body>
    <script>

        $(document).ready(function () {
            $("#chaeckRecord").click(function () {
                var url = 'checkRecordList/${patient.patientId}/page_key_word';
                fillForm("checkRecordButtons", "pageText_1", "pageSelecter_1", currentPage = 1, url, checkRecordTableShow, getCheckRecordItemNumber);
            });
            $("#pageSelecter_1").on("change",function () {
                var url = 'checkRecordList/${patient.patientId}/page_key_word';
                goToThPage("checkRecordButtons", "pageText_1", "pageSelecter_1", url, checkRecordTableShow, getCheckRecordItemNumber);
            });
        });


        function checkRecordTableShow(data) {
        
            $("#checkRecordTable").empty();
            $("#checkRecordTable").append("<thead><tr> <th>检查编号</th><th>病人姓名</th><th>检查项目</th><th>检查日期</th><th>查看详情</th></tr></thead>");
            $.each(data, function (index, checkRecord) {
                var str = "<tr id=" + checkRecord.checkRecordId + ">\n\
                   <td>"+checkRecord.checkRecordId+"</td>\n\
                    <td>${patient.patientName}</td>\n\
                    <td><label class=\"mylabel\" data-content=\"" + formatDatebox(checkRecord.checkDate)  + "\" data-position=\"right center\">" + checkRecord.checkItem.checkItemName + "</label></td>\n\
                    <td><label class=\"mylabel\" data-content=\"" + formatDatebox(checkRecord.checkDate)  + "\" data-position=\"right center\">" + formatDatebox(checkRecord.checkDate) + "</label></td>\n\
                    <td> <a  class='ui button small blue' href='checkRecordDetails/" + checkRecord.checkRecordId + "'>查看</a> </td>\n\</tr>";

                $("#checkRecordTable").append(str);
            });
        }

        $(document).on("mouseover", ".mylabel", function () {
            $(this).popup("show");
        });
        
        function getCheckRecordItemNumber() {
            var itemNum = 0;
            $.ajax({
                url: "checkRecordListItemNumber/${patient.patientId}",
                type: 'POST',
                async: false,
                data: {},
                success: function (data, textStatus, jqXHR) {
                    //返回List项目总数量
                    itemNum = data
                },
                error: function (jqXHR, textStatus, errorThrown) {
                      toastError("请求失败" + errorThrown);
                }
            });
            return itemNum;
        }

    </script>
</html>
