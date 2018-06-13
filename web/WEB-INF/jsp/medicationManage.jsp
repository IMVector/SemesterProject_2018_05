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
                        <div class="ui segment">
                            <div class="ui header green segment">
                                药品信息管理
                            </div>
                            <table>
                                <tr>
                                    <td>
                                        <div class="ui input focus">
                                            <input id="medicalName" placeholder="药品名称" type="text">
                                        </div>
                                    </td>
                                    <td> 
                                        <button id="getByName" class="ui basic button green">查询指定药品信息</button>
                                    </td>
                                    <td>
                                        <button id="getAllBtn" class="ui basic button green">查询所有药品信息</button>
                                    </td>
                                    <td>
                                        <button id="add" class="ui basic button green">添加药品</button>
                                    </td>
                                </tr>
                            </table>

                            <table id="medicationTable" class="ui table green">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody><tr></tr></tbody>
                            </table>
                            <div>
                                <p id="pageText"></p>
                                <div id="PageButtons" class="mini ui basic buttons">

                                </div>
                                <div>
                                    <label for="" class="ui label">跳转到：</label>
                                    <!--发送ajax请求-->
                                    <select id="pageSelecter" class="mini ui button basic dropdown">
                                        <option value="">页码</option>


                                        <!--<option value="1">1</option>-->
                                    </select>
                                </div>
                            </div>
                            <div>
                                <button id="selectAll" class="ui button green">全选</button>
                                <button id="updateAll" class="ui button green">全部更新</button>
                                <button id="deleteAll" class="ui button green">全部删除</button>
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
                        <form id="myForm" action="addMedication">
                            <div class="field">
                                <label for="">药品名称：</label>
                                <div class="ui input ">
                                    <input id="medicationName" name="medicationName" placeholder="药品名称" type="text">
                                </div>
                            </div>
                            <br/>
                            <div class="field">
                                <label for="">药品说明：</label>
                                <div class="ui input ">
                                    <input id="medicationInstructions" name="medicationInstructions" placeholder="药品说明" type="text">
                                </div>
                            </div>
                            <br/>
                            <div class="field">
                                <label for="">药品功效：</label>

                                <div class="ui input ">
                                    <input id="medicationDescription"  name="medicationDescription" placeholder="药品功效" type="text">
                                </div>
                            </div>
                            <br/>
                            <div class="field">
                                <label for="">药品价格：</label>
                                <div class="ui input ">
                                    <input id="price" name="price" placeholder="价格" type="text">
                                </div>
                            </div>

                            <br/>
                            <div class="field">
                                <label for="">有效期&nbsp&nbsp&nbsp&nbsp：</label>
                                <div class="ui input ">
                                    <input id="validityPeriod" name="validityPeriod" placeholder="有效期" type="text">
                                </div>
                            </div>
                            <br/>
                            <div class="field">
                                <label for="">生产日期：</label>
                                <div class="ui input ">
                                    <input id="productionDate" name="productionDate" placeholder="生产日期" type="date">
                                </div>
                            </div>
                            <br/>
                            <button type="reset" class="ui negative button">清空</button>
                            <button type="button" id="addMedication" class="ui positive button">添加</button>
                            <div class="field">
                                <label id="result" class="ui header green"></label>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="actions">
                    <div class="ui black deny button">放弃</div>
                    <div class="ui positive button">关闭</div>
                </div>
            </div>

        </div>
        <jsp:include page="footerTemplete.jsp" />
    </body>

    <script>


        $(document).ready(function () {

            $("#getByName").on("click", function () {
                var name = $("#medicalName").val();
                var url = "getMedicationByName/" + name;
                fillForm("PageButtons", "pageText", "pageSelecter", currentPage = 1, url, medicationTableInfo, function () {
                    return 1
                });
            })

            $("#getAllBtn").click(function () {
                var url = 'medicationList/page_key_word';
                fillForm("PageButtons", "pageText", "pageSelecter", currentPage = 1, url, medicationTableInfo, getMedicationItemNumber);
            });

            $("#pageSelecter").on("change", function () {
                var url = 'medicationList/page_key_word';
                goToThPage("PageButtons", "pageText", "pageSelecter", url, medicationTableInfo, getMedicationItemNumber);
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
                            var id, name, instructions, description, price, productionDate, validatePeriod;
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
                                        name = $(this).val();
                                        break;
                                    case 1:
                                        description = $(this).val();
                                        break;
                                    case 2:
                                        instructions = $(this).val();
                                        break;
                                    case 3:
                                        price = $(this).val();
                                        break;
                                    case 4:
                                        productionDate = $(this).val();
                                        break;
                                    case 5:
                                        validatePeriod = $(this).val();
                                        break;
                                }
                            });
//                            alert(id + ", " + name + ", " + instructions + ", " + description + ", " + price + ", " + productionDate + ", " + validatePeriod)
                            $.ajax({
                                url: "updateMedication",
                                type: 'POST',
                                data: {"medicationId": id, "medicationName": name, "medicationInstructions": instructions, "medicationDescription": description, "productionDate": productionDate, "validityPeriod": validatePeriod, "price": price},
                                success: function (data, textStatus, jqXHR) {
                                    if (data) {
//                                        alert(id);
                                        $("#" + id).find(".mylabel").each(function (index, element) {
                                            switch (index) {
                                                case 0:
                                                    $(this).html(name);
                                                    break;
                                                case 1:
                                                    $(this).html(instructions);
                                                    break;
                                                case 2:
                                                    $(this).html(description);
                                                    break;
                                                case 3:
                                                    $(this).html(price);
                                                    break;
                                                case 4:
                                                    $(this).html(formatDatebox(productionDate));
                                                    break;
                                                case 5:
                                                    $(this).html(validatePeriod);
                                                    break;
                                            }
                                        })
                                        alert('更新成功');
                                        toastSuccess("更新成功");
                                    } else {
                                        alert("更新失败");
                                        toastError("更新失败！");
                                    }
                                }, error: function (jqXHR, textStatus, errorThrown) {
//                                    alert("请求失败" + errorThrown);
                                    toastError("请求失败，请重试！" + errorThrown);
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

            //添加一个medication
            $("#addMedication").on("click", function () {
                $.ajax({
                    url: 'addMedication',
                    type: 'POST',
                    async: false,
                    data: $("#myForm").serialize(), //将表单的数据编码成一个字符串提交给服务器
                    success: function (data) {
                        if (data) {
                            $("#result").html("药品添加成功");
                        } else {
                            $("#result").removeClass("green");
                            $("#result").addClass("red");
                            $("#result").html("药品添加成功");
                        }
                    },
                    error: function (req, status, error) {
//                        alert("Ajax请求失败!" + error);
                        toastError("请求失败，请重试！" + error);
                    }
                });
            });

            //修改一个
            $(document).on('click', '.updatebtn', function () {
                if ($(this).text() == "修改") {
                    $(this).text("保存");
                } else {
                    $(this).text("修改");
                    //发送ajax请求更新当前
                    var id, name, instructions, description, price, productionDate, validatePeriod;
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
                                name = $(this).val();
                                break;
                            case 1:
                                description = $(this).val();
                                break;
                            case 2:
                                instructions = $(this).val();
                                break;
                            case 3:
                                price = $(this).val();
                                break;
                            case 4:
                                productionDate = $(this).val();
                                break;
                            case 5:
                                validatePeriod = $(this).val();
                                break;
                        }
                    });
//                alert(id + ", " + name + ", " + instructions + ", " + description + ", " + price + ", " + productionDate + ", " + validatePeriod)
                    $.ajax({
                        url: "updateMedication",
                        type: 'POST',
                        data: {"medicationId": id, "medicationName": name, "medicationInstructions": instructions, "medicationDescription": description, "productionDate": productionDate, "validityPeriod": validatePeriod, "price": price},
                        success: function (data, textStatus, jqXHR) {
                            if (data) {
                                $("#" + id).find(".mylabel").each(function (index, element) {
                                    switch (index) {
                                        case 0:
                                            $(this).html(name);
                                            break;
                                        case 1:
                                            $(this).html(instructions);
                                            break;
                                        case 2:
                                            $(this).html(description);
                                            break;
                                        case 3:
                                            $(this).html(price);
                                            break;
                                        case 4:
                                            $(this).html(formatDatebox(productionDate));
                                            break;
                                        case 5:
                                            $(this).html(validatePeriod);
                                            break;
                                    }
                                })
//                                alert('更新成功');
                                toastSuccess("更新成功")
                            } else {
//                                alert("更新失败");
                                toastError("更新失败");
                            }
                        }, error: function (jqXHR, textStatus, errorThrown) {
                            toastError("请求失败,请重试！" + errorThrown);
//                            alert("请求失败" + errorThrown);
                        }
                    })

                }
                var checkBox = $(this).closest("tr").find(".ui.toggle.checkbox");
                $(this).closest("tr").find(".ui.toggle.checkbox").checkbox("toggle");
                if (checkBox.checkbox("is checked")) {
                    $(this).closest("tr").find(".nonevisiual").addClass("ui input");
                    $(this).closest("tr").find(".table-label").removeClass("mylabel");
                    $(this).closest("tr").find(".table-label").addClass("nonevisiual");
                } else {
                    $(this).closest("tr").find(".table-label").removeClass("nonevisiual");
                    $(this).closest("tr").find(".table-label").addClass("mylabel");
                    $(this).closest("tr").find(".nonevisiual").removeClass("ui input");
                }
                //alert($(this).checkbox("is checked"))//是否checked
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
                    url: "deleteMedication/" + id,
                    type: 'POST',
                    success: function (data, textStatus, jqXHR) {
                        if (data) {
                            $("#" + id).remove();
                            //alert("成功")
                            toastSuccess("删除成功")
                        } else {
//                            alert("失败");
                            toastError("删除失败");
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
//                        alert("请求失败" + errorThrown)
                        toastError("请求失败,请重试！" + errorThrown);
                    }
                })

            });

            $("#deleteAll").on("click", function () {
                //发送ajax请求更新全部选中
                $(".ui.toggle.checkbox").each(function (index, element) {
                    if ($(this).checkbox("is checked")) {
                        var id;
                        id = $(this).closest("tr").attr("id");
                        $("#" + id).find(".deleteBtn").click();
                    }
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

        function medicationTableInfo(data) {
            $("#medicationTable").empty();
            $("#medicationTable").append("<thead><tr><th>选择</th><th>名称</th><th>适用症</th><th>说明</th><th>价格</th><th>生产日期</th><th>有效期</th><th style=\"padding-left: 10%\" colspan=\"2\">操作</th></tr></thead>");
            $.each(data, function (index, metication) {
                var str = " <tr id=" + metication.medicationId + "><td><div class=\"ui toggle checkbox\"><input name=\"public\" type=\"checkbox\"><label></label></div></td><td>\n\
                                        <label class=\"mylabel table-label\" >" + metication.medicationName + "</label>\n\<div class=\"nonevisiual\" ><input value=" + metication.medicationName + " class=\"myInput\" style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                    <label class=\"mylabel table-label\" >" + metication.medicationDescription + "</label><div class=\"nonevisiual\" ><input value=" + metication.medicationDescription + " class=\"myInput\"  style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                     <label class=\"mylabel table-label\" >" + metication.medicationInstructions + "</label><div class=\"nonevisiual\"><input value=" + metication.medicationInstructions + " class=\"myInput\"  style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                        <label class=\"mylabel table-label\" >" + metication.price + "</label><div class=\"nonevisiual\"><input value=" + metication.price + " class=\"myInput\"  style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                        <label class=\"mylabel table-label\" >" + formatDatebox(metication.productionDate) + "</label><div class=\"nonevisiual\"><input value=" + formatDatebox(metication.productionDate) + " class=\"myInput\"  style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                        <label class=\"mylabel table-label\" >" + metication.validityPeriod + "</label><div class=\"nonevisiual\"><input value=" + metication.validityPeriod + " class=\"myInput\"  style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                        <button  class=\"ui button green updatebtn\" >修改</button></td><td><button class=\"ui button green deleteBtn\">删除</button></td></tr>";


                $("#medicationTable").append(str);
            });
        }

        function getMedicationItemNumber() {
            var itemNum = 0;
            $.ajax({
                url: "medicationListItemNum",
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