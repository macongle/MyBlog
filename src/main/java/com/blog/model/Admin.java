package com.blog.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Admin implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer amId;

    private String name;

    private String tag;

    private String img;

    private String adress;

    private String phone;

    private String email;

    private String pass;

    public Integer getAmId() {
        return amId;
    }

    public void setAmId(Integer amId) {
        this.amId = amId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

	@Override
	public String toString() {
		return "Admin [amId=" + amId + ", name=" + name + ", tag=" + tag
				+ ", img=" + img + ", adress=" + adress + ", phone=" + phone
				+ ", email=" + email + ", pass=" + pass + "]";
	}
    
    
}