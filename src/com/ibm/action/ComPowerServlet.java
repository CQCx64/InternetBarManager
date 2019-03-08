package com.ibm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IComDao;
import com.ibm.dao.IUserDao;
import com.ibm.entity.Com;
import com.ibm.entity.User;
import com.ibm.impl.ComDaoImpl;
import com.ibm.impl.UserDaoImpl;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
@WebServlet(name="power",urlPatterns="/power")
public class ComPowerServlet extends HttpServlet {
	IComDao cd = new ComDaoImpl();
	IUserDao ud = new UserDaoImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		resp.setContentType("text/html;charset=UTF-8");
		String cid = req.getParameter("cid");
		String info = req.getParameter("info");
		try {
			//Com com = cd.selectComByID(Integer.parseInt(cid));
			
			if (info.equals("1")) {		//下机操作
				Com com = cd.selectComByID(Integer.parseInt(cid));
				ud.changeUserCanUseByID(com.getUser().getId(), 0);	//改变可上机状态
				cd.powerOffCom(Integer.parseInt(cid));
				cd.setStartTime(Integer.parseInt(cid),0);
				resp.sendRedirect("/InternetBarManager/comquery");
			}
			
			if (info.equals("2")) {		//上机操作
				String uid = req.getParameter("userid_"+cid);
				if (uid==null || "".equals(uid.trim())) {		//输入为空
					resp.getWriter().write("<script>alert('请输入会员卡号！');window.location.href='/InternetBarManager/comquery'</script>");
				}
				else {					//输入不为空
					User u = ud.selectUserByID(Integer.parseInt(uid)-10000);	//查询是否存在会员
					if (u==null) {		//会员不存在
						resp.getWriter().write("<script>alert('会员卡号错误！');window.location.href='/InternetBarManager/comquery'</script>");
					}
					else {				//会员存在
						Com c = cd.selectComByUID(Integer.parseInt(uid)-10000);	//查询该会员是否已上机
						if (c!=null) {							//已上机
							resp.getWriter().write("<script>alert('该会员已上机！');window.location.href='/InternetBarManager/comquery'</script>");
						}
						else {			//没有上机
							cd.powerOnCom(Integer.parseInt(cid), Integer.parseInt(uid)-10000);
							cd.setStartTime(Integer.parseInt(cid),1);
							int money = ud.getUserMoneyByID(Integer.parseInt(uid)-10000);
							ud.changeUserCanUseByID((Integer.parseInt(uid)-10000), 1);
							ud.updateLastDate((Integer.parseInt(uid)-10000));
							resp.getWriter().write("<script>alert('上机成功！余额："+money+"');window.location.href='/InternetBarManager/comquery'</script>");
						}	
					}
				}
				
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			resp.getWriter().write("<script>alert('操作失败！');window.location.href='/InternetBarManager/comquery'</script>");
			e.printStackTrace();
		}
	}
}
