function operate(value, row, index) {
	var str = "";
	if (row.extend1 == 1) {
		str = '<a class="model start" href="#">开始</a>';
	} else if (row.extend1 == 2) {
		str = '<a class="model stop" href="#">停止</a>';
	} else {
		str = '<a class="model set" href="#">设置参数</a>';
	}
	return str;
}
function st(value, row, index) {
	var str = "";
	if (value == 1) {
		str = "未开始";
	} else if (value == 2) {
		str = "进行中";
	} else if (value == 3) {
		str = "已停止";
	} else if (value == 4) {
		str = "已完成";
	} else {
		str = "未设置参数";
	}
	return str;
}
function hello() {
	$('#Machine').bootstrapTable('refresh');
}
//// 重复执行某个方法
//var t1 = window.setInterval(hello, 5000);
// 去掉定时器的方法
window.operateEvents = {
	'click .set' : function(e, value, row, index) {
		if (row.extend != "48") {
			$.ajax({
				type : "POST",
				url : "../DataReController/addNew.action",
				data : {
					id : row.id,
					extend : row.extend,
					machineCode : row.machineCode
				},
				success : function(data) {
					$.tooltip('设置参数成功');
					refresh('Machine');
				},
				error : function(request) {
					$.tooltip('设置失败');
				}
			});
		} else {
			$.tooltip('未选择回放时长');
		}
	},
	'click .start' : function(e, value, row, index) {
		$.ajax({
			type : "POST",
			url : "../DataReController/datare.action",
			data : {
				id : row.id,
				extend : row.extend,
				machineCode : row.machineCode
			},
			success : function(data) {
				$.tooltip('开始回放');
				$('#Machine').bootstrapTable('refresh');
			},
			error : function(request) {
				$.tooltip('错误！~');
			}
		});
	},
	'click .stop' : function(e, value, row, index) {
		$.ajax({
			type : "POST",
			url : "../DataReController/stop.action",
			data : {
				id : row.id,
				extend : row.extend,
				machineCode : row.machineCode
			},
			success : function(data) {
				$.tooltip("停止回放");
				refresh('Machine');
			},
			error : function(request) {
				$.tooltip('操作失败');
			}
		});
	}
};
$(function() {
	$("#Machine").bootstrapTable({
		pagination : true,
		showRefresh : true,
		clickToSelect : true,
		uniqueId : "id",
		pagination : "true",
		pageSize : "10",
		striped : "true",
		url : "../MachineController/findMachine.action",
		columns : [ {
			field : "id",
			title : "ID"
		}, {
			field : "machineCode",
			title : "机器编号"
		}, {
			field : "machineName",
			title : "机器名称"
		}, {
			field : "extend",
			title : "回放时长",
			editable : {
				type : 'select',
				title : '回放时长',
				source : [ {
					value : '5',
					text : '5分钟'
				}, {
					value : '10',
					text : '10分钟'
				}, {
					value : '15',
					text : '15分钟'
				}, {
					value : '30',
					text : '30分钟'
				}, {
					value : '1',
					text : '1小时'
				}, {
					value : '2',
					text : '2小时'
				} ]
			}
		}, {
			field : "extend1",
			title : "工作状态",
			formatter : st
		}, {
			field : "operate",
			title : "操作",
			formatter : operate,
			events : operateEvents
		} ]
	});
	$('#Machine').bootstrapTable('hideColumn', 'id');
});

window.setInterval("hello()",10000);

