package com.weimob.wechatrobot.wechat.receive;

import com.weimob.wechatrobot.wechat.sender.senderFactory.LinkSenderFactory;
import com.weimob.wechatrobot.wechat.sender.SenderFactory;
import lombok.Data;

/**
 * 链接消息
 */
@Data
public class ReceiveLink extends AbstractReceive{
    /**
     * 标题
     */
    private String Title;
    /**
     * 描述
     */
    private String Description;

    /**
     * 链接跳转的url
     */
    private String Url;
    /**
     * 封面缩略图的url
     */
    private String PicUrl;

    @Override
    public Class<? extends SenderFactory> getSendFactory() {
        return LinkSenderFactory.class;
    }
}
