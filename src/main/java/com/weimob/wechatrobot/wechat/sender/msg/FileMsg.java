package com.weimob.wechatrobot.wechat.sender.msg;

import com.weimob.wechatrobot.wechat.sender.MsgHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 发送文件格式消息格式
 */
@Data @EqualsAndHashCode(callSuper = true)
public class FileMsg extends MsgHeader {
    public FileMsg() {
        super(MsgTypeEnum.FILE.getName());
    }

    /**
     * 表示是否是保密消息，0表示可对外分享，1表示不能分享且内容显示水印，默认为0
     */
    private Integer safe = 0;
    /**
     * 文件内容
     */
    private FileContent file;

    @Data @AllArgsConstructor @NoArgsConstructor
    public static class FileContent{
        /**
         * 文件id，可以调用上传临时素材接口获取
         */
        private String media_id;
    }

}
