package com.weimob.wechatrobot.wechat.sender.msg;

import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 发送视频格式消息格式
 */
@Data @EqualsAndHashCode(callSuper = true)
public class VideoMsg extends MsgHeader {
    public VideoMsg() {
        super(MsgTypeEnum.VIDEO.getName());
    }

    /**
     * 视频内容
     */
    private VideoContent video;

    /**
     * 表示是否是保密消息，0表示可对外分享，1表示不能分享且内容显示水印，默认为0
     */
    private Integer safe = 0;

    @Data @AllArgsConstructor @NoArgsConstructor
    public static class VideoContent{
        /**
         * 视频媒体文件id，可以调用上传临时素材接口获取
         */
        private String media_id;
        /**
         * 视频消息的标题，不超过128个字节，超过会自动截断
         */
        private String title;
        /**
         * 视频消息的描述，不超过512个字节，超过会自动截断
         */
        private String description;
    }

}
