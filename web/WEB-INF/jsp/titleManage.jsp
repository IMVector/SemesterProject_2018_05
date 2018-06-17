<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <jsp:include page="resourcesTemplete.jsp" />
    </head>

    <body>
        <jsp:include page="adminHeaderIndex.jsp" />

        <div class="ui fluid-container body-under-header">
            <div class="ui segment ">

                <div class="ui grid">

                    <jsp:include page="adminMenuTemplete.jsp"/>
                    <div class="eleven wide column">
                        <div class="ui segment container-admin-outer">
                            <div class="ui header blue segment">
                                职称管理
                            </div>

                            <table>
                                <tr>
                                    <td>
                                        <div class="ui input focus">
                                            <input id="titleName" placeholder="职称名称" type="text">
                                        </div>
                                    </td>
                                    <td> 
                                        <button id="getByName" class="ui basic button blue">查询指定职称信息</button>
                                    </td>
                                    <td>
                                        <button id="getAllBtn" class="ui basic button blue">查询所有职称信息</button>
                                    </td>
                                    <td>
                                        <button id="add" class="ui basic button blue">添加职称</button>
                                    </td>
                                </tr>
                            </table>
                            <div class="container-admin-inner">
                                <table id="titleTable" class="ui table blue">
                                </table>
                            </div>
                            <div>
                                <p id="pageText"></p>
                                <div id="PageButtons" class="mini ui basic buttons">

                                </div>
                                <!--<div>-->
                                <label for="" class="ui label">跳转到：</label>
                                <!--发送ajax请求-->
                                <select id="pageSelecter" class="mini ui button basic dropdown">
                                    <option value="">页码</option>


                                    <!--<option value="1">1</option>-->
                                </select>
                                <!--</div>-->
                            </div>
                            <div>
                                <button id="selectAll" class="ui button blue">全选</button>
                                <button id="updateAll" class="ui button blue">全部更新</button>
                                <button id="deleteAll" class="ui button blue">全部删除</button>
                            </div>



                        </div>
                    </div>
                </div>
            </div>
            <div id="modeltest" class="ui inverted modal ">
                <div class="header">添加职称</div>
                <div class="content" style="text-align:center">
                    <div class="ui segment" style="width: 50%;margin: 0 auto">
                        <div class="ui header blue segment">职称信息</div>
                        <form id="myForm">
                            <div class="field">
                                <label for="">职称名称：</label>
                                <div class="ui input ">
                                    <input id="medicationName" name="titleName" placeholder="职称名称" type="text">
                                </div>
                            </div>
                            <br/>
                            <div class="field">
                                <label for="">职称说明：</label>
                                <div class="ui input ">
                                    <input id="medicationInstructions" name="titleDescription" placeholder="职称说明" type="text">
                                </div>
                            </div>
                            <br/>
                            <button type="reset" class="ui negative button">清空</button>
                            <button type="button" id="addTitle" class="ui positive button">添加</button>
                            <div class="field">
                                <label id="result" class="ui header blue"></label>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="actions">
                    <div class="ui black deny button">放弃</div>
                    <div class="ui positive button">关闭</div>
                </div>
            </div>
            <jsp:include page="warningModel.jsp"/>
        </div>
        <!-- /container -->
        <jsp:include page="footerTemplete.jsp" />
    </body>
    <script>


        $(document).ready(function () {

            $("#getByName").on("click", function () {
                var name = $("#titleName").val();
                var url = "getTitleByName/" + name;
                fillForm("PageButtons", "pageText", "pageSelecter", currentPage = 1, url, titleTableInfo, function () {
                    return 1
                });
            });

            $("#getAllBtn").click(function () {
                var url = 'titleList/page_key_word';
                fillForm("PageButtons", "pageText", "pageSelecter", currentPage = 1, url, titleTableInfo, getMedicationItemNumber);
            });

            $("#pageSelecter").on("change", function () {
                var url = 'titleList/page_key_word';
                goToThPage("PageButtons", "pageText", "pageSelecter", url, titleTableInfo, getMedicationItemNumber);
            });
            //全部更新
            $("#updateAll").on("click", function () {
                if ($(this).text() == "全部更新") {
                    $(this).text("全部保存");
                } else {
                    $(this).text("全部更新");

                    //发送ajax请求更新全部选中
                    $(".ui.toggle.checkbox").each(function (index, element) {
                        if ($(this).checkbox("is checked")) {
                            var id, name, description;
                            id = $(this).closest("tr").attr("id")
                            $(this).closest("tr").find(".myInput").each(function (index, element) {
                                //1、药品名称
                                //2、适用症状
                                //3、说明
                                //4、价格
                                //5、生产日期
                                //6、有效期
                                //在这里发送ajax请求    
                                switch (index) {
                                    case 0:
                                        id = $(this).val();
                                        break;
                                    case 1:
                                        name = $(this).val();
                                        break;
                                    case 2:
                                        description = $(this).val();
                                }
                            });
//                            alert(id + ", " + name + "," + description)
                            $.ajax({
                                url: "updateTitle",
                                type: 'POST',
                                data: {"titleId": id, "titleName": name, "titleDescription": description},
                                success: function (data, textStatus, jqXHR) {
                                    if (data) {
//                                        alert(id);
                                        $("#" + id).find(".mylabel").each(function (index, element) {
                                            switch (index) {
                                                case 0:
                                                    $(this).html(id);
                                                    break;
                                                case 1:
                                                    $(this).html(name);
                                                    break;
                                                case 2:
                                                    $(this).html(description);
                                                    break;
                                            }
                                        })
//                                        alert('更新成功');
                                        toastSuccess("更新成功");
                                    } else {
//                                        alert("更新失败");
                                        toastError("更新失败");
                                    }
                                }, error: function (jqXHR, textStatus, errorThrown) {
//                                    alert("请求失败" + errorThrown);
                                    toastError("请求失败,请重试！" + errorThrown);
                                }
                            });
                        }

                    });
                    $("#selectAll").click();//关闭checkbox
                }
                $(".ui.toggle.checkbox").each(function (index, element) {
                    if ($(this).checkbox("is checked")) {
                        $(this).closest("tr").find(".nonevisiual").addClass("ui input");
                        $(this).closest("tr").find(".table-label").removeClass("mylabel");
                        $(this).closest("tr").find(".table-label").addClass("nonevisiual");
                    } else {
                        $(this).closest("tr").find(".table-label").removeClass("nonevisiual");
                        $(this).closest("tr").find(".table-label").addClass("mylabel");
                        $(this).closest("tr").find(".nonevisiual").removeClass("ui input");
                    }
                });

            });

            //弹出添加model框
            $("#add").click(function () {
                $('#modeltest')
                        .modal({
                            inverted: true,
                            closable: false,
                            onDeny: function () {

                                return true;
                            },
                            onApprove: function () {
                                $("input").each(function () {
                                    $(this).val("");
                                })
                            }
                        })
                        .modal('show')
                        ;
            });

            //添加一个
            $("#addTitle").on("click", function () {
                $.ajax({
                    url: 'addTitle',
                    type: 'POST',
                    async: false,
                    data: $("#myForm").serialize(), //将表单的数据编码成一个字符串提交给服务器
                    success: function (data) {
                        if (data) {
                            toastSuccess("添加成功");
                        } else {
                            toastError("添加失败");
                        }
                    },
                    error: function (req, status, error) {
//                        alert("Ajax请求失败!" + error);
                        toastError("请求失败,请重试！" + errorThrown);
                    }
                });
            });

            //修改一个
            $(document).on('click', '.updatebtn', function () {
                if ($(this).text() == "修改") {
                    $(this).text("保存");
                    var checkBox = $(this).closest("tr").find(".ui.toggle.checkbox");
                    $(this).closest("tr").find(".ui.toggle.checkbox").checkbox("check");
                    if (checkBox.checkbox("is checked")) {
                        //选中
                        $(this).closest("tr").find(".nonevisiual").addClass("ui input");
                        $(this).closest("tr").find(".table-label").removeClass("mylabel");
                        $(this).closest("tr").find(".table-label").addClass("nonevisiual");
                    }


                } else {
                    $(this).text("修改");
                    var checkBox = $(this).closest("tr").find(".ui.toggle.checkbox");
                    $(this).closest("tr").find(".ui.toggle.checkbox").checkbox("uncheck");
                    if (!checkBox.checkbox("is checked")) {
                        //去除选中状态
                        $(this).closest("tr").find(".table-label").removeClass("nonevisiual");
                        $(this).closest("tr").find(".table-label").addClass("mylabel");
                        $(this).closest("tr").find(".nonevisiual").removeClass("ui input");
                    }
                    //发送ajax请求更新当前
                    var id, name, description;
                    $(this).closest("tr").find(".myInput").each(function (index, element) {
                        //1、药品名称
                        //2、适用症状
                        //3、说明
                        //4、价格
                        //5、生产日期
                        //6、有效期
                        //在这里发送ajax请求    
                        switch (index) {
                            case 0:
                                id = $(this).val();
                                break;
                            case 1:
                                name = $(this).val();
                                break;
                            case 2:
                                description = $(this).val();
                                break;
                        }
                    });
//                alert(id + ", " + name + ", " + instructions + ", " + description + ", " + price + ", " + productionDate + ", " + validatePeriod)
                    $.ajax({
                        url: "updateTitle",
                        type: 'POST',
                        data: {"titleId": id, "titleName": name, "titleDescription": description},
                        success: function (data, textStatus, jqXHR) {
                            if (data) {
                                $("#" + id).find(".mylabel").each(function (index, element) {
                                    switch (index) {
                                        case 0:
                                            $(this).html(id);
                                            break;
                                        case 1:
                                            $(this).html(name);
                                            break;
                                        case 2:
                                            $(this).html(description);
                                            break;
                                    }
                                })
//                                alert('更新成功');
                                toastSuccess("更新成功")
                            } else {
//                                alert("更新失败");
                                toastError("更新失败")
                            }
                        }, error: function (jqXHR, textStatus, errorThrown) {
//                            alert("请求失败" + errorThrown);
                            toastError("请求失败,请重试！" + errorThrown);
                        }
                    });

                }
            });

            //全部选中按钮事件
            $("#selectAll").on("click", function () {
                if ($(this).text() == "全选") {
                    $(this).text("取消全选");
                    $(".ui.toggle.checkbox").each(function () {
                        if (!$(this).checkbox("is checked")) {
                            $(this).checkbox("check");
                        }
                    });

                } else {
                    $(".ui.toggle.checkbox").each(function () {
                        if ($(this).checkbox("is checked")) {
                            $(this).checkbox("uncheck");
                        }
                    });
                    $(this).text("全选");
                }
            });
            //删除一行
            $(document).on('click', ".deleteBtn", function () {
                var id = $(this).closest("tr").attr("id");
//                alert(id)
                $.ajax({
                    url: "deleteTitle/" + id,
                    type: 'POST',
                    success: function (data, textStatus, jqXHR) {
                        if (data) {
                            $("#" + id).remove();
                            //alert("成功")
                            toastSuccess("删除成功")
                        } else {
                            toastError("删除失败,请重试！");
//                            alert("失败");
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
//                        alert("请求失败" + errorThrown)
                        toastError("请求失败,请重试！" + errorThrown);
                    }
                })

            });

            $("#deleteAll").on("click", function () {
                showWarning("全部删除", "全部删本页选中？", function () {
                    //发送ajax请求删除全部选中
                    $(".ui.toggle.checkbox").each(function (index, element) {
                        if ($(this).checkbox("is checked")) {
                            var id;
                            id = $(this).closest("tr").attr("id");
                            $("#" + id).find(".deleteBtn").click();
                        }
                    });
                });

            });
        });


//        //添加成功响应函数
//        function deleteSuccess(data) {
//            if (true == data) {
//                alert("成功")
//
//            } else {
//                alert("失败")
//            }
//        }

        function titleTableInfo(data) {
            $("#titleTable").empty();
            $("#titleTable").append("<thead><tr><th>选择</th><th>职称编号</th><th>职称</th><th>职称说明</th><th style=\"padding-left: 10%\" colspan=\"2\">操作</th></tr></thead>");
            $.each(data, function (index, title) {
                var str = " <tr id=" + title.titleId + "><td><div class=\"ui toggle checkbox\"><input name=\"public\" type=\"checkbox\"><label></label></div></td><td>\n\
                                        <label class=\"mylabel table-label\" >" + title.titleId + "</label>\n\<div class=\"nonevisiual\" ><input value=" + title.titleId + " class=\"myInput\" style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                    <label class=\"mylabel table-label\" data-content=\"" + title.titleName + "\" data-position=\"right center\">" + title.titleName + "</label><div class=\"nonevisiual\" ><input value=" + title.titleName + " class=\"myInput\"  style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                     <label class=\"mylabel table-label\"  data-content=\"" + title.titleDescription + "\" data-position=\"right center\">" + title.titleDescription + "</label><div class=\"nonevisiual\"><input value=" + title.titleDescription + " class=\"myInput\"  style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                        <button  class=\"ui button blue updatebtn\" >修改</button></td><td><button class=\"ui button blue deleteBtn\">删除</button></td></tr>";


                $("#titleTable").append(str);
            });
        }
        $(document).on("mouseover", ".mylabel", function () {
            $(this).popup("show");
        });

        function getMedicationItemNumber() {
            var itemNum = 0;
            $.ajax({
                url: "titleListItemNum",
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