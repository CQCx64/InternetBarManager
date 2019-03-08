package com.ibm.useraction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
@WebServlet(name="call",urlPatterns="/call")
public class CallServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String cid = req.getParameter("cid");
		HttpSession hs = req.getSession();
		hs.setAttribute("callCom", cid);
		resp.getWriter().write(
				"<script>alert('呼叫成功！');window.location.href='/InternetBarManager/userpages/UserIndex.jsp'</script>");
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		JSONObject json = new JSONObject();
		try {
			HttpSession hs = req.getSession();
			Object cid = hs.getAttribute("callCom");
			
			// 添加到json中
			json.put("cid", cid);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("application/json; charset=utf-8"); 
		PrintWriter out = resp.getWriter();  
		out.println(json);
        out.close();
	}
}
