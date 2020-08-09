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

import sysa14.entityBeans.carl.Product;
import sysa14.facade.carl.FacadeLocal;
import sysa14.pojo.carl.ProductSpec;

/**
 * Servlet implementation class TestServletOne
 */
@WebServlet("/TestServletOne")
public class TestServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    FacadeLocal facade; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServletOne() {
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
		out.println("<title>TestServletOne_Carl</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");
		out.println("<h2>TestClientOne</h2>");
		
		//Check if ... 
		out.print("<p>" + "Test (1 of 4) of Facade/ProductEAO " + " ");
		out.print("<p>" + "Test: facade.checkIfProductExist(4966) result:" + facade.checkIfProductExist(4966) + " ");
		
		// Read/Find
		Product tempProduct = facade.findProduct(4966); 
		out.print("<p>" + "Test: facade.findProduct(4966) --> emp.getProductName() result: " +tempProduct.getProductName() +" ");
		
		Product tempProductTwo = facade.findProduct(0000); 
		out.print("<p>" + "Test: facade.findProduct(0000) --> temp.getProductName() result: " + tempProductTwo.getProductName() +" ");
		
		/*
		Product tempProductTwo = facade.findProduct(0000); 
		String tempName = "No name"; 
		if(tempProductTwo != null) { tempName = tempProductTwo.getProductName();}
		out.print("<p>" + "Test: facade.findProduct(0000) result: " +tempName +" ");
		
		Product tempProductThree = new Product(); 
		out.print("<p>" + "Test: empty object:  " +tempProductThree.getProductName()+ " ");
		*/
		
		// Create
		int resultOfCreateProduct = facade.createProduct("toRemove", "Somthing to remove", 1); 
		out.print("<p>" + "Test: facade.createProduct --> resultOfCreateProduct result: " + resultOfCreateProduct+" ");
		
		
		// Update 
		boolean resultOfUpdateProduct = facade.updateProductName(5000, "TestProdukt");
		out.print("<p>" + "Test: facade.updateProduct --> resultOfUpdateProduct(productID, productName) " + resultOfUpdateProduct + " ");

		boolean resultOfUpdateProductTwo = facade.updateProductDescription(5000, "En beskrivning"); 
		out.print("<p>" + "Test: facade.updateProduct --> resultOfUpdateProduct(productID, productDescription) " + resultOfUpdateProductTwo + " ");

		boolean resultOfUpdateProductThree = facade.updateProductStockQuantity(5000, 20); 
		out.print("<p>" + "Test: facade.updateProduct --> resultOfUpdateProduct(productID, stockQuantity) " + resultOfUpdateProductThree + " ");
		
		boolean resultOfUpdateProductFour = facade.updateProductName(0000, "TestProdukt");
		out.print("<p>" + "Test: facade.updateProduct --> resultOfUpdateProduct(productID, productName) " + resultOfUpdateProductFour + " ");

		// Delete
		boolean resultOfDeleteProduct = facade.deleteProduct(5000); 
		out.print("<p>" + "Test: facade.deleteProduct(5000) --> result: " +resultOfDeleteProduct + " ");

		boolean resultOfDeleteProductTwo = facade.deleteProduct(5000); 
		out.print("<p>" + "Test: facade.deleteProduct(5000) (secound time) --> result: " +resultOfDeleteProductTwo + " ");
		
		List<Product> tempList = facade.getAllProducts(); 
		out.print("<p>" + "Test: facade.getAllProducts() --> result(list): " +" ");
		for(Product p : tempList) {
			out.print("<p>" + p.getProductName() + "</p>");
		}

		int resultOfCheckProductQuantity = facade.checkStockQuantity(4298); 
		out.print("<p>" + "Test: facade.checkStockQuantity(4298) --> result: " +resultOfCheckProductQuantity + " ");

		List<ProductSpec> tempListTwo = facade.displayAllProductsForOrder(8552);
		out.print("<p>" + "Test: facade.displayAllProductsForOrder(8552) --> result: "  + " ");
		for (ProductSpec p : tempListTwo) {
			out.print("<p>" + p.getProductID() +" : " + p.getProductName() +" : " +p.getProductDescription()  +" : " +
						p.getQuantity()+"</p>");
		}
		
		out.println("</body></html>");
		out.close();
	}

}
