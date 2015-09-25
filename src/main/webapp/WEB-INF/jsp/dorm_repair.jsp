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
    <title>学校</title>
    <link rel="stylesheet" href="static/css/frozen.css">
    <link rel="stylesheet" href="static/css/person/fillCommunity.css">
    <link rel="stylesheet" href="static/css/sweetalert.css">
</head>
<body ontouchstart="">
<section class="ui-container">
    <div class="content">
        <div class="con-head">
           填写报修信息
        </div>
       <div class="information ui-whitespace" style="padding-left:5px;padding-right:5px;">
           <form id="dorm_repair_form">
               <div>
                   <label>&nbsp;&nbsp;&nbsp;&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;话：</label>
                   <input type="tel" id="tel" name="tel" value="${user.tel}">
               </div>
               
               <div>
                   <label>&nbsp;&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;校：</label>
                   <select name="area_a" id="area_a" data-placeholder="请选择组">
	                    <option value="">选择学校</option>
                    <c:forEach items="${listAreaA}" var="dormRepairEntity">
                        <option value="${dormRepairEntity.area_a }" <c:if test="${dormRepairEntity.area_a == user.school }">selected</c:if>>${dormRepairEntity.area_a_name}</option>
                    </c:forEach>
                    </select>
               </div>
               
               <div>
                   <label>&nbsp;&nbsp;&nbsp;&nbsp;楼&nbsp;&nbsp;&nbsp;&nbsp;栋：</label>
                   <select name="area_b" id="area_b">
                       <option value="">选择楼栋</option>
                   <c:forEach items="${listAreaB}" var="dormRepairEntity">
                       <option value="${dormRepairEntity.area_b }" >${dormRepairEntity.area_b_name}</option>
                   </c:forEach>
                   </select>
               </div>
               
               <div>
                   <label>&nbsp;&nbsp;&nbsp;&nbsp;楼&nbsp;&nbsp;&nbsp;&nbsp;层：</label>
                   <select name="area_f" id="area_f">
                       <option value="">选择楼层</option>
                   </select>
               </div>
               
               <div>
                   <label>&nbsp;&nbsp;&nbsp;&nbsp;寝室号：</label>
                   <select name="area_r" id="area_r">
                       <option value="">选择寝室号</option>
                   </select>
               </div>
               
               <div>
                   <label>预约时间：</label>
                   <select name="repair_time" id="repair_time">
                       <option value="">选择预约维修时间</option>
                   <c:forEach items="${listRepairTime}" var="repairTimeMap">
                       <option value="${repairTimeMap.repair_time }" <c:if test="${repairTimeMap.repair_time  == pd.repair_time}">selected</c:if>>${repairTimeMap.repair_time}</option>
                   </c:forEach>
                   </select>
               </div>
               
               <div>
                   <label>报修类型：</label>
                   <select name="class_a" id="class_a">
                       <option value="">选择报修类型</option>
                    <c:forEach items="${listClassA}" var="dormRepairEntity">
                       <option value="${dormRepairEntity.class_a }" <c:if test="${dormRepairEntity.class_a == pd.class_a }">selected</c:if>>${dormRepairEntity.class_a_name}</option>
                   </c:forEach>
                   </select>
               </div>
               
               <div>
                   <label>保修内容：</label>
                   <select name="class_b" id="class_b">
	                   <option value="">选择报修内容</option>
	               </select>
               </div>
           </form>
       </div>
        <div class="ui-btn-wrap">
            <button class="ui-btn-lg ui-btn-primary" onclick="javascript:void(0);" id="dorm_repair_btn">提交报修</button>
        </div>

    </div>

</section>
<script src="static/js/sweetalert.min.js"></script>
<script src="static/js/zepto.min.js"></script>
<script src="static/js/frozen.js"></script>
<script type="text/javascript" src="static/js/require.js"></script>

<!--- app --->
<script type="text/javascript" src="static/js/app.js"></script>

<div id="jingle_toast"></div><div id="jingle_popup" style="display: none;" class="loading"></div><div id="jingle_popup_mask" style="opacity: 0.1; display: none;"></div>
<script type="text/javascript" data-requirecontext="_" data-requiremodule="dorm_repair" src="static/js/dorm_repair.js"></script>
</body>
</html>