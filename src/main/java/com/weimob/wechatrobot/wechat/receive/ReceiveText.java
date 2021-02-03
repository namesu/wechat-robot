package com.weimob.wechatrobot.wechat.receive;

import com.weimob.wechatrobot.wechat.sender.senderFactory.ContentSenderFactory;
import com.weimob.wechatrobot.wechat.sender.SenderFactory;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 文本类型的返回消息类型
 */
@Setter @Getter
@EqualsAndHashCode(callSuper = true)
public class ReceiveText extends AbstractReceive{
    /**
     * 文本消息内容
     */
    private String Content;

    @Override
    public Class<? extends SenderFactory> getSendFactory() {
        return ContentSenderFactory.class;
    }

    @Override
    public String toString() {
        return "ReceiveText{" +
                "Content='" + Content + '\'' + super.toString() +
                "} ";
    }
}
