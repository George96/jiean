package com.jiean.common.enums.system;

/**
 * 用户状态
 *
 * @author george
 */
public enum UserStatus {
    OK("0", "正常"), DELETED("1", "删除"), DISABLE("2", "停用");

    private final String code;
    private final String info;

    UserStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
