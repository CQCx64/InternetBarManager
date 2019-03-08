package com.ibm.useraction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IComDao;
import com.ibm.dao.IPosDao;
import com.ibm.dao.IUserDao;
import com.ibm.entity.Com;
import com.ibm.entity.Pos;
import com.ibm.entity.User;
import com.ibm.impl.ComDaoImpl;
import com.ibm.impl.PosDaoImpl;
import com.ibm.impl.UserDaoImpl;

@WebServlet(name = "userlogin", urlPatterns = "/userlogin")
public class UserLoginServlet extends HttpServlet {
	IUserDao ud = new UserDaoImpl();
	IComDao cd = new ComDaoImpl();
	IPosDao pd = new PosDaoImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String id = req.getParameter("txtID");
		String password = req.getParameter("password");
		String comSelected = req.getParameter("comNotUse");

		try {
			User user = ud.selectUserByIDNumber(id); // 按身份证号查询用户
			if (user != null) { // 存在身份证号为id的用户
				int canuse = ud.getUserCanUseByIDNumber(id);
				if (canuse == 1) { // 有上机权限
					if (password.equals("123456")) { // 密码正确
						Com userCom = cd.selectComByUID(user.getId());
						if (userCom == null) { // 如果没有打开过一个机器
							if (comSelected.equals("")) { // 选择打开哪台机器
								resp.getWriter().write(
										"<script>alert('请选择机器！');window.location.href='/InternetBarManager/UserLogin.jsp'</script>");
							} else {
								// System.out.println("登陆成功");
								// 改变机器信息
								cd.changeComPowerStatus(Integer.parseInt(comSelected), user, 1);
								// 更新用户访问日期
								ud.updateLastDate(user.getId());
								userCom = cd.selectComByID(Integer.parseInt(comSelected));
								int posid = cd.getComPosIDByID(Integer.parseInt(comSelected));
								Pos pos = pd.selectPosByID(posid);
								HttpSession hs = req.getSession();
								hs.setAttribute("userInfo", user);
								hs.setAttribute("userCom", userCom);
								hs.setAttribute("userPos", pos);

								resp.getWriter().write(
										"<script>alert('上机成功！');window.location.href='/InternetBarManager/app'</script>");
							}
						} else { // 如果打开过一个机器
							int posid = cd.getComPosIDByID(userCom.getId());
							Pos pos = pd.selectPosByID(posid);
							HttpSession hs = req.getSession();
							hs.setAttribute("userInfo", user);
							hs.setAttribute("userCom", userCom);
							hs.setAttribute("userPos", pos);
							resp.getWriter().write(
									"<script>alert('上机成功！');window.location.href='/InternetBarManager/app'</script>");
						}

					} else {
						// System.out.println("密码错误");
						resp.sendRedirect("/InternetBarManager/UserLogin.jsp?info=1");
					}
				} else { // 没有上机权限
					// System.out.println("没有上机权限");
					resp.sendRedirect("/InternetBarManager/UserLogin.jsp?info=3");
				}

			} else {
				// System.out.println("无此用户");
				resp.sendRedirect("/InternetBarManager/UserLogin.jsp?info=2");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
