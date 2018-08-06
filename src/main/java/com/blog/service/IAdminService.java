package com.blog.service;

import org.springframework.web.multipart.MultipartFile;

import com.blog.model.Admin;
import com.blog.model.ImgResult;

public interface IAdminService {

	Admin login(Admin admin);

	Admin login(String email, String pass);

	void updateAdmin(Admin admin);

	void uploadImg(String savePath, MultipartFile file);

	ImgResult uploadImgs(String savePath, MultipartFile file);

}
