<%-- 
    Document   : bloodBank
    Created on : 2018-6-9, 17:44:07
    Author     : 刘福港
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="resources/js/jquery-3.2.1.min.js"></script>
        <base href="${pageContext.request.contextPath}/">
        <title>血液信息库</title>
        <style>
            table.dataintable {
  margin-top:15px;
  border-collapse:collapse;
  border:1px solid #aaa;
  width:100%;
}
table.dataintable th {
  vertical-align:baseline;
  padding:5px 15px 5px 6px;
  background-color:#3F3F3F;
  border:1px solid #3F3F3F;
  text-align:left;
  color:#fff;
}
table.dataintable td {
  vertical-align:text-top;
  padding:6px 15px 6px 6px;
  border:1px solid #aaa;
}
        </style>
    </head>
    <body>
        <div>
            <h4>按血液类型查询捐献者：</h4>
            <select name="" id="lfg">

                <option value="A">A</option>
                <option value="B">B</option>
                <option value="O">0</option>
                <option value="AB">AB</option>


            </select>
            <input id="myquery" onclick="testFun()" value="查询" type="submit"/>
        </div>
        <br><br><br>
        <table id="LbloodList" class="dataintable">
            
        </table>
        <script>
            function testFun() {
                
                $.ajax({
                    url: 'bloodBank/getBloodList',
                    type: "GET",
                    async: false,
                    data: {"LbloodType": $("#lfg").val()},
                    success: function (list) { //服务器返回一个列表
                        //ajax提供append函数向选中的元素里面追加内容
$("#LbloodList").empty();
                        $("#LbloodList").empty(); //清空表格内容
                        $("#LbloodList").append("<tr><th>姓名</th><th>性别</th><th>血型</th><th>操作</th></tr>");
                        
                        //ajax提供each函数用于遍历集合中的元素
                        //each可提供两个参数
                        //1. 表示要遍历的集合
                        //2. 一个函数，表示要对集合中每个元素执行的操作
                        //1)第一个参数表示当前遍历的元素的索引
                        //2)第二个参数表示当前对象
                        $.each(list, function (index, Lblood) {
                             
                            var str = "<tr id=" + Lblood.recordId + "><td>" + Lblood.donorName + "</td><td>"
                                    + Lblood.donorGender + "</td><td>" + Lblood.donorBloodType + "</td><td><a href=\"javascript:deleteBloodRecord('" + Lblood.recordId + "');\">删除</a>&nbsp;&nbsp;&nbsp;<a href=\"bloodBank/getDonor?recordId=" + Lblood.recordId + "\">查看详细信息</a></td></tr>";
                            
                            $("#LbloodList").append(str);// 将当前学生的数据追加到表格中
                            
                        });
                         
                    },
                    error: function (request, status, error) {
                        //error对应的函数最多可接受3个参数
                        //1.请求对象 
                        //2.请求状态
                        //3.错误对象
                        alert("Ajax请求失败!!!" + error);
                    }
                });
            }
            //定义一个函数,根据学号删除学生
            function deleteBloodRecord(recordId) {
                $.ajax({
                    url: 'bloodBank/delectBloodRecord',
                    type: "POST",
                    data: {"recordId": recordId}, //发送学号给服务器删除学生
                    success: function () {
                        //服务器删除学生的同时从表格删除当前行
                        //需要在打印tr的时候给每个tr一个id用于区分没一行
                        $("#" + recordId).remove(); //remove删除当前元素和其内容
                    },
                    error: function () {
                        alert("Ajax请求失败!");
                    }
                });
            }
//            function getDonor(recordId){
//                $.ajax({
//                    url:'bloodBank/getDonor',
//                    type:"POST",
//                    data:{"recordId":recordId}, //发送学号给服务器删除学生
//                    success:function(BloodBank){
//                        //服务器删除学生的同时从表格删除当前行
//                        //需要在打印tr的时候给每个tr一个id用于区分没一行
//                        $("#donorDetail").empty(); //清空表格内容
//                        $("#donorDetail").append("<tr><th>姓名</th><th>性别</th><th>血型</th><th>家庭住址</th><th>家庭住址</th></tr>");
//                    },
//                    error:function(){
//                        alert("Ajax请求失败!");
//                    }
//                });
//            }



            function test(a, b, c) {}

        </script>

    </body>
</html>
