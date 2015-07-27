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
<div id="section_container_mask"></div><section id="school_list_section" class="active">
    <article class="active search-hm" data-scroll="true" >
        <div class="search-main" >
          <form id="school_list_form" action="showSchoolList" method="post">
            <div class="searchrow clearfix">
                <div class="icon">
                    <a href="javascript:void(0);" id ="school_list_search">
                        <img src="static/image/search.png" >
                    </a>
                </div>
                <div class="coinput">
                    <input id="area_a_name" name="area_a_name" type="text" value="${pd.area_a_name}">
                </div>
            </div>
            </form>
            <div class="colists">
                <ul>
		           <c:forEach items="${mapSchool}" var="schoolInfo">
                          <li class="letter">
                             <span>${schoolInfo.key}</span>
                         </li>
                          
                         <c:forEach items="${schoolInfo.value}" var="dormRepairEntity">
                         <li>
                            <a href="">
                           ${dormRepairEntity.area_a_name}
                               </a>
                             </li>
                         </c:forEach>
		                        
					</c:forEach>
                  </ul>
            </div>
        </div>
   </article>
</section></div>
<!-- lib -->
<!-- lib -->
<script type="text/javascript" data-requirecontext="_" data-requiremodule="school_list" src="static/js/school_list.js"></script>
<script type="text/javascript" src="static/js/require.js"></script>
<!--- app --->
<script type="text/javascript" src="static/js/app.js"></script>
<div id="jingle_toast"></div><div id="jingle_popup" style="display: none;" class="loading"></div><div id="jingle_popup_mask" style="opacity: 0.1; display: none;"></div>

</body>
</html>
