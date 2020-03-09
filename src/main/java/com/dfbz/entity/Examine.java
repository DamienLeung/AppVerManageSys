package com.dfbz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "examine")
public class Examine {
    @Id
    private Long id;

    @Column(name = "examine_user_id")
    private Long examineUserId;

    private Integer score;

    @Column(name = "score_info")
    private String scoreInfo;

    private Integer type;

    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "del_flag")
    private String delFlag;

    @Column(name = "create_by")
    private String createBy;

    @Transient
    private String userName;

    @Transient
    private Integer officeId;

    @Transient
    private String officeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExamineUserId() {
        return examineUserId;
    }

    public void setExamineUserId(Long examineUserId) {
        this.examineUserId = examineUserId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getScoreInfo() {
        return scoreInfo;
    }

    public void setScoreInfo(String scoreInfo) {
        this.scoreInfo = scoreInfo == null ? null : scoreInfo.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    @Override
    public String toString() {
        return "Examine{" +
                "id=" + id +
                ", examineUserId=" + examineUserId +
                ", score=" + score +
                ", scoreInfo='" + scoreInfo + '\'' +
                ", type=" + type +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", delFlag='" + delFlag + '\'' +
                ", createBy='" + createBy + '\'' +
                ", userName='" + userName + '\'' +
                ", officeId=" + officeId +
                ", officeName='" + officeName + '\'' +
                '}';
    }
}
