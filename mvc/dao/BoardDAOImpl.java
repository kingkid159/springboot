package com.project.board.mvc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.project.board.mvc.service.BoardPage;
import com.project.board.mvc.vo.BoardVO;
@Repository("BoardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public void write(Map boardMap) throws DataAccessException {
		System.out.println("DAO의baordMap="+boardMap);
		sqlSession.insert("mapper.board.boardWrite", boardMap);
	}
	
	@Override
	public List<BoardVO> boardList(int startPage, int size) {
		// TODO Auto-generated method stub
		BoardPage boardPage = new BoardPage(startPage, size);
		System.out.println("daoList의 boardPage="+boardPage);
		List<BoardVO> result = (ArrayList)sqlSession.selectList("boardList",boardPage);
		System.out.println("daoList의 result="+result);
		return result;
	}

	@Override
	public int selectListCnt() {
		int result = (Integer)sqlSession.selectOne("boardListCnt");
		return result;
	}

	@Override
	public BoardVO detail(int no) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DAO의 no = "+no);
		BoardVO result = sqlSession.selectOne("mapper.board.boardDetail",no);
		sqlSession.selectOne("mapper.board.boardReadCnt",no);
		System.out.println("DAO의 result"+result);
		return result;
	}
	@Override
	public void modify(Map boardMap) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("daoModify의 boardMap="+boardMap);
		sqlSession.update("mapper.board.boardUpdate",boardMap);
	}
	@Override
	public void delete(int no) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.board.boardDelete",no);
	}
	
}
