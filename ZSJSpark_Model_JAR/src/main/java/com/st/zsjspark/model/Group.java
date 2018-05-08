package com.st.zsjspark.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafish.clients.opc.component.OpcGroup;
import javafish.clients.opc.component.OpcItem;

import org.apache.log4j.Logger;

/**
 * Group 的model类
 * @author zyj
 * @date 2016/10/21
 * 
 * 
 */
public class Group implements Cloneable, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4756767808372261052L;

	private Integer groupId;//组编号

    private String groupName;//组名

    private Integer createPeople;//创建人

    private Long changedDate;//改变日期

    private Integer changePeople;//改变人

    private Long createDate;//创建日期

    private Integer status;//状态

    private Long deleteDate;//删除日期

    private Integer deletePeople;//删除人
    
	private List<Item> items;//item
	
	private OpcGroup group;//组
		
	static Logger logger=Logger.getLogger(Group.class);
	
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public OpcGroup getGroup() {
		return group;
	}

	public void setGroup(OpcGroup group) {
		this.group = group;
	}	

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName
				+ ", createPeople=" + createPeople + ", changedDate="
				+ changedDate + ", changePeople=" + changePeople
				+ ", createDate=" + createDate + ", status=" + status
				+ ", deleteDate=" + deleteDate + ", deletePeople="
				+ deletePeople + ", items=" + items + ", group=" + group + "]";
	}

	public void addItems(String machineGroupName){
		for (Item item : items) {
			//建立一个OpcItem对象，三个参数，分别是OpcItem的name，OpcItem是否开启，访问OpcItem的路径
			OpcItem opcItem = new OpcItem(machineGroupName+"."+item.getParameterName(), true, "");
			item.setOpcItem(opcItem);
			logger.info(machineGroupName+"."+item.getParameterName());
			group.addItem(opcItem);
		}
	}
    
//	// 判断是否为相同数据。
//	public boolean equals(Object obj) {
//		// 1、为了应付传入是否p1等于p1这种情况，可以定义if语句来判断。没必要比较直接返回true
//		if (this == obj) {
//			return true;
//		}
//		// 2、一旦向下转型时需要用关键字instanceof来做出判断。
//		if (!(obj instanceof Group)) {
//			// 为了防止非法值传入，可以定义一个类型转换异常语句：throw
//			// new
//			// ClassCastException();抛出异常！
//			return false;
//		}
//		// 3、向下转型												
//		Group p = (Group) obj;
//		// 4、比较语句
//		for (Item item : p.getItems()) {
//			OpcItem opcItem = p.getOpcItemMap().get(item.getItemName());
//			OpcItem opcItemThis = this.getOpcItemMap().get(item.getItemName());
//			if (opcItem.getValue().toString().compareTo(opcItemThis.getValue().toString()) != 0) {
//				return false;
//			}
//		}
//		return true;
//	}
    
}