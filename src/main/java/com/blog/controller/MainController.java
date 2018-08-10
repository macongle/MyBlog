package com.blog.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.model.Admin;
import com.blog.model.Blog;
import com.blog.model.Message;
import com.blog.model.Visitor;
import com.blog.service.IAdminService;
import com.blog.service.IBlogService;
import com.blog.service.IMessageService;
import com.blog.service.IVisitorService;

@Controller
@RequestMapping(value="/main")
public class MainController {
	
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IBlogService blogService;
	
	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private IVisitorService visitorService;
	
	private int displayCount=5;
	
	
	@RequestMapping
	public String getBlogList(ModelMap map ,HttpSession session,
			String msg){
		//获取博主信息
		Admin admin = adminService.selectByPrimaryKey(1);
		
		//根据时间获取博文信息
		List<Blog> blogListByDate=blogService.selectBlogByDate();
		
		//根据阅读量获取博文信息
		List<Blog> blogListByReadcount=blogService.selectBlogByreadCount();
		
		session.setAttribute("admin", admin);
		
		map.addAttribute("blogListByDate", blogListByDate);
		
		map.addAttribute("blogListByReadcount", blogListByReadcount);
		
		map.addAttribute("msg", msg);
		
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
			msg="留言成功";
		}else{
			msg="留言失败";
		}
		map.addAttribute("msg", msg);
		return "redirect:/main";
	}
	
	@RequestMapping(value="/BlogDetails/{id}")
	public String blogDetails(@PathVariable("id")Integer bId,ModelMap map,
			HttpServletRequest req){
		
		//创建访问者对象
		Visitor visitor=new Visitor();
		visitor.setbId(bId);
		visitor.setIpaddress(req.getRemoteAddr());
		visitor.setVisittime(new Date(System.currentTimeMillis()));
		//将对象插入到数据库中，如果插入成功返回1，插入失败返回0
		int count = visitorService.insert(visitor);
		//插入成功
		if(count>0){
			//更新查看的博文浏览量
			blogService.updateReadCount(bId);
		}
		
		Blog blog = blogService.selectBlogByPK(bId);
		List<Blog> blogListByReadcount=blogService.selectBlogByreadCount();
		map.addAttribute("blog", blog);
		map.addAttribute("blogListByReadcount", blogListByReadcount);
		return "blogDetails";	
	}
	
	@RequestMapping(value="/zz")
	public String zz(){
		return "zz";
	}
}
