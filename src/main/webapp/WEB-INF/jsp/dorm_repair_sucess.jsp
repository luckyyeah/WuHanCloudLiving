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
<style type="text/css"> 
.divClass { 
border: 1px solid red; 
width: 200px; 
height: 200px; 
} 
.divImg{ 
height:100%;
width:100%; 

} 
</style> 
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
      <img class="divImg" src="static/image/repaire_sucess.jpg">
              
    </div>

</section>
</body>
</html>