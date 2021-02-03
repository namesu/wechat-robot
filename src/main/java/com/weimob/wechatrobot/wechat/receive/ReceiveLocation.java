package com.weimob.wechatrobot.wechat.receive;

import com.weimob.wechatrobot.wechat.sender.senderFactory.LocationSenderFactory;
import com.weimob.wechatrobot.wechat.sender.SenderFactory;
import lombok.Data;

/**
 * 位置消息
 */
@Data
public class ReceiveLocation extends AbstractReceive{
    /**
     * 地理位置纬度
     */
    private String Location_X;
    /**
     * 地理位置经度
     */
    private String Location_Y;

    /**
     * 地图缩放大小
     */
    private Integer Scale;
    /**
     * 地理位置信息
     */
    private  String Label;
    /**
     * app类型，在企业微信固定返回wxwork，在微信不返回该字段
     */
    private String AppType;

    @Override
    public Class<? extends SenderFactory> getSendFactory() {
        return LocationSenderFactory.class;
    }
}
