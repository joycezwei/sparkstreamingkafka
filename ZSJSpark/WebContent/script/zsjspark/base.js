function info() {
    if ((navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i))) {
    	return 'col-xs-12';
    }
    else {
    	return 'col-sm-3';
    }
}
var boxL = {};

function closehd(o) {
	var $o = $(o.box);
	$o.removeAttr('class').addClass('animated '+o.effect);
	$o.hasClass(o.effect) && setTimeout(function(){ $o.removeAttr('style').hide(); },300);
	$('#HOverlay,#HTitle,#'+o.iframeId).remove();
	$(".clean_c").val("");
}
function init(type,width,height) {
	var method = "";
	var controller = "../"+type+"Controller/";
	var hbox = '#'+type+'HBox';
	sethDialog('#add'+type,'添加',hbox,width,height,0);
	sethDialog('#modify'+type,'修改',hbox,width,height,1);
	$('#add'+type).click(function(){
		removeClass(type);
		method = "addNew.action";
	});
	$('#modify'+type).click(function(){
		var id = getIdSelections(type,'id');
		if(id.length==1){
			removeClass(type);
			method = "update.action";
			var obj = $('#'+type).bootstrapTable('getRowByUniqueId',id);
			loadData(obj,'#'+type+'HBox');
		}else{
			$.tooltip("请选择一条记录进行操作！");
		}
	});
	$('#search'+type).click(function(){
		refresh(type);
	});
	$('#submit'+type).click(function(){
		if($("#"+type+"Form").valid()){
			$(function(){submitData("#"+type+"Form",controller+method);});
		}
	});
	
	$('#delete'+type).click(function(){
		var ids = getIdSelections(type,'id');
		if(ids.length>0){
			updateData(type,{ids:ids.join(','),status:0},controller+'delete.action');
		}else{
			$.tooltip("请勾选需删除的记录！");
		}
	});
}
function refresh(type) {
	$('#'+type).bootstrapTable('refresh');
}
function removeClass(type) {
	$('#'+type+'HBox').removeClass('btn btn-info');
}
function submitData(form,url) {
	$.ajax({
        type: "POST",
        url:url,
        data:$(form).serialize(),
        success: function(data) {
//        	window.location.reload();
        	closehd(eval('boxL.'+form.substring(1)));
        	refresh($("table:visible").attr("id"));
        },
        error: function(request) {
        	$.tooltip('操作错误');
        }
    });
}
function updateData(type,data,url) {
	var ids = data.ids;
	if(ids!=0){
		$.ajax({
			url : url,
			data : data,
			dataType : 'json',
			success : function(d) {
				refresh(type);
			},
	        error: function(request) {
	        	$.tooltip('操作错误');
	        }
		});
	};
}

function sethDialog(obj,title,hBox,width,height,type) {
	var ob = {
//			title:title,
//			box: hBox,
			boxBg: '#ffffff',
			modalBg: 'rgba(0,0,0,0.5)',
//			width:width,
//			height: height,
			modalHide: false,
			autoShow: false,
			iframeId: 'iframeHBox',
			effect: 'zoomOut',
			isOverlay: true,
			positions: 'top',
			beforeShow: function(){
				var now = $('.now').val();
				var nowms = $('.nowms').val();
				var t = new Date();
				if(now == "" || now == null){
					$('.now').val(t.format("yyyy-MM-dd"));
				}
				if(nowms == "" || nowms == null){
					$('.nowms').val(t.getTime());
				}
			},
			afterHide: function(){
				$(".clean_c").val("");
			}
		};
	ob.box = hBox;
	ob.type = type;
	ob.title = title;
	ob.height = height;
	ob.width = width;
	$(obj).hDialog(ob);
	eval('boxL.'+hBox.substring(1).replace("HBox","Form")+'=ob;');
}

function getIdSelections(type,parm) {
    return $.map($('#'+type).bootstrapTable('getSelections'), function (row) {
        return eval('row.'+parm);
    });
}

