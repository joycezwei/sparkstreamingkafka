package com.st.zsjspark.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.zsjspark.comn.util.Tools;
import com.st.zsjspark.model.Menu;
import com.st.zsjspark.service.IMenuService;

@Controller
@RequestMapping("/MenuController")
public class MenuController {

	@Resource
	private IMenuService menuService;
	
	@RequestMapping("/machinesInfo.action")
	public String showMachinesInfo() {
		// 转向列表的action
		return "/ManageMachine/machinesInfo.jsp?time=" + new Date();
	}
	
	@RequestMapping("/machineData.action")
	public String showMachineData(HttpServletRequest request, String machineCode) {
		request.getSession().setAttribute("machineCode", machineCode);
		request.setAttribute("machineCode", machineCode);
		// 转向列表的action
		return "/ManageMachine/machineData.jsp?time=" + new Date();
	}
	
	@RequestMapping("/workSet.action")
	public String showWorkSet() {
		// 转向列表的action
		return "/ManageMachine/workset.jsp?time=" + new Date();
	}
	
	@RequestMapping("/productsData.action")
	public String showProductsData() {
		// 转向列表的action
		return "/ManageMachine/productsData.jsp?time=" + new Date();
	}
	
	@RequestMapping("/warnings.action")
	public String showWarnings() {
		// 转向列表的action
		return "/ManageMachine/warnings.jsp?time=" + new Date();
	}
	
	@RequestMapping("/subtask.action")
	public String showSubtask() {
		// 转向列表的action
		return "/ManageProduct/subtask.jsp?time=" + new Date();
	}
	
	@RequestMapping("/taskList.action")
	public String showTask() {
		// 转向列表的action
		return "/ManageProduct/producetask.jsp?time=" + new Date();
	}
	@RequestMapping("/Starffer.action")
	public String showStarffer() {
		// 转向列表的action
		return "/SystemCenter/Starffer.jsp?time=" + new Date();
	}
	@RequestMapping("/workshopPanel.action")
	public String showWorkshopPanel() {
		// 转向列表的action
		return "/ManageProduct/workshopPanel.jsp?time=" + new Date();
	}
	
	@RequestMapping("/taskPanel.action")
	public String showTaskPanel() {
		// 转向列表的action
		return "/ManageProduct/taskPanel.jsp?time=" + new Date();
	}

	@RequestMapping("/jqrwzl.action")
	public String showJqrwzl() {
		// 转向列表的action
		return "/ManageProduct/jqrwzl.jsp?time=" + new Date();
	}
	
	@RequestMapping("/workshopList.action")
	public String showWorkshop() {
		// 转向列表的action
		return "/ManageWorkset/workshop.jsp?time=" + new Date();
	}
	
	@RequestMapping("/versionList.action")
	public String showVersion() {
		// 转向列表的action
		return "/ManageWorkset/softversion.jsp?time=" + new Date();
	}
	
	@RequestMapping("/machineList.action")
	public String showMachine() {
		// 转向列表的action
		return "/ManageWorkset/machine.jsp?time=" + new Date();
	}
	
	@RequestMapping("/modelList.action")
	public String showModel() {
		// 转向列表的action
		return "/ManageWorkset/model.jsp?time=" + new Date();
	}
	
	@RequestMapping("/productlList.action")
	public String showProduct() {
		// 转向列表的action
		return "/ManageWorkset/product.jsp?time=" + new Date();
	}
	
	@RequestMapping("/paintList.action")
	public String showPaint() {
		// 转向列表的action
		return "/ManageWorkset/paint.jsp?time=" + new Date();
	}
	
	@RequestMapping("/materialList.action")
	public String showMaterial() {
		// 转向列表的action
		return "/ManageWorkset/material.jsp?time=" + new Date();
	}
	
	@RequestMapping("/gycsda.action")
	public String showGycsda() {
		// 转向列表的action
		return "/ManageWorkset/gycsda.jsp?time=" + new Date();
	}
	
	@RequestMapping("/xntj.action")
	public String showXntj() {
		// 转向列表的action
		return "/ReportCenter/xntj.jsp?time=" + new Date();
	}
	
	@RequestMapping("/jqrlb.action")
	public String showjqrlb() {
		// 转向列表的action
		return "/ReportCenter/jqrlb.jsp?time=" + new Date();
	}
	
