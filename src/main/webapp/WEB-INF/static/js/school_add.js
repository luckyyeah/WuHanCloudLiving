
define(['Page', 'Jingle'], function(p, J) {
    var attach = function() {
        p.page('school_add_section', function() {
        //    this.init = function(){


                $('#school_add_btn').tap(function(e){
                    var school_add_form = $("#school_add_form");
                    if(school_add_form.find('#school').val() == ''){
                        alert('请选择学校');
                        return false;
                    }
        
                    //alert(community_form.serialize());
                    $.ajax({
                        'url' : 'updateStudentInfo',
                        'data' : school_add_form.serialize(),
                        'type' : 'POST',
                        'dataType' : 'json',
                        'success' : function(json){

                          //  if(json.code == 100){
                             //   window.C.bingding = 1;
                                J.showToast(json.msg, 'success');
                                J.Router.goTo("#index_section?_=" + new Date().getTime());
/*                            }else{
                                J.showToast(json.msg, 'error');
                            }*/
                        }
                    });
                });

         //   };

        });
        p.delegate('school_add_section');
    }

    return {
        attach : attach
        
    };
});