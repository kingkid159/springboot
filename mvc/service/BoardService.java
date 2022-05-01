package com.project.board.mvc.service;

import java.util.Map;

import com.project.board.mvc.vo.BoardVO;

public interface BoardService {
	public void write(Map boardMap) throws Exception;
	public BoardPage list(int no) throws Exception;
	public BoardVO detail(int no) throws Exception;
	public void modify(Map boardMap) throws Exception;
	public void delete(int no) throws Exception;
}
