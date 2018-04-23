//var myChart = echarts.init(document.getElementById('echart'));
var myChart1 = echarts.init(document.getElementById('echart1'));
// 指定图表的配置项和数据
/*var option = {
	color : [ '#2ec7c9', '#b6a2de', '#5ab1ef', '#ffb980', '#d87a80', '#8d98b3',
			'#e5cf0d', '#97b552', '#95706d', '#dc69aa', '#07a2a4', '#9a7fd1',
			'#588dd5', '#f5994e', '#c05050', '#59678c', '#c9ab00', '#7eb00a',
			'#6f5553', '#c14089' ],
	title : { // 标题
		text : '数据波动曲线图'
	},
	// 提示框
	tooltip : {
		trigger : 'axis',
		axisPointer : { // 坐标轴指示器，坐标轴触发有效
			type : 'line', // 默认为直线，可选为：'line' | 'shadow'
			lineStyle : { // 直线指示器样式设置
				color : '#008acd'
			},
			crossStyle : {
				color : '#008acd'
			},
			shadowStyle : { // 阴影指示器样式设置
				color : 'rgba(200,200,200,0.2)'
			}
		}
	},

	legend : { // 图例
		data : [ '实际值' ]
	},
	toolbox : { // 工具箱
		show : true,
		feature : {
			magicType : {
				type : [ 'line', 'bar' ]
			},
			restore : {},
			saveAsImage : {}
		}
	},
	xAxis : {
		type : 'category',
		boundaryGap : false,
		data : [ '577', '576', '575', '574', '573', '572', '571' ]
	},
	yAxis : {
		type : 'value',
		axisLabel : {
			formatter : '{value}'
		}
	},
	series : [ {
		name : '循环时间',
		type : 'line',
		data : [ 15.59, 15.58, 15.57, 15.59, 15.54, 15.51, 15.5 ]
	} ]
};*/

var option1 = {
	color : [ '#2ec7c9', '#b6a2de', '#5ab1ef', '#ffb980', '#d87a80', '#8d98b3',
			'#e5cf0d', '#97b552', '#95706d', '#dc69aa', '#07a2a4', '#9a7fd1',
			'#588dd5', '#f5994e', '#c05050', '#59678c', '#c9ab00', '#7eb00a',
			'#6f5553', '#c14089' ],
	/*
	 * tooltip : { trigger : 'axis', },
	 */
	// 提示框
	tooltip : {
		trigger : 'axis',
		axisPointer : { // 坐标轴指示器，坐标轴触发有效
			type : 'shadow', // 默认为直线，可选为：'line' | 'shadow'
			shadowStyle : { // 阴影指示器样式设置
				color : 'rgba(200,200,200,0.2)'
			}
		}
	},
	legend : {
		data : [ '初始化', '手动', '半自动', '全自动' ],
		x : 'right',
		y : 'top',
	},
	toolbox : {
		show : false,
	},
	xAxis : [ {
		type : 'value',
		name : '百分比(%)',
		nameLocation : 'start',
		splitNumber : 10,
		min : 0,
		max : 100,
		splitLine : false,
		splitArea : false

	} ],
	yAxis : [ {
		type : 'category',
		nameLocation : 'start',
		data : [ '运行状态' ],
		splitLine : false
	} ],
	series : [ {
		name : '初始化',
		type : 'bar',
		stack : '总量',
		itemStyle : {
			normal : {
				label : {
					show : true
//					position : 'insideRight'
				}
			}
		},
		data : []
	}, {
		name : '手动',
		type : 'bar',
		stack : '总量',
		itemStyle : {
			normal : {
				label : {
					show : true
//					position : 'insideRight'
				}
			}
		},
		data : []
	}, {
		name : '半自动',
		type : 'bar',
		stack : '总量',
		itemStyle : {
			normal : {
				label : {
					show : true
//					position : 'insideRight'
				}
			}
		},
		data : []
	}, {
		name : '全自动',
		type : 'bar',
		stack : '总量',
		itemStyle : {
			normal : {
				label : {
					show : true
//					position : 'insideRight'
				}
			}
		},
		data : []
	} ]
};
/*// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);
myChart1.setOption(option1);
window.onresize = function() {
	myChart.resize();
	myChart1.resize();
};*/
function queryParams(params) {
	return {
		machineCode: $('#MachineCombox').val(),
		startTime: $('#startTime').val(),
		endTime: $('#endTime').val(),
		 dateStatus: $('#dateStatus').val()
    };
}
function queryParamsCW(params) {
	return {
		machineCode: $('#MachineCombox').val(),
		startTime: $('#startTime').val(),
		endTime: $('#endTime').val()
	};
}
$('.header-zl-left a').click(function (){
	$('.header-zl-left a').css('background-color','#5BC0DE');//原来的颜色
	$(this).css("background-color","#3190D5");//按钮点击之后的颜色
});
function find(dateStatus) {
	$('#dateStatus').val(dateStatus);
	refresh('machineInfo');
}
function m2M(value, row, index) {
	return (value/60000).toFixed(1);
}
function warningNumFormatter(value, row, index) {
	return '<a class="check" data-toggle="modal" href="#alertModal" ><u>' + value + '</u></a>';
}

