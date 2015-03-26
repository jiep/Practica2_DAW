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
	@Lob @Column(name="product_list")
	private ArrayList<Product> products = new ArrayList<Product>();
	@Lob @Column(name="cuantity_list")
	private ArrayList<Double> cuantity = new ArrayList<Double>();
	
	
	public Order(){
	}
	
	public Order(ArrayList<Product> products, ArrayList<Double> cuantity){
		this.state = "Pendiente";
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

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<Double> getCuantity() {
		return cuantity;
	}

	public void setCuantity(ArrayList<Double> cuantity) {
		this.cuantity = cuantity;
	}
	
}
