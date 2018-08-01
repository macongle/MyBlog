package com.blog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.model.Admin;
import com.blog.service.IAdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private IAdminService service;
	
	
	/**
	 * 
	 * ע����½��ɾ���洢�ĵ�½��Ϣ
	 * 
	 * @param req request����
	 * @param resp response����
	 * @return ��ת����½����
	 */
	@RequestMapping(value="logout")
	public String amdinLogout(HttpServletRequest req,HttpServletResponse resp){
		//������session
		req.getSession().removeAttribute("admin");
//		req.getSession().invalidate();
		
		//�Ȼ�ȡcookie�������Ϣ
		Cookie cookies[]=req.getCookies();
		
		for (Cookie cookie : cookies) {
			if("email".equals(cookie.getName())||"pass".equals(cookie.getName())){
				//��cookie�Ĵ��ʱ������Ϊ0
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		}
		
		return "admin/adminLogin";
		
	}
	
	
	/**
	 * ����½״̬����ȡ���cookie
	 * 
	 * @param req request����
	 * 
	 * @return ��cookie��֤��Ч���Զ���½��������ת��adminLogin����
	 */
	@RequestMapping
	public String checkLogin(HttpServletRequest req,HttpServletResponse resp){
		//������session�������Ϣ
		req.getSession().removeAttribute("admin");
		//�Ȼ�ȡcookie�������Ϣ
		Cookie cookies[]=req.getCookies();
		if(cookies!=null){			
			String email=null;
			String pass=null;
			//����,��cookie�����ֵ������ַ�����
			for (Cookie cookie : cookies) {
				if("email".equals(cookie.getName())){
					email=cookie.getValue();
				}else if("pass".equals(cookie.getName())){
					pass=cookie.getValue();
				}
			}
			
			//��ѯ���ݿ����Ƿ񻹺�����������
			Admin admin = service.login(email,pass);
			
			if(admin!=null){
				req.getSession().setAttribute("admin", admin);
				return "admin/adminInfo";
			}
		}
		return "admin/adminLogin";
	}
	
	
	/**
	 * ����Ա��½����������ӱ����½��Ϣ��cookie
	 * 
	 * @param admin ʵ������󣬴洢ҳ������ݵĲ���
	 * @param remember �Ƿ����cookie�ı�־�����Ƿ�����ס�ң�
	 * @param req request����
	 * @param resp response����
	 * 
	 * @return ��½�ɹ�-adminInfo.jsp ��½ʧ��-adminLogin.jsp
	 */
	@RequestMapping(value="/login")
	public String adminLogin(Admin admin,HttpServletRequest req,
			HttpServletResponse resp,String remember){
		Admin adminLogin=service.login(admin);
		
		if(adminLogin!=null){
			
			if(remember!=null){
				Cookie cookie_email=new Cookie("email", admin.getEmail());
				Cookie cookie_pass=new Cookie("pass", admin.getPass());
				
				//��������ʱ��,10��
				cookie_email.setMaxAge(10);
				cookie_pass.setMaxAge(10);
				
				//�ŵ�resp��
				resp.addCookie(cookie_pass);
				resp.addCookie(cookie_email);
			}
			req.getSession().setAttribute("admin", adminLogin);
			return "admin/adminInfo";
		}
		
		req.getSession().setAttribute("msg", "��Ϣ��������");
		  return "admin/adminLogin";
		
	}
}
