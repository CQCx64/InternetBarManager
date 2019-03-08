package com.ibm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.dao.IComDao;
import com.ibm.dao.IUserDao;
import com.ibm.entity.Com;
import com.ibm.entity.User;
import com.ibm.impl.ComDaoImpl;
import com.ibm.impl.UserDaoImpl;

@WebServlet(name = "fastpower", urlPatterns = "/fastpower")
public class ComFastPowerServlet extends HttpServlet {
	IUserDao ud = new UserDaoImpl();
	IComDao cd = new ComDaoImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		resp.setContentType("text/html;charset=UTF-8");
		String info = req.getParameter("info");
		try {
			if (info.equals("1")) { // 快速上机
				String uid = req.getParameter("txtUserId");
				if (uid == null || "".equals(uid.trim())) { // 输入为空
					resp.getWriter().write("<script>alert('请输入会员卡号！');window.location.href='/InternetBarManager/comquery'</script>");
				} else { // 输入不为空
					User u = ud.selectUserByID(Integer.parseInt(uid) - 10000); // 查询是否存在会员
					if (u == null) { // 会员不存在
						resp.getWriter().write("<script>alert('会员卡号错误！');window.location.href='/InternetBarManager/comquery'</script>");
					} else { // 会员存在
						Com c = cd.selectComByUID(Integer.parseInt(uid) - 10000); // 查询该会员是否已上机
						if (c != null) { // 已上机
							resp.getWriter().write("<script>alert('该会员已上机！');window.location.href='/InternetBarManager/comquery'</script>");
						} else { // 没有上机
							int money = ud.getUserMoneyByID(Integer.parseInt(uid)-10000);
							ud.changeUserCanUseByID((Integer.parseInt(uid)-10000), 1);//改变为可自主上机状态
							ud.updateLastDate((Integer.parseInt(uid)-10000));	//更新上机时间
							resp.getWriter().write("<script>alert('"+uid+"号会员已可自主上机！余额："+money+"');window.location.href='/InternetBarManager/comquery'</script>");
						}
					}
				}

			}
			if (info.equals("2")) { // 快速下机
				String uid = req.getParameter("txtUserId");
				if (uid == null || "".equals(uid.trim())) { // 输入为空
					resp.getWriter().write("<script>alert('请输入会员卡号！');window.location.href='/InternetBarManager/comquery'</script>");
				} else { // 输入不为空
					User u = ud.selectUserByID(Integer.parseInt(uid) - 10000); // 查询是否存在会员
					if (u == null) { // 会员不存在
						resp.getWriter().write("<script>alert('会员卡号错误！');window.location.href='/InternetBarManager/comquery'</script>");
					} else { // 会员存在
						ud.changeUserCanUseByID((Integer.parseInt(uid)-10000), 0);//改变为不可上机状态
						Com c = cd.selectComByUID(Integer.parseInt(uid) - 10000); // 查询该会员是否已上机
						if (c == null) { // 会员没有上机
							resp.getWriter().write("<script>alert('该会员没有上机！');window.location.href='/InternetBarManager/comquery'</script>");
						} else { // 开始下机
							int money = ud.getUserMoneyByID(Integer.parseInt(uid)-10000);
							cd.powerOffComFast(Integer.parseInt(uid)-10000);
							resp.getWriter().write("<script>alert('"+uid+"号会员下机成功！余额："+money+"，现在"+c.getId()+"号机空闲');window.location.href='/InternetBarManager/comquery'</script>");
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
