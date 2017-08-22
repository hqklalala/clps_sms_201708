/**
 * Project Name:clps_sms_201708
 * File Name:Sendmail.java
 * Package Name:com.clps.sms.util.mail
 * Date:2017年8月17日下午1:15:03
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.clps.sms.util.mail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;



/**
 * ClassName:Sendmail <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年8月17日 下午1:15:03 <br/>
 * @author   wqeq
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class SendMail {
//	日志
	private static	Logger logger=Logger.getLogger(SendMail.class);
	
	/**
	 * 
	 * sendmail:发邮件
	 * @author wqeq
	 * @param sendperson
	 * @param title
	 * @param sendcontext
	 * @return
	 * @throws EmailException
	 * @since JDK 1.8
	 */
	public String sendmail(String sendperson,String title,String sendcontext) {
		
		SimpleEmail email=new SimpleEmail();
        email.setHostName ( "smtp.qq.com" );
        // 登陆邮件服务器的用户名和密码(发件人)，xcrdfwknetvabeeg密码
        email.setAuthentication ( "1028790600@qq.com", "xcrdfwknetvabeeg" );
        email.setSmtpPort(587);//端口号
       
        try {
        	 // 接收人
			email.addTo ( sendperson, "Zieckey" );
			 // 发送人
	        email.setFrom ( "1028790600@qq.com", "Me" );
	        // 标题
	        email.setSubject ( title);
	        // 邮件内容
	        email.setMsg ( sendcontext );
	        // 发送
	        email.send ( );
	        
	        return "success";
		} catch (EmailException e) {
			logger.error("sendmail is fail");
		}
       
		return "fail";
	}

}
