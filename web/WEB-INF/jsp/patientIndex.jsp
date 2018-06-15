<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <jsp:include page="resourcesTemplete.jsp" />
    </head>

    <body>

        <jsp:include page="patientHeaderTemplete.jsp" />

        <div class="ui container body-under-header">
            <div class="ui segment">
                <div class="ui header blue segment">医院内部导航</div>
                <div class="ui segment">
                    <div class="ui pointing menu">
                        <div id="tab_1" class="ui item active">一楼</div>
                        <div id="tab_2" class="ui item">二楼</div>
                        <div id="tab_3" class="ui item">三楼</div>
                        <div id="tab_4" class="ui item">三楼</div>
                        <div id="tab_5" class="ui item">四楼</div>
                        <div id="tab_6" class="ui item">五楼</div>
                    </div>
                    <div class="ui segment" style="text-align: center">
                        <img id="builderMap" src="resources/image/1楼.gif" alt="楼层分布">
                    </div>

                </div>
                <div class="ui header blue segment">科室导航</div>
                <div id="departmentList" class="ui segment">

                </div>

            </div>

        </div>

        <jsp:include page="footerTemplete.jsp" />
    </body>
    <script>
        $(document).ready(function () {


            $.ajax({
                url: "departmentList",
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    $("#departmentList").empty();
                    $.each(data, function (index, department) {
                        var str = "<a href=\"about\\"+department.departmentName +"\" class=\"ui blue button\">" + department.departmentName + " </a>"
                        $("#departmentList").append(str);
                    });
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    toastError("请求失败！" + errorThrown);
                }
            });




            $(".ui.item").on("click", function () {
                $(".ui.item").removeClass("active");//去掉所有active
                $(this).addClass("active");//给当前点击的active
                var id = $(this).attr("id");//获取当前Id
                id = id.replace("tab_", "");//替换不需要的内容
                var path = "resources/image/" + id + "楼.gif";//构造img的路径
                $("#builderMap").attr("src", path);//替换
            });
        });


        function departmentTableInfo(data) {
            $("#departmentList").empty();
            $("#departmentList").append("<thead><tr><th>选择</th><th>部门编号</th><th>部门名称</th><th>部门描述</th><th style=\"padding-left: 10%\" colspan=\"2\">操作</th></tr></thead>");
            $.each(data, function (index, department) {
                var str = " <tr id=" + department.departmentId + "><td><div class=\"ui toggle checkbox\"><input name=\"public\" type=\"checkbox\"><label></label></div></td><td>\n\
                                        <label class=\"mylabel table-label\" >" + department.departmentId + "</label>\n\<div class=\"nonevisiual\" ><input value=" + department.departmentId + " class=\"myInput\" style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                    <label class=\"mylabel table-label\" >" + department.departmentName + "</label><div class=\"nonevisiual\" ><input value=" + department.departmentName + " class=\"myInput\"  style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                     <label class=\"mylabel table-label\" >" + department.departmentDescription + "</label><div class=\"nonevisiual\"><input value=" + department.departmentDescription + " class=\"myInput\"  style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                        <button  class=\"ui button teal updatebtn\" >修改</button></td><td><button class=\"ui button teal deleteBtn\">删除</button></td></tr>";


                $("#departmentList").append(str);
            });
        }

        function getMedicationItemNumber() {
            var itemNum = 0;
            $.ajax({
                url: "departmentListItemNum",
                type: 'POST',
                async: false,
                data: {},
                success: function (data, textStatus, jqXHR) {
                    //返回List项目总数量
                    itemNum = data
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    toastError("请求失败，请重试！");
                }
            });
            return itemNum;
        }
    </script>
</html>