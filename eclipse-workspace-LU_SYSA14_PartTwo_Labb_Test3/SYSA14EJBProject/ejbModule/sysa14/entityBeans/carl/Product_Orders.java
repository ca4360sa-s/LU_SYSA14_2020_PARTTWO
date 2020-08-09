package sysa14.entityBeans.carl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="Product_Orders.checkIfOrderAlreadyContainsProduct", query= "SELECT po FROM Product_Orders po WHERE po.productID = :productID AND po.orderID = :orderID")
})
@Table(name="Product_Orders")
public class Product_Orders implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Product product; 
	//private Orders ordersX; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_OrdersID")
	private int product_OrdersID; 
	
	@Column(name="productID")
	private int productID; 
	
	@Column(name="orderID")
	private int orderID; 
	
	@Column(name="quantity")
	private int quantity;

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
	
	@ManyToOne
	@JoinColumn(name="productID", referencedColumnName="productID")
	public int getProductID() {
		return productID; 
	}
	public void setProductID(int productID) {
		this.productID = productID; 
	}
	
	@ManyToOne()
	@JoinColumn(name="orderID", referencedColumnName="orderID")
	public int getOrderID() {
		return orderID; 
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}	


	

	
}
