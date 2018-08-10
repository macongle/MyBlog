package com.blog.service.Impl;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.dao.BlogMapper;
import com.blog.model.Blog;
import com.blog.model.ImgResult;
import com.blog.service.IBlogService;

@Service
public class BlogServiceImpl implements IBlogService{

	@Autowired
	private BlogMapper dao;
	

	@Override
	public ImgResult uploadImgs(String savePath, MultipartFile file) {
		String filePath = savePath + File.separator
				+ file.getOriginalFilename();
		File saveFile = new File(filePath);
		if (!saveFile.getParentFile().exists()) {
			saveFile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImgResult imgResult = new ImgResult();
		imgResult.setErrno("0");
		String[] urlDate = new String[1];
		urlDate[0] = "/MyBlog/upload/"+file.getOriginalFilename();
		imgResult.setData(urlDate);
		return imgResult;
	}

	@Override
	public int insertBlog(Blog blog) {
		Date date=new Date(System.currentTimeMillis());
		blog.setCreatetime(date);
		blog.setReadcount(0);
		return dao.insert(blog);
		
	}

	@Override
	public Blog selectBlogByPK(Integer bId) {
		return dao.selectByPrimaryKey(bId);
	}

	@Override
	public int editorBlog(Blog blog) {
		return dao.updateByPrimaryKeySelective(blog);		
	}

	@Override
	public int deleteByPrimaryKey(Integer bId) {
		return dao.deleteByPrimaryKey(bId);
	}

	@Override
	public List<Blog> selectBlogByDate() {
		return dao.selectBlogByDate();
	}

	@Override
	public List<Blog> selectBlogByreadCounts(int pageNow, int displayCount) {
		int m = (pageNow-1)*5;
		int n = displayCount;
		return dao.selectBlogByreadCounts(m,n);
	}

	@Override
	public List<Blog> selectBlogByreadCount() {
		return dao.selectBlogByreadCount();
	}

	@Override
	public int getCount(int displayCount) {
		return dao.getCount(displayCount);
	}

	@Override
	public List<Blog> selectBlogByDates(int pageNow, int displayCount) {
		int m = (pageNow-1)*5;
		int n = displayCount;
		return dao.selectBlogByDates(m,n);
	}

	@Override
	public List<Blog> selectAlls(int pageNow, int displayCount) {
		int m = (pageNow-1)*5;
		int n = displayCount;
		return dao.selectAlls(m,n);
	}

	@Override
	public int updateReadCount(Integer bId) {
		return dao.updateReadCount(bId);
		
	}

}
