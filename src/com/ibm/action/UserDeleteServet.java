package com.ibm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.dao.IComDao;
import com.ibm.dao.IUserDao;
import com.ibm.entity.Com;
import com.ibm.impl.ComDaoImpl;
import com.ibm.impl.UserDaoImpl;
@WebServlet(name="userdelete",urlPatterns="/userdelete")
public class UserDeleteServet extends HttpServlet {
	IUserDao ud = new UserDaoImpl();
	IComDao cd = new ComDaoImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		resp.setContentType("text/html;charset=UTF-8");
		String userid = req.getParameter("userid");
		
		try {
			Com com = cd.selectComByUID(Integer.parseInt(userid));			//判断要删除的用户是否在上机
			if (com == null) {			//不在上机
				ud.deleteUser(Integer.parseInt(userid));
				resp.getWriter().write("<script>alert('删除成功！');window.location.href='/InternetBarManager/userquery'</script>");
			}else {
				resp.getWriter().write("<script>alert('操作失败！该用户正在使用机器，无法删除！');window.location.href='/InternetBarManager/userquery'</script>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
