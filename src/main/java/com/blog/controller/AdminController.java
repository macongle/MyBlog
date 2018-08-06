package com.blog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.blog.model.Admin;
import com.blog.model.ImgResult;
import com.blog.service.IAdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private IAdminService service;
	
	
	
	/**
	 * 检查登陆状态并读取相关cookie
	 * 
	 * @param req request对象
	 * 
	 * @return 若cookie验证有效，自动登陆，否则跳转到adminLogin界面
	 */
	@RequestMapping
	public String checkLogin(HttpServletRequest req,HttpServletResponse resp,
			String msg,ModelMap map){
		
		/**
		 *这里销毁session是防止cookie时间结束，不自动登陆，但是因为本次回话没有结束
		 *所以session中还存放有信息 
		 */
		
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
				map.addAttribute("msg", msg);
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
		
		//如果数据库可以查询到该条数据
		if(adminLogin!=null){
			//如果点击了记住我
			if(remember!=null){
				
				//创建Cookie对象，分别将Email和pass存到对象中
				Cookie cookie_email=new Cookie("email", admin.getEmail());
				Cookie cookie_pass=new Cookie("pass", admin.getPass());
				
				//设置生存时间,10秒
				cookie_email.setMaxAge(10);
				cookie_pass.setMaxAge(10);
				
				//放到resp中
				resp.addCookie(cookie_pass);
				resp.addCookie(cookie_email);
			}
			
			//将查询到的结果存到session里面
			req.getSession().setAttribute("admin", adminLogin);
			//跳转到adminInfo界面
			return "admin/adminInfo";
		}
		//如果没有在数据库中查到对应数据，则存一条提示信息
		req.getSession().setAttribute("msg", "信息输入有误");
		//跳转到当前登陆界面，打印提示信息
		  return "admin/adminLogin";
	}
	
	
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
		
		/**
		 * 退出登陆核心思想：销毁一些信息，返回到最初登陆界面 
		 */
		//先销毁session
		req.getSession().removeAttribute("admin");
//		req.getSession().invalidate();
		
		//先获取cookie里面的信息
		Cookie cookies[]=req.getCookies();
		//遍历cookie，把每个cookie的存活时间设置为0
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
	 * 
	 * 修改信息
	 * 
	 * @param admin 映射类对象，用于存储表单数据
	 * @param file 多媒体文件对象，用户存储上传文件数据
	 * @param req	request对象
	 * @return 重定向页面
	 */
	
	@RequestMapping(value="/updateAdmin", method=RequestMethod.POST)
	public String updateAdmin(Admin admin , 
           //将参数中的imgFile绑定到MultipartFile file
			@RequestParam(value="imgFile",required=false) MultipartFile file ,
			HttpServletRequest req,ModelMap map){
		
		if(!file.isEmpty()){
			String savePath=req.getServletContext().getRealPath("upload");
			System.out.println(savePath);
			service.uploadImg(savePath,file);
			admin.setImg("/upload/"+file.getOriginalFilename());
		}
		service.updateAdmin(admin);
		map.addAttribute("msg", "修改成功");
		return "redirect:/admin";
		
	}
	
	
	//将return的内容以json格式直接加入相应体
	@ResponseBody
	@RequestMapping(value="/imgUpload")
	public ImgResult upload(@RequestParam("img") MultipartFile file,
			HttpServletRequest req){
		String savePath=req.getServletContext().getRealPath("upload");
		
		ImgResult imgResult=service.uploadImgs(savePath,file);
		
		return imgResult;
		
	}
	
	
	
	
	
}
