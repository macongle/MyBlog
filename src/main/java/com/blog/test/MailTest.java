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
	 * ���û������ԣ�
	 * �����˵�ַ
	 * �ռ��˵�ַ
	 * ������������
	 * ��������������
	 * 
	 * @param args
	 */
	private static String fromAddress="1069498942@qq.com";
	
	private static String toAddress[]={"1787675205@qq.com","244217267@qq.com"};
	
	private static String mailUsername="1069498942";
	
	//һ��Ļ�ע��ʱ������룬�п��ܻ����������Ȩ������Ƕ�������
	//�����QQ���䷢�ͣ�����Ȳ���QQ����Ҳ���Ƕ������룬������Ȩ��
	//��Ȩ�룺�������䣬���ã��˻���pop3Э���������������֤���ͻ���ʾ��Ȩ��
	private static String mailPassword="qatlwhcpancgbbfe";
	
	
	public static MimeMessage getMimeMessage(Session session){
		
		//����һ���ʼ���һ��������󣬺ñȰ��ļ�����ΪFile����
		//session���ʼ����ͻ���
		MimeMessage message=new MimeMessage(session);
		
		try {
			//���÷����˵�ַ
			message.setFrom(new InternetAddress(fromAddress));
			
			//Ⱥ��
			 InternetAddress[] sendTo = new InternetAddress[toAddress.length];  
		        for (int i = 0; i < toAddress.length; i++) {  
		            sendTo[i] = new InternetAddress(toAddress[i]);  
		        }  
		        message.setRecipients(Message.RecipientType.CC, sendTo);
			
			//message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
			
			/**
			 * ��ʼд����
			 */
			//�����ʼ�����
			message.setSubject("�ظ��ʼ�", "UTF-8");
			
			//�����ʼ�����
			message.setContent("������<br/> by mcl", "text/html;charset=UTF-8");
			
			//���÷���ʱ��
			message.setSentDate(new Date());
		} catch (MessagingException e) {
			e.printStackTrace();
		}	
		return message;	
	}
	
	public static void sendMessage(){
		Properties pro=new Properties();
		//���ø���Э��
        pro.setProperty("mail.smtp.auth", "true");
		
		pro.setProperty("mail.transport.protocol", "smtp");
		
		//smtp.qq.com    smtp.sina.com
		pro.setProperty("mail.smtp.host", "smtp.qq.com");

		
		//�����ʼ���һ�����ͻ���
		Session session=Session.getInstance(pro);
		
		//��ӡ
		session.setDebug(true);
		
		//��ȡ�ʼ�ʵ��  ���緢������
		Message message=getMimeMessage(session);
		
		try {
			//����ͨ��  ���
			Transport transport=session.getTransport();
			
			//�������ӿ���������ȼ�ϣ��û��������룩
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
