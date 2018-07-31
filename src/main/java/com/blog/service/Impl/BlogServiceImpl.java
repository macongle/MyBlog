package com.blog.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.BlogMapper;
import com.blog.model.Blog;
import com.blog.service.IBlogService;

@Service
public class BlogServiceImpl implements IBlogService{

	@Autowired
	private BlogMapper dao;
	
	@Override
	public List<Blog> selectAll() {
		return dao.selectAll();
	}

}
