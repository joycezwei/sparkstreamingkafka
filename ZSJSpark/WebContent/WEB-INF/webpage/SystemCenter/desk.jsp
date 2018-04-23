<%@ include file="../common/header.jspf"%>
<link href="${ctx}/styles/iCheck_red.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid" style="">
    <div class="row">
        <div class="container-main">
        	<form class="form-horizontal bucket-form" method="get" id="deskListFrom">
	 	         	<div class="row" id="saverow">
	         		<div class="col-lg-12">
	         			<div class="header-zl-right header-search-box">
		         			<div class="searchBtn">
		         				<a id="saveBtn" class="hvr-icon-pulse col-11">保存</a>
		         			</div>
		         		</div>
	         		</div>
		        </div>
	         </form>
        </div>
    </div>
</div>
<%@ include file="../common/bottom.jspf"%>
<script src="${ctx}/script/jquery.icheck.js"></script>
<script src="${ctx}/script/zsjspark/desk.js"></script>
</body>
</html>