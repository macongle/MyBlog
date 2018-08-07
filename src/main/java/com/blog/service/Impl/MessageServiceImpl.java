package com.blog.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.MessageMapper;
import com.blog.model.Message;
import com.blog.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService{

	@Autowired
	private MessageMapper dao;
	
	@Override
	public int insertSelective(Message message) {
		return dao.insertSelective(message);
	}

}
