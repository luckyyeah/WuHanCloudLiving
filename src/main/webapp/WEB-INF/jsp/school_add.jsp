<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <link rel="stylesheet" href="static/css/frozen.css">
    <link rel="stylesheet" href="static/css/person/fillCommunity.css">
    <base href="<%=basePath%>">
    <title>学校</title>
    <script>
        var C = {
            'bingding' : 0        };
    </script>
</head>
<body ontouchstart="">
<section class="ui-container">
    <div class="content">
        <div class="con-head">
            填写学校
        </div>
       <div class="information ui-whitespace">
           <form id="school_add_form">
               <div>
                   <label>学&nbsp;&nbsp;&nbsp;&nbsp;校：</label>
                   <select class="form-control" name="school" id="school" data-placeholder="请选择组">
	                   <option value="">选择学校</option>
	                   <c:forEach items="${listAreaA}" var="dormRepairEntity">
	                       <option value="${dormRepairEntity.area_a }" <c:if test="${dormRepairEntity.area_a == user.school }">selected</c:if>>${dormRepairEntity.area_a_name}</option>
	                   </c:forEach>
                   </select>
               </div>
           </form>
       </div>
        <div class="ui-btn-wrap">
            <button class="ui-btn-lg ui-btn-primary" onclick="javascript:void(0);" id="school_add_btn">
				<c:if test="${user.school==null || user.school==''}">确认添加</c:if>
				<c:if test="${user.school!=null && user.school!=''}">确认修改</c:if> 
            </button>
        </div>

    </div>

</section>
<script src="static/js/zepto.min.js"></script>
<script src="static/js/frozen.js"></script>
<script type="text/javascript" data-requirecontext="_" data-requiremodule="school_add" src="static/js/school_add.js"></script>
<script type="text/javascript" src="static/js/require.js"></script>
<script type="text/javascript" src="static/js/app.js"></script>
<div id="jingle_toast"></div><div id="jingle_popup" style="display: none;" class="loading"></div><div id="jingle_popup_mask" style="opacity: 0.1; display: none;"></div>
</body>
</html>