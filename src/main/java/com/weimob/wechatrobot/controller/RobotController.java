package com.weimob.wechatrobot.controller;

import com.weimob.wechatrobot.wechat.util.JsonUtils;
import com.weimob.wechatrobot.wechat.util.WeChatUtils;
import com.weimob.wechatrobot.wechat.receive.AbstractReceive;
import com.weimob.wechatrobot.wechat.sender.SenderFactory;
import com.weimob.wechatrobot.wechat.sender.SenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/wechat/message")
public class RobotController {

    private final SenderService senderService;

    public RobotController(SenderService senderService) {
        this.senderService = senderService;
    }

    @GetMapping(produces = "text/plain;charset=utf-8")
    public void onMessage(@RequestParam("msg_signature") String msgSignature,
                            @RequestParam("timestamp") String timestamp,
                            @RequestParam("nonce") String nonce,
                            @RequestParam("echostr") String echoStr, HttpServletResponse response){
        String resEchoStr = "";
        try{
            resEchoStr = WeChatUtils.getClient().VerifyURL(msgSignature,timestamp,nonce,echoStr);
            response.setContentType("text/plain;charset=utf-8");
            response.getWriter().write(resEchoStr);
        }catch (Exception e){
            log.info("check callback url occur exception: ",e);
        }
    }

    @PostMapping
    public void onMessage(@RequestBody String xmlStr,
                          @RequestParam("msg_signature") String msgSignature,
                          @RequestParam("timestamp") String timestamp,
                          @RequestParam("nonce") String nonce){
        try{
            String xmlData = WeChatUtils.getClient().DecryptMsg(msgSignature,timestamp,nonce,xmlStr);
            final AbstractReceive receive = JsonUtils.getMsgTypeClass(xmlData);
            final Class<? extends SenderFactory> sendFactory = receive.getSendFactory();
            senderService.send(sendFactory,receive);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
