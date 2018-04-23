function queryParams(params) {
	return {
		materialName: $('#materialName').val()
    };
}
function operate(value, row, index) {
	var str = '<a class="model add" href="#">进料</a>|<a class="model modify" href="#">盘点</a>';
	return str;
}
window.operateEvents = {
	    'click .add': function (e, value, row, index) {
			loadData($('#Material').bootstrapTable('getRowByUniqueId',row.id),'#MaterialJlForm');
	    	$("#method").val(0);
	    },
	    'click .modify': function (e, value, row, index) {
	    	loadData($('#Material').bootstrapTable('getRowByUniqueId',row.id),'#MaterialJlForm');
	    	$("#method").val(1);
	    }
};
$("#Material").bootstrapTable({
	onLoadSuccess : function() {
		sethDialog('.add','进料','#MaterialJlHBox',550,180,0);
		sethDialog('.modify','盘点','#MaterialJlHBox',550,180,0);
	},
	onPageChange : function() {
		sethDialog('.add','进料','#MaterialJlHBox',550,180,0);
		sethDialog('.modify','盘点','#MaterialJlHBox',550,180,0);
	}
});
$(function() {
	$("#MaterialForm").validate({
		rules: {
			materialName:"required",
			materialDescribe:"required",
		},
		errorPlacement: function (label, element) {
            $(element).tooltip('destroy'); /*必需*/
            $(element).attr('title', $(label).text()).tooltip('show'); 
        },
        success: function(label, element) {
        	$(element).tooltip('destroy');
        },
	});
	init('Material',400,200);
	$('#submitMaterialJl').click(function() {
		submitData("#MaterialJlForm","../MaterialController/updateWeight.action");
	});
});
