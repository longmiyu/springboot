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


function openDialog(url,data) {
    debugger;
    layer.open({
        type: 2,
        title: '弹出框',
        shadeClose: true,
        shade: false,
        maxmin: false, //开启最大化最小化按钮
        area: ['893px', '600px'],
       content:'openDialog?url='+url+''
      //  content: window.location.href = 'openDialog'
    });
}


function Dialog(url,data) {
    data.url=url;
    data = JSON.stringify(data);

    $.ajax({
        type:'post',
        url:'openDialog',
        data:data,
        async:false,
        contentType: "application/json; charset=utf-8",
        success:function (data) {

            debugger;
            window.location.href=data;
            var s =data  ;
                alert(s)
        },
        error:function (data) {
            alert('页面错误')

        }

    })
}



