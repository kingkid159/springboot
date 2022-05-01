package com.project.board.mvc.service;

import java.util.List;

import com.project.board.mvc.vo.BoardVO;

public class BoardPage {
	private int total;
	private int currentPage;
	private List<BoardVO> content;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int size;
	
public BoardPage(int startPage, int size) {
	this.startPage = startPage;
	this.size = size;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public BoardPage(int total, int currentPage, int size, List<BoardVO> content) {
	this.total = total;
	this.currentPage = currentPage;
	this.content = content;
	if (total == 0) {
		totalPage = 0;
		startPage = 0;
		endPage = 0;
	}else {
		totalPage = total/size;
		if(total % size > 0) {
			totalPage++;
		}
	int modVal = currentPage % 5;
	startPage = currentPage / 5 * 5 + 1;
	if (modVal == 0)startPage -= 5;
	endPage = startPage + 4;
	if (endPage > totalPage) endPage = totalPage;
	}
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public int getCurrentPage() {
	return currentPage;
}

public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}

public List<BoardVO> getContent() {
	return content;
}

public void setContent(List<BoardVO> content) {
	this.content = content;
}

public int getTotalPage() {
	return totalPage;
}

public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}

public int getStartPage() {
	return startPage;
}

public void setStartPage(int startPage) {
	this.startPage = startPage;
}

public int getEndPage() {
	return endPage;
}

public void setEndPage(int endPage) {
	this.endPage = endPage;
}
@Override
public String toString() {
	return "EduPage [total=" + total + ", currentPage=" + currentPage + ", content=" + content + ", totalPage="
			+ totalPage + ", startPage=" + startPage + ", endPage=" + endPage + ", size=" + size + "]";
}



}
