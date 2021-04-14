package com.greentrade.common.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity<Tid extends Object> implements BaseEntity<Tid> {

//    @org.springframework.data.annotation.Id
//    @javax.persistence.Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Tid id;

    @Column(name = "Remarks")
    private String Remarks;

    @Column(name = "CreatedUserId")
    private String CreatedUserId;

    @Column(name = "CreatedTime")
    private Date CreatedTime;

    @Column(name = "UpdatedUserId")
    private String UpdatedUserId;

    @Column(name = "UpdatedTime")
    private Date UpdatedTime;

//    @Override
//    public Tid getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(Tid id) {
//        this.id = id;
//    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getCreatedUserId() {
        return CreatedUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        CreatedUserId = createdUserId;
    }

    public Date getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(Date createdTime) {
        CreatedTime = createdTime;
    }

    public String getUpdatedUserId() {
        return UpdatedUserId;
    }

    public void setUpdatedUserId(String updatedUserId) {
        UpdatedUserId = updatedUserId;
    }

    public Date getUpdatedTime() {
        return UpdatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        UpdatedTime = updatedTime;
    }
}
