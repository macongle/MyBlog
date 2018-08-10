package com.blog.dao;

import org.springframework.stereotype.Repository;

import com.blog.model.Visitor;

@Repository
public interface VisitorMapper {

	int insert(Visitor visitor);

	Visitor selectVisitorBySelective(Visitor visitor);

}
