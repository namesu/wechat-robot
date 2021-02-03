package com.weimob.wechatrobot.wechat.sender;

import com.weimob.wechatrobot.wechat.receive.AbstractReceive;

public interface SenderService {
    void send(Class<? extends SenderFactory> senderFactory, AbstractReceive abstractReceive);
}
