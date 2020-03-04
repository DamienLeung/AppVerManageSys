package com.dfbz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "app_version")
public class AppVersion {

    @Id
    private Long id;

    private Integer platform;

    @Column(name = "version_no")
    private String versionNo;

    @Column(name = "force_update")
    private Integer forceUpdate;

    @Column(name = "down_path")
    private String downUrl;

    private Float size;

    @Column(name = "app_explain")
    private String verDesc;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Integer getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Integer forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public String getVerDesc() {
        return verDesc;
    }

    public void setVerDesc(String verDesc) {
        this.verDesc = verDesc;
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

    @Override
    public String toString() {
        return "AppVersion{" +
                "id=" + id +
                ", platform=" + platform +
                ", versionNo='" + versionNo + '\'' +
                ", forceUpdate=" + forceUpdate +
                ", downUrl='" + downUrl + '\'' +
                ", size=" + size +
                ", verDesc='" + verDesc + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", delFlag=" + delFlag +
                ", publisher='" + publisher + '\'' +
                '}';
    }

}
