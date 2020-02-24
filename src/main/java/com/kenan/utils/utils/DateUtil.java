package com.kenan.utils.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @创建日期 2009-3-11 下午11:13:41
 * @类名 DateUtil.java
 * @模块 日期转换工具
 */
public class DateUtil {

	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

	public static final String DATEFORMAT1 = "yyyy-MM-dd HH:mm:ss";
	public static final String DATEFORMAT3 = "yyyyMMddHHmmss";
	public static final String DATEFORMAT2 = "yyMMddHHmm";
	public static final String DATEFORMAT4 = "yyyy.MM.dd";
	public static final String DATEFORMAT5 = "yyyy-MM";
	public static final String DATEFORMAT6 = "yyyy-MM-dd";
	public static final String DATEFORMAT7 = "HH:mm:ss";
	public static final String DATEFORMAT8 = "yyMMddHHmm";

	//测试缓存
	public static final long HOURS1 = 1;
	public static final long HOURS2 = 1;
	/**
	 * 每个时间的毫秒数
	 */
	public static final long ONE_YEAR = 31104000000l;
	public static final long ONE_MONTH = 2592000000l;
	public static final long ONE_DAY = 86400000;
	public static final long ONE_HOUR = 3600000;
	public static final long ONE_MINUTE = 60000;

	/**
	 * 转换日期为自定义字符串
	 * 
	 * @return
	 */
	public static String parserDateToString(Date aDate, String aMask) {
		if (aDate != null) {
			return new SimpleDateFormat(aMask == null ? DATEFORMAT1 : aMask).format(aDate);
		}
		if (logger.isInfoEnabled()) {
			logger.info("输入参数日期为空!");
		}
		return null;
	}

	/**
	 * 字符串转换成时间格式：自定义目标格式，验证格式，如果格式不正确返回null
	 * 
	 * @return
	 */
	public static String DateFromString(String aDate, String aMask) {
		if (aDate == null) {
			if (logger.isInfoEnabled()) {
				logger.info("输入参数日期为空!");
			}
			return null;
		}
		String dt = null;
		try {
			dt = new SimpleDateFormat(aMask == null ? DATEFORMAT1 : aMask)
					.format(new SimpleDateFormat(aMask == null ? DATEFORMAT1 : aMask).parse(aDate));
		} catch (ParseException e) {
			logger.error("日期转换失败!\n", e);
		}
		return dt;
	}

	/**
	 * 字符串转换成时间格式：自定义目标格式，验证格式，如果格式不正确返回null
	 * 
	 * @return Date
	 */
	public static Date parserDateFromString(String aDate, String aMask) {
		if (aDate == null) {
			if (logger.isInfoEnabled()) {
				logger.info("输入参数日期为空!");
			}
			return null;
		}
		Date dt = null;
		try {
			dt = new SimpleDateFormat(aMask == null ? DATEFORMAT1 : aMask).parse(aDate);
		} catch (ParseException e) {
			logger.error("日期转换失败!\n", e);
		}
		return dt;
	}

