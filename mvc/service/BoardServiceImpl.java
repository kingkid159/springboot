package com.project.board.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.mvc.dao.BoardDAO;
import com.project.board.mvc.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	private int size = 10 ;
	@Autowired
	private BoardDAO boardDAO;
	@Override
	/*
	 * 입력
	 */
	public void write(Map boardMap) throws Exception {
		System.out.println("Service의 boardMap="+boardMap);
		boardDAO.write(boardMap);
	}
	
	@Override
	public BoardPage list(int pageNo) throws Exception {
		// TODO Auto-generated method stub
		int total = boardDAO.selectListCnt();
		System.out.println("serviceList의 total="+total);
		List<BoardVO> content = boardDAO.boardList((pageNo-1) * size + 1,(pageNo-1) * size + size);
		System.out.println("serviceList의 content"+content);
		return new BoardPage(total,pageNo,size,content);
	}

	/*
	 * 상세정보
	 */
	@Override
	public BoardVO detail(int no) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("service의 no="+no);
		BoardVO boardVO = boardDAO.detail(no);
		System.out.println("service의 boardVO="+boardVO);
		return boardVO;
	}
	/*
	 * 수정
	 */
	@Override
	public void modify(Map boardMap) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("serviceModify의 boardMap="+boardMap);
		boardDAO.modify(boardMap);
	}
	/*
	 * 삭제
	 */
	@Override
	public void delete(int no) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.delete(no);
	}

}
