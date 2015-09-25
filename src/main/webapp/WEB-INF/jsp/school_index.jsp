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
    <title>智慧校园</title>
    <link rel="stylesheet" href="static/css/frozen.css">
    <link rel="stylesheet" href="static/css/index.css">
</head>
<body>
<div class="contain">
    <div class="page">
        <div class="head">
             <a href="showStudent">
              <c:if test="${user.headimgurl==null || user.headimgurl==''}">
                  <img src="static/image/index/sculpture.png">
              </c:if>
             <c:if test="${user.headimgurl!=null && user.headimgurl!=''}">
                  <img src="${user.headimgurl}">
              </c:if>
              </a>
        </div>
        <div class="content">
            <div class="table">
                <div class="row">
                    <a href="dormRepair">
                        <img src="static/image/index/fix.png">
                        <p>寝室报修</p>
                    </a>
                    <a  href="static/pages/wait/justwait.html">
                        <img src="static/image/index/work.png">
                        <p>兼职</p>
                    </a>
                    <a  href="static/pages/wait/justwait.html">
                        <img src="static/image/index/found.png">
                        <p>失物招领</p>
                    </a>
                </div>
            </div>
            <div class="table">
                <div class="row">
                    <a  href="static/pages/wait/justwait.html">
                        <img src="static/image/index/schedule.png">
                        <p>课程表</p>
                    </a>
                    <a  href="static/pages/wait/justwait.html">
                        <img src="static/image/index/exercise.png">
                        <p>题库</p>
                    </a>
                    <a  href="http://shequ.kdweibo.com/shequ/accounts/basics/559a417ae4b0687f3fce7fa4">
                        <img src="static/image/index/talk.png">
                        <p>校话</p>
                    </a>
                </div>
            </div>
            <div class="last">
                <div class="lastrow">
                    <a  href="static/pages/wait/justwait.html">
                        <img src="static/image/index/online.png">
                        <p>online</p>
                    </a>
                    <a  href="static/pages/wait/justwait.html">
                        <img src="static/image/index/announce.png">
                        <p>公告</p>
                    </a>
                    <a></a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>