package com.weimob.wechatrobot.wechat.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.weimob.wechatrobot.wechat.receive.AbstractReceive;
import com.weimob.wechatrobot.wechat.receive.ReceiveText;
import lombok.extern.slf4j.Slf4j;

import java.io.StringWriter;
import java.util.Map;

/**
 * 用jackson序列化与反序列化
 */
@Slf4j
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static XmlMapper xmlMapper = new XmlMapper();

    static {
        /**
         * 忽略json字段大小写
         */
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
        /**
         * 忽略json未知字段
         */
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    /** 根据xml字符串获取msgtype以及转为目标类型
     * @param xml 接受到xml字符串
     * @return 接受数据的类型
     */
    public static AbstractReceive getMsgTypeClass(String xml){
        try{
            log.info("");
            log.info("xml: {}",xml);
            final String jsonStr = xml2json(xml);
            final JsonNode jsonNode = objectMapper.readTree(jsonStr);
            final String msgType = jsonNode.get("MsgType").asText();
            log.info("msgtype: {},jsonStr: {}",msgType,jsonStr);
            return toObj(jsonStr,WeChatUtils.RECEIVE_MAP.getOrDefault(msgType, ReceiveText.class));
        }catch (Exception e){
            log.error("getMsgTypeClass occur exception: ",e);
        }
        return null;
    }

    /**
     * 将对象转为json字符串
     * @param obj 对象
     * @return 字符串
     */
    public static String toJson(Object obj){
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("object to json occur exception: ",e);
        }
        return null;
    }

    /**
     *  将json字符串转为目标类型
     * @param jsonStr json字符串
     * @param clz 目标类型
     * @param <T> 泛型
     * @return 目标类型
     */
    public static <T> T toObj(String jsonStr,Class<T> clz){
        try {
            return objectMapper.readValue(jsonStr,clz);
        } catch (JsonProcessingException e) {
            log.error("json to object occur exception: ",e);
        }
        return null;
    }

    public static <T> T map2pojo(Map map,Class<T> clz){
        return objectMapper.convertValue(map,clz);
    }

    public static String json2xml(String jsonStr){
        JsonNode root = null;
        try {
            objectMapper.readTree(jsonStr);
            return xmlMapper.writeValueAsString(root);
        } catch (JsonProcessingException e) {
            log.error("json to xml occur exception: ",e);
        }
        return null;
    }

    /**
     * 将xml字符串转为json
     * @param xml xml字符串
     * @return json字符串
     */
    public static String xml2json(String xml){
        try{
            StringWriter w = new StringWriter();
            JsonParser jp = xmlMapper.getFactory().createParser(xml);
            JsonGenerator jg = objectMapper.getFactory().createGenerator(w);
            while (jp.nextToken() != null){
                jg.copyCurrentEvent(jp);
            }
            jp.close();
            jg.close();
            return w.toString();
        }catch (Exception e){
            log.error("xml to json occur exception: ",e);
        }
        return null;
    }
}
