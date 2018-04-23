function queryParams(params) {
	return {
		machineCode: $('#MachineCombox').val()
    };
}
$(function(){
	init('ProduceTask',700,310);
	Combox("Model",{id:"id",name:"modelName",width:"100%"});
	$('#searchModel').click(function(){
		refresh('Model');
	});
}) 
