package test.servlet.carl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sysa14.entityBeans.carl.Orders;
import sysa14.facade.carl.FacadeLocal;

/**
 * Servlet implementation class TestServletTwo_Facade_Orders
 */

@WebServlet("/TestServletTwo_Facade_Orders")
public class TestServletTwo_Facade_Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	FacadeLocal facade; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServletTwo_Facade_Orders() {
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
		out.println("<title>TestServletTwo_Carl</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");
		out.println("<h2>TestClientTwo</h2>");
		
		//Test of facade/OrdersEAO		
		out.print("<p>" + "Test (2 of 4) of Facade/OrdersEAO" + " ");	
		
		int resultOfCreateOrdersForPrivateCustomer = facade.createOrdersForPrivateCustomer(2816);
		int resultOfCreateOrdersForPrivateCustomerTwo = facade.createOrdersForPrivateCustomer( 0000);
		out.print("<p>" + "Test: facade.resultOfCreateOrdersForPrivateCustomer(7000, 2816) (exists) result: " + resultOfCreateOrdersForPrivateCustomer + " ");
		out.print("<p>" + "Test: facade.resultOfCreateOrdersForPrivateCustomer(0000, 0000) (does not exists) result: " + resultOfCreateOrdersForPrivateCustomerTwo + " ");

		Orders orders = facade.findOrders(7000); 
		out.print("<p>" + "Test: (exists) facade.findOrders result: " + orders.getOrderID()+" ");
		Orders ordersTwo = facade.findOrders(0000); 
		out.print("<p>" + "Test: (does not exists) facade.findOrders result: " + ordersTwo.getOrderID()+" ");
		
		boolean resultOfDeleteOrders = facade.deleteOrders(7000);
		out.print("<p>" + "Test: facade.deleteOrders(7000) result: " + resultOfDeleteOrders+" ");
		boolean resultOfDeleteOrdersTwo = facade.deleteOrders(7000);
		out.print("<p>" + "Test: facade.deleteOrders(7000) result: " + resultOfDeleteOrdersTwo +" ");

		List<Orders> tempListOne = facade.getAllOrders(); 
		out.print("<p>" + "Test: facade.getAllorders() result: "  +" ");
		for (Orders o : tempListOne) {
			out.print("<p>" + o.getOrderID()+" : " + o.getPrivateCustomerID() +"</p> ");

		}
		
		List<Orders> tempListTwo = facade.getAllOrdersForCustomer(1650);
		out.print("<p>" + "Test: facade.getAllOrdersForCustomer(1650) result: "  +" ");
		for(Orders o : tempListTwo) {
			out.print("<p>" + o.getOrderID()+" : " + o.getPrivateCustomerID() +" ");
		}
		

		out.println("</body></html>");
		out.close();
	}
}
