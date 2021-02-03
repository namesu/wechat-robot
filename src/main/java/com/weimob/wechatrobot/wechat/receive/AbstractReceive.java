package com.weimob.wechatrobot.wechat.receive;

import com.weimob.wechatrobot.wechat.sender.SenderFactory;
import lombok.Getter;
import lombok.Setter;

/**
 * 返回值消息体 共有部分,属性大写是因为对应微信返回值
 */
@Setter @Getter
public abstract class AbstractReceive {
    /**
     * 企业微信CorpID
     */
    private String ToUserName;
    /**
     * 成员UserID,一般都是用户名称
     */
    private String FromUserName ;
    /**
     * 消息创建时间（整型）
     */
    private Long CreateTime;
    /**
     * 消息类型
     */
    private String MsgType;
    /**
     * 消息id，64位整型
     */
    private Long MsgId;
    /**
     * 企业应用的id，整型。可在应用的设置页面查看
     */
    private Long AgentID;

    /**
     * 该类型的发送工厂,处理方式不是很理想,后期可能会优化
     * @return 工厂类型
     */
    public abstract Class<? extends SenderFactory> getSendFactory();

    @Override
    public String toString() {
        return "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", MsgId=" + MsgId +
                ", AgentID=" + AgentID +
                '}';
    }
}
