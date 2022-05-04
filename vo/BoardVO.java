package com.project.board.mvc.vo;

import java.util.Date;

public class BoardVO {
	private int seq;
	private String userName;
	private String title;
	private String content;
	private Date regDate;
	private Date modDate;
	private int readCnt;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", userName=" + userName + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", readCnt=" + readCnt + "]";
	}
}
