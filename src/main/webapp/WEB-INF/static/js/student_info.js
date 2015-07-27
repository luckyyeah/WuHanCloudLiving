
define(['Page', 'Jingle'], function(p, J) {
    var attach = function() {
        p.page('student_info_section', function() {
          //  this.init = function(){
                $('#student_info_save_btn').tap(function(e){
                    var student_info_form = $("#student_info_form");
                    if(student_info_form.find('#name').val() == ''){
                        alert('请填写真实姓名');
                        return false;
                    }

                    if(student_info_form.find('#tel').val() == ''){
                        alert('请填写电话号码');
                        return false;
                    }

                    if(student_info_form.find('#id_card').val() == ''){
                        alert('请填写身份证号');
                        return false;
                    }

                    if(!/^((1[1-5])|(2[1-3])|(3[1-7])|(4[1-6])|(5[0-4])|(6[1-5])|71|(8[12])|91)\d{4}((((19|20)\d{2}(0[13-9]|1[012])(0[1-9]|[12]\d|30))|((19|20)\d{2}(0[13578]|1[02])31)|((19|20)\d{2}02(0[1-9]|1\d|2[0-8]))|((19|20)([13579][26]|[2468][048]|0[48])0229))\d{3}(\d|X|x)|((\d{2}(0[13-9]|1[012])(0[1-9]|[12]\d|30))|(\d{2}(0[13578]|1[02])31)|(\d{2}02(0[1-9]|1\d|2[0-8]))|(([13579][26]|[2468][048]|0[48])0229))\d{3})$/.test(student_info_form.find('#id_card').val())) {
                        alert('请填写正确的身份证号');
                        return false;
                    }

                    $.ajax({
                        'url' : 'updateStudentDetailInfo',
                        'data' : student_info_form.serialize(),
                        'type' : 'POST',
                        'dataType' : 'json',
                        'success' : function(json){
                            if(json.code == 100){
                                J.showToast(json.msg, 'success');
                            }else{
                                J.showToast(json.msg, 'error');
                            }
                        }
                    });
                });
           // };
        });
        p.delegate('student_info_section');
    }

    return {
        attach : attach
    };
});