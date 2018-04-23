function queryParams(params){
	
	return{
	      
		  startTime:$('#startTime').val(),
		  endTime:$('#endTime').val(),
		  dateStatus: $('#dateStatus').val()
		  /*dateStatus:$("option[selected]").val()
		  var item = $("option").val(); */

	};
}

$(function(){
	
	$('#searchSubtask').click(function(){

	
		refresh('Subtask');
	});
});
function find(dateStatus) {
	$('#dateStatus').val(dateStatus);

	refresh('Subtask');

}
$('.header-zl-left a').click(function(){
	$('.header-zl-left a').css("background","#5bc0de");
	$(this).css("background","#3190D5");
//	console.log(this);
});