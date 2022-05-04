package com.project.board.mvc.vo;

import java.util.Date;

public class CommentVO {
	private int b_seq;
	private String c_userName;
	private String c_content;
	private Date c_regDate;
	private int c_seq;
	
	
	public int getC_seq() {
		return c_seq;
	}
	public void setC_seq(int c_seq) {
		this.c_seq = c_seq;
	}
	public int getB_seq() {
		return b_seq;
	}
	public void setB_seq(int b_seq) {
		this.b_seq = b_seq;
	}
	public String getC_userName() {
		return c_userName;
	}
	public void setC_userName(String c_userName) {
		this.c_userName = c_userName;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public Date getC_regDate() {
		return c_regDate;
	}
	public void setC_regDate(Date c_regDate) {
		this.c_regDate = c_regDate;
	}
	@Override
	public String toString() {
		return "CommentVO [b_seq=" + b_seq + ", c_userName=" + c_userName + ", c_content=" + c_content + ", c_regDate="
				+ c_regDate + ", c_seq=" + c_seq + "]";
	}
	
	
}
