<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head >
	<base href="<%=basePath%>">
  <title>学校</title>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <link rel="stylesheet" href="static/css/Jingle.min.css">
    <link rel="stylesheet" href="static/css/school.css">
    <script>
        var C = {
            'bingding' : 0        };
    </script>

<body>
<div id="section_container">
<div id="section_container_mask"></div><section id="school_add_section" class="active">
    <article class="active fillpart-hm" data-scroll="true" style="overflow: hidden;">
        <div class="main" style="transition-property: transform; -webkit-transition-property: transform; transform-origin: 0px 0px 0px; transform: translate(0px, 0px) translateZ(0px);">
            <div class="bar">
                <p>填写学校</p>
            </div>
            <div class="uploadinfo">
                <form id="school_add_form">
                <div class="personal">
                    <ul>
                        <li>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;校：</span>
		                    <select class="form-control" name="school" id="school" data-placeholder="请选择组" style="vertical-align:top;">
							<option value="">选择学校</option>
							<c:forEach items="${listAreaA}" var="dormRepairEntity">
								<option value="${dormRepairEntity.area_a }" <c:if test="${dormRepairEntity.area_a == user.school }">selected</c:if>>${dormRepairEntity.area_a_name}</option>
							</c:forEach>
							</select>    
                        </li>
         
                    </ul>
                </div>
                <input type="hidden" id="open_id" name="open_id" value="${user.open_id}">
                </form>
                <div class="submit">
                    <a href="javascript:void(0);" id="school_add_btn">
	                    <c:if test="${user.school==null || user.school==''}">
	                    	确认添加
	                    </c:if>
	                     <c:if test="${user.school!=null && user.school!=''}">
	                    	确认修改
	                    </c:if> 
                    </a>
                </div>
            </div>
        </div>
    </article>
</section></div>
<!-- lib -->
<!-- lib -->
<script type="text/javascript" data-requirecontext="_" data-requiremodule="school_add" src="static/js/school_add.js"></script>
<script type="text/javascript" src="static/js/require.js"></script>
<!--- app --->
<script type="text/javascript" src="static/js/app.js"></script>
<div id="jingle_toast"></div><div id="jingle_popup" style="display: none;" class="loading"></div><div id="jingle_popup_mask" style="opacity: 0.1; display: none;"></div>

</body>
</html>
