<%@ include file="../common/header.jspf"%>
<link href="${ctx}/styles/workshopPanel.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="container-main">
				<div class="col-sm-3">
					<div class="conditionbar header-zl-left" id="st"style="margin-top: 52px">
					</div>
					<hr style="margin-top: 78px;margin-bottom: 10px;">
					<div class="select-gril">
						<div class="summary">
							<div class="lpane panel-default">
								<div class="panel-heading">生产汇总</div>
								<div class="panel-body" id="panelDetial" style="text-align:left;">
								</div>
							</div>
						</div>
						<div class="summary">
							<div class="lpane panel-default">
								<div class="panel-heading">本日机器工作时间</div>
								<div class="panel-body" id="machineworktime" style="height: 190px;text-align:left;">
								</div>
							</div>
						</div>
						</div>
					</div>
				</div>
				<div class="col-sm-9">
<!-- 					<div style="float:left;margin-top:10px;text-align:center;position:absolute;"> -->
<!-- 						<span>车间：</span> -->
<!-- 						<select class="select-category" id="WorkshopCombox"> -->
<!-- 						</select> -->
<!-- 					</div> -->
					<h2 class="title_table" style="margin-left: -250px">注塑车间实时工况</h2>
<!-- 					<div class="conditionbar header-zl-left" id="st"> -->
<!-- 					</div> -->
					<span id="nowtime" class="text-danger text-right"></span>
					<hr style="margin-top: 35px;margin-bottom: 10px;">
					<div class="select-gril" id="workshopPanel">
					</div>
				</div>
<!-- 				<div class="col-sm-3"> -->
<!-- 					<div class="summary" style="margin-right: 10px;"> -->
<!-- 						<div class="machineTime1"> -->
<!-- 							<div class="panel panel-default responsive"> -->
<!-- 								<div class="panel-heading"> -->
<!-- 									<span class="glyphicon glyphicon-table"></span>本日机器运行时间分布统计 -->
<!-- 								</div> -->
<!-- 								<div class="panel-body" style="padding: 0px"> -->
<!-- 									<div id="echart" style="height: 200px;"></div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="summary"> -->
<!-- 							<div class="lpane panel-default"> -->
<!-- 								<div class="panel-heading">本日机器工作时间</div> -->
<!-- 								<div class="panel-body" id="machineworktime" style="height: 190px;text-align:left;"> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../common/bottom.jspf"%>
	<script type="text/javascript" src="${ctx}/script/echarts.common.min.js"></script>
	<script src="${ctx}/script/macarons.js"></script>
	<script type="text/javascript" src="${ctx}/script/zsjspark/myChart.js"></script>
	<script type="text/javascript" src="${ctx}/script/zsjspark/workshopPanel.js"></script>
</body>
</html>
