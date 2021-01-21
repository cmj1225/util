package com.teach.frame10.constants;


public class UrlConstant {
    private static final int INNER_NET=1,TEST_OUTER_NET=2,RELEASE_NET=3;
    private static int type = RELEASE_NET;
    public static String BASE_URL = "";
    static {
        if (type == RELEASE_NET){
            // TODO: 2021/1/21
            BASE_URL = "http://static.owspace.com/";
        } else if (type == TEST_OUTER_NET){
            BASE_URL = "";
        } else {
            BASE_URL = "";
        }
    }

    // TODO: 2021/1/21
    public static final String ZHULONG1="https://passport.zhulong.com/openapi/user/";
}
