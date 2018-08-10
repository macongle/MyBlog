package com.blog.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.VisitorMapper;
import com.blog.model.Visitor;
import com.blog.service.IVisitorService;

@Service
public class VisitorServiceImpl implements IVisitorService{

	@Autowired
	private VisitorMapper dao;
	
	@Override
	public int insert(Visitor visitor) {
		Visitor v = this.selectVisitorBySelective(visitor);
		System.out.println("²ÎÊý£º"+visitor);
		System.out.println("v:"+v);
		if (v == null) {
			return dao.insert(visitor);
		}
		return 0;
	}

	private Visitor selectVisitorBySelective(Visitor visitor) {
		return dao.selectVisitorBySelective(visitor);
	}

}
