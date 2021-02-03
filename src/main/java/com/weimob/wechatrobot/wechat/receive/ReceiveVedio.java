package com.weimob.wechatrobot.wechat.receive;

import com.weimob.wechatrobot.wechat.sender.SenderFactory;
import com.weimob.wechatrobot.wechat.sender.senderFactory.VedioSenderFactory;
import lombok.Data;

/**
 * 视频消息
 */
@Data
public class ReceiveVedio extends AbstractReceive{
    /**
     * 语音媒体文件id，可以调用获取媒体文件接口拉取数据，仅三天内有效
     */
    private String MediaId;
    /**
     * 视频消息缩略图的媒体id，可以调用获取媒体文件接口拉取数据，仅三天内有效
     */
    private String ThumbMediaId;

    @Override
    public Class<? extends SenderFactory> getSendFactory() {
        return VedioSenderFactory.class;
    }
}
