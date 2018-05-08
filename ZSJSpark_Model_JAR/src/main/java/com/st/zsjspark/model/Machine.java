package com.st.zsjspark.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafish.clients.opc.component.OpcGroup;

/**
 * Machine Model
 * 
 * @author Alex
 * @since 2016.10.22
 * 
 */

/**
 * Machine
 * 
 * @author Alex
 * @since 2016.10.22
 * @update lxc
 * @updatetime 2016.10.22
 * 
 */

public class Machine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3161037256167077953L;

	// 内部id
	private Integer id;

	//工作车间ID
	private String workshopId;

	// OPCServer ID
	private Integer opcserverId;

	// 机器id
	private String machineCode;

	// 机器名称
	private String machineName;

	// 机器类型
	private String machineType;

	// 机器型号
	private Integer machineModel;

	// 机器IP地址
	private String ip;

	// 机器状态
	private Integer status;

	// 机器mac地址
	private String mac;

	// 机器描述
	private String describe;

	// 控制器厂家
	private String controlCompany;

	// 机器版本
	private String version;

	// 所属公司
	private String company;

	// 生产日期
	private Long dateManufacture;

	// 购买日期
	private Long datePurchase;

	// 所在场地
	private String location;

	// 所属车间
	private String workset;

	// 创建人
	private Integer createPeople;

	// 创建时间
	private Long createDate;

	// 修改人
	private Integer changePeople;

	// 修改时间
	private Long changedDate;

	// 删除人
	private Integer deletePeople;

	// 删除时间
	private Long deleteDate;

	// 扩展
	private String extend;

	// 扩展1
	private String extend1;

	// 机器中的组列表
	private List<Group> groupList;
	
	private Serializable[] ids;
	public Serializable[] getIds() {
		return ids;
	}

	public void setIds(Serializable[] ids) {
		this.ids = ids;
	}

	// 机器中的组的HashMap存储
	private Map<String, Group> groupMap;

	private String pageSize;
	private String offset;
	private String sortOrder;

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getWorkshopId() {
		return workshopId;
	}
	
	public void setWorkshopId(String workshopId) {
		this.workshopId = workshopId;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getCreatePeople() {
		return createPeople;
	}

	public void setCreatePeople(Integer createPeople) {
		this.createPeople = createPeople;
	}

	public Integer getChangePeople() {
		return changePeople;
	}

	public void setChangePeople(Integer changePeople) {
		this.changePeople = changePeople;
	}

	public Integer getDeletePeople() {
		return deletePeople;
	}

	public void setDeletePeople(Integer deletePeople) {
		this.deletePeople = deletePeople;
	}

	public Long getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Long deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Machine() {
		this.groupMap = new HashMap<String, Group>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOpcserverId() {
		return opcserverId;
	}

	public void setOpcserverId(Integer opcserverId) {
		this.opcserverId = opcserverId;
	}

	public String getMachineCode() {
		return machineCode;
	}

	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode == null ? null : machineCode.trim();
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName == null ? null : machineName.trim();
	}

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType == null ? null : machineType.trim();
	}

	public Integer getMachineModel() {
		return machineModel;
	}

	public void setMachineModel(Integer machineModel) {
		this.machineModel = machineModel;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac == null ? null : mac.trim();
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe == null ? null : describe.trim();
	}

	public String getControlCompany() {
		return controlCompany;
	}

	public void setControlCompany(String controlCompany) {
		this.controlCompany = controlCompany == null ? null : controlCompany
				.trim();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version == null ? null : version.trim();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company == null ? null : company.trim();
	}

	public Long getDateManufacture() {
		return dateManufacture;
	}

	public void setDateManufacture(Long dateManufacture) {
		this.dateManufacture = dateManufacture;
	}

	public Long getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Long datePurchase) {
		this.datePurchase = datePurchase;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location == null ? null : location.trim();
	}

	public String getWorkset() {
		return workset;
	}

	public void setWorkset(String workset) {
		this.workset = workset == null ? null : workset.trim();
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public Long getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(Long changedDate) {
		this.changedDate = changedDate;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend == null ? null : extend.trim();
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1 == null ? null : extend1.trim();
	}

	public List<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}

	public Map<String, Group> getGroupMap() {
		return groupMap;
	}

	public void setGroupMap(Map<String, Group> groupMap) {
		this.groupMap = groupMap;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", opcserverId=" + opcserverId
				+ ", machineCode=" + machineCode + ", machineName="
				+ machineName + ", machineType=" + machineType
				+ ", machineModel=" + machineModel + ", ip=" + ip + ", status="
				+ status + ", mac=" + mac + ", describe=" + describe
				+ ", controlCompany=" + controlCompany + ", version=" + version
				+ ", company=" + company + ", dateManufacture="
				+ dateManufacture + ", datePurchase=" + datePurchase
				+ ", location=" + location + ", workset=" + workset
				+ ", createPeople=" + createPeople + ", createDate="
				+ createDate + ", changePeople=" + changePeople
				+ ", changedDate=" + changedDate + ", deletePeople="
				+ deletePeople + ", deleteDate=" + deleteDate + ", extend="
				+ extend + ", extend1=" + extend1 + ", groupList=" + groupList
				+ ", pageSize=" + pageSize + ", offset=" + offset
				+ ", sortOrder=" + sortOrder + ", groupMap=" + groupMap + "]";
	}

	// 创建组
	public void creatGroups() {
		long time=System.currentTimeMillis();
		for (Group group : groupList) {
			OpcGroup opcGroup = new OpcGroup(
					machineCode + group.getGroupName()+time, true, 500, 0.0f);
			group.setGroup(opcGroup);
			group.addItems(machineCode);
			groupMap.put(group.getGroupName(), group);
		}
	}
}