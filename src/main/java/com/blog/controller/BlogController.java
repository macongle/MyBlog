package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.model.Blog;
import com.blog.service.IBlogService;

@Controller
@RequestMapping(value="/blog")
public class BlogController {

	@Autowired
	private IBlogService service;
	
	@RequestMapping("/list")
	public String selectAll(ModelMap map){
		List<Blog> blogs = service.selectAll(); 
		map.addAttribute("blogs", blogs);
		return "index";
	}
}
