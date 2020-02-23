package com.kenan.utils.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  获取Url中的一级  二级域名
 * Created by maxb on 2020/2/21.
 */
public class TopDomainUtil {

    private static  Pattern pattern;


    // 定义正则表达式，域名的根需要自定义，这里不全
    private static final String RE_ROOT = "[\\w-]+\\.(com.cn|net.cn|gov.cn|org\\.nz|org.cn|com|net|org|gov|cc|biz|info|cn|co)\\b()*";

    // 二级域名提取
    private static final String RE_SECON = "(\\w*\\.?){2}\\.(com.cn|net.cn|gov.cn|org\\.nz|org.cn|com|net|org|gov|cc|biz|info|cn|co)$";

    // 三级域名提取
    private static final String RE_THIRD = "(\\w*\\.?){3}\\.(com.cn|net.cn|gov.cn|org\\.nz|org.cn|com|net|org|gov|cc|biz|info|cn|co)$";


    public static String getTopDomain(String url,String rule) {
        String result = url;
        try {
            Matcher matcher = Pattern.compile(rule , Pattern.CASE_INSENSITIVE).matcher(url);
            matcher.find();
            result = matcher.group();
        } catch (Exception e) {
            System.out.println("[getTopDomain ERROR]====>");
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        // 示例
        String url = "https://mmanage-dev.19ego.cn/index";
        System.out.println(url + " ==> " + TopDomainUtil.getTopDomain(url,TopDomainUtil.RE_ROOT));

    }
}
