package com.greentrade.backend.service.base;

import com.greentrade.common.base.BaseEntity;
import com.greentrade.common.utils.CompareUtil;
import com.greentrade.worker.persistence.base.BaseJPAPersistence;

import java.io.Serializable;
import java.util.Optional;

public abstract class AbstractJPAService<T extends BaseEntity<Tid>, Tid extends Serializable>
        extends AbstractService<T, Tid> implements BaseService<T, Tid> {

    public abstract BaseJPAPersistence<T, Tid> getPersistence();

    @Override
    public T add(T obj) throws Exception {
        if (CompareUtil.isEqualsNull(obj))
            throw new Exception("OBJ.NULL");
        preAdd(obj);
        getPersistence().save(obj);
        postAdd(obj);
        return obj;
    }

    @Override
    public T edit(T obj) throws Exception {
        if (CompareUtil.isEqualsNull(obj))
            throw new Exception("OBJ.NULL");
        preEdit(obj);
        getPersistence().save(obj);
        postEdit(obj);
        return obj;
    }

    @Override
    public void remove(Tid key) throws Exception {
//        if (CompareUtil.isEqualsNull(key))
//            throw new Exception("OBJ.NULL");
//        T oldObj = getById(key);
//        if (!CompareUtil.isEqualsNull(oldObj)) {
//            preRemove(oldObj);
//            getPersistence().delete(oldObj);
//            postRemove(oldObj);
//        } else
//            throw new Exception("OBJ.NULL");
    }

//    @Override
//    public T getById(Tid key) throws Exception {
//        if (CompareUtil.isEqualsNull(key))
//            throw new FaultException("OBJ.NULL", "Key of object to find is null");
//        preGetById(key);
//        Optional<T> optional = getPersistence().findById(key);
//        if (optional.isPresent()) {
//            T obj = optional.get();
//            postGetById(obj);
//            return obj;
//        }
//        return null;
//    }
}