function loadData(obj,HBox) {
	var key, value, tagName, type, arr;
	for (x in obj) {
		key = x;
		value = obj[x];
		$(HBox+" [name='" + key + "'],"+HBox+" [name='" + key + "[]']").each(function() {
			tagName = $(this)[0].tagName;
			type = $(this).attr('type');
			if (tagName == 'INPUT') {
				if (type == 'radio') {
					$(this).attr('checked', $(this).val() == value);
				} else if (type == 'checkbox') {
					arr = value.split(',');
					for ( var i = 0; i < arr.length; i++) {
						if ($(this).val() == arr[i]) {
							$(this).attr('checked', true);
							break;
						}
					}
				} else {
					$(this).val(value);
				}
			} else if (tagName == 'SELECT' || tagName == 'TEXTAREA') {
				$(this).val(value);
			}

		});
	}
}
function Combox(type,parm,data) {
	$.ajax({
		type : "POST",
		url : "../"+type+"Controller/conditionSearch.action",
		data : data,
		success : function(data) {
			var html = "<option value=''>-请选择-</option>";
			$.each(JSON.parse(data), function(j, o) {
				html += '<option value="' + eval("o."+parm.id) + '">' + eval("o."+parm.name) + '</option>';
			});
			$("#"+type+"Combox").html(html);
			initSelect2(parm.width,parm.val);
		},
		error : function(request) {
			$.tooltip("操作失败");
		}
	});
}
function initSelect2(width,value){
	$('.select-category').select2();
	$('.select2').css('width',width);
    $('.selection').css('width',width);
    $('.select2-selection').css('width','100%');
    if(value!=null){
    $(".select-category").select2("val",value);
    }
}
function formatLName(name) {
	return name.length>9?name.substring(0,9)+"...":name;
}
function formatDate(time) {
	var date = "";
	var D = "";
	if(time != 0){
		if(time != undefined){
			date = new Date(time);
		}else{
			date = new Date();
		}
		var y = date.getFullYear();
		var M = date.getMonth()<10 ? '0'+(date.getMonth()+1) : (date.getMonth()+1);
		var d = date.getDate()<10 ? '0'+date.getDate() : date.getDate();
		D = y+"-"+M+"-"+d;
	}
    return D;
}
function formatTime(time) {
	var date = "";
	var T = "";
	if(time != 0){
		if(time != undefined){
			date = new Date(time);
		}else{
			date = new Date();
		}
		var h = date.getHours()<10 ? '0'+date.getHours() : date.getHours();
		var m = date.getMinutes()<10 ? '0'+date.getMinutes() : date.getMinutes();
		var s = date.getSeconds()<10 ? '0'+date.getSeconds() : date.getSeconds();
		T = h+":"+m+":"+s;
	}
	return T;
}
function formatDT(time) {
	var DTime = "";
	if(time != 0){
		var date = new Date(time);
		var y = date.getFullYear();
		var M = date.getMonth()<10 ? '0'+(date.getMonth()+1) : (date.getMonth()+1);
		var d = date.getDate()<10 ? '0'+date.getDate() : date.getDate();
		var h = date.getHours()<10 ? '0'+date.getHours() : date.getHours();
		var m = date.getMinutes()<10 ? '0'+date.getMinutes() : date.getMinutes();
		var s = date.getSeconds()<10 ? '0'+date.getSeconds() : date.getSeconds();
		DTime = y+"-"+M+"-"+d+" "+h+":"+m+":"+s;
	}
    return DTime;
}

function getStatus() {
	$.ajax({
		type : "POST",
		url : "../KafkaConsumerController/getMachineStatus.action",
		success : function(data) {
			var o = JSON.parse(data);
			var html = "";
			html = '<span class="text-title">所有机器: '+o.allm+'</span>'
				+'<span class="text-muted">&nbsp;&nbsp;未连接: '+o.ncm+'</span>'
				+'<span class="text-success">&nbsp;&nbsp;已连接: '+o.cm+'</span>';
			$("#st").html(html);
		},
		error : function(request) {
			$.tooltip("操作失败");
		}
	});
}

/*$.validator.addMethod("string", function(value, element) {
	return this.optional(element) || /^[u0391-uFFE5w]+$/.test(value);
	}, "不允许包含特殊符号!");*/

//对Date的扩展，将 Date 转化为指定格式的String   
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
//例子：   
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.format = function(fmt)   
{ //author: meizz   
	var o = {   
			"M+" : this.getMonth()+1,                 //月份   
			"d+" : this.getDate(),                    //日   
			"h+" : this.getHours(),                   //小时   
			"m+" : this.getMinutes(),                 //分   
			"s+" : this.getSeconds(),                 //秒   
			"q+" : Math.floor((this.getMonth()+3)/3), //季度   
			"S"  : this.getMilliseconds()             //毫秒   
	};   
	if(/(y+)/.test(fmt))   
		fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
	for(var k in o)   
		if(new RegExp("("+ k +")").test(fmt))   
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	return fmt;   
};

function workP(pattern) {
	return eval("workPattern.workPattern"+pattern);
}
function workC(pattern) {
	if(typeof(pattern)=="undefined"){
		pattern=0;
	}
	return eval("connectionPattern.connectionPattern"+pattern);
}
function parmname(parm) {
	return eval("parms."+parm);
}

function warningCode(parm) {
	return eval("warningcode.warningcode"+parm);
}

function subtaskStatus(parm) {
	return eval("subtaskstatus.status"+parm);
}