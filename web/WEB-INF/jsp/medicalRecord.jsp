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
        <script type="text/javascript" src="resources/js/jqPaginator.js"/>
        <title>个人病例</title>
        <jsp:include page="resourcesTemplete.jsp" />
    </head>

    <body>
        <jsp:include page="patientHeaderTemplete.jsp" />
        <%--<jsp:include page="persionalCenterTemplete.jsp"/>--%>
        <div class="container">
            <table id="medicalRecordTable" class="ui blue table">
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

            <div>
                <p id="pageText"></p>
                <div class="mini ui basic buttons">

                </div>
                <div>
                    <label for="" class="ui label">跳转到：</label>
                    <!--发送ajax请求-->
                    <select class="mini ui button basic dropdown">
                        <option value="">页码</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                    </select>
                </div>
            </div>
            <div id="pageNumber" class="nonevisiual"></div>
        </div>
    </body>
    <script>
        $(document).ready(function () {
            $('.ui.buttons').jqPaginator({
                totalPages: 100,
                visiblePages: 5,
                currentPage: 1,
                first: '  <button class="ui button">首页</button>',
                prev: '   <button  class="ui button">上一页</button>',
                next: '  <button  class="ui button">下一页</button>',
                last: ' <button  class="ui button">尾页</button>',
                page: ' <button class="ui basic button btn">{{page}}</button>',
                activeClass: 'blue',
                onPageChange: function (num) {
                    $('#pageText').html('当前第' + num + '页');
                    //发送ajax请求
                }
            });


            function getMedicalRecord(currentPage) {
                $.ajax({
                    url: 'medicalRecordList/${patient.patientId}/'+currentPage,
                    type: 'POST',
                    data: {},
                    success: function (data) {
                        $("#medicalRecordTable").empty();
                        $("#medicalRecordTable").append("<thead><tr> <th>病例编号</th><th>病人姓名</th><th>病例日期</th><th>诊查情况</th><th>诊查医生</th><th>查看详情</th></tr></thead>");
                        $.each(data, function (index, medicalRecord) {
                            var str = "<tr id=" + medicalRecord.medicalRecordId + ">\n\
                    <td>" + medicalRecord.medicalRecordId + "</td><td>${patient.patientName}</td>\n\
                    <td>" + formatDatebox(medicalRecord.inDate) + "</td>\n\
                    <td>" + medicalRecord.inDiagnosis + "</td>\n\
                    <td>" + medicalRecord.doctorName + "</td>\n\
                    <td> <a  class='ui button small blue' href='medicalRecordDetails/" + medicalRecord.medicalRecordId + "'>查看</a> </td>\n\</tr>"

                            $("#medicalRecordTable").append(str);
                        });
                    }, error: function (req, status, error) {
                        alert("请求失败，请重试！");
                    }

                });
            }

            $("#medicalRecord").click(function () {

            });


        });

    </script>
</html>