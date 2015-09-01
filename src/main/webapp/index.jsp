<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<script>
var name =encodeURIComponent("中文");
 name ='%E4%B8%AD%E6%96%87'
var headimgurl = "http://wx.qlogo.cn/mmopen/WDzXnP0k1oR21endXhZk04CUM9EnGibk81u1ia3aOgz939B3mmKYDuaDhhVGJDbdY1Fxgnj2zw9zPSrmYOxsmHmw/0"
headimgurl = encodeURIComponent(headimgurl);
url ="http://localhost:8080/WuHanCloudLiving/showIndex?openid=oAULZwp8n1ZtBegw5Q13qkdFBP0W5&nickname="+name+"&headimgurl=" +headimgurl ;
location.href=url;
//location.href="showSchoolList";
</script>
</html>