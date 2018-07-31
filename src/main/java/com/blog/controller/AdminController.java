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
	
	
	@RequestMapping
	public String checkLogin(){
		return "admin/adminLogin";
	}
	
	@RequestMapping(value="/login")
	public String adminLogin(Admin admin,HttpServletRequest req,
			HttpServletResponse resp,String remember){
		Admin adminLogin=service.login(admin);
		
		if(adminLogin!=null){
			
			if(remember!=null){
				Cookie cookie_email=new Cookie("email", admin.getEmail());
				Cookie cookie_pass=new Cookie("pass", admin.getPass());
				
				//设置生存时间,20秒
				cookie_email.setMaxAge(20);
				cookie_pass.setMaxAge(20);
				
				//放到resp中
				resp.addCookie(cookie_pass);
				resp.addCookie(cookie_email);
			}
			req.getSession().setAttribute("admin", adminLogin);
			return "admin/adminInfo";
		}
		
		req.getSession().setAttribute("msg", "信息输入有误");
		  return "admin/adminLogin";
		
	}
}
