package com.weimob.wechatrobot.wechat.sender.senderFactory;

import com.weimob.wechatrobot.wechat.sender.SenderFactory;
import com.weimob.wechatrobot.wechat.util.WeChatUtils;
import com.weimob.wechatrobot.wechat.receive.AbstractReceive;
import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import com.weimob.wechatrobot.wechat.sender.msg.MsgTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ImageSenderFactory extends SenderFactory {

    @Override
    protected MsgHeader buildSendContent(AbstractReceive receiveBody) {
        return WeChatUtils.DEFAULT_MESSAGE(MsgTypeEnum.IMAGE);
    }
}
