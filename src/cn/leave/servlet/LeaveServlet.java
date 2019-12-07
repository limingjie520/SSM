package cn.leave.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;

import cn.leave.pojo.LeaveRecords;
import cn.leave.pojo.Page;
import cn.leave.service.LeaveService;
import cn.leave.service.LeaveServiceImpl;

/**
 * Servlet implementation class LeaveServlet
 */
@WebServlet("/LeaveServlet")
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String  oper = request.getParameter("oper");
		LeaveService lsc=new LeaveServiceImpl();
		if(("sel").equals(oper)) {
		
			//首先得到总记录
			int totalCount=lsc.count();
			
			//得到页面的当前页码
			
			Integer pageno=1;
			if(!StringUtils.isNullOrEmpty(request.getParameter("pageno"))) {
				pageno=Integer.valueOf(request.getParameter("pageno"));
			}
			//创建Page对象，设置相关参数
			Page page=new Page();
			page.setCurrPageNo(pageno);
			page.setPageSize(4);
			page.setTotalCount(totalCount);
			
			//分页
			Integer from=(page.getCurrPageNo()-1)*page.getPageSize();//位置偏移量，从0开始
			
			List<LeaveRecords> leaveList=lsc.fyselect(from, /*page.getTotalPageCount()*/page.getPageSize());
			
			
			//保存
			request.setAttribute("page", page);
			request.setAttribute("list", leaveList);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			

			
		}else if(("add").equals(oper)){
			
			
			PrintWriter out = response.getWriter();
			String name=request.getParameter("name");
			String time=request.getParameter("time");
			String qjyy=request.getParameter("qjyy");
			LeaveRecords  leaa= new LeaveRecords(name,time,qjyy);
			
			
		
			     int num=lsc.addLea(leaa);
			     
			     if(num>0) {
			    	 out.print("<script>alert('添加记录成功！');location.href='index.jsp'</script>");

			     }else {
			    	 out.print("<script>alert('添加记录失败！');location.href='addLea.jsp'</script>");
			     }
			
			
			
			
		}else if(("del").equals(oper)){
			
			  PrintWriter out = response.getWriter();
			  String  id = request.getParameter("id");
			 int idd=0;
			 if(id!=null) {
				 idd=Integer.parseInt(id);
			 }
			
			 int num= lsc.delLea(idd);
			  
			 String jg=null;
			 if(num>0) {
			jg="删除成功！";
			 }else {
			jg="删除失败！";
			 }
			out.print(jg);
			/*out.flush();
			out.close();*/
		}
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
