//var myChart1 = echarts.init(document.getElementById('orderprogress'), 'macarons');
var xMax = 100;
option1 = {
	color : [ '#3398DB' ],
	tooltip : {
		trigger : 'axis',
		axisPointer : { // 坐标轴指示器，坐标轴触发有效
			type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
		}
	},
    grid:{
    	top:'5%',
    	bottom:'15%',
    	left:'16%',
    	right:'5%'
    },
	yAxis : [ {
		type : 'category',
		data : [],
		axisTick : {
			alignWithLabel : true
		},
		axisLabel: {
            show: true,
/*            textStyle: {
                color: '#000',
                fontSize:8
            }*/
        }
	} ],
	xAxis : [ {
		type : 'value',
		axisLabel : {
			show : true,
			interval : 'auto',
			formatter : '{value} %'
		}
	} ],
	series : [ {
		name : '完成率',
		type : 'bar',
		barWidth : '40%',
		data : [],
	} ]
};
//myChart1.setOption(option1, true);

function setTime(){
	$("#nowtime").html(formatDate()+" "+formatTime());
}

function getOrderProgress() {
	$.ajax({
		url : "../SubProduceTaskController/searchFinishingRate.action",
		type : "POST",
		data : {
			"realityEndtime" : $('#timeOption').val(),
			"machineCode" : $('#MachineCombox').val()
		},
		success : function(data) {
			// alert($('#timeOption').val());
			// alert(data);
			option1.yAxis[0].data = [];
			option1.series[0].data = [];
//			var o = JSON.parse(data);
			$.each(JSON.parse(data), function(j, o) {
				// alert(o.finishing_rate);
				option1.yAxis[0].data.push(o.schemName);
				option1.series[0].data.push(o.finishing_rate);
			});
			myChart1.setOption(option1, true);
			myChart1.resize();
		},
		error : function(request) {
			$.tooltip("操作失败");
		}
	});
}
