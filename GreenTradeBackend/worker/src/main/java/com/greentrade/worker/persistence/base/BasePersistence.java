package com.greentrade.worker.persistence.base;


import com.greentrade.common.base.BaseEntity;

import java.io.Serializable;

public interface BasePersistence<T extends BaseEntity<Tid>, Tid extends Serializable> {
}
