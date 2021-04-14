package com.greentrade.backend;

import com.greentrade.common.entity.SysBranchImpl;
import com.greentrade.worker.AbstractWorker;
import com.greentrade.worker.persistence.jpa.SysBranchPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BackendWorker extends AbstractWorker {

    @Autowired
    private SysBranchPersistence sysBranchPersistence;

    @Override
    public void onStarted() {
        List<SysBranchImpl> sysBranches = sysBranchPersistence.findBranchByCode("1");
        System.out.println("=========================");
        for (SysBranchImpl sysBranch: sysBranches) {
            System.out.println(sysBranch.getBranchCode());
        }
    }

    @Override
    public void onStopping() {

    }
}