	@RequestMapping("/scbb.action")
	public String showScbb() {
		// 转向列表的action
		return "/ReportCenter/scbb.jsp?time=" + new Date();
	}
	@RequestMapping("/taskCompletionTable.action")
	public String showtaskCompletionTable() {
		// 转向列表的action
		return "/ReportCenter/taskCompletionTable.jsp?time=" + new Date();
	}
	@RequestMapping("/cpkctj.action")
	public String showcpkctj() {
		// 转向列表的action
		return "/ReportCenter/cpkctj.jsp?time=" + new Date();
	}
	@RequestMapping("/ylbb.action")
	public String showYlbb() {
		// 转向列表的action
		return "/ReportCenter/ylbb.jsp?time=" + new Date();
	}
	
	@RequestMapping("/lpltj.action")
	public String showLpltj() {
		// 转向列表的action
		return "/ReportCenter/lpltj.jsp?time=" + new Date();
	}
	
	
	@RequestMapping("/scgj.action")
	public String showscgj() {
		// 转向列表的action
		return "/ReportCenter/scgj.jsp?time=" + new Date();
	}
	
	@RequestMapping("/mjscsl.action")
	public String showMjscsl() {
		// 转向列表的action
		return "/ReportCenter/mjscsl.jsp?time=" + new Date();
	}
	@RequestMapping("/ckdzlcx.action")
	public String showCkdzlcx() {
		// 转向列表的action
		return "/ReportCenter/ckdzlcx.jsp?time=" + new Date();
	}
	@RequestMapping("/ddjqyqtj.action")
	public String showDdjqyqtj() {
		// 转向列表的action
		return "/ReportCenter/ddjqyqtj.jsp?time=" + new Date();
	}
	@RequestMapping("/sczsb.action")
	public String showSczsb() {
		// 转向列表的action
		return "/ReportCenter/sczsb.jsp?time=" + new Date();
	}
	@RequestMapping("/sczst.action")
	public String showSczst() {
		// 转向列表的action
		return "/ReportCenter/sczst.jsp?time=" + new Date();
	}
	@RequestMapping("/jqrlt.action")
	public String showJqrlt() {
		// 转向列表的action
		return "/ReportCenter/jqrlt.jsp?time=" + new Date();
	}
	@RequestMapping("/datare.action")
	public String showDatare() {
		// 转向列表的action
		return "/SystemCenter/datare.jsp?time=" + new Date();
	}
	@RequestMapping("/sbscbb.action")
	public String showSbscbb() {
		// 转向列表的action
		return "/ReportCenter/sbscbb.jsp?time=" + new Date();
	}
	
	@RequestMapping("/rwsl.action")
	public String showRwsl() {
		// 转向列表的action
		return "/ReportCenter/rwsl.jsp?time=" + new Date();
	}
	@RequestMapping("/mrtj.action")
	public String showMrtj() {
		// 转向列表的action
		return "/ReportCenter/mrtj.jsp?time=" + new Date();
	}
	@RequestMapping("/jqpjgzsj.action")
	public String showJqpjgzsj() {
		// 转向列表的action
		return "/ReportCenter/jqpjgzsj.jsp?time=" + new Date();
	}
	@RequestMapping("/jhmxcx.action")
	public String showJhmxcx() {
		// 转向列表的action
		return "/ReportCenter/jhmxcx.jsp?time=" + new Date();
	}
	@RequestMapping("/cpyscmxb.action")
	public String showCpyscmxb() {
		// 转向列表的action
		return "/ReportCenter/cpyscmxb.jsp?time=" + new Date();
	}
	@RequestMapping("/cpjgcx.action")
	public String showCpjgcx() {
		// 转向列表的action
		return "/ReportCenter/cpjgcx.jsp?time=" + new Date();
	}
	@RequestMapping("/rwjzt.action")
	public String showRwjzt() {
		// 转向列表的action
		return "/ReportCenter/rwjzt.jsp?time=" + new Date();
	}
	@RequestMapping("/sbzctjb.action")
	public String showSbzctjb() {
		// 转向列表的action
		return "/ReportCenter/sbzctjb.jsp?time=" + new Date();
	}
	
