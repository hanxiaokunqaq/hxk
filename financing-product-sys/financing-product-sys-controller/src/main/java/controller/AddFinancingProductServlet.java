package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.FinancingProduct;
import service.FinancingProductService;
import service.impl.FinancingProductServiceImpl;

/**
 * Servlet implementation class AddFinancingProductServlet
 */
@WebServlet("/add.do")
public class AddFinancingProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FinancingProductService financingProductService = new FinancingProductServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFinancingProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FinancingProduct financingProduct = new FinancingProduct();
		financingProduct.setId(request.getParameter("id"));
		try{
			financingProduct.setRisk(Integer.valueOf(request.getParameter("risk")));
		} catch(NumberFormatException e) {
			financingProduct.setRisk(0);
		}
		financingProduct.setIncome(request.getParameter("income"));
		financingProduct.setSaleStarting(Date.valueOf(request.getParameter("saleStarting")));
		financingProduct.setSaleEnd(Date.valueOf(request.getParameter("saleEnd")));
		financingProduct.setEnd(Date.valueOf(request.getParameter("end")));
		
		financingProductService.save(financingProduct);
		response.sendRedirect("show.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
