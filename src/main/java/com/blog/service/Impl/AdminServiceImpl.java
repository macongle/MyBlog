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
	 * �ϴ������ļ�
	 */
	@Override
	public void uploadImg(String savePath, MultipartFile file) {
		//savePath :���ļ��洢·��  /upload
				//filePath :���ļ�·��         /upload/+�ļ���
				String filePath=savePath+File.separator+file.getOriginalFilename();
				
				File saveFile=new File(filePath);
				//�ж��ļ��ĸ���·���Ƿ���ڣ��������ھʹ���
				if(!saveFile.getParentFile().exists()){
					saveFile.getParentFile().mkdirs();
				}
				
				//д���ļ����൱������˵�write����
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
		//�ж��ļ��ĸ���·���Ƿ���ڣ��������ھʹ���
		if(!saveFile.getParentFile().exists()){
			saveFile.getParentFile().mkdirs();
		}
		
		//д���ļ����൱������˵�write����
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		//����һ��imgresult���󣬽�������Ϣ��ͼƬ��Ϣ����ڶ����У�Ȼ�󷵻�
		ImgResult imgResult=new ImgResult();
		imgResult.setErrno("0");
		String[] urlDate=new String[1];
		urlDate[0]="/MyBlog/upload/"+file.getOriginalFilename();
		imgResult.setData(urlDate);
		return imgResult;
		
		
	}

}
