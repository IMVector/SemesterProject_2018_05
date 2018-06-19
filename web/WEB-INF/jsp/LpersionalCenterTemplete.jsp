<%-- 
    Document   : PersionalCenterTemplete
    Created on : 2018-5-19, 10:16:28
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head><base href="${pageContext.request.contextPath}/"></head>
<!DOCTYPE html>
<div class="ui container">
    <div class="ui relaxed divided items">
        <div class="ui divider"></div>
        <div class="item">
            <div class="ui small image">
                <img src="${staffDetail.image.imagePath}">
            </div>

            <div class="content">
                <!--<a class="header">内容标题</a>-->
                <div class="meta">
                    <div class="ui label">编号：</div> &nbsp&nbsp${staffDetail.staffId}
                </div>
                <div class="meta">
                    <div class="ui label">姓名：</div> &nbsp&nbsp${staffDetail.staffName}

                    <!--<a>姓名：</a>-->
                </div>
                <div class="meta">
                    <div class="ui label">职位：</div> &nbsp&nbsp${staffDetail.title.titleName}

                    <!--<a>血型：</a>-->
                </div>
<!--                <div class="meta">
                    <div class="ui label">部门：</div> &nbsp&nbsp
                    <a>年龄：</a>
                </div>-->
<!--                <div class="meta">
                    <div class="ui label">婚否：</div> &nbsp&nbsp
                    <a>婚否：</a>
                </div>-->
                <!--                            <div class="description">
                                                可以为多个行流并给内容提供上下文的描述。
                                            </div>-->
                <div class="extra">
                    <div class="ui right floated primary button">
                        <a href="getStaffDetail" style="color: white">修改信息</a>
                        <i class="right chevron icon"></i>
                    </div>
                    <div class="ui right floated primary button">
                        <a href="bloodBank" style="color: white">查看血库信息</a>
                        <i class="right chevron icon"></i>
                    </div>
                </div>
            </div>
        </div>
        <div class="ui divider"></div>
    </div>
</div>
