package com.weimob.wechatrobot.wechat.sender.msg;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MsgTypeEnum {
    TEXT("text","文本消息"),
    IMAGE("image","图片消息"),
    VOICE("voice","语音消息"),
    VIDEO("video","视频消息"),
    FILE("file","文件类型消息"),
    TEXT_CARD("textcard","文本卡片类型消息"),
    TEXT_PIC("pic","图文消息"),
    NEWS("news","图文消息"),
    MP_NEWS("mpnews","图文消息"),
    LOCATION("location","位置消息"),
    LINK("link","链接消息"),
    MARK_DOWN("markdown","markdown类型消息"),
    MINI_NOTICE("miniprogram_notice","小程序类型消息"),
    TASK_CARD("textcard","任务卡片类型消息");
    private String name;
    private String desc;
}
