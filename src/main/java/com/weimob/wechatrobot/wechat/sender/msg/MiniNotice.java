package com.weimob.wechatrobot.wechat.sender.msg;

import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 小程序类型的消息
 */
@Data @EqualsAndHashCode(callSuper = true)
public class MiniNotice extends MsgHeader {
    public MiniNotice(){
        super(MsgTypeEnum.MINI_NOTICE.getName());
    }

    /**
     * 小程序消息格式
     */
    private MiniprogramNotice miniprogram_notice;

    @Data
    public static class MiniprogramNotice{
        /**
         * 小程序appid，必须是与当前小程序应用关联的小程序
         */
        private String appid;
        /**
         * 点击消息卡片后的小程序页面，仅限本小程序内的页面。该字段不填则消息点击后不跳转。
         */
        private String page;
        /**
         * 消息标题，长度限制4-12个汉字（支持id转译）
         */
        private String title;
        /**
         * 消息描述，长度限制4-12个汉字（支持id转译）
         */
        private String description;
        /**
         * 是否放大第一个content_item
         */
        private String emphasis_first_item;
        /**
         * 消息内容键值对，最多允许10个item
         */
        private List<ContentItem> content_item;
    }
    @Data @AllArgsConstructor @NoArgsConstructor
    public static class ContentItem{
        /**
         * 长度10个汉字以内
         */
        private String key;
        /**
         * 长度30个汉字以内（支持id转译）
         */
        private String value;
    }
}
