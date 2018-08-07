package com.blog.model;

import org.springframework.stereotype.Component;

@Component
public class Message {
	private int mId;
	private String name;
	private String email;
	private String content;
	private String phone;
	private int sendBack;
	public Message() {
		super();
	}
	public Message(int mId, String name, String email, String content,
			String phone, int sendBack) {
		super();
		this.mId = mId;
		this.name = name;
		this.email = email;
		this.content = content;
		this.phone = phone;
		this.sendBack = sendBack;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSendBack() {
		return sendBack;
	}
	public void setSendBack(int sendBack) {
		this.sendBack = sendBack;
	}
	@Override
	public String toString() {
		return "Message [mId=" + mId + ", name=" + name + ", email=" + email
				+ ", content=" + content + ", phone=" + phone + ", sendBack="
				+ sendBack + "]";
	}
	
	
	
}
