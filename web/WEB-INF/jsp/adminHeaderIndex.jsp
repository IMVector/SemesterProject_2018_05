<%-- 
    Document   : templete
    Created on : 2018-5-18, 8:36:08
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">导航栏</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">InstalHMS 医院系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="index">管理员主页</a></li>
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">医院管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">部门职能管理</a></li>
                        <li><a href="#">职工管理</a></li>
                        <li><a href="#">医务管理</a></li>
                    </ul>
                </li>
                 <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">网站管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">部门职能管理</a></li>
                        <li><a href="#">职工管理</a></li>
                        <li><a href="#">医务管理</a></li>
                    </ul>
                </li>
                <li><a href="#about">血库信息</a></li>
                <li><a href="#about">关于我们</a></li>
                <li><a href="#contact">联系方式</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <!--<li><a href="../navbar/">Default</a></li>-->
                <li>
                    <a href="personalCenter" class="navbar-brand">
                        <img src="resources/image/狗子.jpeg" class="img-circle" alt="资源丢失" style="height: 30px;">
                    </a>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

