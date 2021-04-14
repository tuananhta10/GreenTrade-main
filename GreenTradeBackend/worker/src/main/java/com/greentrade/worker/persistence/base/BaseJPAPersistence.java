package com.greentrade.worker.persistence.base;

import com.greentrade.common.base.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface BaseJPAPersistence<T extends BaseEntity<Tid>, Tid extends Serializable>
        extends BasePersistence, CrudRepository<T, Tid> {
}