function changeNumFormatter(value, row, index) {
	return '<a class="check" data-toggle="modal" href="#alterModal" ><u>' + value + '</u></a>';
}

function detailFormatter(value, row, index) {
	return '<a class="check" data-toggle="modal" href="#productModal" ><u>详情</u></a>';
}
window.operateEvents = {
	'click .check': function (e, value, row, index) {
		$('#MachineCombox').val(row.MACHINE_CODE);
		$('#startTime').val(row.TIME_ORIGIN);
		$('#endTime').val(parseInt(row.TIME_ORIGIN)+parseInt(row.CONSUMETIME));
		refresh('WorkWarning');
		refresh('Change');
		refresh('WorkDetail');
	}
};
/*$('td').click(function(){
	   var tds =$(this).find('td');
	   alert($('td').val())
	   //这时候this就是被点击的tr，你想怎么处理都可以
	});*/
$(function() {
	$('.header-zl-left .default').css("background-color","#3190D5");
	getCharts();
	Combox("Machine",{id:"machineCode",name:"machineCode",width:'100%',val:$('#machineCode').val()});
	$('#searchMachine').click(function(){
		getCharts();
		refresh('machineInfo');
	});
	var time_spanW = $('.timeline').width()-15-$('.title').width();
	$('.time_span').css('width',time_spanW/12-7);
	$(window).resize(function(){
		var time_spanW = $('.timeline').width()-15-$('.title').width();
		$('.time_span').css('width',time_spanW/12-7);
	});
});
function getCharts() {
	$.ajax({
		type : "POST",
		url : "../RealTimeStatusController/findDayDetial.action",
		data : {"timeOrigin" : $('#timeOrigin').val()},
		success : function(data) {
			var o = JSON.parse(data);
			var sum = o.time0+o.time1+o.time2+o.time3;
			option1.series[0].data = [(o.time0/sum*100).toFixed(1)];
			option1.series[1].data = [(o.time1/sum*100).toFixed(1)];
			option1.series[2].data = [(o.time2/sum*100).toFixed(1)];
			option1.series[3].data = [(o.time3/sum*100).toFixed(1)];
			for(var i=0;i<option1.series.length;i++){
				if(option1.series[i].data<2){
					option1.series[i].itemStyle.normal.label.position = "null";
				}else{
					option1.series[i].itemStyle.normal.label.position = "insideRight";
				}
			}
			myChart1.setOption(option1);
			myChart1.resize();
		},
		error : function(request) {
			$.tooltip("操作失败");
		}
	});
}
$("#searchMachine").click(function (){
	$('.header-zl-left a').css('background-color','#5BC0DE');
});