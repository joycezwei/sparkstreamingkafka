$(function() {	
	jQuery.validator.addMethod("phone", function(value, element) {   
	    var tel = /^((0\d{2,3}-\d{7,8})|(1[35847]\d{9}))$/;
	    return this.optional(element) || (tel.test(value));
	}, "号码格式不正确或者位数不正确");	
	$("#WorkshopForm").validate({
		onfocusin: function(element) { $(".tooltip").css("display","none")},
		rules: {
			workshopname:"required",
			workshopfzr:"required",
			remark:"required",
			phone:{
				required:true,
				phone:true}
		},
		errorPlacement: function (label, element) {
            $(element).tooltip('destroy'); /*必需*/
            $(element).attr('title', $(label).text()).tooltip('show'); 
        },
        success: function(label, element) {
        	$(element).tooltip('destroy');
        },
        showErrors: function(errorMap, errorList) {
            this.defaultShowErrors();
            for(var i = 0; i < errorList.length; i++) {
$(errorList[i].element).one("blur", function() {
             $("label.error[for='" + (this.id ? this.id : this.name) + "']").remove();
			 });}}
	});
	init('Workshop',430,300);
	
	
});
