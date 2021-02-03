package com.weimob.wechatrobot.wechat.sender;

import com.weimob.wechatrobot.wechat.receive.AbstractReceive;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class DefaultSendService implements SenderService, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void send(Class<? extends SenderFactory> senderFactory, AbstractReceive abstractReceive) {
        applicationContext.getBean(senderFactory).send(abstractReceive);
    }
}
