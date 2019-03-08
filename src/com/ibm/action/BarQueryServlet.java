package com.ibm.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IBarDao;
import com.ibm.entity.Bar;
import com.ibm.impl.BarDaoImpl;
@WebServlet(name="bar",urlPatterns="/bar")
public class BarQueryServlet extends HttpServlet {
	IBarDao bd = new BarDaoImpl();
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO 自动生成的方法存根
	resp.setContentType("text/html;charset=UTF-8");
	req.setCharacterEncoding("UTF-8");
	try {
		List<Bar> bars = bd.selectBar();
		HttpSession hs = req.getSession();
		hs.setAttribute("allbar", bars);
		resp.sendRedirect("/InternetBarManager/pages/Bars.jsp");
	} catch (Exception e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
}
}
