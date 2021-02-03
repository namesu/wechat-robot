package com.weimob.wechatrobot.wechat.receive;

import com.weimob.wechatrobot.wechat.sender.senderFactory.ImageSenderFactory;
import com.weimob.wechatrobot.wechat.sender.SenderFactory;
import lombok.Data;

/**
 * 图片消息
 */
@Data
public class ReceiveImage extends AbstractReceive{
    /**
     * 图片链接
     */
    private String PicUrl;
    /**
     * 图片媒体文件id，可以调用获取媒体文件接口拉取，仅三天内有效
     */
    private String MediaId;

    @Override
    public Class<? extends SenderFactory> getSendFactory() {
        return ImageSenderFactory.class;
    }
}
