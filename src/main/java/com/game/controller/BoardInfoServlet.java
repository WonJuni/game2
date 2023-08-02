package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.BoardInfoService;
import com.game.service.impl.BoardInfoServiceImpl;


@WebServlet("/board-info/*")
public class BoardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final BoardInfoService BOARD_INFO_SERVICE = new BoardInfoServiceImpl();   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		HttpSession session = request.getSession();
		Map<String, String> userInfo = (Map<String,String>)session.getAttribute("userInfo");
		System.out.println(userInfo.get("uiNum"));
		if("list".equals(cmd)) {
			if(session.getAttribute("userInfo") == null) {
				request.setAttribute("msg", "plz Login");
				request.setAttribute("url", "/");
				System.out.println(userInfo.get("uiNum"));
				CommonView.forwardMessage(request, response);
				return;
			}
			Map<String,String> searchMap = null;
			if (request.getParameter("searchtype") != null) {
				searchMap = new HashMap<>();
				searchMap.put("key", request.getParameter("searchtype"));
				searchMap.put("value", request.getParameter("searchStr"));
				request.setAttribute("boardInfoList",BOARD_INFO_SERVICE.boardInfoList(searchMap));
				System.out.println(BOARD_INFO_SERVICE.boardInfoList(searchMap));
			}
				request.setAttribute("boardInfoList",BOARD_INFO_SERVICE.boardInfoList(searchMap));
				System.out.println(BOARD_INFO_SERVICE.boardInfoList(searchMap));
			
		}else if ("view".equals(cmd)||"update".equals(cmd)) {
			System.out.println(userInfo.get("uiNum"));
			request.setAttribute("userInfo", userInfo);
			request.setAttribute("boardInfo", BOARD_INFO_SERVICE.boardInfo(request.getParameter("biNum")));
		}
		CommonView.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		HttpSession session = request.getSession();
		Map<String, String> userInfo = (Map<String,String>)session.getAttribute("userInfo");
		if("insert".equals(cmd)) {
			Map<String, String> boardInfo = new HashMap();
			boardInfo.put("biTitle", request.getParameter("biTitle"));
			boardInfo.put("biContent", request.getParameter("biContent"));
			boardInfo.put("uiNum", userInfo.get("uiNum"));
			request.setAttribute("msg", "Bad insert");
			request.setAttribute("url", "/board-info/list");
			if(BOARD_INFO_SERVICE.insertBoardInfo(boardInfo) == 1) {
				request.setAttribute("msg", "Nice insert");
				request.setAttribute("url", "/board-info/list");
			}
			
		}else if ("update".equals(cmd)) {
			Map<String, String> boardInfoMap = new HashMap();
			boardInfoMap.put("biTitle", request.getParameter("biTitle"));
			boardInfoMap.put("biContent", request.getParameter("biContent"));
			boardInfoMap.put("biNum", request.getParameter("biNum"));
			boardInfoMap.put("uiNum", userInfo.get("uiNum"));
			request.setAttribute("msg", "Bad insert");
			request.setAttribute("url", "/board-info/list");
			if(BOARD_INFO_SERVICE.updateBoardInfo(boardInfoMap) == 1) {
				request.setAttribute("msg", "Nice Update");
				request.setAttribute("url", "/board-info/list");
			}
		}else if ("delete".equals(cmd)) {
			request.setAttribute("msg", "Bad Delete");
			request.setAttribute("url", "/board-info/list");
			System.out.println(request.getParameter("biNum"));
			if(BOARD_INFO_SERVICE.deleteBoardInfo(request.getParameter("biNum")) == 1) {
				request.setAttribute("msg", "Nice Delete");
				request.setAttribute("url", "/board-info/list");
			}
		}
		CommonView.forwardMessage(request, response);
	}

}
