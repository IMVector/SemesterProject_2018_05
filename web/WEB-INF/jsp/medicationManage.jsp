<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <jsp:include page="resourcesTemplete.jsp" />
    </head>

    <body>
        <jsp:include page="adminHeaderIndex.jsp" />

        <div class="ui fluid-container body-under-header">
            <div class="ui segment ">

                <div class="ui grid">

                    <jsp:include page="adminMenuTemplete.jsp"/>
                    <div class="eleven wide column">
                        <div class="ui segment">
                            <div class="ui header green segment">
                                药品信息管理
                            </div>
                            <table>
                                <tr>

                                    <td>
                                        <div class="ui input focus">
                                            <input placeholder="药品名称" type="text">
                                        </div>
                                    </td>
                                    <td> 
                                        <button class="ui basic button green">查询指定药品信息</button>
                                    </td>
                                    <td>
                                        <button class="ui basic button green">查询所有药品信息</button>
                                    </td>
                                    <td>
                                        <button id="add" class="ui basic button green">添加药品</button>
                                    </td>
                                </tr>
                            </table>

                            <table class="ui table green">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody><tr></tr></tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
            <div id="modeltest" class="ui inverted modal ">
                <div class="header">添加药品</div>
                <div class="content" style="text-align:center">
                    <div class="ui segment" style="width: 50%;margin: 0 auto">
                        <div class="ui header blue segment">药品信息</div>
                        <div class="field">
                            <label for="">药品名称：</label>
                            <div class="ui input ">
                                <input placeholder="药品名称" type="text">
                            </div>
                        </div>
                        <br/>
                        <div class="field">
                            <label for="">药品说明：</label>
                            <div class="ui input ">
                                <input placeholder="药品说明" type="text">
                            </div>
                        </div>
                        <br/>
                        <div class="field">
                            <label for="">药品功效：</label>

                            <div class="ui input ">
                                <input placeholder="药品功效" type="text">
                            </div>
                        </div>
                        <br/>
                        <div class="field">
                            <label for="">药品价格：</label>
                            <div class="ui input ">
                                <input placeholder="价格" type="text">
                            </div>
                        </div>

                        <br/>
                        <div class="field">
                            <label for="">有效期&nbsp&nbsp&nbsp&nbsp：</label>
                            <div class="ui input ">
                                <input placeholder="有效期" type="text">
                            </div>
                        </div>
                        <br/>
                        <div class="field">
                            <label for="">生产日期：</label>
                            <div class="ui input ">
                                <input placeholder="生产日期" type="date">
                            </div>
                        </div>
                        <br/>
                        <div class="field">
                            <label id="result" for=""></label>
                        </div>

                    </div>
                </div>
                <div class="actions">
                    <div class="ui black deny button">取消 </div>
                    <div class="ui positive right labeled icon button">添加 <i class="checkmark icon"></i> </div>
                </div>
            </div>

        </div>
        <jsp:include page="footerTemplete.jsp" />
    </body>

    <script>
        $(document).ready(function () {

            $("#add").click(function () {
                $('#modeltest')
                        .modal({
                            inverted: true,
                            closable: false,
                            onDeny: function () {
//                            window.alert('Wait not yet!');
                                return false;
                            },
                            onApprove: function () {
//                            window.alert('Approved!');
                            }
                        })
                        .modal('show')
                        ;
            });

        });

    </script>

</html>