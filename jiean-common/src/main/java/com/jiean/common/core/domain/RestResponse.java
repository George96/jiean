package com.jiean.common.core.domain;

import java.util.HashMap;

import com.jiean.common.constant.HttpStatus;
import com.jiean.common.utils.StringUtils;



/**
 *
 * 操作消息提醒
 *
 * @author george
 */
public class RestResponse extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 RestResponse 对象，使其表示一个空消息。
     */
    public RestResponse() {
    }

    /**
     * 初始化一个新创建的 RestResponse 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public RestResponse(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 RestResponse 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public RestResponse(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static RestResponse success() {
        return RestResponse.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static RestResponse success(Object data) {
        return RestResponse.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static RestResponse success(String msg) {
        return RestResponse.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static RestResponse success(String msg, Object data) {
        return new RestResponse(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static RestResponse error() {
        return RestResponse.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static RestResponse error(String msg) {
        return RestResponse.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static RestResponse error(String msg, Object data) {
        return new RestResponse(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static RestResponse error(int code, String msg) {
        return new RestResponse(code, msg, null);
    }
}
