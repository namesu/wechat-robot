package com.weimob.wechatrobot.wechat.sender.msg;

import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 发送markdown格式消息格式,目前仅支持markdown语法的子集
 *   微工作台（原企业号）不支持展示markdown消息
 */
@Data @EqualsAndHashCode(callSuper = true)
public class MarkDownMsg extends MsgHeader {
    public MarkDownMsg() {
        super(MsgTypeEnum.MARK_DOWN.getName());
    }

    /**
     * markdown 格式
     */
    private TextContent markdown;

    @Data @AllArgsConstructor
    @NoArgsConstructor
    public static class TextContent{
        private String content;
    }
}
