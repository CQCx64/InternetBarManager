package com.ibm.useraction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IComDao;
import com.ibm.dao.IUserDao;
import com.ibm.entity.User;
import com.ibm.impl.ComDaoImpl;
import com.ibm.impl.UserDaoImpl;
@WebServlet(name="checkout",urlPatterns="/checkout")
public class CheckOutServlet extends HttpServlet {
	IUserDao ud = new UserDaoImpl();
	IComDao cd = new ComDaoImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String money = req.getParameter("moneyall");
		String uid = req.getParameter("uid");
		String cid = req.getParameter("cid");
		try {
			User user = ud.selectUserByID(Integer.parseInt(uid));
			int oldMoney = user.getMoney();
			int usedMoney = Integer.parseInt(money);
			int newMoney = oldMoney-usedMoney;
			if (newMoney<0) {	//判断余额是否够
				resp.getWriter().write(
						"<script>alert('下机失败！余额不足，请先充值！');window.location.href='/InternetBarManager/userpages/UserIndex.jsp'</script>");
			}
			else{
				ud.checkOutByID(Integer.parseInt(uid), usedMoney);	//更新余额
				ud.changeUserCanUseByID(Integer.parseInt(uid), 0);	//改变可上机信息
				cd.powerOffComFast(Integer.parseInt(uid));	//清空其他信息
				HttpSession hs = req.getSession();
				hs.invalidate();
				resp.getWriter().write(
						"<script>alert('下机成功！期待您下次光临');window.location.href='/InternetBarManager/userpages/UserIndex.jsp'</script>");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
