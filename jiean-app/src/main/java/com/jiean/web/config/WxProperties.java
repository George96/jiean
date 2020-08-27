package com.jiean.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author : george
 * @version V1.0
 * @title : jiean
 * @package : com.jiean.web.config
 * @date : 2020年08月25日 17:33
 */
@Configuration
@ConfigurationProperties(prefix = "wx.mini")
public class WxProperties {

    private String appId;

    private String appSecret;

    private String mchId;

    private String mchSecret;

    private String notifyUrl;

    private String keyPath;

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getMchSecret() {
        return mchSecret;
    }

    public void setMchSecret(String mchSecret) {
        this.mchSecret = mchSecret;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }
}
