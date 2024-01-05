package io.github.bootystar.wechat;

import io.github.bootystar.wechat.core.exception.ResponseException;
import io.github.bootystar.wechat.officialAccount.OfficialAccountApi;
import io.github.bootystar.wechat.core.token.AccessToken;
import io.github.bootystar.wechat.officialAccount.module.menu.ResponseMenuQuery;
import io.github.bootystar.wechat.officialAccount.module.openApi.ResponseQueryQuota;
import io.github.bootystar.wechat.officialAccount.module.openApi.ResponseQueryRid;
import io.github.bootystar.wechat.officialAccount.module.web.UserAccessToken;
import io.github.bootystar.wechat.officialAccount.enums.CgiPathEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/**
 * 微信测试
 * @author booty
 * 
 */
public class WechatTest {

    @Test
    void test1(){
        OfficialAccountApi oa = new OfficialAccountApi("appId","appSecret");
        oa.setAccessTokenFactory(() -> {
            // 必要时自定义token获取方式
            AccessToken accessToken = new AccessToken();
            accessToken.setAccess_token("token");
            accessToken.setExpiresTime(LocalDateTime.now().plusSeconds(7200));
            return accessToken;
        });
        AccessToken accessToken = oa.getStableAccessToken();
        System.out.println(accessToken);

        ResponseMenuQuery responseMenuQuery = oa.queryMenu();
        System.out.println(responseMenuQuery);

        ResponseQueryRid rid = oa.queryRid("64856712-3b612cab-67a23e3a");
        System.out.println(rid);
        System.out.println(rid.getRequest());

//        QueryQuota queryQuota = oa.queryQuota("/cgi-bin/message/custom/send");
//        QueryQuota queryQuota = oa.queryQuota("/cgi-bin/clear_quota/v2 ");
        ResponseQueryQuota queryQuota = oa.queryQuota(CgiPathEnum.KF_ACCOUNT_UPDATE_HEAD_IMG);
        System.out.println(queryQuota);

        try {
            UserAccessToken wwawwanjkwndaknwjadwd = oa.createPersonalAccessToken("wwawwanjkwndaknwjadwd");
        }catch (ResponseException e){
            System.out.println(e.getResponseBase());
            System.out.println(e.getResponseBase().getErrcode());
            System.out.println(e.getResponseBase().getErrmsg());
        }


    }





}
