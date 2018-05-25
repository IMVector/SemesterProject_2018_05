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
                    <div class="ui divider"></div>
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
                                <div class="ui label">Limited</div>
                            </div>
                        </div>
                    </div>
                    <div class="ui divider"></div>
                </div>
            </div>

            <div class="ui container">

                <div class="ui segment">
                    
                    <div class="ui grid">
                        <div class="four wide column">
                            <div class="ui vertical pointing menu">
                                <a class="item" data-tab="first">健康建议 </a>
                                <a class="item" data-tab="second">饮食建议 </a>
                                <a class="item" data-tab="third">就医记录 </a>
                                <a class="item" data-tab="fourth">就医图表 </a>
                            </div>
                        </div>

                        <div class="twelve wide column">
                            <div class="ui tab attached segment" data-tab="first">这是可拉伸的网格列。<br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br> </div>
                            <div class="ui tab attached segment" data-tab="second">这是可拉伸的网格列。2      <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br></div>
                            <div class="ui tab attached segment " data-tab="third">这是可拉伸的网格列。3 </div>
                            <div class="ui tab attached segment " data-tab="fourth">这是可拉伸的网格列。4 </div>
                        </div>
                    </div>
                </div>
                <script>
                    $(document).ready(function () {
                        $('.menu .item').tab();
                    });
                </script>




            </div>
            <jsp:include page="footerTemplete.jsp"/>

    </body>
</html>
