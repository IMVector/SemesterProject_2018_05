<%-- 
    Document   : patientOperateTemplete
    Created on : 2018-5-18, 15:34:06
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="ui cards">
    <div class="card">
        <div class="content">
            内容 1
        </div>
        <div class="content">
            内容 2
        </div>
        <div class="content">
            内容 3
        </div>
        <div class="extra content">
            额外内容
        </div>
    </div>
</div>
<div class="ui vertical pointing menu">
    <a class="active item">查看个人病例 </a>
    <a class="item">查询个人账单 </a>
    <a class="item">查看处方 </a>
    <a class="item">查看检查报告 </a>
    <a class="item">查看个人健康报告 </a>
    <a class="item">修改个人信息 </a> 
</div>


<div class="ui cards">
    <div class="card">
        <div class="panel-heading">操作</div>
        <!--<div class="">-->
        <a href="medicalRecord" class="content">查看个人病例</a>
        <a href="billReport" class="content">查询个人账单</a>
        <a href="#" class="content">查看处方</a>
        <a href="#" class="content">查看检查报告</a>
        <a href="#" class="content">查看个人健康报告</a>
        <a href="#" class="content">修改个人信息</a>
        <!--</div>-->
    </div>
</div>

<h1>
    <p>这边提供病人能够进行的操作</p>
</h1>