<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="WorkshopHBox" style="display:none;">
	<form id="WorkshopForm" method="post">
		<input name="id" type="hidden" class="clean_c">
		<ul class="list">
			<li><strong>车间名称:</strong>
				<div class="fl">
					<input id="workshopname" name="workshopname" class="ipt nickname clean_c" type="text">
				</div>
			</li>
			<li><strong>车间负责人:</strong>
				<div class="fl">
					<input id="workshopfzr" name="workshopfzr" class="ipt nickname clean_c" type="text">
				</div>
			</li>
			<li><strong>联系方式:</strong>
				<div class="fl">
					<input id="phone" name="phone" class="ipt nickname clean_c" type="text">
				</div>
			</li>
			<!-- <li><strong>机器数:</strong>
				<div class="fl">
					<input id="workshopnums" name="workshopnums" class="ipt nickname clean_c" type="text">
				</div>
			</li> -->
			<li><strong>描述:</strong>
				<div class="fl">
					<input id="remark" name="remark" class="ipt nickname clean_c" type="text">
				</div>
			</li>
			<li>
				<input value="保存" class="submitBtn col-md-5" id="submitWorkshop" type="button">
			</li>
		</ul>
	</form>
</div>
