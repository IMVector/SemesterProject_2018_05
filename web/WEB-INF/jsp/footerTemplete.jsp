<%-- 
    Document   : footerTemplete
    Created on : 2018-5-18, 15:08:26
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="ui footer">
    <center>
        <p class="ui header orange bottom">©版权所有：firefly小组</p>

        <div id="weather"></div>
    </center>
</div>
<script>
    $(document).ready(function () {
        $.ajax({
            url: "weather",
            type: 'POST',
            data: {},
            success: function (data, textStatus, jqXHR) {
                $.each(data, function (k, v) {
                    $("#weather").append(v+"\t")
                });

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("请求失败" + errorThrown);
            }
        })
    })
</script>