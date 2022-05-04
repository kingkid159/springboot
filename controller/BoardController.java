package com.project.board.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface BoardController {
	//등록
	public String write(HttpServletRequest request,HttpServletResponse response) throws Exception;
	//조회
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception;
	//세부조회
	public ModelAndView detail(HttpServletRequest request,HttpServletResponse response) throws Exception;
	//수정
	public String modify(HttpServletRequest request,HttpServletResponse response) throws Exception;
	//삭제
	public String delete(HttpServletRequest request,HttpServletResponse response) throws Exception;
	//등록 폼
	public String writeForm(HttpServletRequest request,HttpServletResponse response) throws Exception;
	//수정 폼
	public ModelAndView modifyForm(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
