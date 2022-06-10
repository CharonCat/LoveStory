package com.crlclm.lovestory.domain;

import java.util.Date;

public class CardList {
    private Integer id;

    private Integer cardId;

    private Integer ownerId;

    private Integer num;

    private String detail;

    private Date createTime;

    private Date updateTime;

    public CardList(Integer id, Integer cardId, Integer ownerId, Integer num, String detail, Date createTime, Date updateTime) {
        this.id = id;
        this.cardId = cardId;
        this.ownerId = ownerId;
        this.num = num;
        this.detail = detail;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CardList() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
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
}