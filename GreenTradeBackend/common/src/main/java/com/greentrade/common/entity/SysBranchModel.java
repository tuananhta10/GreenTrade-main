package com.greentrade.common.entity;

import com.greentrade.common.base.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class SysBranchModel extends AbstractEntity<Long> {
    @org.springframework.data.annotation.Id
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BranchCode")
    private String BranchCode;

    @Column(name = "BranchName")
    private String BranchName;

    @Column(name = "BranchSName")
    private String BranchSName;
    @Column(name = "Address")
    private String Address;
    @Column(name = "TelNo")
    private String TelNo;
    @Column(name = "FaxNo")
    private String FaxNo;
    @Column(name = "Email")
    private String Email;

    @Column(name = "Type")
    private Integer Type;

    @Column(name = "Status")
    private Integer Status;

    public String getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(String branchCode) {
        BranchCode = branchCode;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getBranchSName() {
        return BranchSName;
    }

    public void setBranchSName(String branchSName) {
        BranchSName = branchSName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTelNo() {
        return TelNo;
    }

    public void setTelNo(String telNo) {
        TelNo = telNo;
    }

    public String getFaxNo() {
        return FaxNo;
    }

    public void setFaxNo(String faxNo) {
        FaxNo = faxNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }
}
