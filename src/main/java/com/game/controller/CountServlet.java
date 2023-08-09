package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/count/*")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countString = request.getParameter("cnt");
		int count = Integer.parseInt(countString);
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	    response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		try {
			Thread.sleep(count*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(count);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
