package test.servlet.carl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sysa14.facade.carl.FacadeLocal;

/**
 * Servlet implementation class TestServletFour_Facade_ProductOrders
 */
@WebServlet("/TestServletFour_Facade_ProductOrders")
public class TestServletFour_Facade_ProductOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	FacadeLocal facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServletFour_Facade_ProductOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>TestServletFour_Carl</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");
		out.println("<h2>TestClientFour</h2>");
		
		//Test of facade/PrivateCustomerEAO
		out.print("<p>" + "Test (4 of 4) of Facade/PrivateCustomerEAO" + " ");		
		/*
		boolean result = facade.createProduct_Orders(4314, 8552, 20); 
		out.print("<p>" + "Test: facade.createProduct_Orders(exists)  result: "+ result+" ");

		boolean resultTwo = facade.createProduct_Orders(0000, 0000, 20); 
		out.print("<p>" + "Test: facade.createProduct_Orders(does not exist)  result: "+ resultTwo+" ");
		
		boolean result = facade.createProduct_Orders(4314, 7702, 10500); 
		out.print("<p>" + "Test: facade.createProduct_Orders(exists/too large quantity)  result: "+ result+" ");

		*/
		
		boolean result = facade.createProduct_Orders(5013, 7702, 10); 
		out.print("<p>" + "Test: facade.createProduct_Orders(order already contains product)  result: "+ result+" ");


		
		out.println("</body></html>");
		out.close();
		
		
	
	}

}
