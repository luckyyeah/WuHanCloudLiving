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
<div id="section_container_mask"></div><section id="student_info_section" class="active">
    <article class="active signup-hm" data-scroll="true" style="overflow: hidden;">
        <div class="main" style="transition-property: transform; -webkit-transition-property: transform; transform-origin: 0px 0px 0px; transform: translate(0px, 0px) translateZ(0px);">
            <div class="backpic">
                <form id="student_info_form" method="post">
                <ul class="info">
                    <li class="name">
                        <img src="static/image/name.png">
                        <input id="name" name="name" type="text" placeholder="真实姓名" value="${studentInfo.name}">
                    </li>
                    <li class="tel">
                        <img src="static/image/tel(1).png">
                        <input id="tel" name="tel" type="text" placeholder="电话号码" value="${studentInfo.tel}">
                    </li>
                    <li class="cardnum">
                        <img src="static/image/id.png">
                        <input id="id_card" name="id_card" type="text" placeholder="身份证号" value="${studentInfo.id_card}">
                    </li>
                </ul>
                <input type="hidden" id="open_id" name="open_id" value="${user.open_id}">
                </form>
                <div class="sign">
                    <button id="student_info_save_btn">保存修改</button>
                </div>
            </div>
        </div>
    </article>
</section></div>
<!-- lib -->
<!-- lib -->
<script type="text/javascript" data-requirecontext="_" data-requiremodule="student_info" src="static/js/student_info.js"></script>
<script type="text/javascript" src="static/js/require.js"></script>
<!--- app --->
<script type="text/javascript" src="static/js/app.js"></script>
<div id="jingle_toast"></div><div id="jingle_popup" style="display: none;" class="loading"></div><div id="jingle_popup_mask" style="opacity: 0.1; display: none;"></div>

</body>
</html>
