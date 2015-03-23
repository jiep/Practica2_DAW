package tiendapox;

import java.util.ArrayList;

public class Cart {
	private ArrayList<AlmostCart> products = new ArrayList<AlmostCart>();
	private double total;

	public Cart() {
	}

	public Cart(ArrayList<AlmostCart> products) {
		this.setProducts(products);
	}

	public void modify(AlmostCart product, int new_cuantity) {
		if (new_cuantity > 0) {
			if (getProducts().contains(product)) {
				getProducts().get(getProducts().indexOf(product)).setCuantity(
						new_cuantity);
			}
		}
	}

	public void remove(AlmostCart product) {
		getProducts().remove(product);
	}

	public ArrayList<AlmostCart> getProducts() {
		return products;
	}

	void setProducts(ArrayList<AlmostCart> products) {
		this.products = products;
	}

	public double getTotal() {
		int total = 0;

		for (AlmostCart ac : products) {
			total += ac.getProduct().getPrice() * ac.getCuantity();
		}
		
		this.total = total;

		return this.total;
	}
	
}