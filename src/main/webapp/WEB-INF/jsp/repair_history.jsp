<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<head>
    <title>我的报修</title>
    <%@ include file="./wxtop.jsp" %>
</head>
<body style="background-color: #eee">
<c:choose>
    <c:when test="${not empty listDormRepairHistoryInfo}">
        <c:forEach items="${listDormRepairHistoryInfo}" var="dormRepairHistoryInf" varStatus="vs">
            <div class="am-g orderx-extra">
                 <div class="am-u-sm-12">
                 	 报修时间：${dormRepairHistoryInf.create_date} 
                </div>
            </div>        
            <div class="am-g orderx-extra">
                 <div class="am-u-sm-12">
                 	 手机：${dormRepairHistoryInf.tel} 
                </div>
            </div>
            <div class="am-g orderx-extra">
                <div class="am-u-sm-12">
                                                                     学校：${dormRepairHistoryInf.area_a_name} 
                </div>
            </div>            
            <div class="am-g orderx-extra">
                <div class="am-u-sm-12">
                 	 楼栋：${dormRepairHistoryInf.area_b_name} 
                </div>
            </div>
            <div class="am-g orderx-extra">
                <div class="am-u-sm-12">
                 	 楼层：${dormRepairHistoryInf.area_f_name} 
                </div>
            </div>            
            <div class="am-g orderx-extra">
                <div class="am-u-sm-12">
                 	 寝室号：${dormRepairHistoryInf.area_r_name} 
                </div>
             </div> 
            <div class="am-g orderx-extra">
                <div class="am-u-sm-12">
                 	预约维修时：${dormRepairHistoryInf.repair_time} 
                </div>
            </div>             
            <div class="am-g orderx-extra">
                <div class="am-u-sm-12">
                 	报修类型：：${dormRepairHistoryInf.class_a_name} 
                </div>
            </div> 
            <div class="am-g orderx-extra">
                <div class="am-u-sm-12">
                 	保修内容：${dormRepairHistoryInf.class_b_name} 
                </div>
            </div> 
            <div class="am-g orderx-extra-end ">
                <div class="am-u-sm-12">
                 	处理状态：${dormRepairHistoryInf.stat} 
                </div>
            </div>                                                
        </c:forEach>
    </c:when>
    <c:otherwise>
        <div class="am-g tips">
            <div class="am-u-sm-12">
              	  您还没有报修记录！
            </div>
        </div>
    </c:otherwise>
</c:choose>
</body>
<script>
    function confirmDelete(orderId) {
        swal({
                    title: "删除订单",
                    text: "您确定要删除吗？删除后不可恢复!",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    closeOnConfirm: false
                },
                function () {
                    location.href = "/order/order/" + orderId + "/delete";
                });
    }
</script>
</html>