	/**
	 * 当前系统时间生成日期
	 */
	public static String getNowTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEFORMAT3);
		return simpleDateFormat.format(new Date()).toString();
	}

	/**
	 * 当前系统时间生成日期
	 */
	public static Date getCurrentTime() {
		return new Date();
	}

	/**
	 * 根据时间转换时间
	 */
	public static String getNowTime(String outDateFormat) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(outDateFormat);
		return simpleDateFormat.format(new Date()).toString();
	}

	/**
	 * 根据给定的格式输出日
	 * 
	 * @param inDate
	 * @param inDateFormat
	 * @param outDateFormat
	 * @return
	 * @throws ParseException
	 */
	public static String formatDate(String inDate, String inDateFormat, String outDateFormat) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(inDateFormat);
		Date date = simpleDateFormat.parse(inDate);
		simpleDateFormat.applyPattern(outDateFormat);
		return simpleDateFormat.format(date);
	}

	/**
	 * @Title:isDateBefore
	 * @Description:判断参数时间是否比现在时间大
	 * @param date2
	 * @return
	 */
	public static boolean isDateBefore(String date2) {
		try {
			Date date1 = new Date();
			DateFormat df = DateFormat.getDateTimeInstance();
			return date1.before(df.parse(date2));
		} catch (ParseException e) {
			logger.error("日期比较失败", e);
			return false;
		}
	}

	/**
	 * @Title:isDateAfter
	 * @Description:判断参数时间是否比现在时间小
	 * @param date2
	 * @return
	 */
	public static boolean isDateAfter(String date2) {
		try {
			Date date1 = new Date();
			DateFormat df = DateFormat.getDateTimeInstance();
			return date1.after(df.parse(date2));
		} catch (ParseException e) {
			logger.error("日期比较失败", e);
			return false;
		}
	}
	
	/**
	 * @Title:isDateAfter
	 * @Description:判断参数时间是否比现在时间小
	 * @param date2
	 * @return
	 */
	public static boolean isDateAfterDate(Date date2) {
		try {
			Date date1 = new Date();
			return date1.after(date2);
		} catch (Exception e) {
			logger.error("日期比较失败", e);
			return false;
		}
	}

	/**
	 * @Title:compareDate
	 * @Description:比较时间1是否大于时间2
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean compareDate(String date1, String date2) {
		try {
			DateFormat df = DateFormat.getDateTimeInstance();
			return df.parse(date2).before(df.parse(date1));
		} catch (Exception e) {
			logger.error("日期比较失败", e);
			return false;
		}
	}

	/**
	 * 格式化时间为当前时区的时间
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date formatZoneDate(String date) throws ParseException {
		SimpleDateFormat sfStart = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", java.util.Locale.ENGLISH);
		return sfStart.parse(date);
	}

	/**
	 * 获取距离当前时间的描述，如1分钟前、1小时前、昨天、3天前、1个月前、1年前
	 * 
	 * @param date
	 * @return
	 */
	public static String getCnDesAwayFromCurrentTime(Date date) {
		if (date == null) {
			return null;
		}
		Date now = new Date();
		long second = now.getTime() - date.getTime();
		if (second > ONE_YEAR) {
			return (second / ONE_YEAR) + "年前";
		} else if (second > ONE_MONTH) {
			return (second / ONE_MONTH) + "个月前";
		} else if (second > ONE_DAY) {
			if ((second / ONE_DAY) == 1) {
				return "昨天";
			} else {
				return (second / ONE_DAY) + "天前";
			}
		} else if (second > ONE_HOUR) {
			return (second / ONE_HOUR) + "小时前";
		} else {
			if (second / ONE_MINUTE == 0) {
				return "刚刚";
			}
			return (second / ONE_MINUTE) + "分钟前";
		}
	}

	/**
	 * 获取距离当前时间的描述，如1分钟前、1小时前、昨天、3天前、1个月前、1年前
	 * 
	 * @param date
	 * @return
	 */
	public static Date addSecondToDate(Date date, int second) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.SECOND, second);
		return c.getTime();
	}

	/**
	 * 得到几天前的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date date, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}

	/**
	 * 获取XX天之后的日期
	 * 
	 * @param currentTime
	 * @param dayNum
	 * @return
	 */
	public static Date getFewDaysTimeByCurrentTime(Date currentTime, int dayNum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentTime);
		calendar.add(Calendar.DAY_OF_MONTH, dayNum);
		Date date = calendar.getTime();
		return date;
	}

	/**
	 * 验证日期字符串是否规范
	 * 
	 * @param dateStr
	 * @return
	 */
	public static boolean isStandardDate(String dateStr,String rule) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(rule);
			format.setLenient(false);
			format.parse(dateStr);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	 //验证传入时间是否在当前时间15天范围内
    public static boolean getAfter(Date time){
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DAY_OF_YEAR, 15);
    	Date date = calendar.getTime();
        if(time.before(date)){
        	return true;
        }
    	return false;
    }
    
    //获取时间差的天数
    public static Integer getDays(Date start,Date end){
		Calendar cal = Calendar.getInstance();
	    cal.setTime(start);
	    long time1 = cal.getTimeInMillis();
	    cal.setTime(end);
	    long time2 = cal.getTimeInMillis();      
	    long between_days=(time2-time1)/(1000*3600*24);  
	    return Integer.parseInt(String.valueOf(between_days));           
	}

	//获取当前年月   201812
	public static String getYearMonth(){
		String res = new SimpleDateFormat("yyyy-MM").format(new Date()).toString();
		return res.replace("-","");
	}

    //获取当前月份
	public static int getNowMonth() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return gc.get(2) + 1;
	}

	//获取当天开始时间
	public static String getStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return parserDateToString(todayStart.getTime(),DATEFORMAT1);
	}
	//获取当天结束时间
	public static String getnowEndTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		return parserDateToString(todayEnd.getTime(),DATEFORMAT1);
	}

	public static Date getMonEndDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
       //将小时至0
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		//将分钟至0
		calendar.set(Calendar.MINUTE, 0);
        //将秒至0
		calendar.set(Calendar.SECOND,0);
        //将毫秒至0
		calendar.set(Calendar.MILLISECOND, 0);
       //获得当前月第一天
	//	Date sdate = calendar.getTime();
       //将当前月加1；
		calendar.add(Calendar.MONTH, 1);
       //在当前月的下一月基础上减去1毫秒
		calendar.add(Calendar.MILLISECOND, -1);
        //获得当前月最后一天
		Date edate = calendar.getTime();
		return edate;
	}

	//当前时间是否大于指定时间，大于 返回指定时间，否则 返回剩余时间
	public static long getMerTime(long time) {
		Date monEnd = getMonEndDay();
		Date now = new Date();
		long between = monEnd.getTime() - now.getTime();
		long day = between / (24 * 60 * 60 * 1000);
		long hour = (between / (60 * 60 * 1000) - day * 24);
		long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		if(s > time){
			return time;
		}else {
			return s;
		}
	}
   //判断是否为当年
	public static boolean isThisYear(String year) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date date = new Date();
		String thisYear = sdf.format(date);
		if(Integer.parseInt(year) < Integer.parseInt(thisYear)){
			return false;
		}else {
			return true;
		}
	}
}
