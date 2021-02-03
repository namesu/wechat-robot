package com.weimob.wechatrobot.wechat.receive;

import lombok.Data;

/**
 * 获取token时的返回值类型
 */
@Data
public class ResultGetToken {
    /**
     * 返回状态码 0正常,1 异常
     */
    private Integer errcode;
    /**
     * 返回消息
     */
    private String errmsg;
    /**
     * token 数据
     */
    private String access_token;

    /**
     * 凭证的有效时间（秒）
     */
    private Integer expires_in;
}
