package sysa14.controller.carl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sysa14.entityBeans.carl.Orders;
import sysa14.entityBeans.carl.PrivateCustomer;
import sysa14.entityBeans.carl.Product;
import sysa14.facade.carl.FacadeLocal;
import sysa14.pojo.carl.ProductSpec;

import com.google.gson.*;
/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	
	@EJB
	FacadeLocal facade; 
	
	private static final long serialVersionUID = 1L;
    //private static final String CONTENT_TYPE ="text/html; charset=windows-1252";    

    public ControllerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String url = null; 
		boolean feedbackNeeded = false; 
		String feedbackString; 
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String operation = request.getParameter("operation"); 
		Gson gson = new Gson();
		System.out.println("CS: operation : "+operation);
		
		//------------ Customer ------------------------------------------------
		
		if(operation.equals("getAllCustomers")) {
			// POST from JS
			List<PrivateCustomer> tempList = facade.getAllPrivateCustomers(); 
			String temp = gson.toJson(tempList);
			out.print(temp);
			
		} else if (operation.equals("getCustomer")) {
			// POST from JS
			int customerID = Integer.parseInt(request.getParameter("customerID")); 
			PrivateCustomer customer = facade.findPrivateCustomer(customerID);
			String temp = gson.toJson(customer); 
			out.print(temp); 
			
		} else if(operation.equals("createPrivateCustomer")) {
			String firstName = request.getParameter("firstName"); 
			String lastName = request.getParameter("lastName"); 
			String address = request.getParameter("address");
			System.out.println(firstName + " " +  lastName + " "+ address); 
			int resultOfCreate = facade.createPrivateCustomer(firstName, lastName, address); 
			if(resultOfCreate>0) {
				response.sendRedirect("./customer_Handling.jsp?feedback=customerCreated");
			} else {
				response.sendRedirect("./customer_Handling.jsp?feedback=customerNotCreated");
			}
		} else if (operation.equals("updatePrivateCustomer")) {
			int customerID = Integer.parseInt(request.getParameter("customerID"));  
			String newFirstName = request.getParameter("firstName"); 
			String newLastName = request.getParameter("lastName"); 
			String newAddress = request.getParameter("address");
			boolean resultOfUpdate = false; 		
			if(newFirstName.length()>0) {
				resultOfUpdate = facade.updatePrivateCustomerFirstName(customerID, newFirstName);	
			}
			if(newLastName.length()>0) {
				resultOfUpdate = facade.updatePrivateCustomerLastName(customerID, newLastName); 
			}
			if(newAddress.length()>0) {
				resultOfUpdate = facade.updatePrivateCustomerAddress(customerID, newAddress); 
			}
			if(resultOfUpdate) {
				
				response.sendRedirect("./customer_Handling.jsp?feedback=customerUpdated");
			} else {
				response.sendRedirect("./customer_Handling.jsp?feedback=customerNotUpdated");
			}
		} else if(operation.equals("deleteCustomer")) {
			// POST from JS
			String temp; 
			int tempDeleteID = Integer.parseInt(request.getParameter("customerID")); 
			boolean resultOfDelete = facade.deletePrivateCustomer(tempDeleteID); 
			if(resultOfDelete) {
				temp = gson.toJson("deleted"); 
				out.print(temp);
			} else {
				temp = gson.toJson("NotDeletes"); 
				out.print(temp);
			}

		// ----------- Product ---------------------------------------------	
		
		} else if(operation.equals("getAllProducts")) {
			List<Product> tempList = facade.getAllProducts(); 
			String temp = gson.toJson(tempList);
			out.print(temp);
			
		} else if(operation.equals("getProduct")) {
			// POST from JS
			int productID = Integer.parseInt(request.getParameter("productID")); 
			Product product = facade.findProduct(productID); 
			String temp = gson.toJson(product); 
			out.print(temp); 
			
		} else if(operation.equals("createProduct")) {
			String productName = request.getParameter("productName"); 
			String productDescription = request.getParameter("productDescription"); 
			int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
			int resultOfCreate = facade.createProduct(productName, productDescription, stockQuantity);  
			if(resultOfCreate>0) {
				response.sendRedirect("./product_Handeling.jsp?feedback=productCreated");
			} else {
				response.sendRedirect("./product_Handeling.jsp?feedback=productNotCreated");
			}
			
		} else if(operation.equals("updateProduct")) {
			int productID = Integer.parseInt(request.getParameter("productID"));  
			String productName = request.getParameter("productName"); 
			String productDescription = request.getParameter("productDescription"); 
			String stockQuantityString = request.getParameter("stockQuantity");
			boolean resultOfUpdate = false; 		
			if(productName.length()>0) {
				resultOfUpdate = facade.updateProductName(productID, productName);	
			}
			if(productDescription.length()>0) {
				resultOfUpdate = facade.updateProductDescription(productID, productDescription); 
			}
			if(stockQuantityString.length()>0) {
				int stockQuantity = Integer.parseInt(stockQuantityString);
				resultOfUpdate = facade.updateProductStockQuantity(productID, stockQuantity);
			}
			if(resultOfUpdate) {
				response.sendRedirect("./product_Handeling.jsp?feedback=productUpdated");
			} else {
				response.sendRedirect("./product_Handeling.jsp?feedback=productNotUpdated");
			}
			
		} else if(operation.equals("deleteProduct")) {
			// POST from JS
			String temp; 
			int tempDeleteID = Integer.parseInt(request.getParameter("productID")); 
			boolean resultOfDelete = facade.deleteProduct(tempDeleteID);
			if(resultOfDelete) {
				temp = gson.toJson("deleted"); 
				out.print(temp);
			} else {
				temp = gson.toJson("notDeleted"); 
				out.print(temp);
			}
			
			// ----------- Order ---------------------------------------------	
			
		} else if(operation.equals("createOrder")) {
			int condition = 0; 
			List<Product> listOfProducts = facade.getAllProducts();  
			int tempPrivateCustomerID = Integer.parseInt(request.getParameter("listOfCustomers"));
			System.out.println("CS: tempPrivateCustomerID: "+tempPrivateCustomerID);
			int tempOrderID = facade.createOrdersForPrivateCustomer(tempPrivateCustomerID); 
			System.out.println("CS: tempOrderID:" +tempOrderID ); 
			if(tempOrderID != 0) {
				for(Product p : listOfProducts) {
					String tempProductQuantity = request.getParameter(Integer.toString(p.getProductID()));  
					if(tempProductQuantity!=null) {
						facade.createProduct_Orders(p.getProductID(), tempOrderID, Integer.parseInt(tempProductQuantity)); 
						condition ++; 
					}
				}
			}
			if(condition==0) {
				response.sendRedirect("./order_Handeling.jsp?feedback=orderNotCreated");

			} else if (condition>0) {
				response.sendRedirect("./order_Handeling.jsp?feedback=orderCreated");
			}			
			
		} else if(operation.equals("getAllOrders")) {
			List<Orders> tempList = facade.getAllOrders(); 
			String temp = gson.toJson(tempList); 
			out.print(temp);

		} else if(operation.equals("getAllOrdersForCustomer")) {
			int customerID = Integer.parseInt(request.getParameter("customerID"));
			List<Orders> tempList = facade.getAllOrdersForCustomer(customerID);
			String temp = gson.toJson(tempList); 
			out.print(temp);
			
		} else if(operation.equals("getSpecificOrder")) {
			int orderID = Integer.parseInt(request.getParameter("orderID")); 
			List<ProductSpec>tempList = facade.displayAllProductsForOrder(orderID);
			String temp = gson.toJson(tempList);
			out.print(temp);
		
		} else if(operation.equals("deleteOrder")) {
			int orderID = Integer.parseInt(request.getParameter("orderID")); 
			boolean condition = facade.deleteOrders(orderID);
			String temp; 
			if(condition) {
				temp = gson.toJson("deleted"); 
				out.print(temp);
			} else {
				temp = gson.toJson("notDeleted"); 
				out.print(temp);
			}

		}
		
		
		
		
		out.close(); 
		
	}

}
