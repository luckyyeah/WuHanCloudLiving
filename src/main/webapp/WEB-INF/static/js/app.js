require.config({
    baseUrl: 'static/js/',
    paths: {
        Zepto: 'Jingle/lib/zepto',
        Touch: 'Jingle/lib/zepto.touch2mouse',
        Jingle: 'Jingle/lib/Jingle.debug',
        iScroll: 'Jingle/lib/iscroll',
      //  wx: 'Jingle/lib/jsjweixin-1.0.0',
        Page: 'page'
        	

    },
    shim: {
        'wx': {
            exports: 'wx'
        },
        'iScroll': {
            exports: 'iScroll'
        },
        'Zepto': {
            exports: 'Zepto'
        },
        'Touch': {
            deps: ['Zepto']
        },
        'Jingle': {
            deps: ['Zepto', 'Touch', 'iScroll'],
            exports: 'Jingle'
        }
    }
});

/*require(
    ['Page', 'index'],
    function (p, index) {
        index.attach();
        p.setRemotePage('#school_add_section', 'schoolAdd');
        p.run();
    });*/


require(['school_add'], function(school_add){
	school_add.attach();
});
require(['dorm_repair'], function(dorm_repair){
	dorm_repair.attach();
});
require(['school_list'], function(school_list){
	school_list.attach();
});
require(['student_info'], function(student_info){
	student_info.attach();
});
$(function(){
    App.run();
})
