package com.weimob.wechatrobot.wechat.sender.msg;

import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 发送任务卡片格式消息格式
 */
@Data @EqualsAndHashCode(callSuper = true)
public class TaskCardMsg2 extends MsgHeader {
    public TaskCardMsg2() {
        super(MsgTypeEnum.TASK_CARD.getName());
    }

    /**
     * w 格式
     */
    private TaskCardContent taskcard;

    @Data
    public static class TaskCardContent {
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
         * 任务id，同一个应用发送的任务卡片消息的任务id不能重复，只能由数字、字母和“_-@”组成，最长支持128字节
         */
        private String task_id;
        /**
         * 按钮列表，按钮个数为1~2个。
         */
        private List<ButtonContent> btn;

    }
    @Data
    public static class ButtonContent{
        /**
         * 按钮key值，用户点击后，会产生任务卡片回调事件，回调事件会带上该key值，只能由数字、字母和“_-@”组成，最长支持128字节
         */
        private String key;
        /**
         * 按钮名称
         */
        private String value;
        /**
         * 点击按钮后显示的名称，默认为“已处理”
         */
        private String replace_name;
        /**
         * 按钮字体颜色，可选“red”或者“blue”,默认为“blue”
         */
        private String color;
        /**
         * 按钮字体是否加粗，默认false
         */
        private String is_bold;
    }
}
