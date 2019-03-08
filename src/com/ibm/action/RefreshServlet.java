package com.ibm.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IUserDao;
import com.ibm.entity.User;
import com.ibm.impl.UserDaoImpl;
@WebServlet(name="refresh",urlPatterns="/refresh")
public class RefreshServlet extends HttpServlet{
	IUserDao ud = new UserDaoImpl();
	int uid = 0;
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		HttpSession hs = req.getSession();
		hs.setAttribute("queryID", 0);
		hs.setAttribute("queryName", null);
		try {
			
			List<User> users = ud.selectUserByCondition(0, null);
			hs.setAttribute("users", users);
			resp.sendRedirect("/InternetBarManager/pagedo");
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
