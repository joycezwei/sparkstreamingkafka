<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
<link href="${ctx}/styles/bootstrap-datetimepicker.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel-body">
				<div class="select-gril form-inline">
					
						<div class="header-search-box col-sm-2 col-both">
						<span>名字：</span>
						<div class="form-group col-both" style="width: 50%;">
							<input id="MenuCombox" type="text" class="form-control">
						</div>
					</div>
					<div class="header-zl-right header-search-box">
						<div class="searchBtn">
							<a id="searchMenuReport" class="hvr-icon-pulse col-11">查询</a>
						</div>
					</div>
				</div>
			</div>
				<div class="container-main col-sm-12">
				
				<div class="adv-table">
					<div id="hidden-table-info_wrapper" class="dataTables_wrapper form-inline table-responsive" role="grid">
						<table id="MenuReport" class="display table table-bordered dataTable table-striped table-hover"
							data-toggle="table"
							data-query-params="queryParams"
							data-click-to-select="true"
							data-unique-id="ID"
							data-url="../MenuController/findReport.action"
							data-pagination="true" data-page-size="10" data-striped="true">
							<thead>
								<tr role="row">
									<th class="sorting_disabled hidden" data-field="menuid">菜单Id</th>
									<th class="sorting_disabled" data-field="parentmenu">名字</th>
									<th class="sorting_disabled" data-field="menuname">类型名称</th>
									<th class="sorting_disabled" data-field="url" >路径</th>
								    <th class="sorting_disabled hidden" data-field="icon">隐藏类型</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
	
		</div>
	</div>

<%@ include file="../common/bottom.jspf"%>
<script src="${ctx}/script/zsjspark/menureport.js"></script>
</body>
</html>

