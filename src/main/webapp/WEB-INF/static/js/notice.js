/**
 * Created by Administrator on 15-6-17.
 */

define(['Page', 'Jingle'], function(p, J) {
    var attach = function() {
        p.page('notice_section', function() {
            this.init = function(){
            };

            this.show = function(){
                if(window.C.bingding == 0){
                    J.Router.goTo('#index_section');
                }
            };
        });
        p.delegate('notice_section');
    }

    return {
        attach : attach
    };
});