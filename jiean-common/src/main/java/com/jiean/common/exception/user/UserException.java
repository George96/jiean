package com.jiean.common.exception.user;

import com.jiean.common.exception.BaseException;

/**
 * 用户信息异常类
 *
 * @author george
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
