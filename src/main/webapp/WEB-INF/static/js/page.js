define(['Zepto', 'Jingle'], function($, J){
	var pages = {};
    var run = function(){
        pages['index_section'].init();

		J.Transition.add('flip','slideLeftOut','flipOut','slideRightOut','flipIn');
        J.launch({
            showPageLoading : true
        });
    };

    var setRemotePage = function(section, url){
        J.setRemotePage(section, url);
    }

    var delegate = function(id){
    	var factory = _getPage(id);
    	
    	var sectionId = '#'+id;
        $('body').delegate(sectionId,'pageinit',function(){
            factory.init && factory.init.call(factory);
        });
        $('body').delegate(sectionId,'pageshow',function(e,isBack){
           //页面加载的时候都会执行
            factory.show && factory.show.call(factory);
            //后退时不执行
            if(!isBack && factory.load){
                factory.load.call(factory);
            }
        });
    }
    
    var page = function(id, factory){
        return ((id && factory)?_addPage:_getPage).call(this,id,factory);
    }
    var _addPage = function(id,factory){
        pages[id] = new factory();
    };
    var _getPage = function(id){
        return pages[id];
    }
    //动态计算chart canvas的高度，宽度，以适配终端界面
    var calcChartOffset = function(){
        return {
            height : $(document).height() - 44 - 30 -60,
            width : $(document).width()
        }

    }
    return {
        run : run,
        page : page,
        delegate : delegate,
        setRemotePage : setRemotePage,
        calcChartOffset : calcChartOffset
    }
});
