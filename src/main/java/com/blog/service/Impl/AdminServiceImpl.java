package com.blog.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.AdminMapper;
import com.blog.model.Admin;
import com.blog.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private AdminMapper dao;
	
	@Override
	public Admin login(Admin admin) {
		return dao.login(admin);
	}

	@Override
	public Admin login(String email, String pass) {
		Admin admin=new Admin();
		admin.setEmail(email);
		admin.setPass(pass);
		return this.login(admin);
	}

}
