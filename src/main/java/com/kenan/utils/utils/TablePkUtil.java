package com.kenan.utils.utils;

import java.util.UUID;

/**
 * 表主键创建工具
 *
 */
public class TablePkUtil {
    /**
     * 获取主键ID串
     * 格式：标识+yyMMddHHmmss+6位随机数
     *
     * @param pkId
     * @return
     */
    public static String getPrimaryKey(String pkId) {
        //序列拼接
        StringBuffer buffer = new StringBuffer();
        //1.拼接表标识
        buffer.append(pkId);
        //2.拼接时间(yyMMddHHmmss 15位)
        buffer.append(DateUtil.getNowTime(DateUtil.DATEFORMAT3));
        //3.6位随机数
        buffer.append(StringUtils.getRandom(6));
        return buffer.toString();
    }

    /**
     * 生成UUID
     * @return uuid
     */
    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}