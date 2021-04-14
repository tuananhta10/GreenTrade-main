package com.greentrade.backend.service;

import com.greentrade.backend.service.base.BaseService;
import com.greentrade.common.entity.SysBranchImpl;

import java.util.List;

public interface SysBranchService extends BaseService<SysBranchImpl, Long> {
    List<SysBranchImpl> getSysBranchByCode(String code) throws Exception;
}
