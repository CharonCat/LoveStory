package com.crlclm.lovestory.domain;

import java.util.Date;

public class LoveNotes {
    private Integer id;

    private String detail;

    private String imgUrl;

    private Date createTime;

    private Date updateTime;

    private Byte state;

    public LoveNotes(Integer id, String detail, String imgUrl, Date createTime, Date updateTime, Byte state) {
        this.id = id;
        this.detail = detail;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.state = state;
    }

    public LoveNotes() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}