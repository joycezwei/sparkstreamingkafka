$(function(){
	$('.input-group-addon').css('width','23%');
	$('.col-both > input').css('width','100%');
	$('.container-fluid').css('height',$(document).height()-27);
    $('.form_date').datetimepicker({
        language:  'zh-CN',
        format: "yyyy-mm-dd",
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    }).on('changeDate', function(ev){
    	$('#'+ev.id).val(ev.date);
    });
    $(".container-fluid").niceScroll({styler:"fb",cursorcolor:"#65cea7", cursorwidth: '6', cursorborderradius: '0px', background: '#424f63', spacebarenabled:false, cursorborder: '0',  zindex: '1000'});
});