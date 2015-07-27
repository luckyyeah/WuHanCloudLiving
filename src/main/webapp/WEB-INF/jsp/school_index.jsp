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
    <title>学校</title>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <link rel="stylesheet" href="static/css/Jingle.min.css">
    <link rel="stylesheet" href="static/css/school.css">
    <script>
        var C = {
            'bingding' : 0        };
       
    </script>
</head>
<body>
<div id="section_container">
    <section id="index_section" class="active">
        <article class="active coindex-hm" data-scroll="true">
            <div class="commu-main">
                <div class="header">
                    <div class="avatar">
                        <a href="javascript:void(0);" data-target="section">
                        <c:if test="${user.headimgurl==null || user.headimgurl==''}">
                            <img src="static/image/usr_default.png">
                        </c:if>
                       <c:if test="${user.headimgurl!=null && user.headimgurl!=''}">
                            <img src="${user.headimgurl}">
                        </c:if>
                        </a>
                    </div>
                    <div class="info">
                        <a href="showStudentInfo" data-target="section" class="name">
                            <!--<span class="name"></span>-->
                            ${user.nickname}
			            </a>
			            <c:if test="${user.school==null || user.school==''}">
			              <a href="schoolAdd#school_section" data-target="section" class="position">
                           	加入学校                                                    
		                </a>
			            </c:if>
			            <c:if test="${user.school!=null && user.school!=''}">
                        <a href="schoolAdd#school_section" data-target="section" class="position">
                           	${user.school_name}                                                
		                </a>
		                </c:if>
                    </div>
                    <div class="manage">
                        <a href="showSchoolList" data-target="section">学校管理</a>
                    </div>
                </div>
                <div class="common">
                    <div class="row clearfix">
                        <a href="dormRepair#school_section" data-target="section">
                            <img src="static/image/repair.png">
                            <p>寝室报修</p>
                        </a>
                    </div>
                    <div class="tel clearfix">
                        <a href="tel:">
                          
                            <span class="wdwy"></span>
                            <span class="wdtel"></span>
                        </a>
                    </div>
            </div>
        </article>
    </section>
</div>

<!-- lib -->
<script type="text/javascript" src="static/js/require.js"></script>
</body>
</html>