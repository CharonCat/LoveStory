package com.crlclm.lovestory.domain;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String telephone;

    private String eMail;

    private Integer loverId;

    private Byte loveState;

    public User(Integer id, String name, String password, String telephone, String eMail, Integer loverId, Byte loveState) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.eMail = eMail;
        this.loverId = loverId;
        this.loveState = loveState;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public Integer getLoverId() {
        return loverId;
    }

    public void setLoverId(Integer loverId) {
        this.loverId = loverId;
    }

    public Byte getLoveState() {
        return loveState;
    }

    public void setLoveState(Byte loveState) {
        this.loveState = loveState;
    }
}