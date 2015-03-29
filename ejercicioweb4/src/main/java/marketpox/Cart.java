package marketpox;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cart implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "cart_id")
	private Integer id;

	@ElementCollection
	private List<ProductWithCuantity> products = new ArrayList<>();
	private double total;

	public Cart(List<ProductWithCuantity> prod, double total) {
		this.products = prod;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public Cart() {
	}

	public Cart(ArrayList<ProductWithCuantity> products) {
		this.setProducts(products);
	}

	public void modify(ProductWithCuantity product, int new_cuantity) {
		if (new_cuantity > 0) {
			if (getProducts().contains(product)) {
				getProducts().get(getProducts().indexOf(product)).setCuantity(
						new_cuantity);
			}
		}
	}

	public void remove(ProductWithCuantity product) {
		getProducts().remove(product);
	}

	public List<ProductWithCuantity> getProducts() {
		return products;
	}

	void setProducts(ArrayList<ProductWithCuantity> products) {
		this.products = products;
	}

	public double getTotal() {
		int total = 0;

		for (ProductWithCuantity ac : products) {
			total += ac.getProduct().getPrice() * ac.getCuantity();
		}

		this.total = total;

		return this.total;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}