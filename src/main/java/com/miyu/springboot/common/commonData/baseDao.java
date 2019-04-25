package com.miyu.springboot.common.commonData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;


public interface   baseDao <T>  {

    /**
     * 添加实体
     * @param t
     * @return
     */
    public T add(T t);

    /**
     * 更新实体类
     * @param t
     * @return
     */
    public T update(T t);


    /**
     * 根据主键ID删除实体类
     * @param id
     */
    public void delete(Serializable id);


    /**
     * 根据JPQL语句更新或删除操作
     * @param jpql
     * @param obj
     */
    public int executeUpdate(String jpql,Object... obj);

    /**
     * 根据主键ID查找单个实体类
     * @param id
     * @return
     */
    public T load(Serializable id);

    /**
     * 根据JPQL语句查询单个实体类
     * @param jpql
     * @param obj（参数可有可无）
     * @return
     */
    public T load(String jpql,Object... obj);


    /**
     * 查找所有的实体类
     * @return
     */
    public List<T> findAll();


    /**
     * 返回实体
     * @param jpql
     * @param obj
     * @return
     */
    public List<T> find(String jpql,Object... obj);


}
