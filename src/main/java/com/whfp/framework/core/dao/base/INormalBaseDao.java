package com.whfp.framework.core.dao.base;

import org.hibernate.Session;

import com.whfp.framework.core.dao.enums.OrderType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface INormalBaseDao {
     public Session getSession();
     <D> void delete(D persistentInstance);
     int queryIntByHQL(String HQL);
     int queryIntBySQL(String SQL);
     long queryLongByHQL(String HQL);
     long queryLongBySQL(String SQL);
     double queryDoubleByHQL(String HQL);
     double queryDoubleBySQL(String SQL);
     <D> D findById(Class<D> clazz, String id);
     <D> D findById(Class<D> clazz, int id);
     <D> Object save(D transientInstance) ;
     List queryByHQL(final String hql, final Object... values);
     List<Object> queryBySQL(String sql, Class entity);
     List  queryBySQL(final String sql, final Object... values);
     List<Object> queryBySQL(String sql, Class clazz, String[] fields);
     List<Map<String,Object>> queryBySQL(String sql, String[] fields);
     <D> PageBean<D> findPage(Class<D> clazz, ArrayList<Condition> conditions, LinkedHashMap<String, OrderType> orderBys, int pageIndex, int pageSize);
     <D> List<D> findList(Class<D> clazz, ArrayList<Condition> conditions, LinkedHashMap<String, OrderType> orderBys);
     PageBean<Map<String, Object>> queryByDynamicName(final String queryName, int pageIndex, int pageSize, final String[] fields, final Map<String, ?> parameters);
     PageBean<Object[]> queryByDynamicName(final String queryName, int pageIndex, int pageSize, final Map<String, ?> parameters);
     <D> PageBean<D> queryByDynamicName(final String queryName, int pageIndex, int pageSize, Class<D> clazz, final String[] fields, final Map<String, ?> parameters);
     int executeByDynamicName(final String queryName, final Map<String, ?> parameters);
     int queryIntByDynamicName(final String queryName, final Map<String, ?> parameters);
     String getStatement(final String queryName, final Map<String, ?> parameters);
}