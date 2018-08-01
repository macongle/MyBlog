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
	 * 注销登陆，删除存储的登陆信息
	 * 
	 * @param req request对象
	 * @param resp response对象
	 * @return 跳转到登陆界面
	 */
	@RequestMapping(value="logout")
	public String amdinLogout(HttpServletRequest req,HttpServletResponse resp){
		//先销毁session
		req.getSession().removeAttribute("admin");
//		req.getSession().invalidate();
		
		//先获取cookie里面的信息
		Cookie cookies[]=req.getCookies();
		
		for (Cookie cookie : cookies) {
			if("email".equals(cookie.getName())||"pass".equals(cookie.getName())){
				//把cookie的存活时间设置为0
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		}
		
		return "admin/adminLogin";
		
	}
	
	
	/**
	 * 检查登陆状态并读取相关cookie
	 * 
	 * @param req request对象
	 * 
	 * @return 若cookie验证有效，自动登陆，否则跳转到adminLogin界面
	 */
	@RequestMapping
	public String checkLogin(HttpServletRequest req,HttpServletResponse resp){
		//先销毁session里面的信息
		req.getSession().removeAttribute("admin");
		//先获取cookie里面的信息
		Cookie cookies[]=req.getCookies();
		if(cookies!=null){			
			String email=null;
			String pass=null;
			//遍历,把cookie里面的值存放在字符串中
			for (Cookie cookie : cookies) {
				if("email".equals(cookie.getName())){
					email=cookie.getValue();
				}else if("pass".equals(cookie.getName())){
					pass=cookie.getValue();
				}
			}
			
			//查询数据库中是否还含有两个参数
			Admin admin = service.login(email,pass);
			
			if(admin!=null){
				req.getSession().setAttribute("admin", admin);
				return "admin/adminInfo";
			}
		}
		return "admin/adminLogin";
	}
	
	
	/**
	 * 管理员登陆，并可以添加保存登陆信息的cookie
	 * 
	 * @param admin 实体类对象，存储页面表单传递的参数
	 * @param remember 是否添加cookie的标志符（是否点击记住我）
	 * @param req request对象
	 * @param resp response对象
	 * 
	 * @return 登陆成功-adminInfo.jsp 登陆失败-adminLogin.jsp
	 */
	@RequestMapping(value="/login")
	public String adminLogin(Admin admin,HttpServletRequest req,
			HttpServletResponse resp,String remember){
		Admin adminLogin=service.login(admin);
		
		if(adminLogin!=null){
			
			if(remember!=null){
				Cookie cookie_email=new Cookie("email", admin.getEmail());
				Cookie cookie_pass=new Cookie("pass", admin.getPass());
				
				//设置生存时间,10秒
				cookie_email.setMaxAge(10);
				cookie_pass.setMaxAge(10);
				
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
