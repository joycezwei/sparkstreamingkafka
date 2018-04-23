function queryParams(params) {
	return {
		parentmenu:$('#MenuCombox').val()
    };
}
$(function(){
	$('#searchMenuReport').click(function(){
		
		refresh('MenuReport');
	});
});
