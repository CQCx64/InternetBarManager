package com.ibm.useraction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IBarDao;
import com.ibm.dao.IComDao;
import com.ibm.dao.INoteDao;
import com.ibm.dao.IUserDao;
import com.ibm.entity.Bar;
import com.ibm.entity.Com;
import com.ibm.entity.Note;
import com.ibm.impl.BarDaoImpl;
import com.ibm.impl.ComDaoImpl;
import com.ibm.impl.NoteDaoImpl;
import com.ibm.impl.UserDaoImpl;
@WebServlet(name="preUserLogin",urlPatterns="/preUserLogin")
public class PreUserLogin extends HttpServlet {
	IUserDao ud = new UserDaoImpl();
	IComDao cd = new ComDaoImpl();
	IBarDao bd = new BarDaoImpl();
	INoteDao nd = new NoteDaoImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		try {
			int unum = ud.getUserNum();
			int cnum = cd.getComOnlineNum();
			Bar bar = bd.selectBarByID(1);
			List<Com> coms = cd.selectComByStatus(0);
			List<Note> notes = nd.selectNoteByType(2);
			HttpSession hs = req.getSession();
//			req.setAttribute("usernum", unum);
//			req.setAttribute("comnum", cnum);
			hs.setAttribute("usernum", unum);
			hs.setAttribute("comnum", cnum);
			hs.setAttribute("usernotes", notes);
			hs.setAttribute("barInfo", bar);
			hs.setAttribute("comNotUse", coms);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			
			e.printStackTrace();
		}
		//req.getRequestDispatcher("/UserLogin.jsp").forward(req, resp);
	}
}
