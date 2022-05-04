package com.project.board.mvc.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.board.mvc.service.BoardPage;
import com.project.board.mvc.service.BoardService;
import com.project.board.mvc.service.CommentService;
import com.project.board.mvc.vo.BoardVO;
import com.project.board.mvc.vo.CommentVO;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {
	@Autowired
	private BoardService boardService;

	@Autowired
	private CommentService commentService;
	@Override
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> boardMap = new HashMap();
		Enumeration en = request.getParameterNames();
		while(en.hasMoreElements()) {
			String name = (String)en.nextElement();
			String value = request.getParameter(name);
			boardMap.put(name, value);
			System.out.println("name="+name);
			System.out.println("value="+value);
		}
		boardService.write(boardMap);
		System.out.println("controller의 boardMap="+boardMap);
		return null;
	}

	@Override
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String strNo = request.getParameter("pageNo");
		int pageNo = 1;
		if(strNo != null) {
			pageNo=Integer.parseInt(strNo);
		}
		BoardPage boardPage = boardService.list(pageNo);
		System.out.println("controller list의 pageNo="+pageNo);
		System.out.println("controller list의 boardPage="+boardPage);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardList");
		mav.addObject("eduPage",boardPage);
		return mav;
	}

	@Override
	@RequestMapping("/detail")
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO boardVO = boardService.detail(no);
		CommentVO commentVO =commentService.view(no);
		ModelAndView mv = new ModelAndView();
		System.out.println("controller의boardVO="+boardVO);
		System.out.println("boardController의commentVO="+commentVO);
		mv.addObject("boardVO",boardVO);
		mv.addObject("comment",commentVO);
		mv.setViewName("detail1");
		return mv;
	}

	@Override
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> boardMap = new HashMap();
		Enumeration en = request.getParameterNames();
		while(en.hasMoreElements()) {
			String name = (String)en.nextElement();
			String value = request.getParameter(name);
			boardMap.put(name, value);
		}
		System.out.println("controllerModify의 boardMap="+boardMap);
		boardService.modify(boardMap);
		return null;
	}

	@Override
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		boardService.delete(no);
		return null;
	}
	
	@Override
	@RequestMapping(value = "/writeForm")
	public String writeForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "writerForm1";
	}

	@Override
	@RequestMapping(value = "/modifyForm")
	public ModelAndView modifyForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv = new ModelAndView();
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO boardVO = boardService.detail(no);
		mv.addObject("boardVO",boardVO);
		mv.setViewName("modifyForm");
		return mv;
	}

}
