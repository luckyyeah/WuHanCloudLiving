define(['Page', 'Jingle'], function(p, J) {
    var attach = function() {
        p.page('index_section', function() {
            this.init = function(){
                $('#slider-article').on('articleshow',function(){
                   var slider = new J.Slider({
                        selector : '#Community-banner',
                        autoPlay: true,
                        onBeforeSlide : function(){
                            return true;
                        },
                        onAfterSlide : function(i){
                            //do something
                        }
                    });
                });
            };
            this.show = function(){
                if(window.C.bingding == 0){
                    J.popup({
                        html: '<p style="text-align: center;color: red;color: red;line-height: 55px;">你还没有绑定社区</p>',
                        pos : 'top',
                        showCloseBtn : false
                    });
                }
            };
        });
        p.delegate('index_section');
    }
    return {
        attach : attach
    };
});