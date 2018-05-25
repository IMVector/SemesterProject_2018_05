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
        <!--        <div id="mybody" class="container">
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
        <div class="container" id="mybody">
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
        </div>
        <div>
            <jsp:include page="footerTemplete.jsp"/>
        </div>


    </body>
</html>
