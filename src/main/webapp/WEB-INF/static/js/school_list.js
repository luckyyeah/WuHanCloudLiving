
define(['Page', 'Jingle'], function(p, J) {
    var attach = function() {
        p.page('school_list_section', function() {
            this.init = function(){
            };
            $('#school_list_search').tap(function(e){
                var school_list_form = $("#school_list_form");                  
                $("#school_list_form").submit();

             });
            J.Scroll('#search-main',{vScroll:true,vScrollbar : true});
           
        });

        p.delegate('school_list_section');
    }

    return {
        attach : attach
    };
});