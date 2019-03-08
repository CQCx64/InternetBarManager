package com.ibm.useraction;

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

@WebServlet(name = "recharge", urlPatterns = "/recharge")
public class RechargeServlet extends HttpServlet {
	IUserDao ud = new UserDaoImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String money = req.getParameter("money");
		if (money.equals("any")) {
			money = req.getParameter("moneyany");
		}
		String uid = req.getParameter("uid");
		try {
			ud.rechargeByID(Integer.parseInt(uid),Integer.parseInt(money));
			User user = ud.selectUserByID(Integer.parseInt(uid));
			HttpSession hs = req.getSession();
			hs.setAttribute("userInfo", user);
			int newmoney = user.getMoney();
			resp.getWriter().write("<script>alert('1000" + uid + "号会员已充值成功！余额：" + newmoney
					+ "');window.location.href='/InternetBarManager/userpages/UserIndex.jsp'</script>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.getWriter().write(
					"<script>alert('充值失败');window.location.href='/InternetBarManager/userpages/UserIndex.jsp'</script>");
		}
	}
}
