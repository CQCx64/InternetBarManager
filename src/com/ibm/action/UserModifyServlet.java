package com.ibm.action;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.dao.IUserDao;
import com.ibm.entity.User;
import com.ibm.impl.UserDaoImpl;

@WebServlet(name="usermodify",urlPatterns="/usermodify")
public class UserModifyServlet extends HttpServlet {
	IUserDao ud = new UserDaoImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("userID");
		String name = req.getParameter("userName");
		String sex = req.getParameter("sex");
		String age = req.getParameter("age");
		String registerDate = req.getParameter("registerDate");
		String IDNumber = req.getParameter("IDNumber");
		String phone = req.getParameter("phone");
		String money = req.getParameter("money");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		User user;
		
		try {
			user = new User(Integer.parseInt(id)-10000,name, sex, Integer.parseInt(age), sdf.parse(registerDate), IDNumber, phone, Integer.parseInt(money));
			ud.updateUser(user);
			resp.getWriter().write("<script>alert('修改成功！');window.location.href='/InternetBarManager/userquery'</script>");
			//resp.sendRedirect("userquery");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			resp.getWriter().write("<script>alert('修改失败！');window.location.href='/InternetBarManager/userquery'</script>");
			//resp.sendRedirect("userquery");
			e.printStackTrace();
		}
	}
}
