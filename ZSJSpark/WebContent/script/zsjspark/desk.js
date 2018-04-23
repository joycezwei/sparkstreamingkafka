$(function() {
	$.ajax({
		   url : '../MenuController/menuTree.action',
		   dataType : 'json',
		   async : false,
		   success : function(data) {
			   var desklist = '';
			   $.each(data, function(i, item) {
				   desklist += '<div class="row">'
					            +'<div class="col-lg-12">'
					                +'<section class="piece">'
					                    +'<div class="panel-heading piece-heading">'+item.text
					                        +'<span class="tools pull-right">'
					                            +'<a class="fa fa-chevron-down" href="javascript:;"></a>'
					                         +'</span>'
					                    +'</div>'
					                    +'<div class="piece-body">'
					                        +'<div class="row">'
					                            +'<div class="col-ms-12 col-both">'
				                                   +'<div class="form-group">'
				                                       +'<div class="col-sm-12 icheck ">';
					$.each(item.nodes, function(j, nodes) {
						desklist += '<div class="flat-red single-row">'
			                            +'<div class="radio">'
					                        +'<input type="checkbox" id="'+nodes.id+'" value="'+nodes.id+'" '+nodes.check+'>'
					                        +'<label>'+nodes.text+' </label>'
					                    +'</div>'
					                +'</div>';
					});
					desklist += '</div>'
		                        +'</div>'
		                    +'</div>'
		                +'</div>'
		            +'</div>'
		        +'</section>'
		    +'</div>'
		+'</div>';
				});
			   $('#saverow').prepend(desklist);
		   }
	   });
	$('.flat-red input').iCheck({
        checkboxClass: 'icheckbox_flat-red',
        radioClass: 'iradio_flat-red'
    });
	// panel collapsible
    $('.piece .tools .fa').click(function () {
        var el = $(this).parents(".piece").children(".piece-body");
        if ($(this).hasClass("fa-chevron-down")) {
            $(this).removeClass("fa-chevron-down").addClass("fa-chevron-up");
            el.slideUp(200);
        } else {
            $(this).removeClass("fa-chevron-up").addClass("fa-chevron-down");
            el.slideDown(200); }
    });
//	$('.container-bg').css('height',$('#tab_deskList iframe').height());
    $('#saveBtn').click(function (){
    	var ids = '';
    	$(".radio input[type=checkbox]").each(function(){
    	    if(this.checked){
    	    	if(ids != ''){
    	    		ids += ',';
    	    	}
    	    	ids += $(this).val();
    	    }
    	});  
    	if(ids != ''){
    		$.ajax({
			    type: "POST",
			    url:"../MenuController/setDesk.action",
			    data:{ids : ids},
			    success: function(data) {
			    	$.tooltip('设置成功'); 
			    },
			    error: function(request) {
			     	$.tooltip('设置失败');
			    }
			});
    	}
    });
});