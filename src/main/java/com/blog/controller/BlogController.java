package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.blog.model.Blog;
import com.blog.model.ImgResult;
import com.blog.service.IBlogService;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

	@Autowired
	private IBlogService service;
	
	private int displayCount=5;

	/**
	 * 查询所有blog信息，但不包括content字段
	 * @param map
	 * @return
	 */
	@RequestMapping
	public String getBlogsInfo(ModelMap map,String msg,HttpServletRequest req){
		int pageNow=Integer.parseInt(req.getParameter("pageNow"));
		List<Blog> blogList = service.selectAll(pageNow,displayCount);
		int maxCount=service.getCount(displayCount);
		int pageCount=maxCount%displayCount == 0 ? maxCount/displayCount : maxCount/displayCount+1;
		map.addAttribute("blogList", blogList);
		map.addAttribute("msg",msg);
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", pageCount);
		return "admin/bloginfo";
	}
	

	/**
	 * 新增blog信息到数据库
	 * @param blog
	 * @param map
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String addBlogInfo(Blog blog,ModelMap map){
		int count = service.insertBlog(blog);
		String msg=null;
		if(count>0){
			msg	= "添加成功";
		}else{
			msg = "添加失败";
		}
		map.addAttribute("msg", msg);
		return "redirect:/blog";
		
	}
	
	/**
	 * 根据ID查询blog信息，并跳转到edit页面
	 * @param bId
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/updateBlog/{id}")
	public String toEditBlog(@PathVariable("id")Integer bId,ModelMap map){
		Blog blog = service.selectBlogByPK(bId);
		map.addAttribute("blog", blog);
		return "admin/editorBlog";
	}
	
	/**
	 * 根据ID删除blog信息，
	 * @param bId
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/deleteBlog/{id}")
	public String deleteBlog(@PathVariable("id")Integer bId,ModelMap map){
		int count = service.deleteByPrimaryKey(bId);
		String msg=null;
		if(count>0){
			msg="删除成功";
		}else{
			msg="删除失败";
		}
		map.addAttribute("msg", msg);
		return "redirect:/blog";
	}

	// 跳转到addBlog页面
	@RequestMapping(value = "/addBlog")
	public String addBlog() {
		return "admin/addBlog";
	}
	
	//跳转到blog info界面
	@RequestMapping(value="/blogInfo")
	public String blogInfo(){
		return "admin/bloginfo";
	}
	
	/**
	 * 提交修改信息
	 * @param blog
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/editBlog" , method = RequestMethod.POST)
	public String editBlog(Blog blog,ModelMap map){
		int count = service.editorBlog(blog);
		String msg=null;
		if(count>0){
			msg="修改成功";
		}else{
			msg="修改失败";
		}
		map.addAttribute("msg", msg);
		return "redirect:/blog";
	}

	//将return的内容直接加入响应体
			@ResponseBody
			@RequestMapping(value="/imgUpload")
			public ImgResult upload(@RequestParam("img") MultipartFile file,HttpServletRequest req){
				String savePath = req.getServletContext().getRealPath("upload");
				ImgResult imgResult = service.uploadImgs(savePath, file);
				return imgResult;
			}
}
