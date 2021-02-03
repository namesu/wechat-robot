package com.weimob.wechatrobot.wechat.sender.msg;

import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * mpnews类型的图文消息，跟普通的图文消息一致，唯一的差异是图文内容存储在企业微信。
 * 多次发送mpnews，会被认为是不同的图文，阅读、点赞的统计会被分开计算。
 */
@Data @EqualsAndHashCode(callSuper = true)
public class MPNewsMsg extends MsgHeader {
    public MPNewsMsg() {
        super(MsgTypeEnum.NEWS.getName());
    }

    /**
     * 表示是否是保密消息，0表示可对外分享，1表示不能分享且内容显示水印，2表示仅限在企业内分享，默认为0；
     * 注意仅mpnews类型的消息支持safe值为2，其他消息类型不支持
     */
    private Integer safe = 0;
    /**
     * 图文内容
     */
    private List<MPNewsContent> articles;

    @Data @AllArgsConstructor @NoArgsConstructor
    public static class MPNewsContent{
        /**
         * 标题，不超过128个字节，超过会自动截断（支持id转译）
         */
        private String title;
        /**
         * 图文消息缩略图的media_id, 可以通过素材管理接口获得。此处thumb_media_id即上传接口返回的media_id
         */
        private String thumb_media_id;
        /**
         * 图文消息的作者，不超过64个字节
         */
        private String author;
        /**
         * 图文消息点击“阅读原文”之后的页面链接
         */
        private String content_source_url;
        /**
         * 图文消息的内容，支持html标签，不超过666 K个字节（支持id转译）
         */
        private String content;
        /**
         * 图文消息的描述，不超过512个字节，超过会自动截断（支持id转译）
         */
        private String digest;

    }

}
