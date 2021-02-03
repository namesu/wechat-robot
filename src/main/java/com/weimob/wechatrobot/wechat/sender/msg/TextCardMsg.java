package com.weimob.wechatrobot.wechat.sender.msg;

import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 发送文本卡片格式消息格式
 */
@Data @EqualsAndHashCode(callSuper = true)
public class TextCardMsg extends MsgHeader {
    public TextCardMsg() {
        super(MsgTypeEnum.TEXT_CARD.getName());
    }

    /**
     * 文本卡片内容
     */
    private TextCardContent textcard;

    @Data @AllArgsConstructor @NoArgsConstructor
    public static class TextCardContent{
        /**
         * 标题，不超过128个字节，超过会自动截断（支持id转译）
         */
        private String title;
        /**
         * 描述，不超过512个字节，超过会自动截断（支持id转译）
         */
        private String description;
        /**
         * 点击后跳转的链接。 最长2048字节，请确保包含了协议头(http/https)
         */
        private String url;

        /**
         * 按钮文字。 默认为“详情”， 不超过4个文字，超过自动截断。
         */
        private String btntxt;

    }

}
