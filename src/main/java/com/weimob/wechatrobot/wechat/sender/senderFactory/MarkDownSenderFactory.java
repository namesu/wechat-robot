package com.weimob.wechatrobot.wechat.sender.senderFactory;

import com.weimob.wechatrobot.wechat.receive.AbstractReceive;
import com.weimob.wechatrobot.wechat.receive.ReceiveText;
import com.weimob.wechatrobot.wechat.sender.SenderFactory;
import com.weimob.wechatrobot.wechat.sender.msg.MarkDownMsg;
import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 发送markdown数据的业务逻辑
 */
@Slf4j
@Component
public class MarkDownSenderFactory extends SenderFactory {

    @Override
    protected MsgHeader buildSendContent(AbstractReceive receiveBody) {
        MarkDownMsg markDownMsg = new MarkDownMsg();
        ReceiveText receiveText = (ReceiveText)receiveBody;
        String content = receiveText.getContent();
        markDownMsg.setMarkdown(new MarkDownMsg.TextContent(content));
        return markDownMsg;
    }
}
