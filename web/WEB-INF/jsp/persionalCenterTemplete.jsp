<%-- 
    Document   : PersionalCenterTemplete
    Created on : 2018-5-19, 10:16:28
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="ui container">

        <div class="ui relaxed divided items"  style="background: url(resources/image/bg_change.png) no-repeat center">
            <div class="ui divider"></div>
            <div class="item">
                <div class="ui small image">
                    <img src="resources/image/狗子.jpeg">
                </div>

                <div class="content">
                    <!--<a class="header">内容标题</a>-->
                    <div class="meta">
                        <div class="ui label">编号：</div> &nbsp&nbsp${patient.patientId}
                    </div>
                    <div class="meta">
                        <div class="ui label">姓名：</div> &nbsp&nbsp${patient.patientName}

                        <!--<a>姓名：</a>-->
                    </div>
                    <div class="meta">
                        <div class="ui label">血型：</div> &nbsp&nbsp${patient.bloodType}

                        <!--<a>血型：</a>-->
                    </div>
                    <div class="meta">
                        <div class="ui label">年龄：</div> &nbsp&nbsp${patient.patientAge}
                        <!--<a>年龄：</a>-->
                    </div>
                    <div class="meta">
                        <div class="ui label">婚否：</div> &nbsp&nbsp${patient.patientMstatus}
                        <!--<a>婚否：</a>-->
                    </div>
                    <!--                            <div class="description">
                                                    可以为多个行流并给内容提供上下文的描述。
                                                </div>-->
                    <div class="extra">
                        <div class="ui right floated primary button">
                            修改信息
                            <i class="right chevron icon"></i>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ui divider"></div>
        </div>

</div>
