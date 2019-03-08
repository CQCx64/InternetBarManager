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

@WebServlet(name = "userquery", urlPatterns = "/userquery")
public class UserQueryServlet extends HttpServlet {
	IUserDao ud = new UserDaoImpl();
	int uid = 0;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String name = req.getParameter("txtUserName");
		String id = req.getParameter("txtUserId");
		HttpSession hs = req.getSession();
		hs.setAttribute("queryID", id);
		hs.setAttribute("queryName", name);
		try {
			if ((id != null && !"".equals(id.trim())) || (name != null && !"".equals(name.trim()))) {
				if (id != null && !"".equals(id.trim())) {

					uid = Integer.parseInt(id) - 10000;

					List<User> users = ud.selectUserByCondition(uid, name);
					hs.setAttribute("users", users);
					resp.getWriter().write("<script>window.location.href='/InternetBarManager/pagedo'</script>");

				} else {

					List<User> users = ud.selectUserByCondition(0, name);
					hs.setAttribute("users", users);
					resp.getWriter().write("<script>window.location.href='/InternetBarManager/pagedo'</script>");

				}
			} else {

				List<User> users = ud.selectUserByCondition(0, null);
				hs.setAttribute("users", users);
				resp.getWriter().write("<script>window.location.href='/InternetBarManager/pagedo'</script>");

			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			List<User> users;
			try {
				users = ud.selectUserByCondition(0, name);
				hs.setAttribute("users", users);
				resp.getWriter().write("<script>alert('请输入正确的查询目标！');window.location.href='/InternetBarManager/pagedo'</script>");
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			
		}

	}

}
