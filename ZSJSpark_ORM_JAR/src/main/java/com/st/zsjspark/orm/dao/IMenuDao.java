package com.st.zsjspark.orm.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.st.zsjspark.model.Menu;
import com.st.zsjspark.orm.dao.base.IBaseDao;

public interface IMenuDao extends IBaseDao<Menu>{
	public String findMenuList(Map map);
	public String findMenuRList(Map map);
	public String findMenuDesk(Map map);
	public int setUserDesk(Map map);
	public int setRoleMenu(Map map);
	public int deleteUserDesk(String userid);
	public int deleteRoleMenu(String userid);
	public List<Menu> findRightById(Serializable id);
	public List<Menu> findReport(Map map);
	public String findMenuReportList(Map map);
	public String findMenuReportTag(Map map);
	public int deleteUserTag(int originalid);
	public int setUserTag(Map map);
}
