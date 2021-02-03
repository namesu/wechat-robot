package com.weimob.wechatrobot.wechat.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.wechat")
public class WeChatProperties {
    /**
     * 回调接口 token
     */
    private String token;
    /**
     * 企业id
     */
    private String corpid;
    /**
     * 回调接口,aeskey
     */
    private String aeskey;

    /**
     * 应用凭证
     */
    private String corpsecret;
}
