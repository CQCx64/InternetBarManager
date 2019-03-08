package com.ibm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IUserDao;
import com.ibm.entity.User;
import com.ibm.impl.UserDaoImpl;
@WebServlet(name="usermodifypre",urlPatterns="/usermodifypre")
public class UserModifyPreServlet extends HttpServlet {
		IUserDao ud = new UserDaoImpl();
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO 自动生成的方法存根
			String userid = req.getParameter("userid");
			
			try {
				User user = ud.selectUserByID(Integer.parseInt(userid));
				HttpSession hs = req.getSession();
				hs.setAttribute("userModify", user);
				resp.sendRedirect("/InternetBarManager/pages/UserModify.jsp");
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	
}
