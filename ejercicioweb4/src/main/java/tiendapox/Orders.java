package tiendapox;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	
	/*public static enum State{
		PENDIENTE, PREPARADO
	}*/
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne(cascade=CascadeType.ALL)
	private Cart cart;
	private String state;
	private Date date;
	
	public Orders(){
	}
	
	public Orders(Cart cart){
		this.cart = cart;
		this.state = "Pendiente";
		this.setDate(new Date());
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}
	
	public void changeState(){
		this.state = "Preparado";
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Cart getCart(){
		return cart;
	}
	
}
