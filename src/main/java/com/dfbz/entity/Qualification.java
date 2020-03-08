package com.dfbz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "qualification")
public class Qualification {

    @Id
    private Long id;

    @Column(name = "upload_user_id")
    private Long uploadUserId;

    private Integer type;

    private String address;

    @Column(name = "`check`")
    private Integer check;

    private String description;

    @Column(name = "check_user_id")
    private Long checkUserId;

    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy:MM:dd HH:mm:ss")
    private Date createDate;

    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy:MM:dd HH:mm:ss")
    private Date updateDate;

    @Column(name = "del_flag")
    private String delFlag;

    @Column(name = "create_by")
    private String publisher;

    @Transient
    private String uploadUserName;

    @Transient
    private String checkUserName;

    @Transient
    private Integer officeId;

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUploadUserId() {
        return uploadUserId;
    }

    public void setUploadUserId(Long uploadUserId) {
        this.uploadUserId = uploadUserId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Long checkUserId) {
        this.checkUserId = checkUserId;
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
        this.delFlag = delFlag;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getUploadUserName() {
        return uploadUserName;
    }

    public void setUploadUserName(String uploadUserName) {
        this.uploadUserName = uploadUserName;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "id=" + id +
                ", uploadUserId=" + uploadUserId +
                ", type=" + type +
                ", address='" + address + '\'' +
                ", check=" + check +
                ", description='" + description + '\'' +
                ", checkUserId=" + checkUserId +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", delFlag='" + delFlag + '\'' +
                ", publisher='" + publisher + '\'' +
                ", uploadUserName='" + uploadUserName + '\'' +
                ", checkUserName='" + checkUserName + '\'' +
                ", officeId=" + officeId +
                '}';
    }
}
