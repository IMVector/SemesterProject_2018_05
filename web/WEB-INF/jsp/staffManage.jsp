<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <jsp:include page="resourcesTemplete.jsp" />
        <style>
            .mselect {
                border: 1px solid #DCDEE0;
                vertical-align: middle;
                border-radius: 3px;
                height: 40px;
                padding: 0px 16px;
                font-size: 14px;
                color: #555555;
                outline:none;
                width:100%;
                margin:0;
                list-style:none;
                box-sizing: border-box;
            }
            .mselect:focus {
                border: 1px solid #27A9E3;
            }
        </style>
    </head>

    <body>
        <jsp:include page="adminHeaderIndex.jsp" />

        <div class="ui fluid-container body-under-header">
            <div class="ui segment ">

                <div class="ui grid">

                    <jsp:include page="adminMenuTemplete.jsp"/>
                    <div class="eleven wide column">
                        <div class="ui segment">
                            <div class="ui header yellow segment">
                                职工管理
                            </div>
                            <table>
                                <tr>
                                    <td>
                                        <div class="ui input focus">
                                            <input id="staffName" placeholder="职工姓名" type="text">
                                        </div>
                                    </td>
                                    <td> 
                                        <button id="getByName" class="ui basic button yellow">查询指定姓名员工信息</button>
                                    </td>
                                    <td>
                                        <div class="ui input focus">
                                            <input id="staffTitle" placeholder="职工头衔" type="text">
                                        </div>
                                    </td>
                                    <td>
                                        <button id="getByTitle" class="ui basic button yellow">查询指定头衔员工信息</button>
                                    </td>

                                </tr>
                                <tr>
                                    <td>
                                        <button id="getAllBtn" class="ui basic button yellow">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp查询所有职工信息&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</button>
                                    </td>
                                    <td>
                                        <button id="add" class="ui basic button yellow">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp添加职工&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</button>
                                    </td>
                                </tr>
                            </table>
                            <div class="container-admin-inner">
                                <table id="staffTable" class="ui table yellow">
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
                                <button id="selectAll" class="ui button yellow">全选</button>
                                <button id="updateAll" class="ui button yellow">全部更新</button>
                                <button id="deleteAll" class="ui button yellow">全部删除</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="modeltest" class="ui inverted modal ">
                <div class="header">添加药品</div>
                <div class="content" style="text-align:center">
                    <div class="ui segment" style="width: 50%;margin: 0 auto">
                        <div class="ui header blue segment">药品信息</div>
                        <form id="myForm">
                            <div class="field">
                                <label for="">员工编号：</label>
                                <div class="ui input ">
                                    <input id="staffId" name="staffId" placeholder="员工编号" type="text">
                                </div>
                            </div>
                            <br/>
                            <div class="field">
                                <label for="">员工姓名：</label>
                                <div class="ui input ">
                                    <input id="staffName" name="staffName" placeholder="员工姓名" type="text">
                                </div>
                            </div>
                            <br/>
                            <div class="field">
                                <label for="">职工职称：</label>
                                <div class="ui input ">
                                    <select id="staffTitleInfo"  name="titleId" class="ui basic button dropdown" ></select>
                                </div>
                            </div>
                            <br/>
                            <div class="field">
                                <label for="">所属部门：</label>
                                <div class="ui input ">
                                    <select id="departmentId" name="departmentId" class="ui basic button dropdown"></select>
                                </div>
                            </div>

                            <br/>

                            <br/>
                            <button type="reset" class="ui negative button">清空</button>
                            <button type="button" id="addStaff" class="ui positive button">添加</button>
                            <div class="field">
                                <label id="result" class="ui header yellow"></label>
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
        $(document).on("change", "#staffId", function () {
            $.ajax({
                url: "isExistStaff/" + $("#staffId").val(),
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    if (data) {
                        toastError("该用户Id已存在，请更换其他");
                    } else {
                        toastSuccess("该用户Id可用");
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    toastError("请求失败！" + errorThrown);
                }
            });
        });

        $(document).ready(function () {
            $("#getByName").on("click", function () {
                var name = $("#staffName").val();
                var url = "getStaffByName/" + name + "/page_key_word";
                fillForm("PageButtons", "pageText", "pageSelecter", currentPage = 1, url, staffTableInfo, staffByNameItemNum);
            });
            $("#getByTitle").on("click", function () {
                var title = $("#staffTitle").val();
                var url = "getStaffByTitle/" + title + "/page_key_word";
                fillForm("PageButtons", "pageText", "pageSelecter", currentPage = 1, url, staffTableInfo, staffByTitleItemNum);
            });

            $("#getAllBtn").click(function () {
                var url = 'staffList/page_key_word';
                fillForm("PageButtons", "pageText", "pageSelecter", currentPage = 1, url, staffTableInfo, staffItemNum);
            });

            $("#pageSelecter").on("change", function () {
                var url = 'staffList/page_key_word';
                goToThPage("PageButtons", "pageText", "pageSelecter", url, staffTableInfo, staffItemNum);
            });
            //全部更新
            $("#updateAll").on("click", function () {
                if ($(this).text() == "全部更新") {
                    $(this).text("全部保存");
                    var checkBox = $(this).closest("tr").find(".ui.toggle.checkbox");
                    $(this).closest("tr").find(".ui.toggle.checkbox").checkbox("check");
                    if (checkBox.checkbox("is checked")) {
                        //选中
                        $(this).closest("tr").find(".nonevisiual").addClass("ui input");
                        $(this).closest("tr").find(".table-label").removeClass("mylabel");
                        $(this).closest("tr").find(".table-label").addClass("nonevisiual");
                    }


                } else {
                    $(this).text("全部更新");

                    var checkBox = $(this).closest("tr").find(".ui.toggle.checkbox");
                    $(this).closest("tr").find(".ui.toggle.checkbox").checkbox("uncheck");
                    if (!checkBox.checkbox("is checked")) {
                        //去除选中状态
                        $(this).closest("tr").find(".table-label").removeClass("nonevisiual");
                        $(this).closest("tr").find(".table-label").addClass("mylabel");
                        $(this).closest("tr").find(".nonevisiual").removeClass("ui input");
                    }


                    //发送ajax请求更新全部选中
                    $(".ui.toggle.checkbox").each(function (index, element) {
                        if ($(this).checkbox("is checked")) {
                            //发送ajax请求更新当前
                            var id, name, titleId, departmentId, titleName, departmentName;
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
                                        titleId = $(this).val();
                                        titleName = $(this).find("option:selected").text();
                                        break;
                                    case 3:
                                        departmentId = $(this).val();
                                        departmentName = $(this).find("option:selected").text();
                                        break;
                                }
                            });
//                            alert(id + ", " + name + ", " + titleId + "," + titleName + "," + departmentId + "," + departmentName)
                            $.ajax({
                                url: "updateStaff",
                                type: 'POST',
                                data: {"staffId": id, "staffName": name, "titleId": titleId, "departmentId": departmentId},
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
                                                    $(this).html(titleName);
                                                    break;
                                                case 3:
                                                    $(this).html(departmentName);
                                                    break;
                                            }
                                        })
//                                        alert('更新成功');
                                        toastSuccess("更新成功");
                                    } else {
//                                        alert("更新失败");
                                        toastError("更新失败,请重试！");
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
//                $(".ui.toggle.checkbox").each(function (index, element) {
//                    if ($(this).checkbox("is checked")) {
//                        $(this).closest("tr").find(".nonevisiual").addClass("ui input");
//                        $(this).closest("tr").find(".table-label").removeClass("mylabel");
//                        $(this).closest("tr").find(".table-label").addClass("nonevisiual");
//                    } else {
//                        $(this).closest("tr").find(".table-label").removeClass("nonevisiual");
//                        $(this).closest("tr").find(".table-label").addClass("mylabel");
//                        $(this).closest("tr").find(".nonevisiual").removeClass("ui input");
//                    }
//                });

            });

            //弹出添加model框
            $("#add").click(function () {
                requestDepartmentList("#departmentId");
                requestTitleList("#staffTitleInfo");

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

            //添加一个staff
            $("#addStaff").on("click", function () {
                $.ajax({
                    url: 'addStaff',
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
                        toastError("请求失败,请重试！" + error);
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
                    var id, name, titleId, departmentId, titleName, departmentName;
//                    id = $(this).closest("tr").attr("id")
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
                                titleId = $(this).val();
                                titleName = $(this).find("option:selected").text();
                                break;
                            case 3:
                                departmentId = $(this).val();
                                departmentName = $(this).find("option:selected").text();
                                break;
                        }
                    });
//                    alert(id + ", " + name + ", " + titleId + "," + titleName + "," + departmentId + "," + departmentName)
                    $.ajax({
                        url: "updateStaff",
                        type: 'POST',
                        data: {"staffId": id, "staffName": name, "titleId": titleId, "departmentId": departmentId},
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
                                            $(this).html(titleName);
                                            break;
                                        case 3:
                                            $(this).html(departmentName);
                                            break;
                                    }
                                })
//                                alert('更新成功');
                                toastSuccess("更新成功")
                            } else {
//                                alert("更新失败");
                                toastError("更新失败,请重试！");
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
                    url: "deleteStaff/" + id,
                    type: 'POST',
                    success: function (data, textStatus, jqXHR) {
                        if (data) {
                            $("#" + id).remove();
                            //alert("成功")
                            toastSuccess("删除成功");
                        } else {
//                            alert("失败");
                            toastError("删除失败,请重试！");
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


        function staffTableInfo(data) {
            $("#staffTable").empty();
            $("#staffTable").append("<thead><tr><th>选择</th><th>职工编号</th><th>职工姓名</th><th>职工头衔</th><th>所属部门名称</th><th style=\"padding-left: 10%\" colspan=\"2\">操作</th></tr></thead>");
            $.each(data, function (index, staff) {
                var str = " <tr id=" + staff.staffId + "><td><div class=\"ui toggle checkbox\"><input name=\"public\" type=\"checkbox\"><label></label></div></td><td>\n\
                                        <label class=\"mylabel table-label\" >" + staff.staffId + "</label>\n\<div class=\"nonevisiual\" ><input value=" + staff.staffId + " class=\"myInput\" style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                    <label class=\"mylabel table-label\" data-content=\"" + staff.staffName + "\" data-position=\"right center\">" + staff.staffName + "</label><div class=\"nonevisiual\" ><input value=" + staff.staffName + " class=\"myInput\"  style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                     <label class=\"mylabel table-label\" data-content=\"" + staff.title.titleName + "\" data-position=\"right center\">" + staff.title.titleName + "</label><div class=\"nonevisiual\"  style=\"width: 80%;\" ><select class=\"myInput mselect title_select\" value=" + staff.title.titleId + "><option value=" + staff.title.titleId + ">" + staff.title.titleName + "</option></select></div></td><td>\n\
                                        <label class=\"mylabel table-label\" data-content=\"" + staff.department.departmentName + "\" data-position=\"right center\">" + staff.department.departmentName + "</label><div class=\"nonevisiual\"><select class=\"myInput mselect department_select\" value=" + staff.department.departmentId + "><option value=" + staff.department.departmentId + ">" + staff.department.departmentName + "</option></select></div></td><td>\n\
                                        <button  class=\"ui button yellow updatebtn\" >修改</button></td><td><button class=\"ui button yellow deleteBtn\">删除</button></td></tr>";

                $("#staffTable").append(str);
            });
            requestTitleList(".title_select");
            requestDepartmentList(".department_select");
        }

        $(document).on("mouseover", ".mylabel", function () {
            $(this).popup("show");
        });

        function staffItemNum() {
            var itemNum = 0;
            $.ajax({
                url: "staffListItemNum",
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
        function staffByNameItemNum() {
            var itemNum = 0;

            var name = $("#staffName").val();
            $.ajax({
                url: "getStaffByNameItemNum/" + name,
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
        function staffByTitleItemNum() {
            var itemNum = 0;

            var title = $("#staffTitle").val();
            $.ajax({
                url: "getStaffBytitleItemNum/" + title,
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
        function requestTitleList(id) {

            $.ajax({
                url: "titleList",
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    //$(".mselect").empty();
                    $.each(data, function (index, title) {
                        var str = "<option value=" + title.titleId + ">" + title.titleName + "</option>";
                        $(id).append(str);
                    });
                },
                error: function (jqXHR, textStatus, errorThrown) {
//                    alert("请求失败" + errorThrown);
                    toastError("请求失败,请重试！" + errorThrown);
                }
            });
        }

        function requestDepartmentList(id) {

            $.ajax({
                url: "departmentList",
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    //$(".mselect").empty();
                    $.each(data, function (index, department) {
                        var str = "<option value=" + department.departmentId + ">" + department.departmentName + "</option>";
                        $(id).append(str);
                    });
                },
                error: function (jqXHR, textStatus, errorThrown) {
//                    alert("请求失败" + errorThrown);
                    toastError("请求失败,请重试！" + errorThrown);
                }
            });
        }


    </script>
</html>
