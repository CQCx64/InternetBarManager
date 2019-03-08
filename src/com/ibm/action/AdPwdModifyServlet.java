package com.ibm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.dao.IAdminDao;
import com.ibm.entity.Admin;
import com.ibm.impl.AdminDaoImpl;
@WebServlet(name="pwdmodify",urlPatterns="/pwdmodify")
public class AdPwdModifyServlet extends HttpServlet {
	IAdminDao ad = new AdminDaoImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String name = req.getParameter("adminName");
		String pwdo = req.getParameter("pwdOld");
		String pwd = req.getParameter("pwd");
		String pwdc = req.getParameter("pwdConfirm");
		try {
			Admin admin = ad.selectAdminByName(name);
			if (pwdo.equals(admin.getPassword())&&!pwdo.equals("")&&pwdo!=null) {		//如果输入了正确的旧密码
				if (pwd!=null&&!"".equals(pwd.trim())&&pwdc!=null&&!"".equals(pwdc.trim())&&pwd.equals(pwdc)) {		//输入的新密码不为空且确认密码正确
					ad.updateAdminPwd(pwd, admin.getId());
					resp.getWriter().write("<script>alert('修改成功！');window.location.href='/InternetBarManager/index'</script>");
				}
				else{
					resp.getWriter().write("<script>alert('请确定新密码不为空且输入了正确的确认密码！');window.location.href='/InternetBarManager/pages/AdPwdModify.jsp'</script>");
				}
			}
			else {			//旧密码输入错误
				resp.getWriter().write("<script>alert('旧密码输入错误！');window.location.href='/InternetBarManager/pages/AdPwdModify.jsp'</script>");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			resp.getWriter().write("<script>alert('修改失败！');window.location.href='/InternetBarManager/index'</script>");
			e.printStackTrace();
		}
		
		
		
		
	}
}
