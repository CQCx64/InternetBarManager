package com.ibm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.ibm.dao.IPosDao;
import com.ibm.entity.Pos;
import com.ibm.impl.PosDaoImpl;

@WebServlet(name = "posmodify", urlPatterns = "/posmodify")
public class PositionModifyServlet extends HttpServlet {
	IPosDao pd = new PosDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String no = req.getParameter("posno");
		JSONObject json = new JSONObject();
		try {
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			Pos pos = pd.selectPosByID(Integer.parseInt(no));
			json.put("id", pos.getId());
			json.put("name", pos.getName());
			json.put("price", pos.getPrice());
			json.put("cpu", pos.getCpu());
			json.put("board", pos.getBoard());
			json.put("graphics", pos.getGraphics());
			json.put("memory", pos.getMemory());
			json.put("sata", pos.getSata());
			json.put("ssd", pos.getSsd());
			json.put("monitor", pos.getMonitor());
			resp.setContentType("application/json; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println(json);
			out.close();

		} catch (NumberFormatException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		
		try {
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			String id = req.getParameter("posid");
			String name = req.getParameter("posname");
			String price = req.getParameter("posprice");
			String cpu = req.getParameter("poscpu");
			String board = req.getParameter("posboard");
			String graphics = req.getParameter("posgraphics");
			String sata = req.getParameter("possata");
			String ssd = req.getParameter("posssd");
			String memory = req.getParameter("posmemory");
			String monitor = req.getParameter("posmonitor");
			Pos pos;
			pos  = new Pos(Integer.parseInt(id), name, Integer.parseInt(price), cpu, board, graphics, memory, sata, ssd, monitor);
			pd.updatePos(pos);
			resp.getWriter().write("<script>alert('修改成功！');window.location.href='/InternetBarManager/pos'</script>");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			resp.getWriter().write("<script>alert('修改失败！');window.location.href='/InternetBarManager/pos'</script>");
			e.printStackTrace();
		}
				
	}
}
