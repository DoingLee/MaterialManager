

window.app = {};
var d1 = moment().subtract(29, 'days').format('YYYY-MM-DD');
var d2 = moment().format('YYYY-MM-DD');
window.app.startDate = d1;
window.app.endDate = d2;

var dd = new Calendar({
    element: $('.one'),
    earliest_date: 'January 1, 2000',
    latest_date: moment(),
    start_date: moment().subtract(29, 'days'),
    end_date: moment(),
    callback: function () {
        //var start = moment(this.start_date).format('ll'),
        //    end = moment(this.end_date).format('ll');
        var start = moment(this.start_date).format('YYYY-MM-DD'),
            end = moment(this.end_date).format('YYYY-MM-DD');

        window.app.startDate = start;
        window.app.endDate = end;

        console.debug('Start Date: ' + start + '\nEnd Date: ' + end);
    }
});

//查询按钮监听
$(document).on("click", "#btn_search", function () {
    console.log("/report/sum/" + window.app.startDate + "/" + window.app.endDate + '/');

    $.ajax({
        dataType: "json",
        type: "get",
        url: "/report/sum/" + window.app.startDate + "/" + window.app.endDate + '/',
        success: function (data) {
            console.log(data);
            if (data.success == true) {
                fillOrderTable(data.data);
                fillTimeTable(data.data);
            } else {
                alert("查询失败！");
            }
        }
    });
});

function fillOrderTable(data){
    $("#order-table-body").empty();
    $("#order-table-body").append(
        "<tr> " +
        "<td>" + data.finishedOrderCount + "</td>" +
        "<td>" + data.hangUpCount + "</td>" +
        "<tr> ");
}

function fillTimeTable(data){
     ;

    $("#time-table-body").empty();
    $("#time-table-body").append(
        "<tr> " +
        "<td>" +  Math.floor(data.avgOrderTime/60) + "分" + data.avgOrderTime%60 + "秒" + "</td> " +
        "<td>" +  Math.floor(data.avgCollectTime/60) + "分" + data.avgCollectTime%60 + "秒" + "</td> " +
        "<td>" +  Math.floor(data.avgSingleCollectTime/60) + "分" + data.avgSingleCollectTime%60 + "秒" + "</td> " +
        "<td>" +  Math.floor(data.avgSuccessRecheckTime/60) + "分" + data.avgSuccessRecheckTime%60 + "秒" + "</td> " +
        "<td>" +  Math.floor(data.avgSingleRecheckTime/60) + "分" + data.avgSingleRecheckTime%60 + "秒" + "</td> " +
        "<td>" +  Math.floor(data.avgProduceTime/60) + "分" + data.avgProduceTime%60 + "秒" + "</td> " +
        "<td>" +  Math.floor(data.avgSingleProduceTime/60) + "分" + data.avgSingleProduceTime%60 + "秒" + "</td> " +
        "<tr> ");
}

