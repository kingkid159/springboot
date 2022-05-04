package com.project.board.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.board.mvc.vo.CommentVO;

@Controller ("commentControlelr")
public class CommentController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/comWrite", method = RequestMethod.POST)
	public String write(HttpServletRequest request, HttpServletResponse response,CommentVO commentVO) {
		System.out.println("commentControllerwrite의 commentVO="+commentVO);
		sqlSession.insert("mapper.Comment.writeComment",commentVO);
		return null;
	}
	
	@RequestMapping(value = "/comWriteForm")
	public ModelAndView writeForm(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		ModelAndView mv = new ModelAndView();
		mv.addObject("no",no);
		mv.setViewName("comWriteForm");
		return mv;
	}
}
