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


@WebServlet("/show.do")
public class ShowFinancingProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FinancingProductService financingProductService = new FinancingProductServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFinancingProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FinancingProduct financingProduct = new FinancingProduct();
		financingProduct.setId(request.getParameter("id"));
		try{
			financingProduct.setRisk(Integer.valueOf(request.getParameter("risk")));
		} catch(NumberFormatException e) {
			financingProduct.setRisk(0);
		}
		request.setAttribute("financingProducts", financingProductService.findAll(financingProduct));
		request.getRequestDispatcher("show.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
