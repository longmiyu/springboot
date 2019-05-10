//<script src="/js/jquery/jquery-3.4.0.min.js"></script>

function sendDate (url,data,async,type,dateType) {
    async = (async==null || async=="" || typeof(async)=="undefined")? "true" : async;
    type = (type==null || type=="" || typeof(type)=="undefined")? "post" : type;
    dateType = (dateType==null || dataType=="" || typeof(dateType)=="undefined")? "json" : dateType;
   return ajax(url, data,async,type,dateType);

}
function ajax(url, data,async,type,dateType) {
    var rs = "";
    $.ajax({
        type:type,
        url:url,
        data:data,
        async:false,
        contentType: "application/json; charset=utf-8",
        success:function(rsdata){
            rs=rsdata;
        },
        error:function(data){
            alert('数据请求错误')
        }
    });
    return rs;
}



