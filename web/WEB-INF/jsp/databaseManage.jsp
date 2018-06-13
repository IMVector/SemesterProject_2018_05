<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <jsp:include page="resourcesTemplete.jsp" />
        <style>
            .mylabel{
                display: block;
                text-overflow:ellipsis;overflow: hidden;white-space: nowrap;width:60px;
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
                        <div class="ui segment" style="overflow:scroll">
                            <div class="ui header orange segment">
                                数据库管理
                            </div>
                            <table>
                                <tr>
                                    <td>
                                        <button id="getList" class="ui basic button orange">查询备份设置列表</button>
                                    </td>
                                    <td>
                                        <button id="addSetting" class="ui basic button orange">添加备份设置</button>
                                    </td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </table>

                            <table id="databaseSettingTable" class="ui table orange">
                                <!--                                <thead>
                                                                    <tr>
                                                                        <th>选择</th>
                                                                        <th>备份设置编号</th>
                                                                        <th>sql脚本路径</th>
                                                                        <th>bat脚本路径</th>
                                                                        <th>备份保存路径</th>
                                                                        <th style="padding-left: 10%" colspan="2">操作</th>
                                                                    </tr>
                                                                </thead>-->


                            </table>
                            <div>
                                <p id="pageText"></p>
                                <div id="pageButtons" class="mini ui basic buttons">

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
                            <br/>
                            <div>
                                <button class="ui button orange" onclick="selectAll()">全选</button>
                                <button class="ui button orange">全部更新</button>
                                <button class="ui button orange">全部删除</button>
                            </div>


                        </div>
                    </div>
                </div>
            </div>

            <div id="modeltest" class="ui inverted modal ">
                <div class="header">添加设置信息</div>
                <div class="content" style="text-align:center">
                    <div class="ui segment" style="width: 50%;margin: 0 auto">
                        <div class="ui header blue segment">设置信息</div>
                        <div class="field">
                            <label for="">sql脚本路径：</label>
                            <div class="ui input ">
                                <input placeholder="sql脚本路径" type="file">
                            </div>
                        </div>
                        <br/>
                        <div class="field">
                            <label for="">bat脚本路径：</label>

                            <div class="ui input ">
                                <input placeholder="bat脚本路径" type="file">
                            </div>
                        </div>
                        <br/>
                        <div class="field">
                            <label for="">份保存路径：</label>
                            <div class="ui input ">
                                <input placeholder="份保存路径" type="file">
                            </div>
                        </div>


                        <br/>
                        <div class="field">
                            <label id="result" for=""></label>
                        </div>

                    </div>
                </div>
                <div class="actions">
                    <div class="ui black deny button">取消 </div>
                    <div class="ui positive right labeled icon button">添加 <i class="checkmark icon"></i> </div>
                </div>
            </div>
        </div>
        <!-- /container -->
        <jsp:include page="footerTemplete.jsp" />
    </body>
    <script>
        $("#addSetting").click(function () {
            $('#modeltest')
                    .modal({
                        inverted: true,
                        closable: false,
                        onDeny: function () {
//                            window.alert('Wait not yet!');
                            return false;
                        },
                        onApprove: function () {
//                            window.alert('Approved!');
                        }
                    })
                    .modal('show')
                    ;
        });

        $(document).on('click', '.updatebtn', function () {
            $(this).closest("tr").find(".ui.toggle.checkbox").checkbox("toggle");
            $(this).closest("tr").find(".myInput").each(function (index, element) {
                //1、备份设置编号
                //2、sql脚本路径
                //3、bat脚本路径
                //4、备份保存路径

            });
            //alert($(this).checkbox("is checked"))//是否checked
        });
        $(document).on('change', '.ui.toggle.checkbox', function () {
            if ($(this).checkbox("is checked")) {
                $(this).closest("tr").find(".nonevisiual").addClass("ui input");
                $(this).closest("tr").find(".table-label").removeClass("mylabel");
                $(this).closest("tr").find(".table-label").addClass("nonevisiual");
            } else {
                $(this).closest("tr").find(".table-label").removeClass("nonevisiual");
                $(this).closest("tr").find(".table-label").addClass("mylabel");
                $(this).closest("tr").find(".nonevisiual").removeClass("ui input");
            }

        })
        $(document).ready(function () {

            $("#getList").click(function () {
                var url = 'backpackSettingList/page_key_word';
                fillForm("pageButtons", "pageText", "pageSelecter", currentPage = 1, url, showDatabaseSettingTable, getDatabaseSettingItemNum);
            });
            $("#pageSelecter").on("change", function () {
                var url = 'backpackSettingList/page_key_word';
                goToThPage("pageButtons", "pageText", "pageSelecter", url, showDatabaseSettingTable, getDatabaseSettingItemNum);
            });

        });
        //全部选中函数
        function selectAll() {
            $(".ui.toggle.checkbox").checkbox("toggle");
        }

        function showDatabaseSettingTable(data) {
            $("#databaseSettingTable").empty();
            $("#databaseSettingTable").append(" <thead><tr><th>选择</th><th>设置编号</th><th>sql脚本路径</th><th>bat脚本路径</th><th>备份保存路径</th><th style=\"padding-left: 10%\" colspan=\"2\">操作</th></tr></thead>");
            $.each(data, function (index, detabaseSetting) {
//                var str = '<tr><td><div class="ui toggle checkbox"><input name="public" type="checkbox"><label></label></div></td><td> <label class="mylabel">编号1</label><div class="nonevisiual" ><input  class="myInput" style="width: 80%;" type="text"></div></td><td><label  class="mylabel" for="">编号2</label><div class="nonevisiual" ><input  class="myInput" style="width: 80%;" type="text"></div></td><td><label  class="mylabel" for="">编号3</label><div class="nonevisiual"><input  class="myInput" style="width: 80%;" type="text"></div></td><td><label class="mylabel" for="">编号4</label><div class="nonevisiual"><input  class="myInput" style="width: 80%;" type="text"></div></td><td> <button class="ui button orange updatebtn">修改</button></td> <td> <button class="ui button orange deleteBtn">删除</button> </td> </tr>'
                var str = " <tr id=" + detabaseSetting.backpackSettingId + "><td><div class=\"ui toggle checkbox\"><input name=\"public\" type=\"checkbox\"><label></label></div></td><td>\n\
                                        <label class=\"mylabel table-label\" >" + detabaseSetting.backpackSettingId + "</label>\n\<div class=\"nonevisiual\" ><input value=" + detabaseSetting.backpackSettingId + " class=\"myInput\" style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                    <label class=\"mylabel table-label\" >" + detabaseSetting.backpackSqlFile + "</label><div class=\"nonevisiual\" ><input value=" + detabaseSetting.backpackSqlFile + " class=\"myInput\"  style=\"width: 80%;\" type=\"file\"></div></td><td>\n\
                                     <label class=\"mylabel table-label\" >" + detabaseSetting.backpackBatFile + "</label><div class=\"nonevisiual\"><input value=" + detabaseSetting.backpackBatFile + " class=\"myInput\"  style=\"width: 80%;\" type=\"file\"></div></td><td>\n\
                                        <label class=\"mylabel table-label\" >" + detabaseSetting.backpackToPath + "</label><div class=\"nonevisiual\"><input value=" + detabaseSetting.backpackToPath + " class=\"myInput\"  style=\"width: 80%;\" type=\"file\"></div></td><td>\n\
                                        <button  class=\"ui button orange updatebtn\" >修改</button></td><td><button class=\"ui button orange\">删除</button></td></tr>";

//                $("#databaseSettingTable").append(str);
                $("#databaseSettingTable").append(str);
            });
        }
        function getDatabaseSettingItemNum() {
            var itemNum = 0;
            $.ajax({
                url: "backpackSettingListItemNum",
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
//style=\"text-overflow:ellipsis;overflow: hidden;white-space: nowrap;width:60px;\"

    </script>
</html>