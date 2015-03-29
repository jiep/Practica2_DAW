package tiendapox;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductWithCuantity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private Product product;
	private int cuantity;

	public ProductWithCuantity() {
	}

	public ProductWithCuantity(Product product, int cuantity) {
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

		if (o instanceof ProductWithCuantity
				&& product.equals(((ProductWithCuantity) o).getProduct())) {

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
