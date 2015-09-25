<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jsp文件头和头部 -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no, minimal-ui"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black"/>
<meta name="format-detection" content="telephone=no, email=no"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black"/>
<!-- uc强制竖屏 -->
<meta name="screen-orientation" content="portrait">
<meta name="full-screen" content="yes">
<meta name="browsermode" content="application">
<!-- QQ强制竖屏 -->
<meta name="x5-orientation" content="portrait">
<meta name="x5-fullscreen" content="true">
<meta name="x5-page-mode" content="app">


<link rel="stylesheet" href="static/css/amazeui.min.css">
<link rel="stylesheet" href="static/css/sweetalert.css">
<link rel="stylesheet" href="static/css/font-awesome-4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="static/css/mui.min.css">
<link rel="stylesheet" href="static/css/app.css">
<link rel="stylesheet" href="static/css/extra.css">
<script src="static/js/jquery.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
<script src="static/js/sweetalert.min.js"></script>

<%
    String message = (String) request.getSession().getAttribute("message");
    request.getSession().removeAttribute("message");
    String nullMsg = null;
%>
<script>
    <c:choose>
    <c:when test="<%= message==nullMsg %>">
    </c:when>
    <c:otherwise>
    $(document).ready(function () {
        swal({title: "<%=message%>", timer: 1000, showConfirmButton: false});
    });

    </c:otherwise>
    </c:choose>
</script>
