package tiendapox;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order {
	
	/*public static enum State{
		PENDIENTE, PREPARADO
	}*/
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String state;
	private Date date;
	private String name;
	private String address;
	@Lob @Column(name="cart")
	private Cart cart;
	
	public Order(){
	}
	
	public Order(Cart cart){
		this.state = "Pendiente";
		this.setCart(cart);
		this.setDate(new Date());
	}

	public String getState() {
		return state;
	}
	public Date getDate() {
		return date;
	}
	

	public void setDate(Date date) {
		this.date = date;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}
	
	public void changeState(){
		this.state = "Preparado";
	}

	public Cart getCart() {
		return cart;
	}

	private void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
