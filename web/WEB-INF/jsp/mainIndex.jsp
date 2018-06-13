<%-- 
    Document   : mainIndex
    Created on : 2018-5-25, 8:34:34
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="resourcesTemplete.jsp" />
        <style>
            #child {
                display: flex;
                /*实现垂直居中*/
                /*align-items: center;*/
                /*实现水平居中*/
                justify-content: center;
            }

        </style>
    </head>
    <body id="bg_body">

        <!--                <div id="mybody" class="container">
                            <div class="row">
                                <div class="guide">
                                    <ul class="links">
                                        <li class="l1">
                                            <span class="ico animated">
                                                <img title="" alt="" src="resources/image/patient.png">
                                            </span>
                                            <p class="p">患者版</p>
                                            <a class="link" href="patientIndex">进入</a></li>
                                        <li class="l2">  
                                            <span class="ico animated">
                                                <img title="" alt="" src="resources/image/admin.png">
                                            </span>
                                            <p class="p">职工版</p>
                                            <a class="link" href="staffIndex">进入</a></li>
                                        <li class="l3"> 
                                            <span class="ico animated">
                                                <img title="" alt="" src="resources/image/staff.png">
                                            </span>
                                            <p class="p">管理版</p>
                                            <a class="link" href="adminIndex">进入</a></li>
                
                                    </ul>
                                </div>
                
                            </div>
                        </div>-->
        <div class="ui container slideImage">
            <div class="ui segment">
                <div class="ui header teal segment">
                    InstalHMS 医院系统
                </div>

                <div class="demo square ui shape">
                    <div class="sides">
                        <div class="active first side">
                            <img  src="resources/image/bgfirst.png" class="ui fluid  image">
                            <div class="guide">
                                <ul class="links">
                                    <li class="l1">
                                        <p class="p">患者版</p>
                                        <a class="link" href="patientIndex">进入</a>
                                        <a href="patient/signup">登陆</a>
                                    </li>
                                </ul>
                            </div>
                            <!--<div>患者版</div>-->
                        </div>
                        <div class="second side">
                            <img  src="resources/image/bgsecond.png" class="ui fluid  image">
                            <div class="guide">
                                <ul class="links">
                                    <li class="l2">
                                        <p class="p">医生版</p>
                                        <a class="link" href="patientIndex">进入</a>
                                        <a href="doctor/signup">登陆</a>
                                    </li>
                                </ul>
                            </div>
                            <!--<div>医生版</div>-->
                        </div>
                        <div class="third side">
                            <img src="resources/image/bgthird.png" class="ui fluid  image">
                            <div class="guide">
                                <ul class="links">
                                    <li class="l3">
                                        <p class="p">管理版</p>
                                        <a class="link" href="adminIndex">进入</a>
                                    </li>
                                </ul>
                            </div>
                            <!--<div>管理版</div>-->
                        </div>
                    </div>
                </div>

                <div class=" col-offset-11">
                    <div class="ui ignored icon direction buttons">
                        <div class="ui button blue" data-animation="flip" title="向左翻页" data-direction="left"><i class="left long arrow icon"></i></div>
                        <div class="ui button green" data-animation="flip" title="向上翻页" data-direction="up"><i class="up long arrow icon"></i></div>
                        <div class="ui button yellow" data-animation="flip" title="向下翻页" data-direction="down"><i class="down long arrow icon"></i></div>
                        <div class="ui button orange" data-animation="flip" title="向右翻页" data-direction="right"><i class="right long arrow icon"></i></div>
                    </div>
                    <div class="ui ignored icon direction buttons">
                        <div class="ui button teal" title="转动" data-animation="flip" data-direction="over"><i class="retweet icon"></i></div>
                        <div class="ui button olive" title="转回来" data-animation="flip" data-direction="back"><i class="flipped retweet icon"></i></div>
                    </div>
                </div>
                <!--<div class="ui ignored divider"></div>-->
            </div>
            <div class="ui segment">
                <div class="ui header teal segment">
                    名医风采
                </div>
                <div>
                    <div id="child" class="ui link cards" >
                        <!--显示有头像的医生-->

                    </div>
                </div>

            </div>

        </div>

        <div>
            <jsp:include page="footerTemplete.jsp"/>
        </div>
        <script>
            $(document).ready(function () {


                $.ajax({
                    url: "staffWithImage/" + 1,
                    type: 'POST',
                    success: function (data, textStatus, jqXHR) {
                        $("#child").empty();
                        $.each(data, function (index, staff) {
                            var str = '<div class="card"><div class="image" ><img src="' + staff.image.imagePath + '"></div><div class="content"><div class="header">' + staff.staffName + '</div><div class="meta"><a>Friends</a></div><div class="description">' + staff.motto + '</div></div><div class="extra content"><span class="right floated">Joined in 2013</span><span><i class="user icon"></i>75 Friends</span></div></div > '
                            $("#child").append(str);

                        })
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        toastError("请求失败" + errorThrown);
                    }
                })

                var
                        $demo = $('.demo'),
                        $dogDemo = $('.dog.shape'),
                        $directionButton = $('.direction .button'),
                        $shapeButton = $('.type.buttons .button'),
                        handler
                        ;

                // 事件处理程序
                handler = {
                    rotate: function () {
                        var
                                $shape = $('.slideImage').find('.ui.shape'),
                                direction = $(this).data('direction') || false,
                                animation = $(this).data('animation') || false
                                ;
                        if (direction && animation) {
                            var fun = $shape.shape(animation + '.' + direction);
                        }
                    },

                    removeShape: function () {
                        var
                                shape = $(this).data('shape') || false;
                        if (shape) {
                            $demo.removeClass(shape);
                        }
                    },

                    changeShape: function () {
                        var
                                $shape = $(this),
                                $otherShapes = $shape.siblings(),
                                shape = $shape.data('shape');
                        $shape.addClass('active');
                        $otherShapes.removeClass('active').each(handler.removeShape);
                        $demo.removeAttr('style').addClass(shape);
                    }
                };

                // 事件绑定
                $demo.shape();
                $directionButton.on('click', handler.rotate).popup({
                    delay: 0,
                    position: 'bottom center'
                });
                $shapeButton.on('click', handler.changeShape);

                $dogDemo.shape();

                //进入时自动播放
                var timer = setInterval(autoClick, 5000);
                //鼠标放上时停止播放
                $(".demo.square.ui.shape").on("mouseover", function () {
                    clearInterval(timer);
                });
                //鼠标移出时开始计时播放
                $(".demo.square.ui.shape").on("mouseout", function () {
                    timer = setInterval(autoClick, 5000);
                });


            });

            function autoClick() {
                $("[title='向右翻页']").trigger("click");
            }

        </script>
    </body>
</html>
