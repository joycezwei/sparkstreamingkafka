package com.st.zsjspark.orm.dao;

import java.util.List;
import java.util.Map;

import com.st.zsjspark.model.Original;
import com.st.zsjspark.orm.dao.base.IBaseDao;

public interface IOriginalDao extends IBaseDao<Original>{
	public List<Original> getData(Map map);
}
