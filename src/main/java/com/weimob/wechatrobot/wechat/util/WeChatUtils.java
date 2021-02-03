package com.weimob.wechatrobot.wechat.util;

import com.weimob.wechatrobot.wechat.aes.AesException;
import com.weimob.wechatrobot.wechat.aes.WXBizMsgCrypt;
import com.weimob.wechatrobot.wechat.receive.*;
import com.weimob.wechatrobot.wechat.sender.msg.MsgTypeEnum;
import com.weimob.wechatrobot.wechat.sender.msg.TextContentMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeChatUtils {
    private static WeChatProperties weChat;

    private static final String URL_GET_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s";
    public static final String URL_SEND_DATA = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s";
    private static final String ECHO_CONTENT = "暂时不支持该类型[%s]的回复!";
    /**
     * token cache: key: fromUserName value: token,2小时失效,不可更改
     */
    private static final long EXPIRE_TIME = 7200;
    /**
     * key: username, value: token
     */
    public static final Map<String,String> TOKENS = new HashMap<>();
    /**
     * key: username,value: expire time
     */
    private static final Map<String,Long> EXPIRE_TIME_VALUES = new HashMap<>();


    /**
     * 获取接受数据的类型集合
     */
    public static final Map<String, Class<? extends AbstractReceive>> RECEIVE_MAP = new HashMap<>();
    static {
        RECEIVE_MAP.put(MsgTypeEnum.TEXT.getName(), ReceiveText.class);
        RECEIVE_MAP.put(MsgTypeEnum.LINK.getName(), ReceiveLink.class);
        RECEIVE_MAP.put(MsgTypeEnum.LOCATION.getName(), ReceiveLocation.class);
        RECEIVE_MAP.put(MsgTypeEnum.IMAGE.getName(), ReceiveImage.class);
        RECEIVE_MAP.put(MsgTypeEnum.VIDEO.getName(), ReceiveVedio.class);
        RECEIVE_MAP.put(MsgTypeEnum.VOICE.getName(), ReceiveVoice.class);
    }

    /**
     *  默认文本类型占位符,以后根据不同业务需求进行扩展
     * @param msgTypeEnum 数据类型
     * @return 默认文本数据
     */
    public static TextContentMsg DEFAULT_MESSAGE(MsgTypeEnum msgTypeEnum){
        TextContentMsg textContentMsg = new TextContentMsg();
        textContentMsg.setMsgtype("text");
        textContentMsg.setText(new TextContentMsg.TextContent(String.format(ECHO_CONTENT, msgTypeEnum.getDesc())));
        return textContentMsg;
    }
    public static String getToken(String toUser){
//        String token = WeChatUtils.TOKENS.get(toUser);
//        if(!WeChatUtils.check(toUser)){
//            WeChatUtils.updateToken(toUser);
//            token = WeChatUtils.TOKENS.get(toUser);
//        }
        /**
         * 测试使用
         */
        String token = "xsj2h12OB_U57-oGLFcffu_6qLnabID97dq_ns_cgDJZVnd1497OLqKmG5k8GByCpcqpvC0q7-5K69PaTfHybRbmOmB3BbCSz7Jt3FHwVq49VWXmJyFSOOq2S4GkKCzs2ITLNQXhvvcppa9GuRbkudxz0kOMeoSvUXQoQQAe941ol0maIz-kccuHapcDXIjyJsONgcO48G_T8g_cO30d-Q";
        return token;
    }

    @Autowired
    public void init(WeChatProperties weChatProperties){
        WeChatUtils.weChat = weChatProperties;
    }
    public static WXBizMsgCrypt getClient(){
        WXBizMsgCrypt client = null;
        try {
            client = new WXBizMsgCrypt(weChat.getToken(), weChat.getAeskey(), weChat.getCorpid());
        } catch (AesException e) {
            e.printStackTrace();
        }
        return client;
    }

    /**
     * @param fromUserName 用户名称
     * @return token 是否过期,默认过期时间2小时(7200秒)
     */
    public static boolean check(String fromUserName){
        return EXPIRE_TIME_VALUES.get(fromUserName) != null && (System.currentTimeMillis() - EXPIRE_TIME_VALUES.get(fromUserName))/1000  < EXPIRE_TIME;
    }

    /**
     *  不能频繁调用gettoken接口，否则会受到频率拦截
     * @param fromUserName 用户名称
     */
    public static void updateToken(String fromUserName){
        String newToke = HttpUtils.get(String.format(URL_GET_TOKEN, weChat.getCorpid(),weChat.getCorpsecret()));
        TOKENS.put(fromUserName, newToke);
        EXPIRE_TIME_VALUES.put(fromUserName,System.currentTimeMillis());
    }
}
