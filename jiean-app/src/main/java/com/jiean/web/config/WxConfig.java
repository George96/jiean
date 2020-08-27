package com.jiean.web.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.binarywang.wx.miniapp.config.WxMaConfig;

/**
 * @author : george
 * @version V1.0
 * @title : jiean
 * @package : com.jiean.web.config
 * @date : 2020年08月25日 17:36
 */
@Configuration
public class WxConfig {
    @Autowired
    private WxProperties wxProperties;

    @Bean
    public WxMaConfig wxMaConfig() {
        WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
        config.setAppid(wxProperties.getAppId());
        config.setSecret(wxProperties.getAppSecret());
        return config;
    }

    @Bean
    public WxMaService wxMaService(WxMaConfig maConfig) {
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(maConfig);
        return service;
    }

    @Bean
    public WxPayConfig wxPayConfig() {
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(wxProperties.getAppId());
        payConfig.setMchId(wxProperties.getMchId());
        payConfig.setMchKey(wxProperties.getMchSecret());
        payConfig.setNotifyUrl(wxProperties.getNotifyUrl());
        payConfig.setKeyPath(wxProperties.getKeyPath());
        payConfig.setTradeType("JSAPI");
        payConfig.setSignType("MD5");
        return payConfig;
    }

    @Bean
    public WxPayService wxPayService(WxPayConfig payConfig) {
        WxPayService wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(payConfig);
        return wxPayService;
    }
}
