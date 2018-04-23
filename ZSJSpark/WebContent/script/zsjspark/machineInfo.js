$(function() {
	$('.select-category').select2();
	$('.select2').css('width','100%');
	getDate();
	getStatus();
	window.setInterval("getDate();",5000);
	window.setInterval("getStatus();",5000);
});
function getDate() {
	$.ajax({
		type : "POST",
		url : "../RealTimeStatusController/conditionSearch.action",
		success : function(data) {
			var html = "";
			$.each(JSON.parse(data), function(j, o) {
				html += '<div class="'+info()+'">'
				+'<div class="agile-gallery">'
				+'<a href="machineData.action?machineCode='+ o.machineCode +'" class="lsb-preview" data-lsb-group="header">'
				+	'<table class="table table-bordered">'
				+		'<thead>'
				+			'<tr>'
				+				'<th>机器名称：'+o.machineCode+'</th>'
				+			'</tr>'
				+		'</thead>'
				+		'<tbody>'
				+			'<tr>'
				+				'<td>工作模式：'+workP(o.workPattern)+'</td>'
				+			'</tr>'
				+			'<tr>'
				+				'<td>循环周期：'+o.cycleTime+'</td>'
				+			'</tr>'
				+			'<tr>'
				+				'<td>开模数：'+o.openModelMun+'</td>'
				+			'</tr>'
				+			'<tr>'
				+				'<td>更新时间：'+formatDT(o.updateTime)+'</td>'
				+			'</tr>'
				+		'</tbody>'
				+	'</table>'
				+	'<div class="agileits-caption">'
				+		'<h4>查看详情</h4>'
				/*+		'<div class="buttons">'
				+			'<div class="btn-l btn btn-info">'
				+				'<a href="#" class="btn btn-a">实时状态</a>'
				+			'</div>'
				+			'<div class="btn-r btn btn-danger">'
				+				'<a href="#" class="btn btn-a">工艺参数</a>'
				+			'</div>'
				+		'</div>'*/
				+	'</div>'
				+'</a>'
			+'</div>'
		+'</div>';
			});
			$("#machineInfo").html(html);
		},
		error : function(request) {
			$.tooltip("操作失败");
		}
	});
}