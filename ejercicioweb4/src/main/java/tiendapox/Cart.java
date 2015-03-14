package tiendapox;

import java.util.ArrayList;

public class Cart {
	ArrayList <AlmostCart> products;
	
	public Cart(){
		products = new ArrayList <>();
	}
	
	public Cart(ArrayList <AlmostCart> products){
		this.products = products;
	}


	public void modify(AlmostCart product, int new_cuantity){
		if (new_cuantity > 0){
			if (products.contains(product)){
				products.get(products.indexOf(product)).setCuantity(new_cuantity);
			}
		}	
	}
	
	public void remove(AlmostCart product){
			products.remove(product);
	}
}	