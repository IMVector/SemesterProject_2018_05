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
        <script src="resources/js/jquery-3.2.1.min.js"></script>
    </head>
    <body>
        
        <div class="container body-under-header">
            <jsp:include page="LpersionalCenterTemplete.jsp"/>

            <div class="ui container">

                <div class="ui segment">

                    <div class="ui grid stackable">
                        <div class="four wide column">
                            <div class="ui vertical blue pointing menu">
                                <a id="medicalRecord" class="item" data-tab="diagnosis">查看病人个人信息 </a>
                                <a id="chaeckRecord" class="item" data-tab="physicalTest">安排相关检查 </a>
                                <a id="prescription" class="item" data-tab="patientDietAdvice">编写饮食建议 </a>
                                <a id="bill" class="item" data-tab="patientPrescription">编写处方 </a>
                                <!--<a id="checkResult" class="item" data-tab="checkResult">查看我的检查结果 </a>-->
<!--                                <a id="healthAdvice" class="item" data-tab="bloodBank">血库 </a>-->
<!--                                <a id="dietAdvice" class="item" data-tab="dietAdvice">血库 </a>
-->                               <!-- <a id="record" class="item" data-tab="record">血库 </a>
                                <a id="graphy" class="item" data-tab="graphy">就医图表 </a>-->
                            </div>
                        </div>

                        <div class="twelve wide column">
                            <div class="ui tab attached segment" data-tab="diagnosis">
                                <div class="ui header blue segment">个人信息</div>
                                <jsp:include page="diagnosis.jsp"/>

                            </div>
                            <div class="ui tab attached segment" data-tab="physicalTest">    
                                <div class="ui header teal segment" id="test">相关检查</div>
                                <jsp:include page="physicalTest.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="patientDietAdvice">
                                <div class="ui header olive segment" id="dietAdvice">饮食建议</div>
                                <jsp:include page="patientDietAdvice.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="patientPrescription">
                                <div class="ui header orange segment"> 编写处方</div>
                                <jsp:include page="patientPrescription.jsp"/>
                            </div>
<!--                            <div class="ui tab attached segment " data-tab="checkResult">
                                <div class="ui header green segment">    的个人检查结果信息</div>
                                <%--<jsp:include page="checkResult.jsp"/>--%>
                            </div>-->
                            <div class="ui tab attached segment " data-tab="healthAdvice">
                                <div class="ui header green segment">    ${patient.patientName}的个人健康建议</div>
                                <jsp:include page="healthAdvice.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="bloodBank">     
                                <div id="test" class="ui header purple segment"> 血库信息</div>
                                <jsp:include page="bloodBank.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="record">
                                <div class="ui header red segment">血库</div>
                                <jsp:include page="bloodBank.jsp"/>
                            </div>
                            <div class="ui tab attached segment " data-tab="graphy">
                                <div class="ui header blue segment">    ${patient.patientName}的健康可视化</div>
                                <jsp:include page="healthGraphy.jsp"/>
                            </div>
                        </div>
                    </div>
                </div>
                <script>
                    
                    $(document).ready(function () {
                        
                        
                        $('.menu .item').tab();
                    });
                </script>



                <%--<jsp:include page="footerTemplete.jsp"/>--%>

        </div>
    </body>
</html>
