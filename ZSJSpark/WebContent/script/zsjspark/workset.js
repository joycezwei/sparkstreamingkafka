$(function() {
	$.ajax({
		url : '../WorkSetController/conditionSearch.action',
		dataType : 'json',
		success : function(d) {
			// alert(JSON.stringify(d));
			// alert(d[0].context);
			// var j = eval('(' + d.context + ')');
			var j = d[0].context;
			var con = '<img id="bg" alt="车间平面图" src="/ZSJSpark/img/xgt.jpg">';
			var l = [];
			$.each(j.shebei, function(j, o) {
				con += '<dl id="' + o.id
						+ '"><img style="background:green" src="' + o.url
						+ '"><i class="hander">' + o.id + '</i></dl>';
				var a = {};
				a.x = o.x;
				a.y = o.y;
				l.push(a);
			});
			$('#showBox').html(con);
			var c = 0;
			$('#showBox dl').each(function() {
				$(this).dragging({
					move : 'both',
					randomPosition : false,
					hander : '.hander',
					init : true,
					X : l[c].x,
					Y : l[c++].y
				});
			});
		}
	});
});

function save() {
	var data = [];
	$('#showBox dl').each(function() {
		var xy = {};
		xy.x = $(this).css("left");
		xy.y = $(this).css("top");
		xy.id = $(this).attr("id");
		xy.url = $(this).find("img").attr("src");
		data.push(xy);
	});
	
	$.ajax({
		url : '../WorkSetController/setWorkSet.action',
		dataType : 'json',
		data : {
			worksetid : 1,
			data : JSON.stringify(data)
		},
		success : function(data) {
			$.tooltip("保存成功");
		},
		error : function(data){
			$.tooltip("保存失败");
		}
	});
}