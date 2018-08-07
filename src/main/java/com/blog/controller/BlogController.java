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
	 * ��ѯ����blog��Ϣ����������content�ֶ�
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
	 * ����blog��Ϣ�����ݿ�
	 * @param blog
	 * @param map
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String addBlogInfo(Blog blog,ModelMap map){
		int count = service.insertBlog(blog);
		String msg=null;
		if(count>0){
			msg	= "��ӳɹ�";
		}else{
			msg = "���ʧ��";
		}
		map.addAttribute("msg", msg);
		return "redirect:/blog";
		
	}
	
	/**
	 * ����ID��ѯblog��Ϣ������ת��editҳ��
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
	 * ����IDɾ��blog��Ϣ��
	 * @param bId
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/deleteBlog/{id}")
	public String deleteBlog(@PathVariable("id")Integer bId,ModelMap map){
		int count = service.deleteByPrimaryKey(bId);
		String msg=null;
		if(count>0){
			msg="ɾ���ɹ�";
		}else{
			msg="ɾ��ʧ��";
		}
		map.addAttribute("msg", msg);
		return "redirect:/blog";
	}

	// ��ת��addBlogҳ��
	@RequestMapping(value = "/addBlog")
	public String addBlog() {
		return "admin/addBlog";
	}
	
	//��ת��blog info����
	@RequestMapping(value="/blogInfo")
	public String blogInfo(){
		return "admin/bloginfo";
	}
	
	/**
	 * �ύ�޸���Ϣ
	 * @param blog
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/editBlog" , method = RequestMethod.POST)
	public String editBlog(Blog blog,ModelMap map){
		int count = service.editorBlog(blog);
		String msg=null;
		if(count>0){
			msg="�޸ĳɹ�";
		}else{
			msg="�޸�ʧ��";
		}
		map.addAttribute("msg", msg);
		return "redirect:/blog";
	}

	//��return������ֱ�Ӽ�����Ӧ��
			@ResponseBody
			@RequestMapping(value="/imgUpload")
			public ImgResult upload(@RequestParam("img") MultipartFile file,HttpServletRequest req){
				String savePath = req.getServletContext().getRealPath("upload");
				ImgResult imgResult = service.uploadImgs(savePath, file);
				return imgResult;
			}
}
