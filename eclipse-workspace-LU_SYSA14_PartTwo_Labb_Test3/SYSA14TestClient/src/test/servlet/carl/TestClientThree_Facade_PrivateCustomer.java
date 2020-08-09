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

import sysa14.entityBeans.carl.PrivateCustomer;
import sysa14.facade.carl.FacadeLocal;

/**
 * Servlet implementation class TestClientThree_Facade_PrivateCustomer
 */
@WebServlet("/TestClientThree_Facade_PrivateCustomer")
public class TestClientThree_Facade_PrivateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	FacadeLocal facade; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestClientThree_Facade_PrivateCustomer() {
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
		out.println("<title>TestServletThree_Carl</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");
		out.println("<h2>TestClientThree</h2>");
		
		//Test of facade/PrivateCustomerEAO
		out.print("<p>" + "Test (3 of 4) of Facade/PrivateCustomerEAO" + " ");		
		
		int resultOfCreatePrivateCustomer = facade.createPrivateCustomer( "Test", "Testsson", "Testvägen 1"); 
		out.print("<p>" + "Test: facade.createPrivateCustomer(1000, Test, Testsson, Testvägen)  result: "+ resultOfCreatePrivateCustomer +" ");

		int resultOfCreatePrivateCustomerTwo = facade.createPrivateCustomer("Test", "Testsson", "Testvägen 1"); 
		out.print("<p>" + "Test: facade.createPrivateCustomer(1000, Test, Testsson, Testvägen)  result: "+ resultOfCreatePrivateCustomerTwo +" ");
		
		PrivateCustomer privateCustomer = facade.findPrivateCustomer(1000); 
		out.print("<p>" + "Test: facade.findPrivateCustomer(1000) result: " +privateCustomer.getLastName()+" ");
		
		PrivateCustomer privateCustomerTwo = facade.findPrivateCustomer(0000); 
		out.print("<p>" + "Test: facade.findPrivateCustomer(0000) result: " +privateCustomerTwo.getLastName()+" ");
		
		boolean resultUpdateOne = facade.updatePrivateCustomerFirstName(1000, "Tyko"); 
		out.print("<p>" + "Test: facade.updatePrivateCustomerFirstName(1000, Tyko) result: " +resultUpdateOne+" ");
		
		boolean resultUpdateTwo = facade.updatePrivateCustomerLastName(1000, "Nelly"); 
		out.print("<p>" + "Test: facade.updatePrivateCustomerLastName(1000, Nelly) result: " +resultUpdateTwo+" ");
		
		boolean resultUpdateThree = facade.updatePrivateCustomerAddress(1000, "Hundstigen 2"); 
		out.print("<p>" + "Test: facade.updatePrivateCustomerAddress(1000, Hundstigen) result: " +resultUpdateThree+" ");

		boolean resultUpdateFive = facade.updatePrivateCustomerFirstName(0000, "Majken"); 
		out.print("<p>" + "Test: facade.updatePrivateCustomerFirstName(0000, Majken) does not exist result: " +resultUpdateFive+" ");
		
		boolean resultOfDelete = facade.deletePrivateCustomer(0000); 
		out.print("<p>" + "Test: facade.deletePrivateCustomoer(0000) result: " +resultOfDelete+" ");
		
		boolean resultOfDeleteTwo = facade.deletePrivateCustomer(1000); 
		out.print("<p>" + "Test: facade.deletePrivateCustomoer(1000) result: " +resultOfDeleteTwo+" ");

		List<PrivateCustomer> tempList = facade.getAllPrivateCustomers(); 
		out.print("<p>" + "Test: facade.getAllPrivateCustomers() result: " +" ");
		for (PrivateCustomer p : tempList) {
			out.print("<p>" + p.getFirstName() +" " + p.getLastName()+"</p> ");
		}
		out.println("</body></html>");
		out.close();
	}

}
