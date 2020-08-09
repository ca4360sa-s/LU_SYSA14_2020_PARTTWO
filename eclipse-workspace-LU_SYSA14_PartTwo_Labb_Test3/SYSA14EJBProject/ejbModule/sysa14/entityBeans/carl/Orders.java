package sysa14.entityBeans.carl;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="Orders.checkIfOrdersExist", query="SELECT o FROM Orders o WHERE o.orderID = :value"), 

	@NamedQuery(name="Orders.getAllOrders", query="SELECT o FROM Orders o WHERE o.privateCustomerID IS NOT NULL"),
	
	@NamedQuery(name="Orders.getAllOrdersForCustomer", query="SELECT o FROM Orders o WHERE o.privateCustomerID = :value"), 


})
@Table(name="Orders")
public class Orders implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="orderID")
	private int orderID; 

	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	@Column(name="privateCustomerID")
	private int privateCustomerID;

	/*
	@Column(name="companyCustomerID")
	private int companyCustomerID;
	
	public int getCompanyCustomerID() {
		return companyCustomerID;
	}
	public void setCompanyCustomerID(int companyCustomerID) {
		this.companyCustomerID = companyCustomerID;
	}
	*/
	
	@ManyToOne
	@JoinColumn(name="privateCustomerID", referencedColumnName="customerID")
	public int getPrivateCustomerID() {
		return privateCustomerID;
	}
	public void setPrivateCustomerID(int privateCustomerID) {
		this.privateCustomerID = privateCustomerID;
	}
	
	
	@OneToMany(mappedBy="orderID", fetch=FetchType.EAGER)
	private Set<Product_Orders> product_Orders; 

	public Set<Product_Orders> getProduct_Orders() {
		return product_Orders;
	}
	public void setProduct_Orders(Set<Product_Orders> product_Orders) {
		this.product_Orders = product_Orders;
	}

}
