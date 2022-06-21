package com.crlclm.lovestory.enums;

/**
 * RandomCodeUsageEnum
 *
 * @author CharonCat
 * @date 2022/6/21
 */
public enum RandomCodeUsageEnum {
    // MODIFY_PASSWORD: update user password
    // MODIFY_MAIL: update user mail address
    // SIGN_UP: sign up for account
    // LOG_IN: log in the account
    // BIND_MOBILE: bind mobile number with account
    MODIFY_PASSWORD("修改密码"), MODIFY_MAIL("修改邮箱"), SIGN_UP("注册账户"), LOG_IN("登录账户"), BIND_MOBILE("绑定手机");

    private final String name;
    private RandomCodeUsageEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
