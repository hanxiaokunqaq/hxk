package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.FinancingProduct;
import service.FinancingProductService;
import service.impl.FinancingProductServiceImpl;

/**
 * Servlet implementation class ToUpdateServlet
 */
@WebServlet("/toUpdate.do")
public class ToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FinancingProductService financingProductService = new FinancingProductServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FinancingProduct financingProduct = new FinancingProduct();
		financingProduct.setId(request.getParameter("id"));
		request.setAttribute("financingProduct", financingProductService.findAll(financingProduct).get(0));
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
