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
                                        <a class="link" href="staffIndex">进入</a>
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
        </div>

        <script>
            $(document).ready(function () {


                //        $("[data-animation='flip']").click(function () {
                //            var animation = $(this).data('animation') || false;
                //            var direction = $(this).data('direction') || false;
                //
                //            var $shape = $(this).closest('.example').find('.ui.shape');
                //
                //
                ////            alert( $shape.siblings());
                ////            alert( $shape.data('shape'))
                //
                //            if (direction && animation) {
                //                $shape.shape(animation + '.' + direction);
                //            }
                //        });





                var
                        $demo = $('.demo'),
                        $dogDemo = $('.dog.shape'),
                        $directionButton = $('.direction .button'),
                        $shapeButton = $('.type.buttons .button'),
                        // alias
                        handler
                        ;

                // event handlers
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

                // attach events
                $demo.shape();
                $directionButton.on('click', handler.rotate).popup({
                    delay: 0,
                    position: 'bottom center'
                });
                $shapeButton.on('click', handler.changeShape);

                $dogDemo.shape();

                setInterval(autoClick, 10000)
            });

            function autoClick() {
                $("[title='向右翻页']").trigger("click");
            }

        </script>
        <!--</div>-->
        <!--        <div class="ui container" id="mybody">
                 
                    <div class="row">
                        <img src="resources/image/狗子.jpeg" class="img-circle img-thumbnail" style="height: 50px" alt="logo">
                    </div>
                    <div class="row">
                        <div class="pull-left">
                            <ul class="list-group">
                                <li class="list-group-item">    
                                    <p class="p">患者版</p>
                                    <a class="link" href="patientIndex">进入</a></li>
                                <li class="list-group-item">   
                                    <p class="p">职工版</p>
                                    <a class="link" href="staffIndex">进入</a></li>
                                <li class="list-group-item">      
                                    <p class="p">管理版</p>
                                    <a class="link" href="adminIndex">进入</a></li>
        
                            </ul>
                        </div>
        
                        <div class="pull-right">
                            医院介绍
                        </div>
                    </div>
                </div>-->
        <div>
            <jsp:include page="footerTemplete.jsp"/>
        </div>


    </body>
</html>
