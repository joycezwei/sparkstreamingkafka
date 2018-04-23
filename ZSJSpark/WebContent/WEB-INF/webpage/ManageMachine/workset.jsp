<%@ include file="../common/header.jspf"%>
<link href="${ctx}/styles/dragstyle.css" rel="stylesheet">
<title></title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- <div class="panel-body"><p>自由拖动，初始位置固定</p></div> -->
			<div class="container-main" align="center">
				<div id="showBox" class="Box" style="width: 100%;"><!-- position: absolute; -->
				</div>
				<button id="save" type="button" onclick="save()" style="margin:0 auto;">保存</button>
			</div>
		</div>
	</div>
	<%@ include file="../common/bottom.jspf"%>
	<script src="${ctx}/script/drag.js"></script>
	<script src="${ctx}/script/zsjspark/workset.js"></script>
	<script type="text/javascript">
		/* $(function(){
			$('#showBox dl').each(function(){
				$(this).dragging({
					move : 'both',
					randomPosition : false
				});
			});
		}); */
	</script>
</body>
</html>