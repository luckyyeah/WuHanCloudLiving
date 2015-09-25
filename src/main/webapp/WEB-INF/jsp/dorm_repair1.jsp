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
<div id="section_container_mask"></div><section id="dorm_repair_section" class="active">
    <article class="active fillpart-hm" data-scroll="true" >
        <div class="main" style="transition-property: transform; -webkit-transition-property: transform; transform-origin: 0px 0px 0px; transform: translate(0px, 0px) translateZ(0px);">
            <div class="bar">
                <p>填写报修信息</p>
            </div>
            <div class="uploadinfo">
                <form id="dorm_repair_form">
                <div class="personal">
                    <ul>
                        <li>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;话：</span>
                            <input type="tel" id="tel" name="tel" value="${user.tel}">
                        </li>
                        <li>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;校：</span>
		                    <select class="form-control" name="area_a" id="area_a" data-placeholder="请选择组" style="vertical-align:top;">
							<option value="">选择学校</option>
							<c:forEach items="${listAreaA}" var="dormRepairEntity">
								<option value="${dormRepairEntity.area_a }" <c:if test="${dormRepairEntity.area_a == user.school }">selected</c:if>>${dormRepairEntity.area_a_name}</option>
							</c:forEach>
							</select>    
                        </li>
                        <li>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;楼&nbsp;&nbsp;&nbsp;&nbsp;栋：</span>
                            <select name="area_b" id="area_b">
                                <option value="">选择楼栋</option>
                             <c:forEach items="${listAreaB}" var="dormRepairEntity">
								<option value="${dormRepairEntity.area_b }" >${dormRepairEntity.area_b_name}</option>
							</c:forEach>
                            </select>
                        </li>
                        <li>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;楼&nbsp;&nbsp;&nbsp;&nbsp;层：</span>
                            <select name="area_f" id="area_f">
                                <option value="">选择楼层</option>
                            </select>
                        </li>                        
                        <li>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;寝&nbsp;&nbsp;&nbsp;&nbsp;室&nbsp;&nbsp;&nbsp;&nbsp;号：</span>
                            <select name="area_r" id="area_r">
                                <option value="">选择寝室号</option>
                            </select>
                        </li>
                        <li>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;预约维修时间：</span>
                            <select name="repair_time" id="repair_time">
                                <option value="">选择预约维修时间</option>
                            <c:forEach items="${listRepairTime}" var="repairTimeMap">
								<option value="${repairTimeMap.repair_time }" <c:if test="${repairTimeMap.repair_time  == pd.repair_time}">selected</c:if>>${repairTimeMap.repair_time}</option>
							</c:forEach>
                            </select>
                        </li>                        
                       <li>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;报&nbsp;&nbsp;修&nbsp;&nbsp;类&nbsp;&nbsp;型：</span>
                            <select name="class_a" id="class_a">
                                <option value="">选择报修类型</option>
                              <c:forEach items="${listClassA}" var="dormRepairEntity">
								<option value="${dormRepairEntity.class_a }" <c:if test="${dormRepairEntity.class_a == pd.class_a }">selected</c:if>>${dormRepairEntity.class_a_name}</option>
							</c:forEach>
                            </select>
                        </li>
                         <li>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保&nbsp;&nbsp;修&nbsp;&nbsp;内&nbsp;&nbsp;容：</span>
                            <select name="class_b" id="class_b">
                                <option value="">选择保修内容</option>

                            </select>
                        </li>
                    </ul>
                </div>
                <input type="hidden" id="open_id" name="open_id" value="${user.open_id}">
                </form>
                <div class="submit">
                    <a href="javascript:void(0);" id="dorm_repair_btn">提交报修</a>
                </div>
            </div>
        </div>
    </article>
</section></div>
<!-- lib -->
<!-- lib -->


<script type="text/javascript" src="static/js/require.js"></script>
<!--- app --->
<script type="text/javascript" src="static/js/app.js"></script>

<div id="jingle_toast"></div><div id="jingle_popup" style="display: none;" class="loading"></div><div id="jingle_popup_mask" style="opacity: 0.1; display: none;"></div>
<script type="text/javascript" data-requirecontext="_" data-requiremodule="dorm_repair" src="static/js/dorm_repair.js"></script>
</body>
</html>
