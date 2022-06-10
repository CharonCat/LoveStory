package com.crlclm.lovestory.enums;

/**
 * ResultCodeEnum
 *
 * @author CharonCat
 * @date 2022/6/9
 */
public enum ResultCodeEnum {
    /** 成功 */
    SUCCESS("200", "成功"),

    /** 操做失败 */
    ERROR("500", "操做失败");

    ResultCodeEnum(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private final String val;
    private final String msg;
}