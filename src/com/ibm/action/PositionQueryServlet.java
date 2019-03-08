package com.ibm.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IPosDao;
import com.ibm.entity.Pos;
import com.ibm.impl.PosDaoImpl;
@WebServlet(name="pos",urlPatterns="/pos")
public class PositionQueryServlet extends HttpServlet {
	IPosDao pd = new PosDaoImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		try {
			List<Pos> poss = pd.selectPos();
			HttpSession hs = req.getSession();
			hs.setAttribute("pos", poss);
			resp.sendRedirect("/InternetBarManager/pages/Position.jsp");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
