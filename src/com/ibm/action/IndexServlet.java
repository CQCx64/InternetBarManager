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
import com.ibm.dao.INoteDao;
import com.ibm.dao.IUserDao;
import com.ibm.entity.Note;
import com.ibm.impl.ComDaoImpl;
import com.ibm.impl.NoteDaoImpl;
import com.ibm.impl.UserDaoImpl;
@WebServlet(name="index",urlPatterns="/index")

public class IndexServlet extends HttpServlet {
	IUserDao ud = new UserDaoImpl();
	IComDao cd = new ComDaoImpl();
	INoteDao nd = new NoteDaoImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		try {
			int unum = ud.getUserNum();
			int cnum = cd.getComOnlineNum();
			List<Note> notes = nd.selectNoteByType(1);
			HttpSession hs = req.getSession();
			hs.setAttribute("unum", unum);
			hs.setAttribute("cnum", cnum);
			hs.setAttribute("adminnnotes", notes);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			
			e.printStackTrace();
		}
		resp.sendRedirect("/InternetBarManager/pages/Index.jsp");
	}
}
