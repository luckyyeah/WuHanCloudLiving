/**
 * Created by Administrator on 2015/6/25.
 */
define(['Page', 'Jingle'], function(p, J) {
    var attach = function() {
        p.page('list_section', function() {
            this.init = function(){
            };
        });
        var subStr = function(str) {
            var ss = str.substr(0, 1); // 获取子字符串。
            return(ss);
        }
        p.delegate('list_section');
    }

    return {
        attach : attach
    };
});