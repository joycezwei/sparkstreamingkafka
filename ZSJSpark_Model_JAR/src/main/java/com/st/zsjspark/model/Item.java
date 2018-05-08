package com.st.zsjspark.model;

import java.io.Serializable;

import javafish.clients.opc.component.OpcItem;


/**
 * Item的model类
 * 
 * @author zyj
 * @date 2016/10/21
 * 
 */
public class Item implements Cloneable, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7784904719235096484L;

	private Integer itemId;//item编号

    private String itemName;//item名字

    private String parameterName;//参数名字

    private Integer groupId;//组编号

    private Integer createPeople;//创建人

    private Long changedDate;//改变日期

    private Integer changePeople;//改变人

    private Long createDate;//创建日期

    private Integer status;//状态

    private Long deleteDate;//删除日期

    private Integer deletePeople;//删除人
    
    private OpcItem opcItem;//Item绑定具体的item

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getCreatePeople() {
		return createPeople;
	}

	public void setCreatePeople(Integer createPeople) {
		this.createPeople = createPeople;
	}

	public Long getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(Long changedDate) {
		this.changedDate = changedDate;
	}

	public Integer getChangePeople() {
		return changePeople;
	}

	public void setChangePeople(Integer changePeople) {
		this.changePeople = changePeople;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Long deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Integer getDeletePeople() {
		return deletePeople;
	}

	public void setDeletePeople(Integer deletePeople) {
		this.deletePeople = deletePeople;
	}

	public OpcItem getOpcItem() {
		return opcItem;
	}

	public void setOpcItem(OpcItem opcItem) {
		this.opcItem = opcItem;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", parameterName=" + parameterName + ", groupId=" + groupId
				+ ", createPeople=" + createPeople + ", changedDate="
				+ changedDate + ", changePeople=" + changePeople
				+ ", createDate=" + createDate + ", status=" + status
				+ ", deleteDate=" + deleteDate + ", deletePeople="
				+ deletePeople + ", opcItem=" + opcItem + "]";
	}
    
}