package com.weimob.wechatrobot.wechat.receive;

import com.weimob.wechatrobot.wechat.sender.SenderFactory;
import com.weimob.wechatrobot.wechat.sender.senderFactory.VoiceSenderFactory;
import lombok.Data;

/**
 * 语音消息
 */
@Data
public class ReceiveVoice extends AbstractReceive{
    /**
     * 语音媒体文件id，可以调用获取媒体文件接口拉取数据，仅三天内有效
     */
    private String MediaId;
    /**
     * 语音格式，如amr，speex等
     */
    private String Format;

    @Override
    public Class<? extends SenderFactory> getSendFactory() {
        return VoiceSenderFactory.class;
    }
}
