package com.kenan.utils.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * zdal分库分表工具类
 * 
 * @author renby
 * 
 */
public class ZdalRouteUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZdalRouteUtil.class);

    private ZdalRouteUtil() {
    }

    /**
     * 通过sid获取分库索引
     * 
     * @param sid 非number类型字符串
     * @return
     */
    public static long getDbIndexByAsc(Object sid, String dbCount) {
        if (dbCount == null || "".equals(dbCount)) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("getDbIndexByAsc param can't be illegal");
            }
            throw new IllegalArgumentException("method[getDbIndexByAsc] params[pk]=illegal!");
        }
        long index = getIndexByAsc(Long.parseLong(dbCount), sid);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("dbIndex={},dbCount={},getDbIndexByAsc.", index,
                dbCount);
        }
        return index;
    }

    /**
     * 通过sid获取分表索引
     * 
     * @param sid
     * @param tbCount
     * @return
     */
    public static long getTbIndexByAsc(Object sid, String tbCount) {
        if (tbCount == null || "".equals(tbCount)) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("getTbIndexByAsc param can't be illegal");
            }
            throw new IllegalArgumentException("method[getTbIndexByAsc] params[pk]=illegal!");
        }
        long index = getIndexByAsc(Long.parseLong(tbCount), sid);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("tbIndex={},tbCount={},getTbIndexByAsc.", index,
                tbCount);
        }
        return index;
    }

    /**
     * 通过主键获取分库索引
     * 新方法pk中的17~19位是dbIndex
     * @param pk
     * @return
     */
    public static long getDbIndexByAscPk(String pk) {
        if (pk == null || pk.length() < 19) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("getDbOrTbIndexByPk param can't be illegal");
            }
            throw new IllegalArgumentException("method[getDbIndexByAscPk] params[pk]=illegal!");
        }
        //规则版本 28位： 181221160723123 01 010009 23543
        long index = Long.parseLong(StringUtils.substring(pk, 17, 19));
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("index={},getDbIndexByAscPk.", new Object[] { index });
        }
        return index;
    }

    /**
     * 通过主键获取分表索引
     * 新方法pk中的19~23位是tbIndex
     * @param pk
     * @return
     */
    public static long getTbIndexByAscPk(String pk) {
        if (pk == null || pk.length() < 23) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("getTbIndexByAscPk param can't be illegal");
            }
            throw new IllegalArgumentException("method[getTbIndexByAscPk] params[pk]=illegal!");
        }
        //规则版本 28位： 181221160723123 01 010009 23543
        long index = Long.parseLong(StringUtils.substring(pk, 19, 23));
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("index={},getTbIndexByAscPk.", new Object[] { index });
        }
        return index;
    }


    /**
     * 根据sid获取db/tb路由值
     *
     * @param num
     * @param obj
     * @return
     */
    public static long getIndexByAsc(long num, Object obj) {
        //转asc码
        String str = getAscII(obj == null ? "" : obj.toString());
        //将asc码转为BigDecimal类型
        BigDecimal bc = new BigDecimal(str);
        //除库/表个数
        BigDecimal[] results = bc.divideAndRemainder(new BigDecimal(num));
        return results[1].intValue();
    }

    /**
     * 字符串转accii码
     *
     * @param str
     * @return
     */
    public static String getAscII(String str) {
        if (str == null || "".equals(str)) {
            return "0";
        }
        StringBuffer indexSB = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char[] strChar = str.substring(i, i + 1).toCharArray();
            for (char s : strChar) {
                indexSB.append((byte) s);
            }
        }
        return indexSB.toString();
    }




    public static void main(String[] args) {
        System.out.println("db:"+ZdalRouteUtil.getDbIndexByAsc("2088822739607923","8")+"--tb:"+ZdalRouteUtil.getTbIndexByAsc("2088822739607923","64"));
        System.out.println("db:"+ZdalRouteUtil.getDbIndexByAsc("1901010851554290103001174528","8")+"--tb:"+ZdalRouteUtil.getTbIndexByAsc("1901010851554290103001174528","1024"));
    }
}