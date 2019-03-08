package com.ibm.useraction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IAppDao;
import com.ibm.entity.App;
import com.ibm.impl.AppDaoImpl;

@WebServlet(name = "app", urlPatterns = "/app")
public class AppLoadServlet extends HttpServlet {
	IAppDao ad = new AppDaoImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		try {
			List<App> apps1 = ad.selectByGroup(1);
			List<App> apps2 = ad.selectByGroup(2);
			HttpSession hs = req.getSession();
			hs.setAttribute("apps1", apps1);
			hs.setAttribute("apps2", apps2);
			resp.getWriter().write("<script>window.location.href='/InternetBarManager/userpages/UserIndex.jsp'</script>");
		} catch (Exception e) {
			resp.getWriter().write("<script>alert('app读取失败！');window.location.href='/InternetBarManager/UserLogin.jsp'</script>");
			e.printStackTrace();
		}
		
	}
}
