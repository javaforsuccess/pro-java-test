package com.pratap.ex.jms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pratap.ex.jms.db.MyJmsEnv;

public class SubmitDataServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msgId = req.getParameter("msgID").trim();
		int msgPriority = Integer.parseInt(req.getParameter("msgPriority").trim());
		String queueName = req.getParameter("queueName");
		String msgBody = req.getParameter("msgBody");
		MyJmsEnv myJmsEnv = MyJmsEnv.getMyJmsEnv();
		String queueAndTableName="MyJmsQueueTable";
		myJmsEnv.jmsEnvSetup(queueAndTableName);
		myJmsEnv.sendMessage(queueAndTableName, msgId, msgPriority, queueName, msgBody);
		RequestDispatcher rd = req.getRequestDispatcher("/successpage.jsp");
		rd.forward(req, resp);
	}
}
