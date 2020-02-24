package com.kenan.utils.utils;


import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  数字格式化
 * Created by maxb on 2019/4/26.
 */
public class NumFormatUtils {

    /**
     * 保留两位小数
     * @param param
     * @return
     */
    public static String  saveToPoint(String param){
         if(StringUtils.isEmpty(param)){
             return "0.00";

         }
        return new BigDecimal(param).setScale(2, BigDecimal.ROUND_FLOOR).toString();
    }


    /**
     * 保留两位小数
     * @param param
     * @return
     */
    public static String  saveToPoint(BigDecimal param){
        if(param == null){
            return "0";

        }
        return param.setScale(2, BigDecimal.ROUND_FLOOR).toString();
    }
    /**
     * 保留两位小数
     * @param param
     * @return
     */
    public static String  bigToStr(BigDecimal param){
        if(param == null){
            return "0";

        }
        return param.toString();
    }

    public static BigDecimal  strToBig(String param){
        if(StringUtils.isEmpty(param)){
            return new BigDecimal("0");

        }
        return new BigDecimal(param);
    }

    public static Boolean  isNumber(String param){
        if(StringUtils.isEmpty(param)){return false;}
        Pattern pattern = null;
        if(param.indexOf(".")<0){
            pattern = Pattern.compile("[-]?[0-9]+");
        }else{
            pattern = Pattern.compile("[-]?[0-9]+[.][0-9]+");
        }
        Matcher isNum = pattern.matcher(param);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
