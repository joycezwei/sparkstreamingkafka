package com.st.zsjspark.orm.dao.base.impl;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.st.zsjspark.orm.dao.base.IBaseDao;


/**
 * BaseDaoImpl<T>
 *
 * @param <T>
 * @author Wlq
 */
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements IBaseDao<T> {

    /**
     * xxxMapper.xml的命名空间
     * 在各自的Dao中设置
     */
    private String nameSpace;

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    /**
	 * 注入
	 */
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
    
    /**
     * 计数，用于分页
     * @return
     */
    public int count(Map map){
    	return this.getSqlSession().selectOne(nameSpace+".count",map);
    }


    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public T findById(Serializable id) {
        return this.getSqlSession().selectOne(nameSpace + ".findById", id);
    }

    /**
     * 根据条件查询
     *
     * @return
     */
    public List<T> findByCondition(Map map) {
        List<T> list = this.getSqlSession().selectList(nameSpace + ".findByCondition", map);
        return list;
    }

    /**
     * 插入，用实体作为参数
     *
     * @param entity
     */
    public int insert(T entity) {
       return  this.getSqlSession().insert(nameSpace + ".insert", entity);
    }
    
    /** 
     * insert:批量插入操作. <br/> 
     * 
     * @author zhuyao
     * @param method 插入操作的方法名 
     * @param entity 查询参数或实体类 
     * @return 返回影响的行数 
     * @since JDK 1.7 
     */  
    public int insert(String method,Object entity){  
        return this.getSqlSession().insert(nameSpace +"."+method, entity);  
    }  
    
    /**
     * 修改，用实体作为参数
     *
     * @param entity
     */
    public int update(T entity) {
        return this.getSqlSession().update(nameSpace + ".update", entity);
    }

    /**
     * 批量删除；支持整数型和字符串类型ID
     *
     * @param ids
     */

    public int delete(Serializable[] ids) {
        return this.getSqlSession().delete(nameSpace + ".delete", ids);
    }

}

