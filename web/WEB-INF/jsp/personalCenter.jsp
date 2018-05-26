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
            <jsp:include page="persionalCenterTemplete.jsp"/>
            <!--            <div class="ui container">
                            <div class="ui relaxed divided items">
                                <div class="ui divider"></div>
                                <div class="item">
                                    <div class="ui small image">
                                        <img src="resources/image/狗子.jpeg">
                                    </div>
            
                                    <div class="content">
                                        <a class="header">内容标题</a>
                                        <div class="meta">
                                            <a>编号：</a>
                                        </div>
                                        <div class="meta">
                                            <a>姓名：</a>
                                        </div>
                                        <div class="meta">
                                            <a>日期</a>
                                        </div>
                                        <div class="meta">
                                            <a>日期</a>
                                        </div>
                                        <div class="meta">
                                            <a>日期</a>
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
                        </div>-->


            <div class="ui container">

                <div class="ui segment">

                    <div class="ui grid stackable">
                        <div class="four wide column">
                            <div class="ui vertical blue pointing menu">
                                <a id="medicalRecord" class="item" data-tab="medicalRecord">查看我的病例 </a>
                                <a id="chaeckRecord" class="item" data-tab="chaeckRecord">查看我的检查记录 </a>
                                <a id="prescription" class="item" data-tab="prescription">查看我的处方信息 </a>
                                <a id="bill" class="item" data-tab="bill">查看我的账单信息 </a>
                                <a id="checkResult" class="item" data-tab="checkResult">查看我的检查结果 </a>
                                <a id="healthAdvice" class="item" data-tab="healthAdvice">健康建议 </a>
                                <a id="dietAdvice" class="item" data-tab="dietAdvice">饮食建议 </a>
                                <a id="record" class="item" data-tab="record">就医记录 </a>
                                <a id="graphy" class="item" data-tab="graphy">就医图表 </a>
                            </div>
                        </div>

                        <div class="twelve wide column">
                            <div class="ui tab attached segment" data-tab="medicalRecord">
                                <div class="ui header blue segment">    XXX的个人病例消息</div>
                                <jsp:include page="medicalRecord.jsp"/>

                            </div>
                            <div class="ui tab attached segment" data-tab="chaeckRecord">    
                                <div class="ui header blue segment">    XXX的个人检查记录</div>
                                <jsp:include page="medicalRecord.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="prescription">
                                <div class="ui header blue segment">    XXX的个人处方信息</div>
                                <jsp:include page="medicalRecord.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="bill">
                                <div class="ui header blue segment">    XXX的个人账单信息</div>
                                <jsp:include page="medicalRecord.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="checkResult">
                                <div class="ui header blue segment">    XXX的个人检查结果信息</div>
                                <jsp:include page="medicalRecord.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="healthAdvice">
                                <div class="ui header blue segment">    XXX的个人健康建议</div>
                                <jsp:include page="medicalRecord.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="dietAdvice">     
                                <div class="ui header blue segment">    XXX的个人饮食建议</div>
                                <jsp:include page="medicalRecord.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="record">
                                <div class="ui header blue segment">    XXX的个人就医记录</div>
                                <jsp:include page="medicalRecord.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="graphy">
                                <div class="ui header blue segment">    XXX的健康可视化</div>
                                <jsp:include page="medicalRecord.jsp"/>
                            </div>
                        </div>
                    </div>
                </div>
                <script>
                    $(document).ready(function () {
                        $("#medicalRecord").click(function () {
                            $.ajax({
                                url: 'medicalRecordList/p001',
                                type: 'POST',
                                 data: {},
                                success: function (data) {
                                    $.each(data,function(index,medicalrecord){
                                       alert(medicalrecord.inDiagnosis) ;
                                    });

                                }, error: function (req,status,error) {
                                    alert("请求失败，请重试！");
                                }

                            });
                        });
                        $('.menu .item').tab();









                    });
                </script>




            </div>
            <jsp:include page="footerTemplete.jsp"/>

        </div>
    </body>
</html>
