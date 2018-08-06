package com.blog.model;

import java.io.Serializable;
import java.util.Arrays;

public class ImgResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errno;
	private String[] data;

	public ImgResult() {
		super();
	}

	public ImgResult(String errno, String[] data) {
		super();
		this.errno = errno;
		this.data = data;
	}

	public String getErrno() {
		return errno;
	}

	public void setErrno(String errno) {
		this.errno = errno;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ImgResult [errno=" + errno + ", data=" + Arrays.toString(data)
				+ "]";
	}

}
