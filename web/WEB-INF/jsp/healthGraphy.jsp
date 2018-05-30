<%-- 
    Document   : healthGraphy
    Created on : 2018-5-30, 14:38:18
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="resourcesTemplete.jsp" />
        <title>健康可视化</title>
    </head>

    <body>

        <div class="ui container">
            <div class="ui segment">
                <canvas id="chart_1"></canvas>
                <select id="yearSelecter" class="mini ui button basic dropdown">
                    <option value="">选择年份</option>
                    <!--<option value="1">1</option>-->
                </select>
                <button id="showChart" class="ui blue button">查看该年份的就医次数</button>

            </div>
            <div class="ui segment">
                <canvas id="chart_2"></canvas>
                <select id="yearSelecter" class="mini ui button basic dropdown">
                    <option value="">选择年份</option>
                    <!--<option value="1">1</option>-->
                </select>
                <button id="showChart" class="ui blue button">查看该年份的就医花费</button>
            </div>
        </div>

    </body>
    <script>
        $("#showChart").click(function () {

            //            var year = $("#yearSelecter").val();
            var year = 2018;
            var url = "graphy_times/${patient.patientId}/" + year;
            getSomethingByAjax(url, changeValue);
        })
        function changeValue(data) {

            var MONTHS = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
            var config = {
                type: 'line',
                data: {
                    labels: MONTHS,
                    datasets: [{
                            label: "就医次数",
                            backgroundColor: window.chartColors.blue,
                            borderColor: window.chartColors.blue,
                            data: [
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                data[4],
                                data[5],
                                data[6],
                                data[7],
                                data[8],
                                data[9],
                                data[10],
                                data[11]
                            ],
                            fill: false,
                        }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: '就医次数统计'
                    },
                    tooltips: {
                        mode: 'index',
                        intersect: false,
                    },
                    hover: {
                        mode: 'nearest',
                        intersect: true
                    },
                    scales: {
                        xAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: '月份'
                                }
                            }],
                        yAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: '次数'
                                }
                            }]
                    }
                }
            };
            var ctx = document.getElementById("chart_1").getContext("2d");
            window.myLine = new Chart(ctx, config);
        }

        var MONTHS = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        var color = Chart.helpers.color;
        var config = {
           type: 'bar',
            data: {
                labels: MONTHS,
                datasets: [{
                        label: '就医花费情况',
                        backgroundColor: color(window.chartColors.blue).alpha(0.5).rgbString(),
                        borderColor: window.chartColors.blue,
                        borderWidth: 1,
                        data: [
                            8, 60, 70, 80, 90, 100
                        ]
                    }]

            },
            options: {
                responsive: true,
                legend: {
                    position: 'top',
                },
                title: {
                    display: true,
                    text: '就医花费情况'
                }
            }
        };
        var ctx = document.getElementById("chart_2").getContext("2d");
        window.myLine = new Chart(ctx, config);

    </script>

</html>