package com.jiean.common.exception.file;

import com.jiean.common.exception.BaseException;
import com.jiean.common.exception.BaseException;

/**
 * 文件信息异常类
 *
 * @author george
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}
