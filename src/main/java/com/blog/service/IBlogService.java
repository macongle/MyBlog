package com.blog.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.blog.model.Blog;
import com.blog.model.ImgResult;

public interface IBlogService {


	ImgResult uploadImgs(String savePath, MultipartFile file);

	int insertBlog(Blog blog);

	Blog selectBlogByPK(Integer bId);

	int editorBlog(Blog blog);

	int deleteByPrimaryKey(Integer bId);

	List<Blog> selectBlogByDate();

	List<Blog> selectBlogByreadCounts(int pageNow, int displayCount);

	List<Blog> selectBlogByreadCount();

	int getCount(int displayCount);

	List<Blog> selectBlogByDates(int pageNow, int displayCount);

	List<Blog> selectAll(int pageNow, int displayCount);

}
