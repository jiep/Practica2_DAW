package tiendapox;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AlmostCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	private int cuantity;

	public AlmostCart() {
	}

	public AlmostCart(Product product, int cuantity) {
		this.cuantity = cuantity;
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public int getCuantity() {
		return cuantity;
	}

	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}

	public void add() {
		this.cuantity++;
	}

	public void substract() {
		this.cuantity--;
	}

	@Override
	public boolean equals(Object o) {
		boolean equals = false;

		if (o instanceof AlmostCart
				&& product.equals(((AlmostCart) o).getProduct())) {

			equals = true;

		}

		return equals;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
