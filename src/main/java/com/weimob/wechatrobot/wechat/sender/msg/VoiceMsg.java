package com.weimob.wechatrobot.wechat.sender.msg;

import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 发送语音消息格式
 */
@Data @EqualsAndHashCode(callSuper = true)
public class VoiceMsg extends MsgHeader {
    public VoiceMsg() {
        super(MsgTypeEnum.VOICE.getName());
    }

    /**
     * 语音内容
     */
    private VoiceContent voice;

    @Data @AllArgsConstructor @NoArgsConstructor
    public static class VoiceContent{
        /**
         * 语音文件id，可以调用上传临时素材接口获取
         */
        private String media_id;
    }

}
