package com.ibm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IAdminDao;
import com.ibm.entity.Admin;
import com.ibm.impl.AdminDaoImpl;
@WebServlet(name="login",urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	
	IAdminDao ad = new AdminDaoImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		
		String name = req.getParameter("txtAdmin");
		String password = req.getParameter("password");
		
		try {
			Admin admin = ad.selectAdminByName(name);		//按name查询管理员用户
			if (admin != null) {			//存在用户名为name的用户
				if (admin.getPassword().equals(password)) {			//密码正确
					//System.out.println("登陆成功");
					HttpSession hs = req.getSession();
					hs.setAttribute("adminInfo", admin);
					resp.sendRedirect("/InternetBarManager/index");
				}
				else{
					//System.out.println("密码错误");
					resp.sendRedirect("/InternetBarManager/Login.jsp?info=1");
				}
			}
			else {
				//System.out.println("无此用户");
				resp.sendRedirect("/InternetBarManager/Login.jsp?info=2");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
