package sysa14.pojo.carl;

public class ProductSpec {
	
	private int productID; 
	private String productName; 
	private String productDescription; 
	private int quantity;
	
	public ProductSpec() {
		
	}
	public ProductSpec(int productID, String productName, String productDiscription, int quantity) {
		this.productID = productID; 
		this.productName = productName; 
		this.productDescription = productDiscription; 
		this.quantity = quantity; 
	}
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
	
	

}
