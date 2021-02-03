package com.weimob.wechatrobot.wechat.sender.msg;

import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 发送文本消息格式
 */
@Data @EqualsAndHashCode(callSuper = true)
public class TextContentMsg extends MsgHeader {
    public TextContentMsg() {
        super(MsgTypeEnum.TEXT.getName());
    }
    /**
     * 表示是否是保密消息，0表示可对外分享，1表示不能分享且内容显示水印，默认为0
     */
    private Integer safe = 0;
    /**
     * 文本类容
     */
    private TextContent text;

    @Data @AllArgsConstructor @NoArgsConstructor
    public static class TextContent{
        private String content;
    }
}
