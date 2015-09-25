
define(['Page', 'Jingle'], function(p, J) {
    var attach = function() {
        p.page('dorm_repair_section', function() {
        //    this.init = function(){
                var cache = {};
                $("#area_a").change(function(){
                    var _this = $(this);
                    if(_this.val() == ''){
                        $("#area_b").html('<option value="">选择楼栋</option>');
                        $("#area_f").html('<option value="">选择楼层</option>');
                        $("#area_r").html('<option value="">选择寝室号</option>');
                        $("#class_a").html('<option value="">选择报修类型</option>');
                    }else{
                        var val = _this.val();
                        if(!!cache[val]){
                          //  $("#area_b").html(cache[val]);
                        }
                        $.ajax({
                        	'type': "post", //请求方式
                            'url' : 'showAreaB',
                            'data' : { area_a : val },
                            'success' : function(json){
                            	$("#area_b").empty();
                            	var    optionstring = "<option value=''>选择楼栋</option>";
                            	 var objs = eval('(' + json + ')');
								for (var o in objs) {
								           
								        var     jsonObj  =  objs[o];
								         optionstring += "<option value=\"" + jsonObj.area_b + "\" >" + jsonObj.area_b_name + "</option>";
								   
								}
                            	$("#area_b").append(optionstring);   //为Select追加一个Option(下拉项)           
                               // $("#dorm").html(cache[val]);
                            }
                                            
                        });
                        $.ajax({
                        	'type': "post", //请求方式
                            'url' : 'showRepairClassA',
                            'data' : { area_a : val },
                            'success' : function(json){
                            	$("#class_a").empty();
                            	var    optionstring = "<option value=''>选择报修类型</option>";
                            	 var objs = eval('(' + json + ')');
								for (var o in objs) {
								           
								        var     jsonObj  =  objs[o];
								         optionstring += "<option value=\"" + jsonObj.class_a + "\" >" + jsonObj.class_a_name + "</option>";
								   
								}
                            	$("#class_a").append(optionstring);   //为Select追加一个Option(下拉项)           
                               // $("#dorm").html(cache[val]);
                            }
                        });
                    }
                });
                $("#area_b").change(function(){
                    var _this = $(this);
                    if(_this.val() == ''){
                        $("#area_f").html('<option value="">选择楼层</option>');
                        $("#area_r").html('<option value="">选择寝室号</option>');
                    }else{
                        var val = _this.val();
                        if(!!cache[val]){
                           // $("#area_f").html(cache[val]);
                        }
                        $.ajax({
                        	'type': "post", //请求方式
                            'url' : 'showAreaF',
                            'data' : { area_b : val },
                            'success' : function(json){
                            	$("#area_f").empty();
                            	var    optionstring = "<option value=''>选择楼层</option>";
                            	 var objs = eval('(' + json + ')');
								for (var o in objs) {
								           
								        var     jsonObj  =  objs[o];
								         optionstring += "<option value=\"" + jsonObj.area_f + "\" >" + jsonObj.area_f_name + "</option>";
								   
								}
                            	$("#area_f").append(optionstring);   //为Select追加一个Option(下拉项)           
                               // $("#dorm").html(cache[val]);
                            }
                        });
                                    
                    }
                });
                $("#area_f").change(function(){
                    var _this = $(this);
                    if(_this.val() == ''){
                        $("#area_r").html('<option value="">选择寝室号</option>');
                    }else{
                        var val = _this.val();
                        if(!!cache[val]){
                           // $("#area_r").html(cache[val]);
                        }
                        $.ajax({
                        	'type': "post", //请求方式
                            'url' : 'showAreaR',
                            'data' : { area_f : val },
                            'success' : function(json){
                            	$("#area_r").empty();
                            	var    optionstring = "<option value=''>选择寝室号</option>";
                            	 var objs = eval('(' + json + ')');
								for (var o in objs) {
								           
								        var     jsonObj  =  objs[o];
								         optionstring += "<option value=\"" + jsonObj.area_r + "\" >" + jsonObj.area_r_name + "</option>";
								   
								}
                            	$("#area_r").append(optionstring);   //为Select追加一个Option(下拉项)           
                               // $("#dorm").html(cache[val]);
                            }
                        });
                    }
                });
                $("#class_a").change(function(){
                    var _this = $(this);
                    if(_this.val() == ''){
                        $("#class_b").html('<option value="">选择报修内容</option>');
                    }else{
                        var val = _this.val();
                        if(!!cache[val]){
                            $("#class_b").html(cache[val]);
                        }
                        $.ajax({
                        	'type': "post", //请求方式
                            'url' : 'showRepairClassB',
                            'data' : { class_a : val},
                            'success' : function(json){
                            	$("#class_b").empty();
                            	var    optionstring = "<option value=''>选择报修内容</option>";
                            	 var objs = eval('(' + json + ')');
								for (var o in objs) {
								           
								        var     jsonObj  =  objs[o];
								         optionstring += "<option value=\"" + jsonObj.class_b + "\" >" + jsonObj.class_b_name + "</option>";
								   
								}
                            	$("#class_b").append(optionstring);   //为Select追加一个Option(下拉项)           
                               // $("#dorm").html(cache[val]);
                            }
                        });
                    }
                });
                $('#dorm_repair_btn').click(function(e){
                    var repair_form = $("#dorm_repair_form");
                    if(repair_form.find('#tel').val() == ''){
                        alert('请填写电话号码');
                        return false;
                    }
                    if(repair_form.find('#area_a').val() == ''){
                        alert('请选择学校');
                        return false;
                    }

                    if(repair_form.find('#area_b').val() == ''){
                        alert('请选择楼栋');
                        return false;
                    }

                    if(repair_form.find('#area_f').val() == ''){
                        alert('请选择楼层');
                        return false;
                    }
                    if(repair_form.find('#area_r').val() == ''){
                        alert('请选择寝室号');
                        return false;
                    }                  
                    if(repair_form.find('#repair_time').val() == ''){
                        alert('请选择预约维修时间');
                        return false;
                    }    
                    if(repair_form.find('#class_a').val() == ''){
                        alert('请选择报修类型');
                        return false;
                    }   
                    if(repair_form.find('#class_b').val() == ''){
                        alert('选择报修内容');
                        return false;
                    }
                    //alert(repair_form.serialize());
                    $.ajax({
                        'url' : 'addRepairInfo',
                        'data' : repair_form.serialize(),
                        'type' : 'POST',
                        'dataType' : 'json',
                        'success' : function(json){

                          //  if(json.code == 100){
                             //   window.C.bingding = 1;
                        	 //swal( "寝室报修", json.msg, "success" );
                        	location.href="repairSuccess"
                               // J.showToast(json.msg, 'success');
                               // J.Router.goTo("#index_section?_=" + new Date().getTime());
/*                            }else{
                                J.showToast(json.msg, 'error');
                            }*/
                        }
                    });
                });

         //   };

        });
        p.delegate('dorm_repair_section');
    }

    return {
        attach : attach
        
    };
});