<%@ include file="../common/header.jspf"%>
<link href="${ctx}/styles/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel-body">
				<div class="header-zl-left">
					<div class="btn-group btn-group-justified">
						<a class="btn btn-info" id="addWorkshop"><span><i class="fa fa-plus-circle"></i></span>添加</a>
						<a class="btn btn-info" id="modifyWorkshop"><span><i class="fa fa-pencil"></i></span>修改</a>
						<a class="btn btn-info" id="deleteWorkshop"><span><i class="fa fa-trash-o"></i></span>删除</a>
					</div>
				</div>
			</div>
			<div class="container-main col-sm-12">
				<div class="adv-table">
					<div id="hidden-table-info_wrapper"
						class="dataTables_wrapper form-inline" role="grid">
						<table id="Workshop" class="display table table-bordered dataTable table-striped table-hover"
							data-toggle="table"
							data-url="../WorkshopController/conditionSearch.action"
							data-click-to-select="true"
							data-unique-id="id"
							data-pagination="true" data-page-size="5" data-striped="true">
							<thead>
								<tr role="row">
									<th class="sorting_disabled" data-checkbox="true"></th>
									<th class="sorting_disabled hidden" data-field="id" hidden="true">ID</th>
									<th class="sorting_disabled" data-field="workshopname">车间名称</th>
									<th class="sorting_disabled" data-field="workshopfzr">车间负责人</th>
									<th class="sorting_disabled" data-field="phone">联系方式</th>
									<th class="sorting_disabled" data-field="workshopnums">机器数</th>
									<th class="sorting_disabled" data-field="remark">描述</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="workshop_file.jsp"%>
	<%@ include file="../common/bottom.jspf"%>
	<script type="text/javascript" src="${ctx}/script/zsjspark/workshop.js"></script>
</body>
</html>