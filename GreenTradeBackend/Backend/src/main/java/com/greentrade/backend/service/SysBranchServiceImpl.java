package com.greentrade.backend.service;

import com.greentrade.backend.service.base.AbstractJPAService;
import com.greentrade.common.entity.SysBranchImpl;
import com.greentrade.worker.persistence.base.BaseJPAPersistence;
import com.greentrade.worker.persistence.jpa.SysBranchPersistence;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SysBranchService")
public class SysBranchServiceImpl extends AbstractJPAService<SysBranchImpl, Long> implements SysBranchService{
    @Resource
    private SysBranchPersistence persistence;

    @Override
    public List<SysBranchImpl> getSysBranchByCode(String code) throws Exception {
        return persistence.findBranchByCode(code);
    }

    @Override
    public SysBranchPersistence getPersistence() {
        return persistence;
    }
}
