/**
 * Project Name:clps_sms_201708
 * File Name:StringtoDate.java
 * Package Name:com.clps.sms.util.date
 * Date:2017年8月15日下午11:39:59
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.clps.sms.util.date;





import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * ClassName:StringtoDate <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年8月15日 下午11:39:59 <br/>
 * @author   wqeq
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class StringtoDate {
	/**
	 * 
	 * strtoDate:String转换为date类型
	 *
	 * @author wqeq
	 * @param str
	 * @return Date date
	 * @throws ParseException
	 * @since JDK 1.8
	 */
//	public static Date strtoDate(String str) throws ParseException {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date utilDate=sdf.parse(str);
//		Date sqlDate=new java.sql.Date(utilDate.getTime());
//		return sqlDate;
//		
//	}
	
	public static String datetoString(Date date){		
		String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		
		return dateStr;
		
	}
}
