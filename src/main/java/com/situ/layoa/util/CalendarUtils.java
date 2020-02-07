/**
 * @Company:中享思途   
 * @Title:CalendarUtils.java 
 * @Author:wxinpeng   
 * @Date:2019年12月31日 下午3:09:42     
 */
package com.situ.layoa.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/** 
 * @ClassName:CalendarUtils 
 * @Description:(CalendarUtils)  
 */
public class CalendarUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final SimpleDateFormat FORMAT_YYMMDDHHMM = new SimpleDateFormat("yyMMddHHmm");

	public static String getShortDate() {
		return FORMAT_YYMMDDHHMM.format(Calendar.getInstance().getTime());
	}
}
