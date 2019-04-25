package com.miyu.springboot.common.commonData;

import antlr.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

public abstract class commonDAO {
    @Autowired
    private EntityManager entityManager;

    /**
     * 查询列表
     * @param sql native sql语句，可以包含？
     * @param params 参数列表
     * @param <T> 泛型
     * @return 查询列表结果
     */
    public <T> List<T> querySqlByList(String sql  , Object... params) {
        Query query = entityManager.createNativeQuery(sql);
        if(params != null && params.length > 0)
        {
            for(int i = 0; i < params.length; i++)
                query.setParameter(i, params[i]);
        }
        Query nativeQuery=entityManager.createNativeQuery(sql);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List resultList=nativeQuery.getResultList();
        return resultList;

    }

    /**
     * 执行sql
     * @param sql
     * @param params
     * @return
     */
    public int updateSql(String sql  , Object... params){
        Query query = entityManager.createNativeQuery(sql);
        if(params != null && params.length > 0)
        {
            for(int i = 0; i < params.length; i++)
                query.setParameter(i, params[i]);
        }
        Query nativeQuery=entityManager.createNativeQuery(sql);
        int i = nativeQuery.executeUpdate();
        return i;
     }


    /**新增
     * @param entity
     */
    public <T> void insert(T entity) {
        entityManager.persist(entity);
    }

    /**删除
     * @param entity
     */
    public <T> void delete(T entity) {
        entityManager.remove(entity);
    }
    /**更新
     * @param entity
     */
    public <T> void update(T entity) {
        entityManager.merge(entity);
    }

    /**执行hql语句
          * @param hql
          * @param params
          * @param classz
          * @return
          * @throws Exception
          */
    public <T> List<T> executeHqlQuery(String hql, Class<T> classz) throws Exception {

        //单表处理 取出实体对象
        TypedQuery<T> createQuery = entityManager.createQuery(hql, classz);

        List<T> resultList = createQuery.getResultList();
        return resultList;

    }


}

