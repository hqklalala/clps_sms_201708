
	package com.clps.sms.mail;  
	import java.util.Properties;

import javax.mail.Address;

	import javax.mail.Message;  
	import javax.mail.MessagingException;  
	import javax.mail.Session;  
	import javax.mail.Transport;  
	import javax.mail.internet.InternetAddress;  
	import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.SimpleEmail; 
	
//	public class HelloJMail {  
//	    
//	    
//	    public static void main(String[] args) throws MessagingException {  
//	        Properties props = new Properties();  
//	        props.setProperty("mail.smtp.auth", "true");//设置访问smtp服务器需要认证  
//	        props.setProperty("mail.transport.protocol", "smtp"); //设置访问服务器的协议  
//	          
//	        Session session = Session.getDefaultInstance(props);  
//	        session.setDebug(true); //打开debug功能  
//	          
//	        Message msg = new MimeMessage(session);  
//	        msg.setFrom(new InternetAddress("1028790600@qq.com")); //设置发件人，163邮箱要求发件人与登录用户必须一致（必填），其它邮箱不了解  
//	        msg.setText("Hello world!"); //设置邮件内容  
//	        msg.setSubject("test"); //设置邮件主题  
//	          
//	        Transport trans = session.getTransport();  
//	        trans.connect("smtp.qq.com",25, "1028790600@qq.com", "xcrdfwknetvabeeg");
//	        trans.sendMessage(msg, new Address[]{new InternetAddress("994700490@qq.com")}); //发送邮件  
//	          
//	        trans.close(); //关闭连接  
//	    }  
//	}

	public class SendEMail
	{
	    //@Test
	    public static void main ( String[] arg ) throws Exception
	    {
	        SimpleEmail email=new SimpleEmail();
	        email.setHostName ( "smtp.qq.com" );
	        // 登陆邮件服务器的用户名和密码
	        email.setAuthentication ( "1028790600@qq.com", "xcrdfwknetvabeeg" );
	        email.setSmtpPort(587);
	        // 接收人
	        email.addTo ( "994700490@qq.com", "Zieckey" );
	        // 发送人
	        email.setFrom ( "1028790600@qq.com", "Me" );
	        // 标题
	        email.setSubject ( "Test message" );
	        // 邮件内容
	        email.setMsg ( "This is a simple test of commons-email" );
	        // 发送
//	        email.send ( );
	        System.out.println ( email.send ( ) );
	    }
	}
