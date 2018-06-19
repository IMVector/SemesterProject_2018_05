<%-- 
    Document   : templete
    Created on : 2018-5-18, 8:36:08
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="ui four column grid">
    <div class="computer only one column row">

        <div class="ui top fixed menu">
            <div class="ui secondary menu">
                <div class="item">
                    <img class="myLogo" src="resources/image/狗子.jpeg">
                </div>
                <a href="index" class="active item">
                    InstalHMS 医院系统
                </a>
                <a href="adminIndex" class="item">
                    管理员主页
                </a>

            </div>
            <!--            <div class="right stackable  menu">
                            <a class="item" href="personalCenter">
                                <img class="ui avatar image" src="resources/image/狗子.jpeg">
                            </a>
                        </div>-->
        </div>
    </div>
    <div class="tablet only column">
        <div class="ui top fixed menu">
            <div class="ui secondary menu">
                <div class="item">
                    <img  class="myLogo" src="resources/image/狗子.jpeg">
                </div>
                <a class="active item">
                    InstalHMS 医院系统
                </a>
                <a href="adminIndex" class="item">
                    管理员主页
                </a>

            </div>
            <!--            <div class="right stackable  menu">
                            <a class="item" href="personalCenter">
                                <img class="ui avatar image" src="resources/image/狗子.jpeg">
                            </a>
                        </div>-->
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $.ajax({
            url: "getLogo" ,
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                $(".myLogo").attr("src",data.imagePath);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                toastError("请求失败" + errorThrown);
            }
        });
    });

</script>
