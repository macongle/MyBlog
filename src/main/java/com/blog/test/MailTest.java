package com.blog.test;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTest {
	
	/**
	 * 设置基本属性：
	 * 发送人地址
	 * 收件人地址
	 * 发送人邮箱名
	 * 发送人邮箱密码
	 * 
	 * @param args
	 */
	private static String fromAddress="1069498942@qq.com";
	
	private static String toAddress[]={"1787675205@qq.com","244217267@qq.com"};
	
	private static String mailUsername="1069498942";
	
	//一般的话注册时候的密码，有可能会是邮箱的授权码或者是独立密码
	//如果是QQ邮箱发送，密码既不是QQ密码也不是独立密码，而是授权码
	//授权码：进入邮箱，设置，账户，pop3协议点击开启，完成验证，就会显示授权码
	private static String mailPassword="qatlwhcpancgbbfe";
	
	
	public static MimeMessage getMimeMessage(Session session){
		
		//代表一个邮件的一个抽象对象，好比把文件抽象为File对象
		//session是邮件发送环境
		MimeMessage message=new MimeMessage(session);
		
		try {
			//设置发件人地址
			message.setFrom(new InternetAddress(fromAddress));
			
			//群发
			 InternetAddress[] sendTo = new InternetAddress[toAddress.length];  
		        for (int i = 0; i < toAddress.length; i++) {  
		            sendTo[i] = new InternetAddress(toAddress[i]);  
		        }  
		        message.setRecipients(Message.RecipientType.CC, sendTo);
			
			//message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
			
			/**
			 * 开始写正题
			 */
			//设置邮件标题
			message.setSubject("回复邮件", "UTF-8");
			
			//设置邮件内容
			message.setContent("再试试<br/> by mcl", "text/html;charset=UTF-8");
			
			//设置发送时间
			message.setSentDate(new Date());
		} catch (MessagingException e) {
			e.printStackTrace();
		}	
		return message;	
	}
	
	public static void sendMessage(){
		Properties pro=new Properties();
		//设置各种协议
        pro.setProperty("mail.smtp.auth", "true");
		
		pro.setProperty("mail.transport.protocol", "smtp");
		
		//smtp.qq.com    smtp.sina.com
		pro.setProperty("mail.smtp.host", "smtp.qq.com");

		
		//生成邮件的一个发送环境
		Session session=Session.getInstance(pro);
		
		//打印
		session.setDebug(true);
		
		//获取邮件实例  比如发送卫星
		Message message=getMimeMessage(session);
		
		try {
			//发送通道  火箭
			Transport transport=session.getTransport();
			
			//给火箭添加可以启动的燃料（用户名，密码）
			transport.connect(mailUsername, mailPassword);
			
			transport.sendMessage(message, message.getAllRecipients());
			
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	
	}

	public static void main(String[] args) {
		sendMessage();
	}
}
