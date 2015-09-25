<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>寝室报修</title>
    <%@ include file="./wxtop.jsp" %>
</head>
<body style="background-color: #eee">
<div class="am-g account-head">
    <div class="avatar">
        <img src="${user.headimgurl}">
    </div>
    <div class="account-info">
        <span>${user.nickname} </span>
        
    </div>
</div>
<div style="clear: both;"></div>
<div class="am-g account-list">
    <a href="showDormRepairHistory">
        <div class="am-u-sm-12 account-ul">
            <div class="account-item">
                <i class="am-icon-history am-icon-sm"></i>我的报修
                <span class="am-icon-angle-right am-icon-md"></span>
            </div>
        </div>
    </a>
    <a href="dormRepair">
        <div class="am-u-sm-12 account-ul">
            <div class="account-item account-item-last">
                <i class="am-icon-legal am-icon-sm"></i>寝室报修
                <span class="am-icon-angle-right am-icon-md"></span>
            </div>
        </div>
    </a>
</div>
</body>
</html>