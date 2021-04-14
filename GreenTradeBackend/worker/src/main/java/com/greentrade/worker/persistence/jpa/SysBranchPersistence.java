package com.greentrade.worker.persistence.jpa;


import com.greentrade.common.entity.SysBranchImpl;
import com.greentrade.worker.persistence.base.BaseJPAPersistence;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface SysBranchPersistence extends BaseJPAPersistence<SysBranchImpl, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM SysBranchImpl t WHERE t.BranchCode = :BranchCode")
    void deleteTickByDate(@Param("BranchCode") String BranchCode);

    @Query("SELECT t FROM SysBranchImpl t WHERE t.BranchCode = :BranchCode")
    List<SysBranchImpl> findBranchByCode(@Param("BranchCode") String BranchCode);


}
