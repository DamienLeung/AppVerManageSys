package com.dfbz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Table(name = "work_order")
public class WorkOrder {
    @Id
    private Long id;

    private String code;

    @Column(name = "createUser_id")
    private Long createUserId;

    @Column(name = "transportUser_id")
    private Long transportUserId;

    @Column(name = "recipientUser_id")
    private Long recipientUserId;

    private Integer status;

    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    @Column(name = "del_flag")
    private String delFlag;

    @Column(name = "create_by")
    private String createBy;

    @Transient
    private String createUserName;

    @Transient
    private String createUserPhone;

    @Transient
    private String createUserOffice;

    @Transient
    private String transportUserName;

    @Transient
    private String transportUserPhone;

    @Transient
    private String transportUserOffice;

    @Transient
    private String recipientUserName;

    @Transient
    private String recipietUserPhone;

    @Transient
    private String recipientUserOffice;

    @Transient
    private List<WorkDetail> workDetails;

    @Transient
    private List<Transfer> transfers;

    public List<WorkDetail> getWorkDetails() {
        return workDetails;
    }

    public void setWorkDetails(List<WorkDetail> workDetails) {
        this.workDetails = workDetails;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateUserPhone() {
        return createUserPhone;
    }

    public void setCreateUserPhone(String createUserPhone) {
        this.createUserPhone = createUserPhone;
    }

    public String getCreateUserOffice() {
        return createUserOffice;
    }

    public void setCreateUserOffice(String createUserOffice) {
        this.createUserOffice = createUserOffice;
    }

    public String getTransportUserName() {
        return transportUserName;
    }

    public void setTransportUserName(String transportUserName) {
        this.transportUserName = transportUserName;
    }

    public String getTransportUserPhone() {
        return transportUserPhone;
    }

    public void setTransportUserPhone(String transportUserPhone) {
        this.transportUserPhone = transportUserPhone;
    }

    public String getTransportUserOffice() {
        return transportUserOffice;
    }

    public void setTransportUserOffice(String transportUserOffice) {
        this.transportUserOffice = transportUserOffice;
    }

    public String getRecipientUserName() {
        return recipientUserName;
    }

    public void setRecipientUserName(String recipientUserName) {
        this.recipientUserName = recipientUserName;
    }

    public String getRecipietUserPhone() {
        return recipietUserPhone;
    }

    public void setRecipietUserPhone(String recipietUserPhone) {
        this.recipietUserPhone = recipietUserPhone;
    }

    public String getRecipientUserOffice() {
        return recipientUserOffice;
    }

    public void setRecipientUserOffice(String recipientUserOffice) {
        this.recipientUserOffice = recipientUserOffice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getTransportUserId() {
        return transportUserId;
    }

    public void setTransportUserId(Long transportUserId) {
        this.transportUserId = transportUserId;
    }

    public Long getRecipientUserId() {
        return recipientUserId;
    }

    public void setRecipientUserId(Long recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    @Override
    public String toString() {
        return "WorkOrder{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", createUserId=" + createUserId +
                ", transportUserId=" + transportUserId +
                ", recipientUserId=" + recipientUserId +
                ", status=" + status +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", delFlag='" + delFlag + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", createUserPhone='" + createUserPhone + '\'' +
                ", createUserOffice='" + createUserOffice + '\'' +
                ", transportUserName='" + transportUserName + '\'' +
                ", transportUserPhone='" + transportUserPhone + '\'' +
                ", transportUserOffice='" + transportUserOffice + '\'' +
                ", recipientUserName='" + recipientUserName + '\'' +
                ", recipietUserPhone='" + recipietUserPhone + '\'' +
                ", recipientUserOffice='" + recipientUserOffice + '\'' +
                '}';
    }
}