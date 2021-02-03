package com.weimob.wechatrobot.wechat.sender;

import com.weimob.wechatrobot.wechat.util.HttpUtils;
import com.weimob.wechatrobot.wechat.util.JsonUtils;
import com.weimob.wechatrobot.wechat.util.WeChatUtils;
import com.weimob.wechatrobot.wechat.receive.AbstractReceive;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SenderFactory {

    /**
     * 填充共有数据
     * @param receiveBody 接受到的数据
     * @param msgHeader 发送消息体
     */
    void fillOptions(AbstractReceive receiveBody, MsgHeader msgHeader){
//        msgHeader.setMsgtype(receiveBody.getMsgType());
        msgHeader.setAgentid(receiveBody.getAgentID());
        msgHeader.setTouser(receiveBody.getFromUserName());
    }
    /**
     * 构建发送消息体,业务逻辑的具体实现
     * @param receiveBody 接受消息体
     * @return 发送数据的消息体
     */
     protected abstract MsgHeader buildSendContent(AbstractReceive receiveBody);

    /**
     * 发送数据的业务逻辑
     * @param receive 接受到消息体
     */
     public void send(AbstractReceive receive){
         MsgHeader msgHeader = buildSendContent(receive);
         fillOptions(receive,msgHeader);
         String toUser = msgHeader.getTouser();
         HttpUtils.post(String.format(WeChatUtils.URL_SEND_DATA, WeChatUtils.getToken(toUser)),JsonUtils.toJson(msgHeader));
     }
}
