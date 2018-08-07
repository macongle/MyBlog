package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.model.Admin;
import com.blog.model.Blog;
import com.blog.model.Message;
import com.blog.service.IAdminService;
import com.blog.service.IBlogService;
import com.blog.service.IMessageService;

@Controller
@RequestMapping(value="/main")
public class MainController {
	
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IBlogService blogService;
	
	@Autowired
	private IMessageService messageService;
	
	private int displayCount=5;
	
	
	@RequestMapping
	public String getBlogList(ModelMap map ,HttpSession session,
			String msg,HttpServletRequest req){
		//��ȡ������Ϣ
		Admin admin = adminService.selectByPrimaryKey(1);
		
		int pageNow=Integer.parseInt(req.getParameter("pageNow"));
		//����ʱ���ȡ������Ϣ
		List<Blog> blogListByDate=blogService.selectBlogByDates(pageNow,displayCount);
		int maxCount=blogService.getCount(displayCount);
		int pageCount=maxCount%displayCount == 0 ? maxCount/displayCount : maxCount/displayCount+1;
		
		//�����Ķ�����ȡ������Ϣ
		List<Blog> blogListByReadcount=blogService.selectBlogByreadCount();
		
		session.setAttribute("admin", admin);
		
		map.addAttribute("blogListByDate", blogListByDate);
		
		map.addAttribute("blogListByReadcount", blogListByReadcount);
		
		map.addAttribute("msg", msg);
		
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", pageCount);
		
		return "index";
		
	}
	
	@RequestMapping(value="/blogList")
	public String blogList(ModelMap map,HttpServletRequest req){	 
		int pageNow=Integer.parseInt(req.getParameter("pageNow"));
		List<Blog> blogListByReadcount=blogService.selectBlogByreadCounts(pageNow,displayCount);
		int maxCount=blogService.getCount(displayCount);
		int pageCount=maxCount%displayCount == 0 ? maxCount/displayCount : maxCount/displayCount+1;
		map.addAttribute("blogListByReadcount", blogListByReadcount);
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", pageCount);
		return "bloglist";
	}

	@RequestMapping(value="/message")
	public String toMessage(ModelMap map){
		return "sendmessage";
		
	}
	
	@RequestMapping(value="/saveMessage")
	public String saveMessage(ModelMap map,Message message){
		int count = messageService.insertSelective(message);
		String msg=null;
		if(count>0){
			msg="���Գɹ�";
		}else{
			msg="����ʧ��";
		}
		map.addAttribute("msg", msg);
		return "redirect:/main";
	}
}
