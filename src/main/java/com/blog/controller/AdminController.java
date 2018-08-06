package com.blog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.blog.model.Admin;
import com.blog.model.ImgResult;
import com.blog.service.IAdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private IAdminService service;
	
	
	
	/**
	 * ����½״̬����ȡ���cookie
	 * 
	 * @param req request����
	 * 
	 * @return ��cookie��֤��Ч���Զ���½��������ת��adminLogin����
	 */
	@RequestMapping
	public String checkLogin(HttpServletRequest req,HttpServletResponse resp,
			String msg,ModelMap map){
		
		/**
		 *��������session�Ƿ�ֹcookieʱ����������Զ���½��������Ϊ���λػ�û�н���
		 *����session�л��������Ϣ 
		 */
		
		//������session�������Ϣ
		req.getSession().removeAttribute("admin");
		//�Ȼ�ȡcookie�������Ϣ
		Cookie cookies[]=req.getCookies();
		if(cookies!=null){			
			String email=null;
			String pass=null;
			//����,��cookie�����ֵ������ַ�����
			for (Cookie cookie : cookies) {
				if("email".equals(cookie.getName())){
					email=cookie.getValue();
				}else if("pass".equals(cookie.getName())){
					pass=cookie.getValue();
				}
			}
			
			//��ѯ���ݿ����Ƿ񻹺�����������
			Admin admin = service.login(email,pass);
			
			if(admin!=null){
				req.getSession().setAttribute("admin", admin);
				map.addAttribute("msg", msg);
				return "admin/adminInfo";
			}
		}
		return "admin/adminLogin";
	}
	

	/**
	 * ����Ա��½����������ӱ����½��Ϣ��cookie
	 * 
	 * @param admin ʵ������󣬴洢ҳ������ݵĲ���
	 * @param remember �Ƿ����cookie�ı�־�����Ƿ�����ס�ң�
	 * @param req request����
	 * @param resp response����
	 * 
	 * @return ��½�ɹ�-adminInfo.jsp ��½ʧ��-adminLogin.jsp
	 */
	@RequestMapping(value="/login")
	public String adminLogin(Admin admin,HttpServletRequest req,
			HttpServletResponse resp,String remember){
		Admin adminLogin=service.login(admin);
		
		//������ݿ���Բ�ѯ����������
		if(adminLogin!=null){
			//�������˼�ס��
			if(remember!=null){
				
				//����Cookie���󣬷ֱ�Email��pass�浽������
				Cookie cookie_email=new Cookie("email", admin.getEmail());
				Cookie cookie_pass=new Cookie("pass", admin.getPass());
				
				//��������ʱ��,10��
				cookie_email.setMaxAge(10);
				cookie_pass.setMaxAge(10);
				
				//�ŵ�resp��
				resp.addCookie(cookie_pass);
				resp.addCookie(cookie_email);
			}
			
			//����ѯ���Ľ���浽session����
			req.getSession().setAttribute("admin", adminLogin);
			//��ת��adminInfo����
			return "admin/adminInfo";
		}
		//���û�������ݿ��в鵽��Ӧ���ݣ����һ����ʾ��Ϣ
		req.getSession().setAttribute("msg", "��Ϣ��������");
		//��ת����ǰ��½���棬��ӡ��ʾ��Ϣ
		  return "admin/adminLogin";
	}
	
	
	/**
	 * 
	 * ע����½��ɾ���洢�ĵ�½��Ϣ
	 * 
	 * @param req request����
	 * @param resp response����
	 * @return ��ת����½����
	 */
	@RequestMapping(value="logout")
	public String amdinLogout(HttpServletRequest req,HttpServletResponse resp){
		
		/**
		 * �˳���½����˼�룺����һЩ��Ϣ�����ص������½���� 
		 */
		//������session
		req.getSession().removeAttribute("admin");
//		req.getSession().invalidate();
		
		//�Ȼ�ȡcookie�������Ϣ
		Cookie cookies[]=req.getCookies();
		//����cookie����ÿ��cookie�Ĵ��ʱ������Ϊ0
		for (Cookie cookie : cookies) {
			if("email".equals(cookie.getName())||"pass".equals(cookie.getName())){
				//��cookie�Ĵ��ʱ������Ϊ0
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		}		
		return "admin/adminLogin";		
	}

	/**
	 * 
	 * �޸���Ϣ
	 * 
	 * @param admin ӳ����������ڴ洢������
	 * @param file ��ý���ļ������û��洢�ϴ��ļ�����
	 * @param req	request����
	 * @return �ض���ҳ��
	 */
	
	@RequestMapping(value="/updateAdmin", method=RequestMethod.POST)
	public String updateAdmin(Admin admin , 
           //�������е�imgFile�󶨵�MultipartFile file
			@RequestParam(value="imgFile",required=false) MultipartFile file ,
			HttpServletRequest req,ModelMap map){
		
		if(!file.isEmpty()){
			String savePath=req.getServletContext().getRealPath("upload");
			System.out.println(savePath);
			service.uploadImg(savePath,file);
			admin.setImg("/upload/"+file.getOriginalFilename());
		}
		service.updateAdmin(admin);
		map.addAttribute("msg", "�޸ĳɹ�");
		return "redirect:/admin";
		
	}
	
	
	//��return��������json��ʽֱ�Ӽ�����Ӧ��
	@ResponseBody
	@RequestMapping(value="/imgUpload")
	public ImgResult upload(@RequestParam("img") MultipartFile file,
			HttpServletRequest req){
		String savePath=req.getServletContext().getRealPath("upload");
		
		ImgResult imgResult=service.uploadImgs(savePath,file);
		
		return imgResult;
		
	}
	
	
	
	
	
}
