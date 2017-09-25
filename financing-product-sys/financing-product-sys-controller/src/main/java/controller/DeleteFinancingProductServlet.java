package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FinancingProductService;
import service.impl.FinancingProductServiceImpl;

/**
 * Servlet implementation class DeleteFinancingProductServlet
 */
@WebServlet("/delete.do")
public class DeleteFinancingProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FinancingProductService financingProductService = new FinancingProductServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteFinancingProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		financingProductService.delete(request.getParameter("id"));
		response.sendRedirect("show.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
