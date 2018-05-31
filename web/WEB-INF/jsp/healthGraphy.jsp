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
            <div id="canvasContainer_1" class="ui segment">
                <canvas id="chart_1"></canvas>
                <select id="yearSelecter_1" class="mini ui button basic dropdown">
                    <option value="">选择年份</option>
                    <!--<option value="1">1</option>-->
                </select>
                <button id="showChart" class="ui blue button">查看该年份的就医次数</button>

            </div>
            <div class="ui segment">
                <canvas id="chart_2"></canvas>
                <select id="yearSelecter_2" class="mini ui button basic dropdown ">
                    <option value="">选择年份</option>
                    <!--<option value="1">1</option>-->
                </select>
                <button id="showChart" class="ui blue button">查看该年份的就医花费</button>
                <a href="medicalRecordYearSet/${patient.patientId}">年份</a>
            </div>
        </div>

    </body>
    <script>
        var year = 0;
        $("#showChart").click(function () {

            //            var year = $("#yearSelecter").val();
            var year = $("#yearSelecter_1").val();
            var url = "graphy_times/${patient.patientId}/" + year;
            getSomethingByAjax(url, changeValue);
        })
        $(document).ready(function () {
            var url = "medicalRecordYearSet/${patient.patientId}/";
            getSomethingByAjax(url, getYearSet);

        });

        function getYearSet(data) {
            $("#yearSelecter_1").empty();
            $("#yearSelecter_2").empty();
            $("#yearSelecter_1").append('<option value="0">年份</option>');
            $("#yearSelecter_2").append('<option value="0">年份</option>');

            for (var i = 0; i < data.length; i++) {

                $("#yearSelecter_1").append('<option value=' + data[i] + '>' + data[i] + '</option>');
                $("#yearSelecter_2").append('<option value=' + data[i] + '>' + data[i] + '</option>');
            }
        }

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
            
            
            
            var i = 0;
            config.data.datasets.forEach(function (dataset) {
                dataset.data = dataset.data.map(function () {
                    console.log(data[i]);
                    return data[i++];

                });
            });

            //清空画布
            if (!!(document.getElementById("chart_1"))) {
                document.getElementById("chart_1").remove();
            }
            $('#canvasContainer_1').prepend('<canvas id="chart_1"></canvas>');
            
            var ctx = document.getElementById("chart_1").getContext("2d");
            window.myLine = new Chart(ctx, config);
            window.myLine.update();
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
                            0, 0, 0, 0, 0, 0,0,0,0,0,0,0
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