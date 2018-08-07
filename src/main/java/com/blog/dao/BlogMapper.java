package com.blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blog.model.Blog;

@Repository
public interface BlogMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

	List<Blog> selectBlogByDate();

	List<Blog> selectBlogByreadCount();

	List<Blog> selectBlogByreadCounts(int m, int n);

	int getCount(int displayCount);

	List<Blog> selectBlogByDates(int m, int n);

	List<Blog> selectAll(int m, int n);

	
}