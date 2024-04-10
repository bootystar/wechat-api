package io.github.bootystar.wechat.miniProgram;


import io.github.bootystar.wechat.core.ApiBase;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 小程序api
 * @author booty
 * 
 */
public class MiniProgramApi extends ApiBase {


    public MiniProgramApi(String appId, String appSecret) {
        super(appId, appSecret);
    }


    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(1711072010L, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime);
    }


}
