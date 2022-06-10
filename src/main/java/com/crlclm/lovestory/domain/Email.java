package com.crlclm.lovestory.domain;

import java.util.Date;

public class Email {
    private Integer id;

    private String nickName;

    private String eMail;

    private String content;

    private Date createTime;

    private Date updateTime;

    private Date sendTime;

    private Byte state;

    public Email(Integer id, String nickName, String eMail, String content, Date createTime, Date updateTime, Date sendTime, Byte state) {
        this.id = id;
        this.nickName = nickName;
        this.eMail = eMail;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.sendTime = sendTime;
        this.state = state;
    }

    public Email() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}