package com.greentrade.backend.service.base;

import com.greentrade.common.base.BaseEntity;

import java.io.Serializable;

public interface BaseService<T extends BaseEntity<Tid>, Tid extends Serializable> {
    public T add(T obj) throws Exception;

    public T edit(T obj) throws Exception;

    public void remove(Tid key) throws Exception;
}
