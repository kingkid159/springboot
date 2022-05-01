package com.project.board.mvc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.project.board.mvc.vo.BoardVO;

public interface BoardDAO {
	public void write(Map boardMap) throws DataAccessException;
	public List<BoardVO> boardList(int startPage, int size);
	public int selectListCnt();
	public BoardVO detail(int no) throws Exception;
	public void modify(Map boardMap)throws DataAccessException;
	public void delete(int no)throws Exception;
}
