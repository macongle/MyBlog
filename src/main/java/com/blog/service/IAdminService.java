package com.blog.service;

import com.blog.model.Admin;

public interface IAdminService {

	Admin login(Admin admin);

	Admin login(String email, String pass);

}
