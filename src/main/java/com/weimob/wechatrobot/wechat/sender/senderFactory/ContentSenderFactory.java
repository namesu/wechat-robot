package com.weimob.wechatrobot.wechat.sender.senderFactory;

import com.weimob.wechatrobot.wechat.receive.AbstractReceive;
import com.weimob.wechatrobot.wechat.receive.ReceiveText;
import com.weimob.wechatrobot.wechat.sender.SenderFactory;
import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import com.weimob.wechatrobot.wechat.sender.msg.TextContentMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 发送文本数据的业务逻辑
 */

@Slf4j
@Component
public class ContentSenderFactory extends SenderFactory {

    @Override
    protected MsgHeader buildSendContent(AbstractReceive receiveBody) {
        TextContentMsg textContentMsg = new TextContentMsg();
        ReceiveText receiveText = (ReceiveText)receiveBody;
        String content = receiveText.getContent();
        textContentMsg.setText(new TextContentMsg.TextContent(content));
        return textContentMsg;
    }
}
