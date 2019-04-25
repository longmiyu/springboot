package com.miyu.springboot.common.commonData;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Repository
public abstract   class baseDaoImpl <T> implements baseDao<T> {

    @Autowired
    private EntityManager entityManager;

    private Class<T> clazz = null;

    @Override
    public T add(T t) {
        entityManager.persist(t);
        return t;
    }
    @Override
    public T update(T t) {
        return entityManager.merge(t);
    }

    @Override
    public void delete(Serializable id) {
        T t = entityManager.getReference(clazz, id);
        entityManager.remove(t);

    }

    @Override
    public int executeUpdate(String jpql, Object... obj) {
        Query query = entityManager.createQuery(jpql);
        if(obj.length > 0){
            for (int i = 0; i < obj.length; i++) {
                query.setParameter((i+1),obj[i]);
            }
        }
        return query.executeUpdate();

    }

    @Override
    public T load(Serializable id) {

        return entityManager.find(clazz, id);

    }

    @Override
    public T load(String jpql, Object... obj) {
        try{
            Query query = entityManager.createQuery(jpql);
            if(obj.length > 0){
                for (int i = 0; i < obj.length; i++) {
                    query.setParameter((i+1),obj[i]);
                }
            }
            return (T) query.getSingleResult();
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from "+clazz.getSimpleName()).getResultList();
    }

    @Override
    public List<T> find(String jpql, Object... obj) {
        try{
            Query query = entityManager.createQuery(jpql);
            if(obj.length > 0){
                for (int i = 0; i < obj.length; i++) {
                    query.setParameter((i+1),obj[i]);
                }
            }
            return query.getResultList();
        }catch (Exception e){
            return null;
        }

    }


}
