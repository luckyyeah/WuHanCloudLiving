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
  <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>社区-个人资料</title>
    <link rel="stylesheet" href="static/css/frozen.css">
    <link rel="stylesheet" href="static/css/person/personinfo.css">
</head>
<body>
<section class="ui-container">
<div class="content">
    <div class="sculpture">
            <c:if test="${user.headimgurl==null || user.headimgurl==''}">
                <img src="static/image/usr_default.png">
            </c:if>
           <c:if test="${user.headimgurl!=null && user.headimgurl!=''}">
                <img src="${user.headimgurl}">
            </c:if>
    </div>
    <form id="student_info_form" method="post">
    <div class="information">
        <div class="name">
            <div class="common clear">
                <div class="icon">
                    <img src="static/image/person/personinfo/name.png">
                </div>
                <input id="name" name="name" type="text" placeholder="真实姓名" value="${studentInfo.name}">
            </div>
        </div>
        <div class="phone">
            <div class="common  clear">
                <div class="icon">
                  <img src="static/image/person/personinfo/phone.png">
                </div>
                <input id="tel" name="tel" type="text" placeholder="电话号码" value="${studentInfo.tel}">
            </div>
        </div>
        <div class="card">
            <div class="common  clear">
                <div class="icon">
                    <img src="static/image/person/personinfo/card.png">
                </div>
                <input id="id_card" name="id_card" type="text" placeholder="身份证号" value="${studentInfo.id_card}">
            </div>
        </div>
    </div>
           <input type="hidden" id="open_id" name="open_id" value="${user.open_id}">
       </form>
    <div class="save">
        <button id="student_info_save_btn">保存修改</button>
    </div>

</div>
</section>
<!-- lib -->
<!-- lib -->

<script type="text/javascript" src="static/js/require.js"></script>
<!--- app --->
<script type="text/javascript" src="static/js/app.js"></script>
<div id="jingle_toast"></div><div id="jingle_popup" style="display: none;" class="loading"></div><div id="jingle_popup_mask" style="opacity: 0.1; display: none;"></div>
<script type="text/javascript" data-requirecontext="_" data-requiremodule="student_info" src="static/js/student_info.js"></script>
</body>
</html>
