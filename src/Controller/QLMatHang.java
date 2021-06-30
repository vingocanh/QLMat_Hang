package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Control.Connect;
import Models.MatHang;

/**
 * Servlet implementation class QLMatHang
 */
//@WebServlet("/QLMatHang")
@WebServlet(urlPatterns = {"/", "/create", "/edit", "/delete"})
public class QLMatHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connect conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QLMatHang() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	conn = new Connect();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String luaChon = request.getServletPath();
		switch (luaChon) {
//		Thêm vào csdl
		case "/themCB":
			themMatHang(request, response);
			break;
//		Chuyển đến form thêm
		case "/create":
			newForm(request, response);
			break;
		default:
			danhSach(request, response);
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void newForm(HttpServletRequest request, HttpServletResponse response){
		try
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(".jsp");
			requestDispatcher.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void themMatHang(HttpServletRequest request, HttpServletResponse response){
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void editForm(HttpServletRequest request, HttpServletResponse response){
		try
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(".jsp");
			requestDispatcher.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void suaMatHang(HttpServletRequest request, HttpServletResponse response){
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private void xoaMatHang(HttpServletRequest request, HttpServletResponse response){
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private void danhSach(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<MatHang> arrayList = conn.danhSachMatHang();
			request.setAttribute("matHang", arrayList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("danhSach.jsp");
			requestDispatcher.forward(request, response);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
