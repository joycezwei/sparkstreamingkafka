$(function() {
	$('#full').click(function(){
		$('section').fullScreen();
	});
	$('#myhome').click(function(){
		getDesk();
		initTabs();
	});
	var h = $(".nav-tabs").height()+$(".header-section").height();
	$('.page-content').css('height',$(document).height()-h-5);
	window.onresize = function() {
		$('.page-content').css('height',$(".main-content").height()-h-5);
	};
	getMenu();
	getDesk();
	initTabs();
});
function getMenu() {
	$.ajax({
		url : 'MenuController/menuTree.action',
		dataType : 'json',
		async : false,
		success : function(data) {
			var menulist = '';
			$.each(data, function(i, n) {
				menulist += '<li class="menu-list"><a><i class="fa '+n.classes+' fa-2x"></i> <span>&nbsp;&nbsp;'+n.text+'</span></a><ul class="sub-menu-list">';
				$.each(n.nodes, function(j, o) {
//					var url = o.url;
//					var s = url.indexOf("/");
//					var e = url.indexOf(".");
					menulist += '<li><a addtabs="'+o.id+'" url="'+o.url+'">&nbsp;&nbsp;&nbsp;'+o.text+'</a></li>';
				});
				menulist += '</ul></li>';
			});
			menulist += '<script src="script/scripts.js"></script>';
			$('#nav').html(menulist);
		}
	});
}
function getDesk() {
	$.ajax({
		url : 'MenuController/menuDesk.action',
		dataType : 'json',
		async : false,
		success : function(data) {
			var desk = '';
			$.each(data, function(i, n) {
//				var url = n.url;
//				var s = url.indexOf("/");
//				var e = url.indexOf(".");
				var icon = n.classes;
				var t = icon.indexOf("-");
				desk += '<a addtabs="'+n.id+'" url="'+n.url+'"><div class="col-sm-6 col-md-3"><div class="panel income db mbm"><div class="panel-body"><p class="icon">'
                     +  '<i class="icon '+icon.substring(0,t)+' '+icon+'"></i></p><h4 class="value">'+n.text+'</h4></div></div></div></a>';
			});
//			desk += '<script src="script/scripts.js"></script>';
			$('#sum_box').html(desk);
		}
	});
}
function initTabs(){
	$('#tabs').addtabs({
    	monitor: '.topbar',
 		iframeHeight: $(document).height()-105});
    $('#sum_box a').click(function () {
        Addtabs.add({
            id: $(this).attr('addtabs'),
            title: $(this).attr('title') ? $(this).attr('title') : $(this).text(),
            url: $(this).attr('url'),
            ajax: $(this).attr('ajax') ? true : false
        });
    });
    $('.sub-menu-list li a').click(function() {
        Addtabs.add({
            id: $(this).attr('addtabs'),
            title: $(this).attr('title') ? $(this).attr('title') : $.trim($(this).text()),
            url: $(this).attr('url'),
            ajax: $(this).attr('ajax') ? true : false
        });
    });
}
