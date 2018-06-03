<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <jsp:include page="resourcesTemplete.jsp" />
        <style>
            .mylabel{
                display: block;
                text-overflow:ellipsis;
                overflow: hidden;
                white-space: nowrap;
                width:60px;
            }
            .mylabel:hover{
                display: block;
                text-overflow:auto;
                overflow: auto;
                white-space: initial;
                width:100px;
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
                            <div class="ui header violet segment">
                                数据库备份设置
                            </div>
                            <button id="getSettingList" class="ui basic button violet">查询所有设置</button>
                            <table id="databaseSettingTable" class="ui table violet">
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

                            <div class="ui header violet segment">
                                数据库备份管理
                            </div>

                            <button id="getbackpackFile" class="ui basic button violet">查询所有数据库备份</button>
                            <table id="databaseBackpackFileTable" class="ui table violet">
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
                                <p id="pageText_1"></p>
                                <div id="pageButtons_1" class="mini ui basic buttons">

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
                            <br/>
                            <div>
                                <button class="ui button violet" onclick="selectAll()">全选</button>
                                <button class="ui button violet">全部删除</button>
                            </div>



                        </div>
                    </div>
                </div>
            </div>


        </div>
        <!-- /container -->
        <jsp:include page="footerTemplete.jsp" />
    </body>
    <script>

        $(document).ready(function () {

            $("#getSettingList").click(function () {
                var url = 'backpackSettingList/page_key_word';
                fillForm("pageButtons", "pageText", "pageSelecter", currentPage = 1, url, showDatabaseSettingTable, getDatabaseSettingItemNum);
            });
            $("#pageSelecter").on("change", function () {
                var url = 'backpackSettingList/page_key_word';
                goToThPage("pageButtons", "pageText", "pageSelecter", url, showDatabaseSettingTable, getDatabaseSettingItemNum);
            });

            $("#getbackpackFile").click(function () {
                var url = 'databaseBackpackFileList/page_key_word';
                fillForm("pageButtons_1", "pageText_1", "pageSelecter_1", currentPage = 1, url, showDatabaseBackpackTable, getBackpackFileItemNum);
            })
            $("#pageSelecter_1").on("change", function () {
                var url = 'databaseBackpackFileList/page_key_word';
                goToThPage("pageButtons_1", "pageText_1", "pageSelecter_1", url, showDatabaseBackpackTable, getBackpackFileItemNum);
            });

        });
        $(document).on('click', '.settingBtn', function () {
            //$(this).closest("tr").find(".ui.toggle.checkbox").checkbox("toggle");
            $(this).closest("tr").find(".myInput").each(function (index, element) {
                if (index == 0) {
                    //alert(index + "  " + $(this).val())
                    var id = $(this).val();
                    var url = "setSettting/" + id;
                    getSomethingByAjax(url, setting);

                }

                //1、备份设置编号
                //2、sql脚本路径
                //3、bat脚本路径
                //4、备份保存路径

            });
            //alert($(this).checkbox("is checked"))//是否checked
        });

        $(document).on("click", ".restoreBtn", function () {

            $(this).closest("tr").find(".table-label").each(function (index, element) {
                if (index == 0) {
                    var id = $(this).html().trim();
                    var url = "restore/" + id;
//                    alert(url)
                    getSomethingByAjax(url, restore);

                }

            });
        });
        $(document).on('change', '.ui.toggle.checkbox', function () {
//            if ($(this).checkbox("is checked")) {
//                $(this).closest("tr").find(".nonevisiual").addClass("ui input");
//                $(this).closest("tr").find(".table-label").removeClass("mylabel");
//                $(this).closest("tr").find(".table-label").addClass("nonevisiual");
//            } else {
//                $(this).closest("tr").find(".table-label").removeClass("nonevisiual");
//                $(this).closest("tr").find(".table-label").addClass("mylabel");
//                $(this).closest("tr").find(".nonevisiual").removeClass("ui input");
//            }

        })
//        $(document).ready(function () {
//
//            $("#getList").click(function () {
//                var url = 'backpackSettingList/page_key_word';
//                fillForm("pageButtons", "pageText", "pageSelecter", currentPage = 1, url, showDatabaseSettingTable, getDatabaseSettingItemNum);
//            });
//            $("#pageSelecter").on("change", function () {
//                var url = 'backpackSettingList/page_key_word';
//                goToThPage("pageButtons", "pageText", "pageSelecter", url, showDatabaseSettingTable, getDatabaseSettingItemNum);
//            });
//
//        });
        //全部选中函数
        function selectAll() {
            $(".ui.toggle.checkbox").checkbox("toggle");
        }
        function showDatabaseSettingTable(data) {
            $("#databaseSettingTable").empty();
            $("#databaseSettingTable").append(" <thead><tr><th>设置编号</th><th>sql脚本路径</th><th>bat脚本路径</th><th>备份保存路径</th><th>操作</th></tr></thead>");
            $.each(data, function (index, detabaseSetting) {
//                var str = '<tr><td><div class="ui toggle checkbox"><input name="public" type="checkbox"><label></label></div></td><td> <label class="mylabel">编号1</label><div class="nonevisiual" ><input  class="myInput" style="width: 80%;" type="text"></div></td><td><label  class="mylabel" for="">编号2</label><div class="nonevisiual" ><input  class="myInput" style="width: 80%;" type="text"></div></td><td><label  class="mylabel" for="">编号3</label><div class="nonevisiual"><input  class="myInput" style="width: 80%;" type="text"></div></td><td><label class="mylabel" for="">编号4</label><div class="nonevisiual"><input  class="myInput" style="width: 80%;" type="text"></div></td><td> <button class="ui button orange updatebtn">修改</button></td> <td> <button class="ui button orange deleteBtn">删除</button> </td> </tr>'
                var str = " <tr id=" + detabaseSetting.backpackSettingId + "><td>\n\
                                        <label class=\"mylabel table-label\" >" + detabaseSetting.backpackSettingId + "</label>\n\<div class=\"nonevisiual\" ><input value=" + detabaseSetting.backpackSettingId + " class=\"myInput\" style=\"width: 80%;\" type=\"text\"></div></td><td>\n\
                                    <label class=\"mylabel table-label\" >" + detabaseSetting.backpackSqlFile + "</label><div class=\"nonevisiual\" ><input value=" + detabaseSetting.backpackSqlFile + " class=\"myInput\"  style=\"width: 80%;\" type=\"file\"></div></td><td>\n\
                                     <label class=\"mylabel table-label\" >" + detabaseSetting.backpackBatFile + "</label><div class=\"nonevisiual\"><input value=" + detabaseSetting.backpackBatFile + " class=\"myInput\"  style=\"width: 80%;\" type=\"file\"></div></td><td>\n\
                                        <label class=\"mylabel table-label\" >" + detabaseSetting.backpackToPath + "</label><div class=\"nonevisiual\"><input value=" + detabaseSetting.backpackToPath + " class=\"myInput\"  style=\"width: 80%;\" type=\"file\"></div></td><td>\n\
                                        <button  class=\"ui button violet settingBtn\" >使用设置</button></tr>";

//                $("#databaseSettingTable").append(str);
                $("#databaseSettingTable").append(str);
            });
        }
        function showDatabaseBackpackTable(data) {
            $("#databaseBackpackFileTable").empty();
            $("#databaseBackpackFileTable").append(" <thead><tr><th>选择</th><th>文件编号</th><th>文件路径</th><th>备份时间</th><th style=\"padding-left: 10%\" colspan=\"2\">操作</th></tr></thead>");
            $.each(data, function (index, backpack) {
//                var str = '<tr><td><div class="ui toggle checkbox"><input name="public" type="checkbox"><label></label></div></td><td> <label class="mylabel">编号1</label><div class="nonevisiual" ><input  class="myInput" style="width: 80%;" type="text"></div></td><td><label  class="mylabel" for="">编号2</label><div class="nonevisiual" ><input  class="myInput" style="width: 80%;" type="text"></div></td><td><label  class="mylabel" for="">编号3</label><div class="nonevisiual"><input  class="myInput" style="width: 80%;" type="text"></div></td><td><label class="mylabel" for="">编号4</label><div class="nonevisiual"><input  class="myInput" style="width: 80%;" type="text"></div></td><td> <button class="ui button orange updatebtn">修改</button></td> <td> <button class="ui button orange deleteBtn">删除</button> </td> </tr>'
                var str = " <tr id=" + backpack.backpackFileId + "><td><div class=\"ui toggle checkbox\"><input name=\"public\" type=\"checkbox\"><label></label></div></td><td>\n\
                                        <label class=\"mylabel table-label\" >" + backpack.backpackFileId + "</label>\n\<div class=\"nonevisiual\" ></td><td>\n\
                                    <label class=\"mylabel table-label\" >" + backpack.backpackFilePath + "</label><div class=\"nonevisiual\" ></td><td>\n\
                                     <label class=\"mylabel table-label\" >" + formatDatebox(backpack.backpackTime) + "</label><div class=\"nonevisiual\"></td><td>\n\
                                        <button  class=\"ui button violet restoreBtn\" >还原</button></td><td><button class=\"ui button violet deleteBtn\">删除</button></td></tr>";

//                $("#databaseSettingTable").append(str);
                $("#databaseBackpackFileTable").append(str);
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
                    alert("请求失败，请重试！");
                }
            });
            return itemNum;
        }
        function setting(data) {

            alert("设置成功！可以进行还原！");

        }
        function restore(data) {
            if (data == true) {
                alert("还原成功！");

            } else {
                alert("还原失败！");
            }

        }
        function getBackpackFileItemNum() {
            var itemNum = 0;
            $.ajax({
                url: "backpackFileListItemNum",
                type: 'POST',
                async: false,
                data: {},
                success: function (data, textStatus, jqXHR) {
                    //返回List项目总数量
                    itemNum = data
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("请求失败，请重试！");
                }
            });
            return itemNum;
        }

    </script>

</html>