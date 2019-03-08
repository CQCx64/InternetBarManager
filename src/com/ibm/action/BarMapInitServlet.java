package com.ibm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ibm.dao.IBarDao;
import com.ibm.entity.Bar;
import com.ibm.impl.BarDaoImpl;
@WebServlet(name="map",urlPatterns="/map")
public class BarMapInitServlet extends HttpServlet {
	IBarDao bd = new BarDaoImpl();
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO 自动生成的方法存根
	try {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		List<Bar> bars = bd.selectBar();
		JSONObject json = new JSONObject();
		JSONArray array=new JSONArray();
		for (int i = 0; i < bars.size(); i++) {
			JSONObject temp = new JSONObject();
			temp.put("id", bars.get(i).getBid());
			temp.put("name", bars.get(i).getBname());
			temp.put("address", bars.get(i).getBaddress());
			temp.put("x", bars.get(i).getX());
			temp.put("y", bars.get(i).getY());
			array.put(i,temp);
		}
		json.put("bars", array);
		PrintWriter out=resp.getWriter();
        out.println(json);
        out.close();
        System.out.println(json);
	} catch (Exception e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
}
}
