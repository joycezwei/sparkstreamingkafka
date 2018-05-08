package com.st.zsjspark.orm.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.st.zsjspark.comn.util.JsonUtil;
import com.st.zsjspark.model.Menu;
import com.st.zsjspark.orm.dao.IMenuDao;
import com.st.zsjspark.orm.dao.base.impl.BaseDaoImpl;

/**
 * FactoryDaoImpl
 * 注解开发
 * @author wlq
 */
@Repository
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements IMenuDao{

	/**
	 * 调用FactoryDaoImpl实现类时，设置命名空间
	 * 设置命名空间
	 */
	public MenuDaoImpl(){
		super.setNameSpace("com.st.zsjspark.mapper.MenuMapper");
	}

	@Override
	public String findMenuList(Map map) {
		List<Menu> menuList = this.getSqlSession().selectList(getNameSpace() + ".findMenuList",map);
		return JsonUtil.deelMenu(menuList);
	}
	
	@Override
	public String findMenuRList(Map map) {
		List<Menu> menuList = this.getSqlSession().selectList(getNameSpace() + ".findMenuRList",map);
		return JsonUtil.deelMenu(menuList);
	}
	
	@Override
	public String findMenuDesk(Map map) {
		List<Menu> menuList = this.getSqlSession().selectList(getNameSpace() + ".findMenuDesk",map);
		return JsonUtil.deelDesk(menuList);
	}

	@Override
	public List<Menu> findRightById(Serializable id) {
		return this.getSqlSession().selectList(getNameSpace() + ".findRightById",id);
	}
	
	@Override
	public int setUserDesk(Map map) {
		return this.getSqlSession().insert(getNameSpace() + ".setUserDesk",map);
	}
	
	@Override
	public int setRoleMenu(Map map) {
		return this.getSqlSession().insert(getNameSpace() + ".setRoleMenu",map);
	}
	
	@Override
	public int deleteUserDesk(String userid) {
		return this.getSqlSession().delete(getNameSpace() + ".deleteUserDesk",userid);
	}
	
	@Override
	public int deleteRoleMenu(String userid) {
		return this.getSqlSession().delete(getNameSpace() + ".deleteRoleMenu",userid);
	}

	@Override
	public List<Menu> findReport(Map map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(getNameSpace() + ".findReport",map);
	}

	@Override
	public String findMenuReportList(Map map) {
		List<Menu> menuList = this.getSqlSession().selectList(getNameSpace() + ".findMenuReportList",map);
		return JsonUtil.deelMenu(menuList);
	}

	@Override
	public String findMenuReportTag(Map map) {
		List<Menu> menuList = this.getSqlSession().selectList(getNameSpace() + ".findMenuReportTag",map);
		return JsonUtil.deelDesk(menuList);
	}

	@Override
	public int deleteUserTag(int originalid) {
		return this.getSqlSession().insert(getNameSpace() + ".deleteUserTag",originalid);
	}

	@Override
	public int setUserTag(Map map) {
		return this.getSqlSession().insert(getNameSpace() + ".setUserTag",map);
	}
	
}