	@RequestMapping("/scrkjlmx.action")
	public String showScrkjlmx() {
		// 转向列表的action
		return "/ReportCenter/scrkjlmx.jsp?time=" + new Date();
	}
	
	@RequestMapping("/tagList.action")
	public String showtag() {
		// 转向列表的action
		return "/ReportCenter/tag.jsp?time=" + new Date();
	}
	@RequestMapping("/tagShow.action")
	public String tagshow() {
		// 转向列表的action
		return "/ReportCenter/tag_show.jsp?time=" + new Date();
	}
	
	@RequestMapping("/qxgl.action")
	public String showQxgl() {
		// 转向列表的action
		return "/SystemCenter/qxgl.jsp?time=" + new Date();
	}
	@RequestMapping("/deskList.action")
	public String showGzt() {
		// 转向列表的action
		return "/SystemCenter/desk.jsp?time=" + new Date();
	}
	@RequestMapping("/userList.action")
	public String showUser() {
		// 转向列表的action
		return "/SystemCenter/user.jsp?time=" + new Date();
	}
	@RequestMapping("/roleList.action")
	public String showRole() {
		// 转向列表的action
		return "/SystemCenter/role.jsp?time=" + new Date();
	}
	
	@RequestMapping("/menureport.action")
	public String showmenureport() {
		// 转向列表的action
		return "/SystemCenter/menureport.jsp?time=" + new Date();
	}
	
	/**
	 * 权限树选项
	 * 
	 */
	@RequestMapping("/Useproduct1.action")
	public String showUseproduct() {
		// 转向列表的action
		return "/ReportCenter/useproduct.jsp?time=" + new Date();
	}
	@RequestMapping(value = "/menuTree.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String menuTree(String userid) {
		Map map = new HashMap();
		return menuService.findMenuList(map);
	}
	/**
	 * 权限树选项
	 * 
	 */
	@RequestMapping(value = "/menuTreeR.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String menuTreeR(String userid) {
		Map map = new HashMap();
	return menuService.findMenuRList(map);
	}
	/**
	 * 权限树选项
	 * 
	 */
	@RequestMapping(value = "/menuDesk.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String menuDesk(String userid) {
		Map map = new HashMap();
//		map.put("userid", userid);
		map.put("userid", 1);
		return menuService.findMenuDesk(map);
	}
	
	/**
	 * 权限树选项
	 * 
	 */
	@RequestMapping(value = "/setDesk.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void setDesk(String ids) {
		String[] id = ids.split(",");
		menuService.deleteUserDesk("1");
		for(int i=0;i<id.length;i++){
			Map map = new HashMap();
			map.put("userid", 1);
			map.put("menuid", id[i]);
			menuService.setUserDesk(map);
		}
	}
	@RequestMapping(value = "/findReport.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findbyCondition(Menu record) {
		Map map = Tools.transBean2Map(record);//.transBean2Map(record);
		List<Menu> list = menuService.findReport(map);//.findByCondition(map);
	    JSONObject json = new JSONObject();
	    json.put("data", list);
		return json.getString("data");

	}
	/**
	 * 根据表查询tag
	 * @param originalid
	 * @return
	 */
	@RequestMapping("/menuReportList.action")
	@ResponseBody
	public String menuReportList(Integer originalid) {
		Map map = new HashMap();
		map.put("originalid", originalid);
		return menuService.findMenuReportList(map);
	}
	
	/**
	 * 查询tag
	 * @param originalid
	 * @return
	 */
	@RequestMapping("/menuReportTag.action")
	@ResponseBody
	public String menuReportTag(Integer originalid) {
		Map map = new HashMap();
		map.put("originalid", originalid);
		return menuService.findMenuReportTag(map);
	}
	
	/**
	 * 写入数据库
	 * @param ids
	 * @param originalid
	 */
	@RequestMapping("/setTag.action")
	@ResponseBody
	public void setTag(String ids,Integer originalid) {
		String[] id = ids.split(",");
		menuService.deleteUserTag(originalid);
		for(int i=0;i<id.length;i++){
			Map map = new HashMap();
			map.put("originalid", originalid);
			map.put("targetid", id[i]);
			menuService.setUserTag(map);
		}
	}
}
