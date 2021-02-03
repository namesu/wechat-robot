package com.weimob.wechatrobot.wechat.sender.msg;

import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 图文消息
 */
@Data @EqualsAndHashCode(callSuper = true)
public class NewsMsg extends MsgHeader {
    public NewsMsg() {
        super(MsgTypeEnum.NEWS.getName());
    }

    /**
     * 图片内容
     */
    private List<NewsContent> articles;

    @Data @AllArgsConstructor @NoArgsConstructor
    public static class NewsContent{
        /**
         * 标题，不超过128个字节，超过会自动截断（支持id转译）
         */
        private String title;
        /**
         * 描述，不超过512个字节，超过会自动截断（支持id转译）
         */
        private String description;
        /**
         * 点击后跳转的链接。最长2048字节，请确保包含了协议头(http/https)
         */
        private String url;
        /**
         * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150。
         */
        private String picurl;

    }

}
