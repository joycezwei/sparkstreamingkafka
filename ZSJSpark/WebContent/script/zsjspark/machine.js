function queryParams(params) {
	return {
		machineCode: $('#machineCode').val(),
		machineName: $('#machineName').val()
    };
}
$(function() {
	$("#MachineForm").validate({
		rules: {			
			company:"required",			
			machineCode:"required",
			machineName:"required",
			location:"required",
			workset:"required",
			machineType:"required",
			ip:{
				required:true,
			},
			mac:{
				required:true,				
			},
			opcserverId:"required",
		},
		errorPlacement: function (label, element) {
            $(element).tooltip('destroy'); /*必需*/
            $(element).attr('title', $(label).text()).tooltip('show'); 
        },
        success: function(label, element) {
        	$(element).tooltip('destroy');
        },
	});
	init('Machine',700,400);
	Combox("SoftVersion",{id:"id",name:"version",width:"100%"});
	Combox("OPCServer",{id:"opcserverId",name:"serverProgId",width:"100%"});
	Combox("Workshop",{id:"id",name:"workshopname",width:"100%"});
});
