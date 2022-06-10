package com.crlclm.lovestory.domain;

import java.util.Date;

public class SpecialCalendar {
    private Integer id;

    private String name;

    private String detail;

    private Date date;

    private Date createTime;

    private Date updateTime;

    private Byte state;

    public SpecialCalendar(Integer id, String name, String detail, Date date, Date createTime, Date updateTime, Byte state) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.date = date;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.state = state;
    }

    public SpecialCalendar() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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