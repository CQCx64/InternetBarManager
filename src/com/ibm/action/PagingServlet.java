package com.ibm.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.dao.IUserDao;
import com.ibm.entity.Paging;
import com.ibm.entity.User;
import com.ibm.impl.UserDaoImpl;
@WebServlet(name="pagedo",urlPatterns="/pagedo")
public class PagingServlet extends HttpServlet {
	IUserDao ud = new UserDaoImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		HttpSession hs = req.getSession();
		List<User> users = (List<User>) hs.getAttribute("users");
		int page = 0;
        //得到传过来的当前页
        String str_page= req.getParameter("page");
        Paging paging=new Paging();
        paging.setList(users);//从数据库得到数据存入的list集合
        paging.setCount();//数据总数
        paging.setPagesize(12);//一个页面的数据多少条
        paging.setPagenumber();//总的页面数
        paging.setEndpage();//最后一页
        paging.setIndexpage(1);//第一页
        if (str_page!=null) {
            //将页转换整型判断其大小
            int pag=Integer.parseInt(str_page);
            //当大于零，将传过来的pag值赋给当前页page
            if (pag>=0) {
                page=pag;
                //如果小于最大值时则，将其传过来的值减1在赋值给当前页，让其一直在最后一页
                if (pag>(paging.getPagenumber()-1)) {
                    page=pag-1;
                }
            }
        }
        paging.setPage(page);//最终确认当前页
        List<User> user_page =new ArrayList<>();
        //将当前页的值传给新的list_page集合中，list集合是全部数据综合，用i调用其中的几条数据给list_page
        for (int i = paging.getPage()*paging.getPagesize(); i <(paging.getPage()+1)*paging.getPagesize()&&i<users.size(); i++) {
            user_page.add(users.get(i));
        }
        hs.setAttribute("paging", paging);
        hs.setAttribute("user_page", user_page);
        
        resp.sendRedirect("/InternetBarManager/pages/User.jsp");
	}
}	
