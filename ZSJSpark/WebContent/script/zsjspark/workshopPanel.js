//var myChart = echarts.init(document.getElementById('echart'));
//// 指定图表的配置项和数据
//var option = {
//	color : [ '#2ec7c9','#b6a2de','#5ab1ef','#ffb980','#d87a80',
//	          '#8d98b3','#e5cf0d','#97b552','#95706d','#dc69aa',
//	          '#07a2a4','#9a7fd1','#588dd5','#f5994e','#c05050',
//	          '#59678c','#c9ab00','#7eb00a','#6f5553','#c14089' ],
//	title : {
//		x : 'center'
//	},
//	tooltip : {
//		trigger : 'item',
//		formatter : "{a} <br/>{b} : {c}小时 ({d}%)"
//	},
//	legend : {
//		orient : 'horizontal',
//		center : 'center',
//		data : [ '初始化', '手动', '半自动','全自动']
//	},
//	series : [ {
//		name : '工作模式',
//		type : 'pie',
//		radius : '55%',
//		center : [ '50%', '60%' ],
//		data : [],
//		itemStyle : {
//			emphasis : {
//				shadowBlur : 10,
//				shadowOffsetX : 0,
//				shadowColor : 'rgba(0, 0, 0, 0.5)'
//			}
//		}
//	} ]
//};
//myChart.setOption(option, true);

var myChart2 = echarts.init(document.getElementById('machineworktime'),'macarons');
//指定图表的配置项和数据 
option2 = {
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        },
	        formatter : "{b} <br/>{a0} : {c0}小时 <br/>{a1} : {c1}小时"
	    },
	    legend: {
	        data:['半自动','全自动']
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        top: '15%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            data:[]
//	            data : ['2017-02-03','2017-02-04','2017-02-05','2017-02-06','2017-02-07','2017-02-08','2017-02-09','2017-02-10','2017-02-11','2017-02-12','2017-02-13','2017-02-14','2017-02-15','2017-02-16']
     }
	    ],
	    yAxis : [
	        {
	            type : 'value',
//	            name: '小时',
//	            nameGap :10,
	            axisLabel: {                   
	            	formatter: function (value, index) {           
	                return value.toFixed(2);      
	            	}                
	            }
	        }
	    ],
	    series : [
	        {
	            name:'半自动',
	            type:'bar',
	            data:[],
	            animationDelay: function (idx) {
	                return idx * 10;
	            }
//	            data:[320, 332, 301, 334, 390, 330, 320,311,323,234]
	        },
	        {
	            name:'全自动',
	            type:'bar',
	            data:[],
	            animationDelay: function (idx) {
	                return idx * 10;
	            }
//	            data:[120, 132, 101, 134, 90, 230, 210,320,311,323]
	        }],
	        animationEasing: 'elasticOut',
	        animationDelayUpdate: function (idx) {
	            return idx * 5;
	        }
};
myChart2.setOption(option2, true);
window.onresize = function() {
//	myChart.resize();
//	myChart1.resize();
	myChart2.resize();
};
$(function() {
	Combox("Workshop",{id:"id",name:"workshopname"});
	setTime();
	getData();
	getDayDetial();
	getStatus();
//	getOrderProgress();
	getMachineWorkTime();
	window.setInterval("setTime();",1000);
	window.setInterval("getData();",2000);
	window.setInterval("getStatus();",2000);
	window.setInterval("getDayDetial();",2000);
//	window.setInterval("getOrderProgress();",2000);
	window.setInterval("getMachineWorkTime();",4000);
});
var mg = [];
function getData() {
	$.ajax({
		type : "POST",
		url : "../KafkaConsumerController/conditionSearch.action",
		success : function(data) {
			var html = "";
			$.each(JSON.parse(data), function(j, o) {
				mg.push(o.machineCode);
				html += '<div class="col-sm-3">'
				+ '<table class="table table-hover" style="text-align:left;border:1px solid #e5e5e5;"><thead><tr>';
				if(o.connectionStatus==1){
					html +=	'<th>机器编号：'+o.machineCode+'</th></tr></thead>';;
				}else{
					html +=	'<th style="background:#ff6767;">机器编号：'+o.machineCode+'</th></tr></thead>';;
				}
				html +='<tbody style="font-size:15px;">'
				+ '<tr><td><span>工作模式&nbsp;:&nbsp;&nbsp;</span>'+workP(o.workPattern)+'</td></tr>'
				+ '<tr><td><span>循环周期&nbsp;:&nbsp;&nbsp;</span>'+o.cycleTime+'</td></tr>'
				+ '<tr><td><span>开&nbsp;模&nbsp;&nbsp;数&nbsp;:&nbsp;&nbsp;</span>'+o.openModelMun+'</td></tr>'
//				+ '<tr><td><span>连接状态:</span>'+workC(o.connectionStatus)+'</td></tr>'
//				+ '<tr><td><span>持续时长:</span>'+formatDT(o.updateTime)+'</td>'
				+ '</tr></tbody></table></div>';
			});
			$("#workshopPanel").html(html);
//			getData();
		},
		error : function(request) {
//			$.tooltip("操作失败");
//			getData();
		}
	});
}

