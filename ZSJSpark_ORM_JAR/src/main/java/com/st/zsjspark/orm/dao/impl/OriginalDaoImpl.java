package com.st.zsjspark.orm.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.st.zsjspark.model.Original;
import com.st.zsjspark.orm.dao.IOriginalDao;
import com.st.zsjspark.orm.dao.base.impl.BaseDaoImpl;

/**
 * FactoryDaoImpl
 * 注解开发
 * @author wlq
 */
@Repository
public class OriginalDaoImpl extends BaseDaoImpl<Original> implements IOriginalDao{

	/**
	 * 调用FactoryDaoImpl实现类时，设置命名空间
	 * 设置命名空间
	 */
	public OriginalDaoImpl(){
		super.setNameSpace("com.st.zsjspark.mapper.OriginalMapper");
	}
	
    /** 
     * batchInsertOriginal:批量插入原始记录.
     * 
     * @author zhuyao
     * @param originalList 原始记录list集合 
     * @return 影响的行数 
     * @since JDK 1.7
     */  
    public int addOriginalRecordBatch(List<Original> originalList){  
        return this.insert("batchInsertOriginal", originalList);  
    }

	@Override
	public List<Original> getData(Map map) {
		return this.getSqlSession().selectList(getNameSpace() + ".findByConditionOld",map);
	}

}
