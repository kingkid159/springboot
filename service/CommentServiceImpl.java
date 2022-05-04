package com.project.board.mvc.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.mvc.vo.CommentVO;
@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private SqlSession sqlSession;
	@Override
	public CommentVO view(int no) {
		// TODO Auto-generated method stub
		CommentVO commentVO = sqlSession.selectOne("mapper.Comment.commentView",no);
		return commentVO;
	}

}
