package io.github.bootystar.wechat;

import lombok.AllArgsConstructor;

import java.util.*;

/**
 * 微信模板枚举
 *
 * @Author booty
 * @Date 2023/6/2 9:22
 */
@AllArgsConstructor
public enum WechatTemplateEnum {
    FLOW_APPROVAL(
            "wVIMukiDMjQg8O4acrFwsfDKbi0MHBXgyzpZ7kOOHyw"
            , "流程审批提醒"
            , Arrays.asList("流程编号","流程名称","发起人","发起时间")
            , null
    ),

    FILE(
            "b0rNjSutM43kM7zCIgcIUE9feOAOCkwAcN__wfEKAYA"
            , "文件提醒查看通知"
            , Arrays.asList("文件名称","提醒人员","提醒时间")
            , null
    ),

    ORDER_SUCCESS(
            "ZeuebVzQNLjxv6eXalqPD1Tu8ISnR4Vo96jmkSg-8f0"
            , "预约成功提醒"
            , Arrays.asList("业务标题","业务内容","订单号","预约时间","预约受理点","提示标题","备注")
            , Arrays.asList("businessType","business","order","time","address","first","remark")
    ),
    ;


    public final String templateId;
    public final String title;
    public final List<String> keywords;
    public final List<String> converters;


    public Map<String,Object> getBodyDataMap(List<String> values){
        Map<String,Object> map =new LinkedHashMap<>();
        if (values==null){
            values=new ArrayList<>();
        }
        if (converters ==null){
            String key="keyword";
            for (int i = 0; i < keywords.size()+1; i++) {
                HashMap<Object, Object> valueMap = new HashMap<>();
                valueMap.put("value",i<values.size()?values.get(i):"");
                map.put(key+(i+1),valueMap);
            }
            return map;
        }
        for (int i = 0; i < converters.size(); i++) {
            HashMap<Object, Object> valueMap = new HashMap<>();
            valueMap.put("value",i<values.size()?values.get(i):"");
            map.put(converters.get(i),valueMap);
            map.put(converters.get(i),valueMap);
        }
        return map;
    }

    public static WechatTemplateEnum fromOrdinal(Integer ordinal){
        if (ordinal == null) return null;
        for (WechatTemplateEnum value : WechatTemplateEnum.values()) {
           if (Objects.equals(ordinal,value.ordinal())) return value;
        }
        return null;
    }



    public Map<?,?> getSendBody4Url(String openId, String url, List<String> keywords){
        Map<String, Object> sendBody = new HashMap<>();
        sendBody.put("touser", openId);
        sendBody.put("url", url);
        sendBody.put("data", getBodyDataMap(keywords));
        sendBody.put("template_id", templateId);
        return sendBody;
    }

//    public Map<?,?> getSendBody4miniProgram(String openId, String path, List<String> keywords){
//        Map<String, Object> sendBody = new HashMap<>();
//        sendBody.put("touser", openId);
//        HashMap<String, String> miniprogram = new HashMap<>();
//        miniprogram.put("appid", "wxd936dbee4e56c21c");
//        miniprogram.put("pagepath", "/pages/index");
//        sendBody.put("miniprogram", miniprogram);
//        if (path!=null && !path.equals("")) miniprogram.put("pagepath",path);
//        sendBody.put("data", getBodyDataMap(keywords));
//        sendBody.put("template_id", templateId);
//        return sendBody;
//    }

    public Map<?,?> getSendBodyBase(String openId, List<String> keywords){
        Map<String, Object> sendBody = new HashMap<>();
        sendBody.put("touser", openId);
        sendBody.put("data", getBodyDataMap(keywords));
        sendBody.put("template_id", templateId);
        return sendBody;
    }







}
