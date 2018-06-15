<%-- 
    Document   : about
    Created on : 2018-6-15, 8:21:15
    Author     : Vector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>医院简介</title>
        <jsp:include page="resourcesTemplete.jsp"/>
        <style>
            body
            {

                margin:34px 0 0 37px;
            }
            .font_{
                color: #fe6673;
                font:18px/14px Georgia, "Times New Roman", Times, serif;
            }
            #card_parent {
                display: flex;
                /*实现垂直居中*/
                /*align-items: center;*/
                /*实现水平居中*/
                justify-content: center;
            }

        </style>
    </head>
    <body>
        <!--<div class="ui container">-->
        <jsp:include page="patientHeaderTemplete.jsp"/>
        
        <div class="ui grid body-under-header">
            <div class="ui four wide column">

                <div class="ui header blue segment">
                    医院简介
                </div>
                <div class="ui segment">
                    <img class="ui fluid image" src="resources/image/bgthird.png">
                    <div class="font_">
                        <p>1898年，滥觞于黄海之滨的德国野战医院，几乎与青岛市同时诞生。百年沧桑，守正出新，厚重的历史，一代又一代人薪火相传，非凡的发展历程及成就彰显了她在医学界显赫的地位和不朽功勋。她的创立演变史与青岛现代化开放发展史同步迈进，更与中国现代医院建设体系共时延伸。</p>
                        <p>一个多世纪的风云变幻，虽然历经磨难，但不坠亲民济世的青云之志。人道的从医精神和精细的技术追求在这里浩然传承。历代青医人以仁心妙术的医风，救死扶伤，发扬“大医精诚”风尚，铸就了她百年的荣光。今天的她，是一所集医疗、教学、科研、预防、保健、康复、业务技术指导为一体的省属大型综合性三级甲等医院。医院拥有四个院区——位于江苏路的市南院区，地处老城区，倚山靠海，古朴典雅；位于海尔路的崂山院区，地处青岛最繁华的东部，近海拥湾，端庄大气；位于青岛西海岸新区的西海岸院区，地处经济新区，气势恢弘，雄伟现代；位于老四方的市北院区，将建设成为以肿瘤综合诊治为主，内、外科门诊为辅的高端专科医院。2016年，医院门急诊量470万人次，居山东省第一位，连续三年跻身“中国最佳医院百强榜”。2017年开放床位3700余张，拥有国际一流的万元以上医学设备5800余台（件）。四个院区实行统一领导，不同院区各具特色、优势互补、协调发展。</p>
                        <p>医院设有临床业务科室75个，研究室（所）23个，拥有全国重点学科、省市重点学科、实验室及特色专业41个，其中，国家级重点学科（专科）2个，省级临床重点专科29个，省中医药重点专科3个。是临床医学、护理学一级学科博士学位培养单位，设有临床医学、护理学一级学科博士后科研流动站。</p>
                        <p>医院现有职工6000余人，其中高级专业技术人员800余名，博士生导师近百名，博士500余名，硕士1300余名，留学归国人员百余名。有各级各类学术专业委员会主委、副主委，享受国务院政府特殊津贴专家，有突出贡献中青年专家，山东省卫生系统杰出学科带头人和泰山学者岗位特聘专家，中青年重点科技人才等近200名，成为学科发展的中流砥柱。</p>
                        <p>以“博学慎思，笃行亲民”院训为指导，医院深入开展了“三百爱心工程”、“无障碍就医”等惠民、便民医疗服务和卫生强基、援边援外工作，探索建立了集团化发展模式，成功构建了惠及农村、城市社区群众的医疗集团纵向服务网络。</p>
                        <p>宏伟蓝图已绘就，扬帆前行正当时。承载着人类对生命的更高期望，盛世大任激励我们宏业图新。全院职工一定会不辱使命，站在新起点，实现新超越，开创一个良医济民、事业常青的新境界！</p>
                    </div>
                </div>   
            </div>
            <div class="ui eleven wide column">
                <!--<div class="ui segment"></div>-->
                <div class="ui header blue segment">
                    科室介绍
                </div>
                <div class="ui segment">
                    <div>
                        <div class="ui header blue segment">科室信息</div>
                        <div class="font_"  id="departmentInfo">
                        </div>
                    </div>
                    <br>
                    <div>
                        <div class="ui header blue segment">优秀医生</div>
                        <div>
                            <div id="card_parent" class="ui link cards" >
                                <!--显示有头像的医生-->

                            </div>
                        </div>

                        <div>
                            <p id="pageText"></p>
                            <div id="PageButtons" class="mini ui basic buttons">

                            </div>

                            <label for="" class="ui label">跳转到：</label>
                            <!--发送ajax请求-->
                            <select id="pageSelecter" class="mini ui button basic dropdown">
                                <option value="">页码</option>

                                <!--<option value="1">1</option>-->
                            </select>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <!--</div>-->
    </body>
<!--神经科，主要诊治脑血管疾病(脑梗塞、脑出血)、偏头痛、脑部炎症性疾病(脑炎、脑膜炎)、脊髓炎、癫痫(抽搐)、帕金森、癫痫、脑瘫、共济失调、扭转痉挛、孤独症、老年性痴呆、神经系统变性病、代谢病和遗传病、三叉神经痛、坐骨神经病、周围神经病(四肢麻木、无力)以及重症肌无力等神经疾病，采用CT、脑电图、TCD(经颅多普勒超声)及血流变学检查等检测手段。同时诊治神经衰弱、失眠等功能性疾患。-->
    <script>
        $(document).ready(function () {

            $.ajax({
                url: "getDepartmentByName/" + '${departmentName}',
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    $("#departmentInfo").empty();
                    $.each(data, function (index, department) {
                        $("#departmentInfo").append("<p>" + department.departmentDescription + "</p>");
                    });


                },
                error: function (jqXHR, textStatus, errorThrown) {
                    toastError("请求失败");
                }
            });

            var url = 'getStaffByDepartment/' + '${departmentName}' + '/page_key_word';
            fillForm("PageButtons", "pageText", "pageSelecter", currentPage = 1, url, getStaffWithImage, staffItemNumWithImage);

            $("#pageSelecter").on("change", function () {
                var url = 'getStaffByDepartment/' + '${departmentName}' + '/page_key_word';
                goToThPage("PageButtons", "pageText", "pageSelecter", url, getStaffWithImage, staffItemNumWithImage);
            });

        });

        function staffItemNumWithImage() {
            var itemNum = 0;

            $.ajax({
                url: "getStaffByDepartmentItemNum/" + '${departmentName}',
                type: 'POST',
                async: false,
                data: {},
                success: function (data, textStatus, jqXHR) {
                    //返回List项目总数量
                    itemNum = data;
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    toastError("请求失败,请重试！" + errorThrown);
                }
            });
            return itemNum;
        }
        function getStaffWithImage(data) {
            $("#card_parent").empty();
            $.each(data, function (index, staff) {
                var str = '<div class="card"><div class="image" ><img src="' + staff.image.imagePath + '"></div>\n\
                     <div class="content"><div class="header">' + staff.staffName + '</div>\n\
                    <div class="meta">座右铭</div><div class="description">' + staff.motto + '</div></div>\n\
                    <div class="extra content"><span class="right floated">' + staff.department.departmentName + '</span><span><i class="user icon"></i>' + staff.title.titleName + '</span></div></div > ';
                $("#card_parent").append(str);

            });
        }
    </script>
</html>
