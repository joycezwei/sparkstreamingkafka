function queryParams(params) {
	return {
		modelName: $('#modelName').val()
    };
}
$(function() {
$("#ModelForm").validate({
		rules: {
			modelName:"required",
			size:"required",
			modelNum:"required",
			mouldOwner:"required",
			subordinateCompanies:"required",
		},
		errorPlacement: function (label, element) {
            $(element).tooltip('destroy'); /*必需*/
            $(element).attr('title', $(label).text()).tooltip('show'); 
        },
        success: function(label, element) {
        	$(element).tooltip('destroy');
        },
	});
	init('Model',468,500);
});