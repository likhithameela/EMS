package com.employee.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.bean.LeaveApproval;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LeaveApprovalServlet
 */
@WebServlet("/LeaveApprovalServlet")
public class LeaveApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN SERVLET");

		String appid = request.getParameter("appid");
		String rejid = request.getParameter("rejid");
		
		LeaveApproval la = new LeaveApproval();
		
		if (null != request.getParameter("appid")) {
			System.out.println("In Sevlet , In IF condition");
			System.out.println(appid);
			la.Approve(appid);
			la.setAppid(appid);
		}else {
			System.out.println("In secvlet , in ELSE condition");
			la.Reject(rejid);	
			la.setRejid(rejid);
		}
        
		//la.saveData();
		
		RequestDispatcher rd = request.getRequestDispatcher("LeaveApproval.jsp");
		rd.forward(request, response);

	}

}