function getDayDetial() {
	$.ajax({
		type : "POST",
		url : "../KafkaConsumerController/findMDetial.action",
		success : function(data) {
			var o = JSON.parse(data);
			var html = "";
			var sumt = o.time3+o.time2+o.time1+o.time0;
			sumt = sumt==0?1:sumt;
			html = '<span>本日开模数：'+o.omnum+'</span><br>'
				  +'<span>本周开模数：'+o.womnum+'</span><br>'
				  +'<span>本日告警数：'+o.warningnum+'</span><br>'
				  +'<span>本周告警数：'+o.wwarningnum+'</span><br>'
				  +'<span>日总开工工时：'+((o.time2+o.time3)/1000/60/60).toFixed(2)+'(小时)</span><br>'
				  +'<span>日机器有效率：'+((o.time2+o.time3)/sumt*100).toFixed(2)+'(%)</span><br>';
			$("#panelDetial").html(html);
//			option.series[0].data = [{
//				value : (o.time0/3600000).toFixed(2),
//				name : '初始化'
//			},{
//				value : (o.time1/3600000).toFixed(2),
//				name : '手动'
//			},{
//				value : (o.time2/3600000).toFixed(2),
//				name : '半自动'
//			},{
//				value : (o.time3/3600000).toFixed(2),
//				name : '全自动'
//			}];
//			myChart.setOption(option);
//			myChart.resize();
		},
		error : function(request) {
//			$.tooltip("操作失败");
		}
	});
}
var tmp=0;
function getMachineWorkTime(){
	$.ajax({
		url:"../KafkaConsumerController/machineDay.action",
		type:"POST",
		data:{"machineCode":$('#MachineCombox').val(),"mg":mg},
		success:function(data){
			option2.xAxis[0].data = [];
			option2.series[0].data = [];
			option2.series[1].data = [];
//			var o = JSON.parse(data);
			if(tmp>=5){
				tmp=0;
			}
			$.each(JSON.parse(data), function(j, o) {
				if(tmp*10<=j&&j<tmp*10+10){
//					alert(tmp);
//					alert(j);
//					alert(o.machineCode);
				option2.xAxis[0].data.push(o.machineCode);
				option2.series[0].data.push((o.time2/1000/60/60).toFixed(2));
				option2.series[1].data.push((o.time3/1000/60/60).toFixed(2));
				}
			});
			tmp++;
			option2.xAxis[0].axisLabel={
					formatter:function(value, index){
						if(value != undefined ){
							return value.substring(6);
						}
					}
			};
			myChart2.setOption(option2);
			myChart2.resize();	
			mg = [];
		},
		error : function(request) {
//			$.tooltip("操作失败");
			}
	});
}