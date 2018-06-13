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
                            <div class="ui header red segment">
                                网站图片管理
                            </div>

                            <div class="ui link cards">
                                <div class="card">
                                    <div class="image">
                                        <img src="resources/image/狗子.jpeg">
                                    </div>
                                    <div class="content">
                                        <div class="header">Matt Giampietro</div>
                                        <div class="meta">
                                            <a>Friends</a>
                                        </div>
                                        <div class="description">
                                            Matthew is an interior designer living in New York.
                                        </div>
                                    </div>
                                    <div class="extra content">
                                        <span class="right floated">
                                            Joined in 2013
                                        </span>
                                        <span>
                                            <i class="user icon"></i>
                                            75 Friends
                                        </span>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="image">
                                        <img src="resources/image/狗子.jpeg">
                                    </div>
                                    <div class="content">
                                        <div class="header">Molly</div>
                                        <div class="meta">
                                            <span class="date">Coworker</span>
                                        </div>
                                        <div class="description">
                                            Molly is a personal assistant living in Paris.
                                        </div>
                                    </div>
                                    <div class="extra content">
                                        <span class="right floated">
                                            Joined in 2011
                                        </span>
                                        <span>
                                            <i class="user icon"></i>
                                            35 Friends
                                        </span>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="image">
                                        <img src="resources/image/狗子.jpeg">
                                    </div>
                                    <div class="content">
                                        <div class="header">Elyse</div>
                                        <div class="meta">
                                            <a>Coworker</a>
                                        </div>
                                        <div class="description">
                                            Elyse is a copywriter working in New York.
                                        </div>
                                    </div>
                                    <div class="extra content">
                                        <span class="right floated">
                                            Joined in 2014
                                        </span>
                                        <span>
                                            <i class="user icon"></i>
                                            151 Friends
                                        </span>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="image">
                                        <img src="resources/image/狗子.jpeg">
                                    </div>
                                    <div class="content">
                                        <div class="header">Elyse</div>
                                        <div class="meta">
                                            <a>Coworker</a>
                                        </div>
                                        <div class="description">
                                            Elyse is a copywriter working in New York.
                                        </div>
                                    </div>
                                    <div class="extra content">
                                        <span class="right floated">
                                            Joined in 2014
                                        </span>
                                        <span>
                                            <i class="user icon"></i>
                                            151 Friends
                                        </span>
                                    </div>
                                </div>
                                <form  id="imageForm" enctype="multipart/form-data">
                                    <div> 
                                        <!--![](${path}/mall/image/load_image.png)-->
                                        <input type="file" id="input-image" name="input-image"> 
                                        <!--<input id="input-relative-path" name="imgs" type="hidden" >-->
                                        <!--<input id="input-last-path" type="hidden">--> 
                                        <input type="button" onclick=" updateImage()" value="上传图片"> 
                                    </div> 
                                </form>
                            </div>
                        </div>
                    </div>
                </div>




            </div>
            <!-- /container -->
            <jsp:include page="footerTemplete.jsp" />
    </body>
    <script>
        function updateImage() {
            $.ajax({
                url: "upload/uploadImage",
                type: 'POST',
                cache: false,
                data: new FormData($("#imageForm")[0]),
                processData: false,
                contentType: false,
                success: function (data) {
//                    alert("上传成功");
                    toastSuccess("上传成功")
                },
                error: function (jqXHR, textStatus, errorThrown) {
//                  toastError("请求失败" + errorThrown);
                    toastError("请求失败，请重试！" + errorThrown);
                }
            })
        }
    </script>
</html>