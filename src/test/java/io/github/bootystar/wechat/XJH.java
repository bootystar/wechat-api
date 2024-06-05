package io.github.bootystar.wechat;

import com.alibaba.fastjson2.JSON;
import io.github.bootystar.wechat.core.ResponseBase;
import io.github.bootystar.wechat.officialAccount.OfficialAccountApi;
import io.github.bootystar.wechat.officialAccount.module.message.MessageApi;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Map;

public class XJH {



    @Test
    void xjh(){
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(1711950623L, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime);
        String appId = "wx5f0b4c9cbdf7a749";
        String appSecret = "ae55e8302da44678103b6e126ff3aecd";
        OfficialAccountApi api = new OfficialAccountApi(appId, appSecret);
//        ResponseBase responseBase = api.queryMenu();
/*
{"access_token":"79_t-ooPHTgGhjxlpOM_Xn581SdQP30RGHIGFqIiC55mtBldiw2mBOgmjjkzto-M1AHDFWsoKocCGaL4_iQnQHvJgjVVHXMMI_mWb3jwiFZnWgTY89KjpPAXNItUMkCBNgAEALKW","expires_in":7115}

 */

//        ResponseTemplateMessage allPrivateTemplate = MessageApi.getAllPrivateTemplate(api.getTokenValue());

        Map<?, ?> body = WechatTemplateEnum.ORDER_SUCCESS.getSendBody4Url(
                "o-v_0jnxukbuRRS-NtCtiGUVd_z8"
                , ""
                , Arrays.asList("业务标题","业务内容","订单号","预约时间","预约受理点","提示标题","备注")

        );
        String jsonString = JSON.toJSONString(body);
        System.out.println(jsonString);

        ResponseBase responseBase = MessageApi.sendMsgByMap(
                api.getAccessTokenValue(),
                body
        );

        System.out.println();
    }

}
