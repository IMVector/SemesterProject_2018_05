/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *  ajax封装函数
 * @param {type} url
 * @param {type} successFun
 * @param {type} reqType
 * @param {type} reqData
 * @returns {undefined}        
 */
function getSomethingByAjax(url, successFun, async, reqType, reqData) {
    reqType = reqType || "POST";
    reqData = reqData || {};
    async = async && true;
    $.ajax({
        url: url,
        type: reqType,
        data: reqData,
        async: async,
        success: successFun,
        error: function (req, status, error) {
            toastError("请求失败，请重试！ajax封装器BUG请检查");
        }
    });
}

/**
 * 
 * @param {type} pageContainerId 存放分页按钮的容器ID
 * @param {type} pageShowElementId 显示当前页码的容器ID
 * @param {type} pageNum 总页数
 * @param {type} currentPage 当前页数
 * @param {type} reqUrl 请求路径
 * @param {type} showTableFun 显示表格的函数
 * @returns {undefined}   
 */
function pagination(pageContainerId, pageShowElementId, pageNum, currentPage, reqUrl, showTableFun) {
    $('#' + pageContainerId).jqPaginator({
        totalPages: parseInt(pageNum),
        visiblePages: 5,
        currentPage: parseInt(currentPage),
        first: '  <button class="ui button">首页</button>',
        prev: '   <button  class="ui button">上一页</button>',
        next: '  <button  class="ui button">下一页</button>',
        last: ' <button  class="ui button">尾页</button>',
        page: ' <button class="ui basic button btn">{{page}}</button>',
        activeClass: 'blue',
        onPageChange: function (num) {
            $('#' + pageShowElementId).html('当前第' + num + '页');
            //发送ajax请求
            var url = reqUrl.replace("page_key_word", num)
            getSomethingByAjax(url, showTableFun, true);
            //alert('请求次数');
        }
    });
}

/**
 * 根据总的Item数量计算总页数
 * @param {type} itemNum item的数量
 * @returns {unresolved}  返回总页数      
 */
function calPageNum(itemNum) {

    itemNum = parseInt(itemNum);
    var pageNum = 0;
    if (itemNum % 5 == 0) {
        pageNum = itemNum / 5;
    } else {
        pageNum = itemNum / 5 + 1;
    }
    if (pageNum == 0 || isNaN(pageNum)) {
        pageNum = 1;
    }
    return parseInt(pageNum);
}



/**
 * 
 * @param {type} pageContainerId 存放分页按钮的容器ID
 * @param {type} pageShowElementId 存放当前页码的容器ID
 * @param {type} dropDownListElementId 下拉列表的Id
 * @param {type} currentPage 要请求的页码
 * @param {type} reqUrl 请求路径
 * @param {type} showTableFun 显示表格函数
 * @returns {undefined}          */
function fillForm(pageContainerId, pageShowElementId, dropDownListElementId, currentPage, reqUrl, showTableFun, totalItemFun) {
    var itemNum = totalItemFun();
    var pageNum = calPageNum(itemNum);//计算总页数
    pagination(pageContainerId, pageShowElementId, pageNum, currentPage, reqUrl, showTableFun);//调用分页并根据当前页查询数据
    $("#" + dropDownListElementId).empty();
    $("#" + dropDownListElementId).append('<option value="0">页码</option>');
    for (var i = 1; i <= pageNum; i++) {
        $("#" + dropDownListElementId).append("<option value='" + i + "'>第" + i + "页</option>");
    }
}


/**
 * 
 * @param {type} pageContainerId 存放分页按钮的容器ID
 * @param {type} pageShowElementId 存放当前页码的容器ID
 * @param {type} dropDownListElementId 下拉列表的Id
 * @param {type} reqUrl 请求路径
 * @param {type} showTableFun 显示表格函数
 * @returns {undefined}          */
function goToThPage(pageContainerId, pageShowElementId, dropDownListElementId, reqUrl, showTableFun, totalItemFun) {
    var pageTh = $("#" + dropDownListElementId).val();
    fillForm(pageContainerId, pageShowElementId, dropDownListElementId, currentPage = pageTh, reqUrl, showTableFun, totalItemFun);
}
/**
 * 显示模态框，等待用户确认
 * @param {type} title 模态框标题
 * @param {type} content 模态框内容
 * @returns {undefined}
 */
function showWarning(title, content,fun) {
    $(".warning_model").find(".header").html(title);
    $(".warning_model").find(".content").html("<p>" + content + "</p>");
    var flag = $('.warning_model').modal({
        closable: false,
        onDeny: function () {
            return false;
        },
        onApprove: function () {
            fun();
            return true;
        }
    }).modal('show');
}