package com.kenan.utils.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maxb on 2020/2/21.
 */
public class HttpReqUtils {

    /**
     * 获取url请求前缀
     * @explain http://localhost:8080/test
     * @param request request对象
     * @return
     */
    public static String getRequestPrefix (HttpServletRequest request) {
        // 网络协议
        String networkProtocol = request.getScheme();
        // 网络ip
        String ip = request.getServerName();
        // 端口号
        int port = request.getServerPort();
        // 项目发布名称
        String webApp = request.getContextPath();
        String urlPrefix = networkProtocol + "://" + ip + ":" + port + webApp;
        return urlPrefix;
    }
}
