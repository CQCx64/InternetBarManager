package com.ibm.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IComDao;
import com.ibm.entity.Com;
import com.ibm.impl.ComDaoImpl;

@WebServlet(name="comquery",urlPatterns="/comquery")
public class ComQueryServlet extends HttpServlet {
	IComDao cd = new ComDaoImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("UTF-8");
		
		try {
			List<Com> coms1 = cd.selectCom(1);
			List<Com> coms2 = cd.selectCom(2);
			List<Com> coms3 = cd.selectCom(3);
			List<Com> coms4 = cd.selectCom(4);
			HttpSession hs = req.getSession();
			hs.setAttribute("coms1", coms1);
			hs.setAttribute("coms2", coms2);
			hs.setAttribute("coms3", coms3);
			hs.setAttribute("coms4", coms4);
			resp.sendRedirect("/InternetBarManager/pages/Computer.jsp");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			resp.getWriter().write("<script>alert('操作失败！');window.location.href='/InternetBarManager/comquery'</script>");
			e.printStackTrace();
		}
	}
}
