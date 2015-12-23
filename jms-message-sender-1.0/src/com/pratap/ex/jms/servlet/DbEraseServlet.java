package com.pratap.ex.jms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pratap.ex.jms.db.MyJmsEnv;

public class DbEraseServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyJmsEnv myJmsEnv = MyJmsEnv.getMyJmsEnv();
		String queueAndTableName="MyJmsQueueTable";
		myJmsEnv.jmsEnvDest(queueAndTableName);
		RequestDispatcher rd = req.getRequestDispatcher("/destroypage.jsp");
		rd.forward(req, resp);
	}
}
