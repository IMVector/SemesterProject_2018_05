<%-- 
    Document   : warningModel
    Created on : 2018-6-13, 10:22:02
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<button class="ui button blue" onclick="showWarning('Warning','是否要删除所选行')">show</button>
<div class="ui mini modal warning_model">
    <div class="header">
        <!--Delete Your Account-->
    </div>
    <div class="content">
        <!--<p>Are you sure you want to delete your account</p>-->
    </div>
    <div class="actions">
        <div class="ui negative button">
            No
        </div>
        <div class="ui positive right labeled icon button">
            Yes
            <i class="checkmark icon"></i>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {

    });
    function showWarning(title, content) {
        $(".warning_model").find(".header").html(title)
        $(".warning_model").find(".content").html("<p>" + content + "</p>");
        $('.warning_model').modal({
            closable: false,
            onDeny: function () {
                return false;
            },
            onApprove: function () {
                return true;
            }
        }).modal('show');
    }
</script>