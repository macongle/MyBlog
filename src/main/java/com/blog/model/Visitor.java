package com.blog.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Visitor {

	 private Integer vId;

	    private String ipaddress;

	    private Integer bId;

	    private Date visittime;

		public Integer getvId() {
			return vId;
		}

		public void setvId(Integer vId) {
			this.vId = vId;
		}

		public String getIpaddress() {
			return ipaddress;
		}

		public void setIpaddress(String ipaddress) {
			this.ipaddress = ipaddress;
		}

		public Integer getbId() {
			return bId;
		}

		public void setbId(Integer bId) {
			this.bId = bId;
		}

		public Date getVisittime() {
			return visittime;
		}

		public void setVisittime(Date visittime) {
			this.visittime = visittime;
		}

		@Override
		public String toString() {
			return "Visitor [vId=" + vId + ", ipaddress=" + ipaddress
					+ ", bId=" + bId + ", visittime=" + visittime + "]";
		}

		
	    
}
