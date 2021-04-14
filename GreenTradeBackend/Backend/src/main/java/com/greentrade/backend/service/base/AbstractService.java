package com.greentrade.backend.service.base;


import com.greentrade.common.base.BaseEntity;
import com.greentrade.worker.persistence.base.BasePersistence;

import javax.annotation.security.PermitAll;
import java.io.Serializable;

public abstract class AbstractService<T extends BaseEntity<Tid>, Tid extends Serializable> implements BaseService<T, Tid> {
    @PermitAll
    public abstract BasePersistence<T, Tid> getPersistence();


    @PermitAll
    protected void preAdd(T obj) throws Exception {

    }

    @PermitAll
    protected void postAdd(T obj) throws Exception {

    }

    @PermitAll
    protected void preEdit(T obj) throws Exception {

    }

    @PermitAll
    protected void postEdit(T obj) throws Exception {

    }

    @PermitAll
    protected void preRemove(T obj) throws Exception {

    }

    @PermitAll
    protected void postRemove(T obj) throws Exception {

    }

    @PermitAll
    protected void preGetById(Tid key) throws Exception {

    }

    @PermitAll
    protected void postGetById(T obj) throws Exception {

    }
}
