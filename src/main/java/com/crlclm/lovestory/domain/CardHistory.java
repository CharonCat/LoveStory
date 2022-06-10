package com.crlclm.lovestory.domain;

import java.util.Date;

public class CardHistory {
    private Integer id;

    private Integer cardId;

    private Date createTime;

    public CardHistory(Integer id, Integer cardId, Date createTime) {
        this.id = id;
        this.cardId = cardId;
        this.createTime = createTime;
    }

    public CardHistory() {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}