package sysa14.entityBeans.carl;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="PrivateCustomer.checkIfPrivateCustomerExist", query="SELECT c FROM PrivateCustomer c WHERE c.customerID = :value"),
	@NamedQuery(name="PrivateCustomer.getAllPrivateCustomoers", query="SELECT c FROM PrivateCustomer c")
	
})
@Table(name="PrivateCustomer")
public class PrivateCustomer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int customerID; 
	private String firstName; 
	private String lastName; 
	private String address; 
	private Set <Orders> pOrders;
	
	@Id
	@Column(name="customerID")
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	@Column(name="firstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@OneToMany(mappedBy="privateCustomerID", fetch=FetchType.EAGER)
	public Set<Orders> getOrders() {
		return pOrders;
	}
	public void setOrders(Set<Orders> orders) {
		this.pOrders = orders;
	} 
	
}
