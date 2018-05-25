<%-- 
    Document   : personalCenter
    Created on : 2018-5-18, 9:01:50
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="resourcesTemplete.jsp"/>
    </head>
    <body>
        <jsp:include page="patientHeaderTemplete.jsp"/>
        <div class="container body-under-header">
            <div class="ui container">
                <div class="ui relaxed divided items">
<!--                    <div class="item">
                        <div class="ui small image">
                            <img src="resources/image/狗子.jpeg">
                        </div>
                        <div class="content">
                            <a class="header">内容标题</a>
                            <div class="meta">
                                <a>日期</a>
                                <a>目录</a>
                            </div>
                            <div class="description">
                                可以为多个行流并给内容提供上下文的描述。
                            </div>
                            <div class="extra">
                                <img src="./响应式元素 - Semantic UI - 1号自习室_files/square-image.png" class="ui circular avatar image"> Username
                            </div>
                        </div>
                    </div>-->
<!--                    <div class="item">
                        <div class="ui small image">
                            <img src="resources/image/狗子.jpeg">
                        </div>
                        <div class="content">
                            <a class="header">内容标题</a>
                            <div class="meta">
                                <a>日期</a>
                                <a>目录</a>
                            </div>
                            <div class="description">
                                可以为多个行流并给内容提供上下文的描述。
                            </div>
                            <div class="extra">
                                <div class="ui right floated primary button">
                                    Primary
                                    <i class="right chevron icon"></i>
                                </div>
                                <div class="ui label">Limited</div>
                            </div>
                        </div>
                    </div>-->
                    <div class="item">
                        <div class="ui small image">
                            <img src="resources/image/狗子.jpeg">
                        </div>
                        <div class="content">
                            <a class="header">内容标题</a>
                            <div class="meta">
                                <a>日期</a>
                                <a>目录</a>
                            </div>
                            <div class="description">
                                可以为多个行流并给内容提供上下文的描述。
                            </div>
                            <div class="extra">
                                <div class="ui right floated primary button">
                                    Primary
                                    <i class="right chevron icon"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="ui card ">
                <div class="blurring dimmable image">
                    <div class="ui dimmer transition hidden">
                        <div class="content">
                            <div class="center">
                                <div class="ui inverted button">调用行为</div>
                            </div>
                        </div>
                    </div>
                    <img src="resources/image/狗子.jpeg">
                </div>
                <div class="content">
                    <a class="header">姓名</a>
                    <div class="meta">
                        <span class="date">日期</span>
                    </div>
                </div>
                <div class="extra content">
                    <a>
                        <i class="users icon"></i>
                        用户
                    </a>
                </div>
            </div>
        </div>



        <jsp:include page="persionalCenterTemplete.jsp"/>

        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-3 col-lg-3" style="background-color: lightblue;height: 900px;">
                    <jsp:include page="patientOperateTemplete.jsp"/>
                </div>
                <div class="col-md-9 col-sm-9 col-lg-9" style="background-color: lightcoral ;height: 900px;">

                    <ul class="list-group">
                        <li class="list-group-item">            
                            <div class="row">
                                健康建议
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                            </div>
                        </li>
                        <li class="list-group-item">       
                            <div class="row">
                                饮食建议
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row">
                                就医记录
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                            </div>
                        </li>
                        <li class="list-group-item">            
                            <div class="row">
                                就医图表
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                            </div>
                        </li>

                    </ul>


                    显示个人就医记录等信息   查询病例表的indata信息，显示所有的就医记录

                    显示当季的饮食建议等信息，预防建议等信息

                    显示个人健康状况等信息   


                </div>
            </div>
        </div>

    </body>
</html>
