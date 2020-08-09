package sysa14.entityBeans.carl;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.*;
import javax.persistence.Table;

import sysa14.pojo.carl.ProductSpec;

@Entity
@SqlResultSetMapping(name="ProductSpecMapping",
		classes= {
				@ConstructorResult(
						targetClass = ProductSpec.class,
						columns = {
								@ColumnResult(name="productID", type = Integer.class),
								@ColumnResult(name="productName", type = String.class),
								@ColumnResult(name="productDescription", type = String.class),
								@ColumnResult(name="quantity", type = Integer.class)
						})
		}
)
@NamedQueries({
	@NamedQuery(name="Product.checkIfProductExist", 
			query="SELECT p FROM Product p WHERE p.productID = :value "),

	@NamedQuery(name="Product.getAllProducts", query="SELECT p FROM Product p")
})
@Table(name="Product")
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int productID; 
	private String productName; 
	private String productDescription; 
	private int stockQuantity;
	private Set<Product_Orders> product_Orders; 
	
	@Id
	@Column(name="productID")
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	@Column(name="productName")
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name="productDescription")
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	@Column(name="stockQuantity")
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	@OneToMany(mappedBy="productID", fetch=FetchType.EAGER)
	public Set<Product_Orders> getProduct_Orders() {
		return product_Orders;
	}
	public void setProduct_Orders(Set<Product_Orders> product_Orders) {
		this.product_Orders = product_Orders;
	} 
	
	
}
