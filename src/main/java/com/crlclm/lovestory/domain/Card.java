package com.crlclm.lovestory.domain;

import java.util.Date;

public class Card {
    private Integer id;

    private String name;

    private String detail;

    private String imgUrl;

    private Date createTime;

    private Date updateTime;

    private Byte state;

    public Card(Integer id, String name, String detail, String imgUrl, Date createTime, Date updateTime, Byte state) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.state = state;
    }

    public Card() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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