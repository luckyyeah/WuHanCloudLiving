<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>个人信息</title>
    <link rel="stylesheet" href="static/css/frozen.css">
    <link rel="stylesheet" href="static/css/person/person.css">
</head>
<body>
    <div class="contain">
        <div class="head">
        </div>
        <div class="sculpture">
            <a href="showStudentInfo">
                <c:if test="${user.headimgurl==null || user.headimgurl==''}">
                    <img src="static/image/usr_default.png">
                </c:if>
               <c:if test="${user.headimgurl!=null && user.headimgurl!=''}">
                    <img src="${user.headimgurl}">
                </c:if>
            </a>
        </div>
        <div class="name">
            <p class="nameone"> ${user.nickname}</p>
            <p class="nametwo">	${user.school_name}</p>
        </div>
        <div class="main">
            <a href="showStudentInfo" class="ui-arrowlink">个人资料</a>
            <a href="schoolAdd" class="ui-arrowlink">学校管理</a>
        </div>
    </div>
</body>
</html>
