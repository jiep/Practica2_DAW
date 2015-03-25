package tiendapox;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
	
	public static enum State{
		PENDIENTE, PREPARADO
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private Cart cart;
	private State state;
	private Date date;
	
	public Order(){
	}
	
	public Order(Cart cart){
		this.cart = cart;
		this.state = State.PENDIENTE;
		this.setDate(new Date());
	}

	public Cart getCart() {
		return cart;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}
	
	public void changeState(){
		this.state = State.PREPARADO;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
