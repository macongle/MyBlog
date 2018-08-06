package com.blog.service.Impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.dao.AdminMapper;
import com.blog.model.Admin;
import com.blog.model.ImgResult;
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

	
	

	@Override
	public void updateAdmin(Admin admin) {
		dao.updateByPrimaryKey(admin);
		
	}

	
	/**
	 * 上传单个文件
	 */
	@Override
	public void uploadImg(String savePath, MultipartFile file) {
		//savePath :是文件存储路径  /upload
				//filePath :是文件路径         /upload/+文件名
				String filePath=savePath+File.separator+file.getOriginalFilename();
				
				File saveFile=new File(filePath);
				//判断文件的父级路径是否存在，若不存在就创建
				if(!saveFile.getParentFile().exists()){
					saveFile.getParentFile().mkdirs();
				}
				
				//写入文件，相当于输出了的write方法
				try {
					file.transferTo(saveFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				
		
	}

	@Override
	public ImgResult uploadImgs(String savePath, MultipartFile file) {
		String filePath=savePath+File.separator+file.getOriginalFilename();
		
		File saveFile=new File(filePath);
		//判断文件的父级路径是否存在，若不存在就创建
		if(!saveFile.getParentFile().exists()){
			saveFile.getParentFile().mkdirs();
		}
		
		//写入文件，相当于输出了的write方法
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		//创建一个imgresult对象，将错误信息和图片信息存放在对象中，然后返回
		ImgResult imgResult=new ImgResult();
		imgResult.setErrno("0");
		String[] urlDate=new String[1];
		urlDate[0]="/MyBlog/upload/"+file.getOriginalFilename();
		imgResult.setData(urlDate);
		return imgResult;
		
		
	}

}
